CREATE SCHEMA IF NOT EXISTS MovieNetwork;
USE MovieNetwork;

DROP TABLE IF EXISTS ImdbRating;
DROP TABLE IF EXISTS RottenTomatoes;
DROP TABLE IF EXISTS Amazon;
DROP TABLE IF EXISTS Netflix;
DROP TABLE IF EXISTS Disney;
DROP TABLE IF EXISTS Hulu;
DROP TABLE IF EXISTS StreamingInfo;
DROP TABLE IF EXISTS StreamingSite;
DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS MediaActorMatches;
DROP TABLE IF EXISTS ActorInfo;
DROP TABLE IF EXISTS Media;

CREATE TABLE Media(
    TitleId VARCHAR(50),
    TitleType VARCHAR(50),
    Title VARCHAR(500),
    IsAdult BOOLEAN,
    StartYear INT,
    RuntimeMinutes INT,
    Genres VARCHAR(50),
    CONSTRAINT pk_Media_TitleID PRIMARY KEY (TitleId)
);

CREATE TABLE ImdbRating(
	TitleId VARCHAR(50),
    AverageRating DECIMAL,
    NumVotes INT,
    CONSTRAINT pk_ImdbRating_ImdbId PRIMARY KEY (TitleId),
    CONSTRAINT fk_ImdbRating_ImdbId FOREIGN KEY (TitleId)
		REFERENCES Media(TitleId)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE ActorInfo(
	ActorId VARCHAR(255),
    Name VARCHAR(255) NOT NULL,
    BirthYear INT,
    PrimaryProfession VARCHAR(255),
    CONSTRAINT pk_ActorInfo_ActorId
		PRIMARY KEY (ActorId)
);

CREATE TABLE MediaActorMatches(
	MediaActorId INT Auto_Increment,
	TitleId VARCHAR(255),
    ActorId VARCHAR(255),
    CONSTRAINT pk_MediaActorMatches_MediaActorId
		PRIMARY KEY (MediaActorId),
    CONSTRAINT fk_MediaActorMatches_TitleId 
		FOREIGN KEY (TitleId) 
        REFERENCES Media(TitleId)
        ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT fk_MediaActorMatches_ActorID
		FOREIGN KEY (ActorId)
        REFERENCES ActorInfo(ActorId)
		ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Books(
    BookId VARCHAR(255),
    BookTitle VARCHAR(255) NOT NULL,
    BookAuthor VARCHAR(255),
    AvgRating DECIMAL,
    ISBN13 VARCHAR(255),
    URL VARCHAR(255),
    TitleId VARCHAR(255),
    TvId VARCHAR(255),
    CONSTRAINT pk_Books_BookId PRIMARY KEY (BookId),
	CONSTRAINT fk_Books_TitleId FOREIGN KEY (TitleId)
		REFERENCES Media(TitleId)
		ON UPDATE CASCADE ON DELETE CASCADE
    );


CREATE TABLE StreamingSite(
	StreamingSiteId INT AUTO_INCREMENT,
    StreamingPlatform VARCHAR(255) NOT NULL,
    Url VARCHAR(255) NOT NULL,
    CONSTRAINT PK_StreamingSite_StreamingSiteId PRIMARY KEY (StreamingSiteId)
);

CREATE TABLE Netflix (
	StreamingInfoId INT Auto_Increment,
	StreamingSiteId INT not null,
    Type varchar(255),
    Title varchar(255),
    Director varchar(5000),
	Cast TEXT,
    Country varchar(1000),
    Date_Added varchar(255),
    Release_Year INT,
    Rating varchar(10),
    Duration varchar(255),
 	Listed_In varchar(5000),
	Description TEXT,
	CONSTRAINT PK_Netflix_StreamingInfoId PRIMARY KEY (StreamingInfoId),
	CONSTRAINT FK_Netflix_StreamingSiteId FOREIGN KEY (StreamingSiteId) 
		REFERENCES StreamingSite(StreamingSiteId)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Amazon (
	StreamingInfoId INT Auto_Increment,
	StreamingSiteId INT not null,
    Type varchar(255),
    Title varchar(255),
    Director varchar(5000),
	Cast TEXT,
    Country varchar(1000),
    Date_Added varchar(255),
    Release_Year INT,
    Rating varchar(10),
    Duration varchar(255),
 	Listed_In varchar(5000),
	Description TEXT,
	CONSTRAINT PK_Amazon_StreamingInfoId PRIMARY KEY (StreamingInfoId),
	CONSTRAINT FK_Amazon_StreamingSiteId FOREIGN KEY (StreamingSiteId) 
		REFERENCES StreamingSite(StreamingSiteId)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Disney (
	StreamingInfoId INT Auto_Increment,
	StreamingSiteId INT not null,
    Type varchar(255),
    Title varchar(255),
    Director varchar(5000),
	Cast TEXT,
    Country varchar(1000),
    Date_Added varchar(255),
    Release_Year INT,
    Rating varchar(10),
    Duration varchar(255),
 	Listed_In varchar(5000),
	Description TEXT,
	CONSTRAINT PK_Disney_StreamingInfoId PRIMARY KEY (StreamingInfoId),
	CONSTRAINT FK_Disney_StreamingSiteId FOREIGN KEY (StreamingSiteId) 
		REFERENCES StreamingSite(StreamingSiteId)
		ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE Hulu (
	StreamingInfoId INT Auto_Increment,
	StreamingSiteId INT not null,
    Type varchar(255),
    Title varchar(255),
    Director varchar(5000),
	Cast TEXT,
    Country varchar(1000),
    Date_Added varchar(255),
    Release_Year INT,
    Rating varchar(10),
    Duration varchar(255),
 	Listed_In varchar(5000),
	Description TEXT,
	CONSTRAINT PK_Hulu_StreamingInfoId PRIMARY KEY (StreamingInfoId),
	CONSTRAINT FK_Hulu_StreamingSiteId FOREIGN KEY (StreamingSiteId) 
		REFERENCES StreamingSite(StreamingSiteId)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE RottenTomatoes(
	RottenTomatoesID INT Auto_Increment,
	Title VARCHAR(255),
    RunTime INT,
    Status VARCHAR(50),
    CriticRating INT,
    AudienceRating INT,
    CONSTRAINT PK_RottenTomatoesRating_RottenTomatoesID PRIMARY KEY(RottenTomatoesID)
);
