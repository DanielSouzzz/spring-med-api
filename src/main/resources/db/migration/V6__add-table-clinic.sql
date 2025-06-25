CREATE TYPE day_enum AS ENUM (
    'MONDAY', 'TUESDAY', 'WEDNESDAY',
    'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY'
);

CREATE TABLE available_schedule
(
    id            SERIAL PRIMARY KEY,
    id_medico     INT         NOT NULL,
    especialidade VARCHAR(30) NOT NULL,
    available BOOLEAN DEFAULT true,
    day_of_week day_enum NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,

    CONSTRAINT fk_agendamento_medico FOREIGN KEY (id_medico) REFERENCES medicos (id) ON DELETE CASCADE
    );