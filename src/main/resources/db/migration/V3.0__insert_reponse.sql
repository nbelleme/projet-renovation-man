INSERT INTO reponse (intitule, id_question) VALUES ("Salle de bain",
                                                    (select id_question
                                                    from question
                                                    where question.intitule
                                                              like "Quel est votre projet de rénovation ?"));

INSERT INTO reponse (intitule, id_question) VALUES ("Cuisine",
                                                    (select id_question
                                                     from question
                                                     where question.intitule
                                                               like "Quel est votre projet de rénovation ?"));

INSERT INTO reponse (intitule, id_question) VALUES ("Autre",
                                                    (select id_question
                                                     from question
                                                     where question.intitule
                                                               like "Quel est votre projet de rénovation ?"));

# Question : Quel est le but de votre recherche ?

INSERT INTO reponse (intitule, id_question) VALUES ("Je veux une estimation",
                                                    (select id_question
                                                     from question
                                                     where question.intitule
                                                               like "Quel est le but de votre recherche ?"));

INSERT INTO reponse (intitule, id_question) VALUES ("Je veux des conseils",
                                                    (select id_question
                                                     from question
                                                     where question.intitule
                                                               like "Quel est le but de votre recherche ?"));

INSERT INTO reponse (intitule, id_question) VALUES ("Je recherche un artisan",
                                                    (select id_question
                                                     from question
                                                     where question.intitule
                                                               like "Quel est le but de votre recherche ?"));

# Question : Quel niveau de gamme de matériaux souhaitez-vous ?

INSERT INTO reponse (intitule, id_question) VALUES ("Bas de gamme",
                                                    (select id_question
                                                     from question
                                                     where question.intitule
                                                               like "Quel niveau de gamme de matériaux souhaitez-vous ?"));

INSERT INTO reponse (intitule, id_question) VALUES ("Milieu de gamme",
                                                    (select id_question
                                                     from question
                                                     where question.intitule
                                                               like "Quel niveau de gamme de matériaux souhaitez-vous ?"));

INSERT INTO reponse (intitule, id_question) VALUES ("Haut de gamme",
                                                    (select id_question
                                                     from question
                                                     where question.intitule
                                                               like "Quel niveau de gamme de matériaux souhaitez-vous ?"));