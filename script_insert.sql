USE MovieNetwork;

LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/title.basics.tsv'
	INTO TABLE Media
	FIELDS TERMINATED BY '\t'
	LINES TERMINATED BY '\n'
	IGNORE 1 LINES
    (TitleId, TitleType, Title, @dummy, isAdult, startYear, @dummy, RuntimeMinutes, Genres);
 	
LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/title.ratings.tsv'
	INTO TABLE ImdbRating
	FIELDS TERMINATED BY '\t'
	LINES TERMINATED BY '\n'
	IGNORE 1 LINES;

INSERT INTO StreamingSite VALUES (
	NULL,
    'Netflix',
    'https://www.netflix.com/browse'
);

INSERT INTO StreamingSite VALUES (
NULL,
    'Amazon',
    'https://www.amazon.com/Amazon-Video/b?ie=UTF8&node=2858778011'
);

INSERT INTO StreamingSite VALUES (
NULL,
    'Disney',
    'https://www.disneyplus.com/'
);

INSERT INTO StreamingSite VALUES (
NULL,
    'Hulu',
    'https://www.hulu.com/'
);

LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/netflix_titles.txt' INTO TABLE Netflix
	CHARACTER SET latin1
    FIELDS TERMINATED BY '\t'
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES
    (@StreamingInfoId , @StreamingSiteId, Type, Title, Director, Cast, Country, Date_Added, Release_Year, Rating, Duration, Listed_In, Description)
    SET StreamingSiteId = 1;

LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/amazon_prime_titles_withoutId_empty.txt' INTO TABLE Amazon
    CHARACTER SET latin1
    FIELDS TERMINATED BY '\t'
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES
    (@StreamingSiteId, Type, Title, Director, Cast, Country, Date_Added, Release_Year, Rating, Duration, Listed_In, Description)
    SET StreamingSiteId = 2;
    
    
 LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/disney_plus_titles.txt' INTO TABLE Disney
    CHARACTER SET latin1
    FIELDS TERMINATED BY '\t'
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES
    (@StreamingInfoId , @StreamingSiteId, Type, Title, Director, Cast, Country, Date_Added, Release_Year, Rating, Duration, Listed_In, Description)
    SET StreamingSiteId = 3;
    
 LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/hulu_titles.txt' INTO TABLE Hulu
    CHARACTER SET latin1
    FIELDS TERMINATED BY '\t'
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES
    (@StreamingInfoId , @StreamingSiteId, Type, Title, Director, Cast, Country, Date_Added, Release_Year, Rating, Duration, Listed_In, Description)
    SET StreamingSiteId = 4;

CREATE TABLE StreamingInfo
	SELECT * FROM Netflix
    UNION
    SELECT * FROM Amazon
    UNION
    SELECT * FROM Disney
    UNION
    SELECT * FROM Hulu;

LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/name.basics.tsv'
	INTO TABLE ActorInfo
	FIELDS TERMINATED BY '	' ENCLOSED BY '"'
	LINES TERMINATED BY '\n'
	IGNORE 1 LINES
    (ActorId,Name,BirthYear,@dummy, PrimaryProfession);

LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/actor.media.tsv' 
	INTO TABLE MediaActorMatches
	FIELDS TERMINATED BY '	' ENCLOSED BY '"'
	LINES TERMINATED BY '\n'
	IGNORE 1 LINES
    (TitleId, ActorId);

LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/rotten.tomatoes.csv' 
	INTO TABLE RottenTomatoes
	FIELDS TERMINATED BY ',' ENCLOSED BY '"'
	LINES TERMINATED BY '\n'
	IGNORE 1 LINES
    (Title, RunTime, Status, CriticRating, AudienceRating);
    
LOAD DATA LOCAL INFILE '/Users/zhanghanchen/Desktop/Database_Project/dataset/books_2.csv' 
	INTO TABLE Books
	FIELDS TERMINATED BY ',' ENCLOSED BY '"'
	LINES TERMINATED BY '\n'
	IGNORE 1 LINES;

/**
SELECT Media.Title AS Title, Media.TitleId AS TitleId, Name AS Actor,
	AverageRating AS ImdbAudience, NumVotes AS ImdbNumVotes, CriticRating AS RottenCritic,
    AudienceRating AS RottenAudience, StreamingPlatform, Media.Genres AS Genres, Media.StartYear AS Year,
    Books.URL AS URL
FROM Media 
LEFT OUTER JOIN MediaActorMatches ON Media.TitleId = MediaActorMatches.TitleId
LEFT OUTER JOIN ActorInfo ON MediaActorMatches.ActorId = ActorInfo.ActorId
LEFT OUTER JOIN ImdbRating ON Media.TitleId = ImdbRating.TitleId
LEFT OUTER JOIN StreamingInfo ON Media.Title = StreamingInfo.Title
LEFT OUTER JOIN StreamingSite ON StreamingInfo.StreamingSiteId = StreamingSite.StreamingSiteId
LEFT OUTER JOIN RottenTomatoes ON Media.Title = RottenTomatoes.Title
LEFT OUTER JOIN Books ON Media.Title = Books.BookTitle
WHERE Books.URL IS NOT NULL AND Name IS NOT NULL AND StreamingPlatform IS NOT NULL;
**/
