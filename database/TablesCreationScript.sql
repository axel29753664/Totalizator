CREATE TABLE IF NOT EXISTS `users` (
  `UserID`    BIGINT(20)             NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45)            NOT NULL,
  `LastName`  VARCHAR(45)            NOT NULL,
  `Login`     VARCHAR(45)            NOT NULL,
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),
  `Password`  VARCHAR(20)            NOT NULL,
  `admin`     BOOLEAN DEFAULT FALSE  NOT NULL,
PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `main_events` (
  `MainEventID`        BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `MainEventName`      VARCHAR(45)  NOT NULL,
  `MainEventAddTime`   INT(11)      NOT NULL,
  `MainEventStartTime` INT(11)      NOT NULL,
  `MainEventEndTime`   INT(11)      NOT NULL,
  `MainEventInfo`      VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MainEventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `events` (
  `EventID`   BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `EventName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`EventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `bets` (
  BetID             BIGINT(20) AUTO_INCREMENT,
  UserID            BIGINT(20)      NOT NULL,
  EventID           BIGINT(20)      NOT NULL,
  Bet_Sum           BIGINT UNSIGNED NOT NULL,
  Winning_Condition BOOLEAN         NOT NULL,
  PRIMARY KEY (BetID),
  FOREIGN KEY (UserID) REFERENCES users (UserID),
  FOREIGN KEY (EventID) REFERENCES events (EventID)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `accounts` (
  `AccountID`      BIGINT(20) NOT NULL AUTO_INCREMENT,
  `AccountBalance` BIGINT     NOT NULL,
  PRIMARY KEY (`AccountID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `userAccounts` (
  `UserAccountID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `AccountID`     BIGINT(20) NOT NULL,
  `UserID`        BIGINT(20) NOT NULL,
  PRIMARY KEY (`UserAccountID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `transactions` (
  `TransactionID`      BIGINT(20) NOT NULL AUTO_INCREMENT,
  `TransactionTime`    TIMESTAMP  NOT NULL,
  `TransactionAmmount` BIGINT     NOT NULL,
  `AccountID`          BIGINT(20),
  PRIMARY KEY (`TransactionID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;
