package com.swisscom.backend.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.swisscom.backend.dao.UserRepository;
import com.swisscom.backend.mapper.UserMapper;
import com.swisscom.backend.model.UserDto;
import com.swisscom.backend.model.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
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

    // © https://attacomsian.com/blog/spring-boot-upload-parse-csv-file
    public String index() {
        return "index";
    }

    public String upload(MultipartFile file, Model model) {
        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<UserEntity> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(UserEntity.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSeparator(';')
                        .build();

                // convert `CsvToBean` object to list of users
                List<UserEntity> users = csvToBean.parse();

                // delete and update database user table content with new list
                userRepository.deleteAll();
                userRepository.saveAll(users);

                // save users list on model
                model.addAttribute("users", users);
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "file-upload";
    }

}
