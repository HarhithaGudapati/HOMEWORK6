CREATE TABLE companies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO companies (name) VALUES ('Liverpool');
INSERT INTO companies (name) VALUES ('Manchester Utd');
INSERT INTO companies (name) VALUES ('Chelsea');
INSERT INTO companies (name) VALUES ('Manchester City');
CREATE TABLE season_stats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    company_id INT,
    season_year INT,
    league VARCHAR(100),
    wins INT,
    losses INT,
    points INT,
    FOREIGN KEY (company_id) REFERENCES companies(id)
);
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2018, 1, 'Premier League', 21, 2, 91),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2018, 2, 'Premier League', 20, 10, 84),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2018, 3, 'Premier League', 24, 3, 79),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2018, 4, 'Premier League', 28, 11, 97),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2019, 4, 'Premier League', 29, 11, 93),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2019, 3, 'Premier League', 32, 6, 92),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2019, 1, 'Premier League', 28, 7, 76),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2019, 2, 'Premier League', 20, 9, 82),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2020, 1, 'Premier League', 25, 10, 95),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2020, 3, 'Premier League', 21, 8, 79),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2020, 4, 'Premier League', 19, 12, 84),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2020, 2, 'Premier League', 30, 7, 99),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2021, 1, 'Premier League', 27, 13, 75),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2021, 3, 'Premier League', 26, 6, 78),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2021, 4, 'Premier League', 18, 3, 71),
INSERT INTO season_stats (leagueyear, company_id, league, wins, losses, points) VALUES (2021, 2, 'Premier League', 20, 5, 93);
