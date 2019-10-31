package io.belleme.renovation.model;


import io.belleme.renovation.model.converter.IntituleConverter;

import javax.persistence.*;

@Entity(name = "reponse")
public class Reponse {

    @Id
    @Column(name = "id_reponse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = IntituleConverter.class)
    private Intitule intitule;
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    private Reponse() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public Intitule getIntitule() {
        return intitule;
    }

    public Question getQuestion() {
        return question;
    }

    public static final class Builder {
        private Long id;
        private Intitule intitule;

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

        public Reponse build() {
            Reponse reponse = new Reponse();
            reponse.intitule = this.intitule;
            reponse.id = this.id;
            return reponse;
        }
    }
}
