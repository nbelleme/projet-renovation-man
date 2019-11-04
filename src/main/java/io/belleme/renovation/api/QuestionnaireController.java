package io.belleme.renovation.api;

import io.belleme.renovation.model.Questionnaire;
import io.belleme.renovation.model.mapper.ApiMapper;
import io.belleme.renovation.service.QuestionnaireService;
import org.apache.commons.lang3.StringUtils;
import org.openapitools.api.QuestionnaireApi;
import org.openapitools.model.QuestionnaireDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuestionnaireController implements QuestionnaireApi {

    private QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @Override
    public ResponseEntity<List<QuestionnaireDto>> getQuestionnaireByEmail(@Valid String email) {
        List<Questionnaire> questionnaires;
        if (StringUtils.isEmpty(email)) {
            questionnaires = questionnaireService.getByEmail(email);
        } else {
            questionnaires = questionnaireService.getAll();
        }
        List<QuestionnaireDto> questionnaireDtos = questionnaires.stream()
                                                                 .map(ApiMapper.INSTANCE::toDto)
                                                                 .collect(Collectors.toList());
        return ResponseEntity.ok(questionnaireDtos);
    }

    @Override
    public ResponseEntity<QuestionnaireDto> postQuestionnaire(@Valid QuestionnaireDto questionnaireDto) {
        Questionnaire questionnaire = ApiMapper.INSTANCE.fromDto(questionnaireDto);

        Questionnaire questionnaireSaved = questionnaireService.save(questionnaire);

        return ResponseEntity.ok(ApiMapper.INSTANCE.toDto(questionnaireSaved));
    }
}
