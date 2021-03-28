CREATE TABLE IF NOT EXISTS public.smartphones_table
(
    Id integer NOT NULL,
    OS character varying(50) COLLATE pg_catalog."default" NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT test_table_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.smartphones_table
    OWNER to postgres;

-- DROP TABLE IF EXISTS public.smartphones_table