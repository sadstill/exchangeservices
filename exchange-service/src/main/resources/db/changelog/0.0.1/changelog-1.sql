-- liquibase formatted sql


--changeset sadstill:1
--comment first migration

drop table if exists currency_rate cascade;

create table currency_rate
(
    rate            numeric(10, 5),
    id              bigserial not null,
    timestamp       timestamp(6),
    source_currency varchar(255),
    target_currency varchar(255),
    primary key (id)
);

