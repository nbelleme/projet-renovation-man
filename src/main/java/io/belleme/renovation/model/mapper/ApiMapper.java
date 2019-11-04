package io.belleme.renovation.model.mapper;

import io.belleme.renovation.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.QuestionDto;
import org.openapitools.model.QuestionnaireDto;
import org.openapitools.model.ReponseDto;

@Mapper
public interface ApiMapper {
    ApiMapper INSTANCE = Mappers.getMapper(ApiMapper.class);

    QuestionDto toDto(Question question);

    ReponseDto toDto(Reponse reponse);

    Questionnaire fromDto(QuestionnaireDto dto);

    QuestionnaireDto toDto(Questionnaire questionnaire);

    default String toDto(Intitule intitule) {
        return intitule.getValue();
    }

    default Intitule fromIntituleDto(String s) {
        return new Intitule(s);
    }

    default String toDto(Email email) {
        return email.getValue();
    }

    default Email fromEmailDto(String s) {
        return new Email(s);
    }
}
