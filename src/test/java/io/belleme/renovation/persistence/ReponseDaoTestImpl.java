package io.belleme.renovation.persistence;

import io.belleme.renovation.model.Reponse;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

public class ReponseDaoTestImpl implements ReponseDao {

    public Map<Long, Reponse> db = new HashMap<>();

    @Override
    public List<Reponse> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public List<Reponse> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Reponse> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Reponse> findAllById(Iterable<Long> iterable) {
        List<Reponse> result = new ArrayList<>();
        iterable.forEach(aLong -> {
            if (db.containsKey(aLong)) {
                result.add(db.get(aLong));
            }

        });
        return result;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Reponse reponse) {

    }

    @Override
    public void deleteAll(Iterable<? extends Reponse> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Reponse> S save(S s) {
        return null;
    }

    @Override
    public <S extends Reponse> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Reponse> findById(Long aLong) {
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
    public <S extends Reponse> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Reponse> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Reponse getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Reponse> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Reponse> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Reponse> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Reponse> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Reponse> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Reponse> boolean exists(Example<S> example) {
        return false;
    }

    public void clean() {
        db.clear();
    }
}
