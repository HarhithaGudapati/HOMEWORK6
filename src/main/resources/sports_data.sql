BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "sports_data" (
	"year"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"league"	TEXT NOT NULL,
	"wins"	INTEGER NOT NULL,
	"losses"	INTEGER NOT NULL,
	"points"	INTEGER NOT NULL
);
INSERT INTO "sports_data" VALUES (2018,'Liverpool','Premier League',21,2,91);
INSERT INTO "sports_data" VALUES (2018,'Manchester Utd','Premier League',20,10,84);
INSERT INTO "sports_data" VALUES (2018,'Chelsea','Premier League',24,3,79);
INSERT INTO "sports_data" VALUES (2018,'Manchester City','Premier League',28,11,97);
INSERT INTO "sports_data" VALUES (2019,'Manchester City','Premier League',29,11,93);
INSERT INTO "sports_data" VALUES (2019,'Chelsea','Premier League',32,6,92);
INSERT INTO "sports_data" VALUES (2019,'Liverpool','Premier League',28,7,76);
INSERT INTO "sports_data" VALUES (2019,'Manchester Utd','Premier League',20,9,82);
INSERT INTO "sports_data" VALUES (2020,'Liverpool','Premier League',25,10,95);
INSERT INTO "sports_data" VALUES (2020,'Chelsea','Premier League',21,8,79);
INSERT INTO "sports_data" VALUES (2020,'Manchester City','Premier League',19,12,84);
INSERT INTO "sports_data" VALUES (2020,'Manchester Utd','Premier League',30,7,99);
INSERT INTO "sports_data" VALUES (2021,'Liverpool','Premier League',27,13,75);
INSERT INTO "sports_data" VALUES (2021,'Chelsea','Premier League',26,6,78);
INSERT INTO "sports_data" VALUES (2021,'Manchester City','Premier League',18,3,71);
INSERT INTO "sports_data" VALUES (2021,'Manchester Utd','Premier League',20,5,93);
INSERT INTO "sports_data" VALUES (2021,'Chelsea','Premier League',29,3,96);
COMMIT;