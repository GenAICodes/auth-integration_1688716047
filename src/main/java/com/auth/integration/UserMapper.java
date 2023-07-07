
package com.auth.integration;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public UserDto mapToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setEmail(userEntity.getEmail());
        return userDto;
    }
    
    public UserEntity mapToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        return userEntity;
    }
}
