USE test;
DROP TABLE IF EXISTS part;
CREATE TABLE part
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  name     TEXT            NULL,
  required INT DEFAULT '0' NULL,
  count INT DEFAULT 1,
  CONSTRAINT part_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;



INSERT INTO part(name,required,count)
VALUES
  ('motherboard',1,1),
  ('keyboard',1,1),
  ('mouse',1,3),
  ('soundcard', 0,2),
  ('processor', 1,5),
  ('corpuslight', 0,1),
  ('hdd-disk', 0,1),
  ('corpus', 1,10),
  ('ram', 1,10),
  ('ssd-disk', 1,15),
  ('videocard', 0,7),
  ('ozu', 1,10),
  ('router', 0,11),
  ('paper', 0,4),
  ('monitor', 0,25),
  ('html-Cable', 0,50),
  ('NOD32', 0,5),
  ('Windows-license', 0,10),
  ('box', 0,50),
  ('cooler', 0,6),
  ('LG UltraFine', 0,10),
  ('BeatsSolo3', 0,9),
  ('printer', 0,3),
  ('Adobe-Photoshop', 0,100);
