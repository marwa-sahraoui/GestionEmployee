CREATE SEQUENCE hibernate_sequence START 2;

create table activities
(
    id           BIGINT NOT NULL primary key,
    days_of_work int    not null,
    days_off     int    not null
);
create table clients
(
    id   BIGINT NOT NULL primary key,
    name varchar(50)
);
create table consultants
(
    id            BIGINT NOT NULL primary key,
    date_of_birth date,
    hiring_date   date,
    name          varchar(50),
    manager_id    BIGINT
);

create table managers
(
    id            BIGINT NOT NULL primary key,
    date_of_birth date,
    hiring_date   date,
    name          varchar(50)
);
create table missions
(
    id   BIGINT NOT NULL primary key,
    date date,
    tgm  int    not null
);

create table consultants_missions
(
    consultant_id BIGINT NOT NULL references consultants (id),
    mission_id    BIGINT NOT NULL references missions (id)
);

create table missions_clients
(
    client_id  BIGINT NOT NULL references clients (id),
    mission_id BIGINT NOT NULL references missions (id)
);
create table payslips
(
    id     BIGINT  NOT NULL primary key,
    date   date,
    salary decimal not null
);


