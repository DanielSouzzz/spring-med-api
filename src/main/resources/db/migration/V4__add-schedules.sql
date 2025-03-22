CREATE TABLE Agendamento (
                             id SERIAL PRIMARY KEY,
                             id_medico INT NOT NULL,
                             id_paciente INT NOT NULL,
                             especialidade VARCHAR(30) NOT NULL,
                             data TIMESTAMP NOT NULL,

                             CONSTRAINT fk_agendamento_medico FOREIGN KEY (id_medico) REFERENCES Medico(id) ON DELETE CASCADE,
                             CONSTRAINT fk_agendamento_paciente FOREIGN KEY (id_paciente) REFERENCES Paciente(id) ON DELETE CASCADE
);