package io.belleme.renovation.persistence;

import io.belleme.renovation.model.Email;
import io.belleme.renovation.model.Questionnaire;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

public class QuestionnaireDaoTestImpl implements QuestionnaireDao {

    public Map<String, Questionnaire> db = new HashMap<>();


    public void clean(){
        db.clear();
    }

    @Override
    public List<Questionnaire> findAllByEmail(Email email) {
        return Collections.singletonList(db.get(email.getValue()));
    }

    @Override
    public boolean existsByEmail(Email email) {
        return db.containsKey(email.getValue());
    }

    @Override
    public List<Questionnaire> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public List<Questionnaire> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Questionnaire> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Questionnaire> findAllById(Iterable<Long> iterable) {

        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Questionnaire questionnaire) {

    }

    @Override
    public void deleteAll(Iterable<? extends Questionnaire> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Questionnaire> S save(S s) {
        db.put(s.getEmail()
                .getValue(), s);
        return s;
    }

    @Override
    public <S extends Questionnaire> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Questionnaire> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Questionnaire> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Questionnaire> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Questionnaire getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Questionnaire> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Questionnaire> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Questionnaire> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Questionnaire> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Questionnaire> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Questionnaire> boolean exists(Example<S> example) {
        return false;
    }
}
