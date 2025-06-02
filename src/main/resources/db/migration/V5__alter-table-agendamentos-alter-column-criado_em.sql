ALTER TABLE agendamentos
    ALTER COLUMN criado_em SET DEFAULT date_trunc('minute', NOW());
