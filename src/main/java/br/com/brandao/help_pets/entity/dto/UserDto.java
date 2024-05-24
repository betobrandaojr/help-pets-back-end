package br.com.brandao.help_pets.entity.dto;

import br.com.brandao.help_pets.entity.User;
import br.com.brandao.help_pets.exception.NothinUserException;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private UUID id;
    private String email;
    private String password;

    public static UserDto returnId(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        return userDto;
    }
    public User transforInEntity(){
        User user = new User();

        user.setEmail(this.email);
        user.setPassword(this.password);

        return user;
    }

    public UserDto transformInDto(User saveUser){
        UserDto userDto = new UserDto();
        userDto.setId(saveUser.getId());
        userDto.setEmail(saveUser.getEmail());
        userDto.setPassword(saveUser.getPassword());
        return userDto;
    }

    public List<UserDto> transformInListOfDtos(List<User> users){
        if(users.isEmpty()){
            throw new NothinUserException();
        }
        return users.stream().map(this::transformInDto).collect(Collectors.toList());
    }

}
