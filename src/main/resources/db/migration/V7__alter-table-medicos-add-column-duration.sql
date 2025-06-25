ALTER TABLE medicos
    ADD COLUMN minutesDuration INT DEFAULT 30;

UPDATE medicos
SET minutesDuration = 30;
