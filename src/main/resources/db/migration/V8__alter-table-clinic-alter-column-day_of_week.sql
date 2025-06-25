ALTER TABLE available_schedule
ALTER COLUMN day_of_week TYPE day_enum
USING day_of_week::day_enum;
