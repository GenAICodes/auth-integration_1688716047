
package com.auth.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    
    public UserDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.mapToDto(userEntity);
    }
    
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.mapToEntity(userDto);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.mapToDto(savedUserEntity);
    }
    
    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        userEntity.setEmail(userDto.getEmail());
        UserEntity updatedUserEntity = userRepository.save(userEntity);
        return userMapper.mapToDto(updatedUserEntity);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
