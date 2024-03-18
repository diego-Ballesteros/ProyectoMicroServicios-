package edu.unimagdalena.demo.persistence.entity.mapper;

import edu.unimagdalena.demo.persistence.entity.UserEntity;
import edu.unimagdalena.demo.persistence.entity.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userDtoToUserEntity(UserDto userDto);
    UserDto userEntityToUserDto(UserEntity userEntity);
}
