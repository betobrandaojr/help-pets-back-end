package br.com.brandao.help_pets.service;

import br.com.brandao.help_pets.dto.UserDTO;
import br.com.brandao.help_pets.exceptions.InvalidEmailException;
import br.com.brandao.help_pets.exceptions.UserAlreadyExistsException;
import br.com.brandao.help_pets.exceptions.UserNotFoundException;
import br.com.brandao.help_pets.module.User;
import br.com.brandao.help_pets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
    );

    public Page<UserDTO> getAll(Integer pageNumber, Integer size) {
        Pageable pageable = Optional.ofNullable(pageNumber)
                .flatMap(pn -> Optional.ofNullable(size)
                        .map(sz -> PageRequest.of(pn, sz)))
                .orElse(null);

        if (pageable == null) {
            List<User> users = userRepository.findAll();
            List<UserDTO> userDTOs = users.stream().map(this::convertToDto).collect(Collectors.toList());
            return new PageImpl<>(userDTOs);
        } else {
            Page<User> page = userRepository.findAll(pageable);
            return page.map(this::convertToDto);
        }
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Este usuário não existe"));
    }

    public User save(UserDTO userDTO) {
        validateEmail(userDTO.getEmail());
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Usuário já cadastrado com este email");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAdress(userDTO.getAdress());
        user.setContact(userDTO.getContact());
        user.setDocument(userDTO.getDocument());
        return userRepository.save(user);
    }

    public User update(UUID id, UserDTO userDTO) {
        validateEmail(userDTO.getEmail());
        User existingUser = findById(id);
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setAdress(userDTO.getAdress());
        existingUser.setContact(userDTO.getContact());
        existingUser.setDocument(userDTO.getDocument());
        return userRepository.save(existingUser);
    }

    public void deleteById(UUID id) {
        findById(id); // Verifica se o usuário existe antes de tentar deletar
        userRepository.deleteById(id);
    }

    private void validateEmail(String email) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidEmailException("Email inválido: " + email);
        }
    }

    private UserDTO convertToDto(User user) {
        return new UserDTO(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getAdress(),
                user.getContact(),
                user.getDocument()
        );
    }
}
