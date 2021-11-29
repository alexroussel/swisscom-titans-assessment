package com.swisscom.backend.service;

import com.swisscom.backend.dao.UserRepository;
import com.swisscom.backend.mapper.UserMapper;
import com.swisscom.backend.model.UserDto;
import com.swisscom.backend.model.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserDto> getUsers(List<String> filter) {
        List<UserDto> users;
        if(filter == null || filter.isEmpty()){
            users = userMapper.toDtoList(userRepository.findAll());
        } else {
            users = userMapper.toDtoList(userRepository.findAll(filter));
        }
        return users;
    }

    public void deleteUsers() {
        userRepository.deleteAll();
    }

    public void updateUsers(List<UserEntity> users) {
        userRepository.deleteAll();
        userRepository.saveAll(users);
    }

}
