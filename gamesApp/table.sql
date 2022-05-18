use gameroom;
CREATE TABLE IF NOT EXISTS `score` (
  username varchar(100) NOT NULL PRIMARY KEY,
  score int
);