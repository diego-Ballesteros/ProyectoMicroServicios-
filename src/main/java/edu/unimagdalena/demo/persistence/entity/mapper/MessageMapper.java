package edu.unimagdalena.demo.persistence.entity.mapper;

import edu.unimagdalena.demo.persistence.entity.MessageEntity;
import edu.unimagdalena.demo.persistence.entity.dto.MessageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageDto mesaggeEntityToMessageDto (MessageEntity message);
    MessageEntity messageDtoToMessageEntity (MessageDto messageDto);

}
