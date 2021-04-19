CREATE TABLE IF NOT EXISTS public.users_table
(
    id serial NOT NULL,
    login character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_table_pkey PRIMARY KEY (id, login)
)

    TABLESPACE pg_default;

ALTER TABLE public.users_table
    OWNER to postgres;