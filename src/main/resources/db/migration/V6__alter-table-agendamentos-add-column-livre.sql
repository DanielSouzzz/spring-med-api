ALTER TABLE agendamentos
    ADD COLUMN  BOOLEAN;

ALTER TABLE medicos
    ALTER COLUMN ativo SET DEFAULT true;

UPDATE medicos
SET ativo = true;

ALTER TABLE medicos
    ALTER COLUMN ativo SET NOT NULL;