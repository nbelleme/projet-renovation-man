package io.belleme.renovation.model;

import io.belleme.renovation.model.converter.IntituleConverter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "question")
public class Question {

    @Id
    @Column(name = "id_question")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = IntituleConverter.class)
    private Intitule intitule;
    @OneToMany(targetEntity = Reponse.class)
    @JoinColumn(name = "id_question")
    private Set<Reponse> reponses;

    private Question() {
    }

    public Long getId() {
        return id;
    }

    public Intitule getIntitule() {
        return intitule;
    }

    public Set<Reponse> getReponses() {
        return reponses;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Intitule intitule;
        private Set<Reponse> reponses;

        private Builder() {
        }


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder intitule(Intitule intitule) {
            this.intitule = intitule;
            return this;
        }

        public Builder reponses(Set<Reponse> reponses) {
            this.reponses = reponses;
            return this;
        }

        public Question build() {
            Question question = new Question();
            question.intitule = this.intitule;
            question.id = this.id;
            question.reponses = this.reponses;
            return question;
        }
    }
}
