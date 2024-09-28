------/* schema.*/
--- https://github.com/hackmods/The-the_simpsons-SQL
CREATE SCHEMA the_simpsons;
------/* character.*/
CREATE TABLE IF NOT EXISTS the_simpsons.character (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    update_ts TIMESTAMP DEFAULT current_timestamp NOT NULL
);
------/*Insertion des données dans la table character.*/
INSERT INTO the_simpsons.character  (name, surname) VALUES
    ('Homer','Simpson'),
    ('Bart','Simpson'),
    ('Lisa','Simpson');
------/*Trigger pour maj de la date "update_ts"*/
CREATE OR REPLACE FUNCTION maj_date()
RETURNS TRIGGER AS $$
BEGIN
    NEW.update_ts := NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER maj_date_trigger
    BEFORE INSERT OR UPDATE ON the_simpsons.character
                         FOR EACH ROW
                         EXECUTE FUNCTION maj_date();
------/*Tres utile pour obtenir des details dans la section before de la donnée*/
ALTER TABLE the_simpsons.character REPLICA IDENTITY FULL;
---
SELECT * FROM the_simpsons.character;