package io.belleme.renovation.api;

import io.belleme.renovation.model.mapper.ApiMapper;
import io.belleme.renovation.service.QuestionService;
import org.openapitools.api.QuestionApi;
import org.openapitools.model.QuestionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuestionController implements QuestionApi {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public ResponseEntity<List<QuestionDto>> getQuestions() {
        List<QuestionDto> questionDtos = questionService.findAll()
                                                        .stream()
                                                        .map(ApiMapper.INSTANCE::toDto)
                                                        .collect(Collectors.toList());

        return ResponseEntity.ok(questionDtos);
    }
}
