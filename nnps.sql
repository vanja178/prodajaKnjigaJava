CREATE DATABASE IF NOT EXISTS nnps DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE nnps;

DROP TABLE IF EXISTS radniksmena;
DROP TABLE IF EXISTS stavkaracuna;
DROP TABLE IF EXISTS racun;
DROP TABLE IF EXISTS kupac;
DROP TABLE IF EXISTS knjiga;
DROP TABLE IF EXISTS smena;
DROP TABLE IF EXISTS radnik;
DROP TABLE IF EXISTS kategorija;

CREATE TABLE kategorija (
  idKategorija BIGINT NOT NULL AUTO_INCREMENT,
  naziv VARCHAR(50) NOT NULL,
  popust DOUBLE NOT NULL,
  PRIMARY KEY (idKategorija)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE radnik (
  idRadnik BIGINT NOT NULL AUTO_INCREMENT,
  ime VARCHAR(50) NOT NULL,
  prezime VARCHAR(50) NOT NULL,
  korisnickoIme VARCHAR(50) NOT NULL,
  sifra VARCHAR(50) NOT NULL,
  PRIMARY KEY (idRadnik)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE smena (
  idSmena BIGINT NOT NULL AUTO_INCREMENT,
  naziv VARCHAR(50) NOT NULL,
  PRIMARY KEY (idSmena)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE knjiga (
  idKnjiga BIGINT NOT NULL AUTO_INCREMENT,
  naziv VARCHAR(50) NOT NULL,
  cena DOUBLE NOT NULL,
  PRIMARY KEY (idKnjiga)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE kupac (
  idKupac BIGINT NOT NULL AUTO_INCREMENT,
  ime VARCHAR(50) NOT NULL,
  prezime VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  brojTelefona VARCHAR(20) NOT NULL,
  kategorija BIGINT NOT NULL,
  PRIMARY KEY (idKupac),
  KEY kategorija_idx (kategorija),
  CONSTRAINT kupac_ibfk_1 FOREIGN KEY (kategorija) REFERENCES kategorija (idKategorija)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE racun (
  idRacun BIGINT NOT NULL AUTO_INCREMENT,
  datum DATE DEFAULT NULL,
  ukupanIznos DOUBLE DEFAULT NULL,
  popust DOUBLE DEFAULT NULL,
  radnik BIGINT NOT NULL,
  kupac BIGINT NOT NULL,
  PRIMARY KEY (idRacun),
  KEY radnik_idx (radnik),
  KEY kupac_idx (kupac),
  CONSTRAINT racun_ibfk_1 FOREIGN KEY (radnik) REFERENCES radnik (idRadnik),
  CONSTRAINT racun_ibfk_2 FOREIGN KEY (kupac) REFERENCES kupac (idKupac)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE stavkaracuna (
  rb BIGINT NOT NULL AUTO_INCREMENT,
  racun BIGINT NOT NULL,
  cena DOUBLE DEFAULT NULL,
  kolicina INT DEFAULT NULL,
  iznos DOUBLE DEFAULT NULL,
  knjiga BIGINT NOT NULL,
  PRIMARY KEY (rb, racun),
  KEY racun_idx (racun),
  KEY knjiga_idx (knjiga),
  CONSTRAINT stavkaracuna_ibfk_1 FOREIGN KEY (racun) REFERENCES racun (idRacun),
  CONSTRAINT stavkaracuna_ibfk_2 FOREIGN KEY (knjiga) REFERENCES knjiga (idKnjiga)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE radniksmena (
  datum DATE NOT NULL,
  idRadnik BIGINT NOT NULL,
  idSmena BIGINT NOT NULL,
  PRIMARY KEY (datum, idRadnik, idSmena),
  KEY radnik_idx (idRadnik),
  KEY smena_idx (idSmena),
  CONSTRAINT radniksmena_ibfk_1 FOREIGN KEY (idRadnik) REFERENCES radnik (idRadnik),
  CONSTRAINT radniksmena_ibfk_2 FOREIGN KEY (idSmena) REFERENCES smena (idSmena)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO kategorija (idKategorija, naziv, popust) VALUES
(1, 'Standard', 0),
(2, 'VIP', 20);

INSERT INTO radnik (idRadnik, ime, prezime, korisnickoIme, sifra) VALUES
(1, 'Nikola', 'Petrovic', 'nikola', 'nikola123'),
(2, 'Jovana', 'Nikolic', 'jovana', 'jovana123');

INSERT INTO smena (idSmena, naziv) VALUES
(1, 'Prva'),
(2, 'Druga'),
(3, 'Treca');

INSERT INTO knjiga (idKnjiga, naziv, cena) VALUES
(1, 'Na Drini cuprija', 990),
(2, 'Seobe', 1190),
(3, 'Prokleta avlija', 850),
(4, 'Travnicka hronika', 1050);

INSERT INTO kupac (idKupac, ime, prezime, email, brojTelefona, kategorija) VALUES
(1, 'Dusan', 'Vasic', 'dusan.vasic@example.com', '0621112233', 2),
(2, 'Jelena', 'Stankovic', 'jelena.stankovic@example.com', '0632223344', 1),
(3, 'Nemanja', 'Jankovic', 'nemanja.jankovic@example.com', '0643334455', 2);

INSERT INTO racun (idRacun, datum, ukupanIznos, popust, radnik, kupac) VALUES
(1, '2026-08-20', 1980, 0, 1, 2),
(2, '2026-08-22', 1632, 20, 2, 1);

INSERT INTO stavkaracuna (rb, racun, cena, kolicina, iznos, knjiga) VALUES
(1, 1, 990, 2, 1980, 1),
(2, 2, 1190, 1, 1190, 2),
(3, 2, 850, 1, 850, 3);

INSERT INTO radniksmena (datum, idRadnik, idSmena) VALUES
('2026-08-01', 1, 1),
('2026-08-02', 2, 2);
