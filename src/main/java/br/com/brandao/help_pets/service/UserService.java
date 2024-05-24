package br.com.brandao.help_pets.service;

import br.com.brandao.help_pets.entity.User;
import br.com.brandao.help_pets.entity.dto.UserDto;
import br.com.brandao.help_pets.exception.UserDuplicatedException;
import br.com.brandao.help_pets.exception.UserOrPasswordException;
import br.com.brandao.help_pets.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService implements UserDetailsService {
    private final UserRepository repository;

    public UserService(UserRepository repository){this.repository = repository;}

    public List<User> findAll(){return repository.findAll();}

    public User createNewUser(User user){
        if(repository.findByEmail(user.getEmail())!= null){
            throw new UserDuplicatedException();
        }
        return repository.save(user);
    }

    public UserDto findUser(User user){
        User userDb = repository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(userDb !=null){
            return UserDto.returnId(userDb);
        }
        throw new UserOrPasswordException();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
