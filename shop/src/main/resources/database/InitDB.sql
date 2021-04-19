CREATE TABLE IF NOT EXISTS public.smartphones_table
(
    Id integer NOT NULL,
    OS character varying(50) COLLATE pg_catalog."default" NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    img character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT test_table_pkey PRIMARY KEY (id)
)

ALTER TABLE public.smartphones_table
    OWNER to postgres;

TABLESPACE pg_default;


