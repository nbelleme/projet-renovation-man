package io.belleme.renovation.model;

import io.belleme.renovation.model.converter.EmailConverter;
import io.belleme.renovation.model.exception.IncorrectNumberOfResponseException;
import io.belleme.renovation.model.exception.NullEmailException;
import io.belleme.renovation.model.exception.QuestionAlreadyInQuestionnaireException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "questionnaire")
public class Questionnaire {

    private static final int QUESTIONNAIRE_SIZE = 3;

    @Id
    @Column(name = "id_questionnaire")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = EmailConverter.class)
    private Email email;

    @OneToMany
    @JoinTable(name = "resultat",
            joinColumns = {@JoinColumn(name = "id_questionnaire", referencedColumnName = "id_questionnaire")},
            inverseJoinColumns = {@JoinColumn(name = "id_reponse", referencedColumnName = "id_reponse")})
    private List<Reponse> reponses;

    private Questionnaire() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void validate() {

        if (email == null) {
            throw new NullEmailException();
        }

        email.validate();

        if (reponses == null || reponses.size() != QUESTIONNAIRE_SIZE) {
            throw new IncorrectNumberOfResponseException();
        }

        Set<Question> questions = new HashSet<>();
        reponses.forEach(reponse -> {
            if (!questions.add(reponse.getQuestion())) {
                throw new QuestionAlreadyInQuestionnaireException();
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questionnaire that = (Questionnaire) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return reponses != null ? reponses.equals(that.reponses) : that.reponses == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (reponses != null ? reponses.hashCode() : 0);
        return result;
    }

    public static final class Builder {
        private Long id;
        private Email email;
        private List<Reponse> reponses;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder email(Email email) {
            this.email = email;
            return this;
        }

        public Builder reponses(List<Reponse> reponses) {
            this.reponses = reponses;
            return this;
        }

        public Questionnaire build() {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.email = this.email;
            questionnaire.id = this.id;
            questionnaire.reponses = this.reponses;
            return questionnaire;
        }
    }
}
