/*
File name: C:\Users\hdogan\retrovideopost.sql
Creation date: 09/30/2021
Created by MySQL to PostgreSQL 5.3 [Demo]
--------------------------------------------------
More conversion tools at http://www.convert-in.com
*/
set client_encoding to 'UTF8';

/*
Table structure for table 'public.films'
*/


begin; 
set transaction read write;


DROP TABLE IF EXISTS "public"."films" CASCADE;
CREATE TABLE "public"."films" ("id" SERIAL NOT NULL, "genreid" INTEGER NOT NULL, "titel" VARCHAR(30)  NOT NULL, "voorraad" BIGINT NOT NULL, "gereserveerd" BIGINT NOT NULL, "prijs" DECIMAL(9,2) NOT NULL);
ALTER SEQUENCE "public"."films_id_seq" RESTART WITH 40 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY";
ALTER TABLE "public"."films" ADD CONSTRAINT "PRIMARY" PRIMARY KEY ("id");
DROP INDEX IF EXISTS "Titel";
CREATE INDEX "Titel" ON "public"."films" ("titel");
DROP INDEX IF EXISTS "filmsGenres";
CREATE INDEX "filmsGenres" ON "public"."films" ("genreid");

INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (1, 2, 'Raiders of the lost ark', 3, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (2, 7, 'Harry Potter', 3, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (3, 11, 'Love story', 1, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (4, 4, 'Two moon junction', 8, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (5, 6, 'Police academy', 3, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (6, 3, 'Once upon a time in the west', 2, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (7, 2, 'In de ban van de ring', 3, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (8, 7, 'Babe', 2, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (9, 2, 'Zorro', 2, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (10, 6, 'Hector', 2, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (11, 3, 'High noon', 4, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (12, 9, 'Captain blood', 2, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (13, 2, 'The last emperor', 3, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (14, 12, 'The deer hunter', 9, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (15, 6, 'The gods must be crazy', 6, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (16, 13, 'Silent night, deadly night', 4, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (17, 13, 'The gangs of new york', 4, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (18, 13, 'Kickboxer', 4, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (19, 2, 'Batman', 12, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (20, 11, 'Cramer vs Cramer', 1, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (21, 11, 'Titanic', 5, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (22, 3, 'El gringo', 5, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (23, 11, 'The graduate', 3, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (24, 13, 'The omen', 5, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (25, 4, 'Sex,lies and videotapes', 0, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (26, 1, 'Chicago', 7, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (27, 7, 'De smurfen', 6, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (28, 13, 'First blood', 3, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (29, 4, 'Her alibi', 5, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (30, 8, 'De langste dag', 3, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (31, 8, 'The guns of navarone', 2, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (32, 2, 'The revenge of jaws', 6, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (33, 13, 'Lock up', 3, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (34, 5, 'Hellraiser', 5, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (35, 5, 'The exorcist', 2, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (36, 13, 'Road house', 5, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (37, 11, 'Matador', 5, 0, 3);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (38, 8, 'Missing in action', 4, 0, 3.5);
INSERT INTO "public"."films"("id", "genreid", "titel", "voorraad", "gereserveerd", "prijs") VALUES (39, 2, 'Licence to kill', 6, 0, 3.5);

DROP TABLE IF EXISTS "public"."genres" CASCADE;
CREATE TABLE "public"."genres" ("id" SERIAL NOT NULL, "naam" VARCHAR(20)  NOT NULL);
ALTER SEQUENCE "public"."genres_id_seq" RESTART WITH 14 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY00000";
ALTER TABLE "public"."genres" ADD CONSTRAINT "PRIMARY00000" PRIMARY KEY ("id");
DROP INDEX IF EXISTS "naam";
CREATE UNIQUE INDEX "naam" ON "public"."genres" ("naam");

INSERT INTO "public"."genres"("id", "naam") VALUES (1, 'Aktiefilm');
INSERT INTO "public"."genres"("id", "naam") VALUES (2, 'Avontuur');
INSERT INTO "public"."genres"("id", "naam") VALUES (3, 'Cowboyfilm');
INSERT INTO "public"."genres"("id", "naam") VALUES (4, 'Erotiek');
INSERT INTO "public"."genres"("id", "naam") VALUES (5, 'Griezel');
INSERT INTO "public"."genres"("id", "naam") VALUES (6, 'Humor');
INSERT INTO "public"."genres"("id", "naam") VALUES (7, 'Kinderfilm');
INSERT INTO "public"."genres"("id", "naam") VALUES (8, 'Oorlog');
INSERT INTO "public"."genres"("id", "naam") VALUES (9, 'Piratenfilm');
INSERT INTO "public"."genres"("id", "naam") VALUES (10, 'Science fiction');
INSERT INTO "public"."genres"("id", "naam") VALUES (11, 'Sentimenteel');
INSERT INTO "public"."genres"("id", "naam") VALUES (12, 'Speelfilm');
INSERT INTO "public"."genres"("id", "naam") VALUES (13, 'Thriller');

DROP TABLE IF EXISTS "public"."klanten" CASCADE;
CREATE TABLE "public"."klanten" ("id" SERIAL NOT NULL, "familienaam" VARCHAR(30)  NOT NULL, "voornaam" VARCHAR(20)  NOT NULL, "straatNummer" VARCHAR(30)  NOT NULL, "postcode" VARCHAR(10)  NOT NULL, "gemeente" VARCHAR(30)  NOT NULL);
ALTER SEQUENCE "public"."klanten_id_seq" RESTART WITH 31 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY00001";
ALTER TABLE "public"."klanten" ADD CONSTRAINT "PRIMARY00001" PRIMARY KEY ("id");
DROP INDEX IF EXISTS "Familienaam";
CREATE INDEX "Familienaam" ON "public"."klanten" ("familienaam");

INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (1, 'Heiremans', 'Inge', 'Koekelbergstraat 32', '9330', 'Dendermonde');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (2, 'Goessens', 'Joris', 'Diepeweg 1', '9000', 'Gent');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (3, 'Van delsen', 'Lode', 'Kouterstraat 10', '9263', 'Bavegem');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (4, 'Van den berghe', 'Piet', 'Melkerijstraat 34', '8900', 'Ieper');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (5, 'Van den bosche', 'Christel', 'Heirbaan 34', '9311', 'Impe');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (6, 'Verbiest', 'Karen', 'Dorpsstraat 35', '9000', 'Gent');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (7, 'Boelens', 'Luc', 'Gravenstraat 23', '9402', 'Meerbeke');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (8, 'Verplancken', 'Mia', 'Kempeland 3', '9200', 'Wetteren');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (9, 'Meert', 'Sabine', 'Oosthoek 23', '9230', 'Melle');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (10, 'Boelens', 'Kristel', 'Koekoekstraat 2', '9000', 'Gent');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (11, 'De clerq', 'Hilde', 'Molenstraat 23', '9140', 'Zele');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (12, 'De coninck', 'Philippe', 'Stationstraat 23', '9402', 'Meerbeke');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (13, 'Cousaert', 'Nathalie', 'Stationstraat 234', '9300', 'Aalst');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (14, 'De coninck', 'Kathleen', 'Vogelzang 34', '9000', 'Gent');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (15, 'Lorez', 'Veronique', 'Beverhoekstraat 23', '9200', 'Wetteren');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (16, 'Heyman', 'Lieve', 'Dendermondse stwg 112', '9010', 'Gentbrugge');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (17, 'Huysman', 'Ann', 'Noordlaan 12', '9300', 'Aalst');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (18, 'Gevaert', 'Jan', 'Wortegemstraat 3', '1890', 'Opwijk');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (19, 'Nijs', 'Pascal', 'Lindestraat 23', '9200', 'Wetteren');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (20, 'Coppens', 'Roland', 'Dorp 6', '9411', 'Erondegem');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (21, 'Gysels', 'Rita', 'Kasteeldreef 45', '9000', 'Gent');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (22, 'Janssens', 'Etienne', 'Blikstraat 21', '9370', 'Lebbeke');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (23, 'Goeman', 'Christine', 'Eikelstraat 345', '9160', 'Hamme');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (24, 'Van de sompel', 'Luc', 'Voermanstraat 45', '9170', 'Waasmunster');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (25, 'Van de poele', 'Trees', 'Stationstraat 11', '9000', 'Gent');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (26, 'Matthijs', 'Paul', 'Sticheldreef 37', '9140', 'Zele');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (27, 'Lefever', 'Hendrik', 'Lijsterstraat 2', '9290', 'Berlare');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (28, 'Lenaerds', 'Marc', 'Dragonderwegel 23', '9281', 'Overmere');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (29, 'Lampens', 'Lieven', 'Drapstraat 45', '9282', 'Uitbergen');
INSERT INTO "public"."klanten"("id", "familienaam", "voornaam", "straatnummer", "postcode", "gemeente") VALUES (30, 'Verpoest', 'Steven', 'Dammenlaan', '9200', 'Dendermonde');

DROP TABLE IF EXISTS "public"."reservaties" CASCADE;
CREATE TABLE "public"."reservaties" ("klantid" INTEGER NOT NULL, "filmid" INTEGER NOT NULL, "reservatie" TIMESTAMP(0) NOT NULL);
DROP INDEX IF EXISTS "PRIMARY00002";
ALTER TABLE "public"."reservaties" ADD CONSTRAINT "PRIMARY00002" PRIMARY KEY ("klantid", "filmid", "reservatie");
DROP INDEX IF EXISTS "reservatiesFilms";
CREATE INDEX "reservatiesFilms" ON "public"."reservaties" ("filmid");

commit;