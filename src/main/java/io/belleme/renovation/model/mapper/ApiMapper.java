package io.belleme.renovation.model.mapper;

import io.belleme.renovation.model.Intitule;
import io.belleme.renovation.model.Question;
import io.belleme.renovation.model.Reponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.QuestionDto;
import org.openapitools.model.ReponseDto;

@Mapper
public interface ApiMapper {
    ApiMapper INSTANCE = Mappers.getMapper(ApiMapper.class);

    QuestionDto toDto(Question question);

    ReponseDto toDto(Reponse reponse);

    default String toDto(Intitule intitule) {
        return intitule.getValue();
    }

    default Intitule fromDto(String s) {
        return new Intitule(s);
    }
}
