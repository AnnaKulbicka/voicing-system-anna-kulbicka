CREATE TABLE public.vat
(

    name character varying(20),
    rate numeric(3, 2) NOT NULL,
    PRIMARY KEY (name)
);

insert into public.vat (name, rate)
values ('23', 0.23),
       ('8', 0.08),
       ('5', 0.05),
       ('0', 0.00),
       ('ZW', 0.00);

ALTER TABLE public.vat
    OWNER to postgres;