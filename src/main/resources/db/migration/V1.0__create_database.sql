create table question
(
    id_question bigint auto_increment primary key,
    intitule    varchar(255) null
);

create table reponse
(
    id_reponse  bigint auto_increment
        primary key,
    intitule    varchar(255) null,
    id_question bigint       null,
    constraint FK7utui46seipahjep29ytvvwep foreign key (id_question) references question (id_question)
);

create table questionnaire
(
    id_questionnaire bigint auto_increment primary key,
    email            varchar(255) null
);

create table resultat
(
    id_questionnaire bigint not null,
    id_reponse       bigint not null,
    constraint FK2m1nutbhnctywds9u13oi0sxf foreign key (id_questionnaire) references questionnaire (id_questionnaire),
    constraint FKmlhecj5c4dhjurcit9ecuh470 foreign key (id_reponse) references reponse (id_reponse)
);

