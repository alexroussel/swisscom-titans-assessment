package com.swisscom.backend.mapper;

import com.swisscom.backend.model.UserDto;
import com.swisscom.backend.model.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.FIELD, componentModel = "spring")
public interface UserMapper {

    UserDto toDto(UserEntity userEntity);
    List<UserDto> toDtoList(List<UserEntity> userEntityList);
    UserEntity toEntity(UserDto userDto);
    List<UserEntity> toEntityList(List<UserDto> userDtoList);
}
