ALTER TABLE medicos
    ADD COLUMN IF NOT EXISTS ativo BOOLEAN;

ALTER TABLE medicos
    ALTER COLUMN ativo SET DEFAULT true;

UPDATE medicos
SET ativo = true;

ALTER TABLE medicos
    ALTER COLUMN ativo SET NOT NULL;