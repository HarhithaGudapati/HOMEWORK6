-- Clear existing data
DELETE FROM team;
DELETE FROM companies;

-- Insert companies
INSERT INTO companies (id, name) VALUES
(1, 'Liverpool'),
(2, 'Manchester Utd'),
(3, 'Chelsea'),
(4, 'Manchester City');

-- Insert teams
INSERT INTO team (name, league_year, company_id, league, wins, losses, points) VALUES
('Liverpool', 2018, 1, 'Premier League', 21, 2, 91),
('Man Utd', 2018, 2, 'Premier League', 20, 10, 84),
('Chelsea', 2018, 3, 'Premier League', 24, 3, 79),
('Man City', 2018, 4, 'Premier League', 28, 11, 97);