CREATE TABLE IF NOT EXISTS agendamentos
(
    id            SERIAL PRIMARY KEY,
    id_medico     INT         NOT NULL,
    id_paciente   INT         NOT NULL,
    especialidade VARCHAR(30) NOT NULL,
    data          TIMESTAMP   NOT NULL,
    criado_em     TIMESTAMP DEFAULT NOW(),

    CONSTRAINT fk_agendamento_medico FOREIGN KEY (id_medico) REFERENCES medicos (id) ON DELETE CASCADE,
    CONSTRAINT fk_agendamento_paciente FOREIGN KEY (id_paciente) REFERENCES pacientes (id) ON DELETE CASCADE
);
