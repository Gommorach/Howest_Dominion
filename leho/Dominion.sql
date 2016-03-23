/*
SQLyog Community v12.14 (32 bit)
MySQL - 5.6.17 : Database - dominion
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dominion` /*!40100 DEFAULT CHARACTER SET latin1 */;

/*Table structure for table `actions` */

DROP TABLE IF EXISTS `actions`;

CREATE TABLE `actions` (
  `ActionID` int(11) NOT NULL AUTO_INCREMENT,
  `ActionName` varchar(10) NOT NULL,
  `Description` text,
  PRIMARY KEY (`ActionID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `actions` */

insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (1,'Victory','Add x Amount of Victory Points');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (2,'Treasure','Add x amount of coins\r\n');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (3,'Curse','Remove x Amount of Victory Points\r\n');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (4,'Action','Gain x Amount of Action Points');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (5,'Action-Rea','Counter Action-Attack');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (6,'Action-Att','Perform Actions against other Player');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (7,'Draw','Draw x Amount of Cards');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (8,'Buy','Gain x Amount of Buy Points\r\n');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (9,'Reveal ','Reveal x Amount of Cards');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (10,'Trash','Remove x Amount of cards from play');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (11,'Discard','Put x Amount of cards in Discard Pile\r\n');
insert  into `actions`(`ActionID`,`ActionName`,`Description`) values (12,'Pick','Pick x card(s) costing x Amount');

/*Table structure for table `cardactioninfo` */

DROP TABLE IF EXISTS `cardactioninfo`;

CREATE TABLE `cardactioninfo` (
  `CardID` int(11) NOT NULL,
  `ActionID` int(11) NOT NULL,
  PRIMARY KEY (`CardID`,`ActionID`),
  KEY `ActionID` (`ActionID`),
  CONSTRAINT `cardactioninfo_ibfk_1` FOREIGN KEY (`CardID`) REFERENCES `cards` (`CardID`),
  CONSTRAINT `cardactioninfo_ibfk_2` FOREIGN KEY (`ActionID`) REFERENCES `actions` (`ActionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cardactioninfo` */

insert  into `cardactioninfo`(`CardID`,`ActionID`) values (4,1);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (5,1);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (6,1);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (1,2);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (2,2);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (3,2);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (12,2);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (15,2);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (16,2);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (7,3);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (8,4);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (10,4);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (16,4);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (9,5);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (15,6);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (8,7);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (9,7);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (10,7);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (13,7);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (16,7);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (12,8);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (16,8);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (14,10);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (17,10);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (8,11);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (11,12);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (14,12);
insert  into `cardactioninfo`(`CardID`,`ActionID`) values (17,12);

/*Table structure for table `cardcollection` */

DROP TABLE IF EXISTS `cardcollection`;

CREATE TABLE `cardcollection` (
  `CcID` int(11) NOT NULL AUTO_INCREMENT,
  `CardCount` int(11) NOT NULL,
  `Visible` tinyint(1) DEFAULT NULL,
  `GameID` int(11) NOT NULL,
  PRIMARY KEY (`CcID`),
  KEY `GameID` (`GameID`),
  CONSTRAINT `cardcollection_ibfk_2` FOREIGN KEY (`GameID`) REFERENCES `games` (`GameID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `cardcollection` */

insert  into `cardcollection`(`CcID`,`CardCount`,`Visible`,`GameID`) values (1,10,0,1);
insert  into `cardcollection`(`CcID`,`CardCount`,`Visible`,`GameID`) values (3,10,0,1);
insert  into `cardcollection`(`CcID`,`CardCount`,`Visible`,`GameID`) values (4,10,0,1);

/*Table structure for table `cardcollectioninfo` */

DROP TABLE IF EXISTS `cardcollectioninfo`;

CREATE TABLE `cardcollectioninfo` (
  `CcID` int(11) NOT NULL,
  `CardID` int(11) NOT NULL,
  `CardAmount` int(11) NOT NULL,
  PRIMARY KEY (`CcID`,`CardID`),
  KEY `CardID` (`CardID`),
  CONSTRAINT `cardcollectioninfo_ibfk_1` FOREIGN KEY (`CcID`) REFERENCES `cardcollection` (`CcID`),
  CONSTRAINT `cardcollectioninfo_ibfk_2` FOREIGN KEY (`CardID`) REFERENCES `cards` (`CardID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cardcollectioninfo` */

insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,8,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,9,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,10,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,11,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,12,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,13,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,14,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,15,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,16,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (1,17,10);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (3,1,7);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (3,4,3);
insert  into `cardcollectioninfo`(`CcID`,`CardID`,`CardAmount`) values (4,1,7);

/*Table structure for table `cards` */

DROP TABLE IF EXISTS `cards`;

CREATE TABLE `cards` (
  `CardID` int(11) NOT NULL AUTO_INCREMENT,
  `CardName` varchar(20) NOT NULL,
  `Cost` tinyint(4) NOT NULL,
  `CardType` varchar(20) NOT NULL,
  PRIMARY KEY (`CardID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `cards` */

insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (1,'Copper',0,'Treasure');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (2,'Silver',3,'Treasure');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (3,'Gold',6,'Treasure');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (4,'Estate',2,'Victory');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (5,'Duchy',5,'Victory');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (6,'Province',8,'Victory');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (7,'Curse',0,'Curse');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (8,'Cellar',2,'Action');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (9,'Moat',2,'Action-Reaction');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (10,'Village',3,'Action');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (11,'Workshop',3,'Action');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (12,'WoodCutter',3,'Action');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (13,'Smithy',4,'Action');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (14,'Remodel',4,'Action');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (15,'Militia',4,'Action-Attack');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (16,'Market',5,'Action');
insert  into `cards`(`CardID`,`CardName`,`Cost`,`CardType`) values (17,'Mine',5,'Action');

/*Table structure for table `gameplayerinfo` */

DROP TABLE IF EXISTS `gameplayerinfo`;

CREATE TABLE `gameplayerinfo` (
  `GameID` int(11) NOT NULL,
  `PlayerID` int(11) NOT NULL,
  `Turns` int(11) DEFAULT NULL,
  `DeckList` int(11) DEFAULT NULL,
  `DiscardList` int(11) DEFAULT NULL,
  `HandSize` int(11) DEFAULT NULL,
  PRIMARY KEY (`GameID`,`PlayerID`),
  KEY `PlayerID` (`PlayerID`),
  KEY `DeckList` (`DeckList`),
  CONSTRAINT `gameplayerinfo_ibfk_1` FOREIGN KEY (`GameID`) REFERENCES `games` (`GameID`),
  CONSTRAINT `gameplayerinfo_ibfk_2` FOREIGN KEY (`PlayerID`) REFERENCES `players` (`PlayerID`),
  CONSTRAINT `gameplayerinfo_ibfk_3` FOREIGN KEY (`DeckList`) REFERENCES `cardcollection` (`CcID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gameplayerinfo` */

insert  into `gameplayerinfo`(`GameID`,`PlayerID`,`Turns`,`DeckList`,`DiscardList`,`HandSize`) values (1,1,0,3,0,0);
insert  into `gameplayerinfo`(`GameID`,`PlayerID`,`Turns`,`DeckList`,`DiscardList`,`HandSize`) values (1,2,0,4,0,0);

/*Table structure for table `games` */

DROP TABLE IF EXISTS `games`;

CREATE TABLE `games` (
  `GameID` int(11) NOT NULL AUTO_INCREMENT,
  `Cards` int(11) DEFAULT NULL,
  `Trashpile` int(11) DEFAULT NULL,
  `Rounds` int(11) DEFAULT NULL,
  PRIMARY KEY (`GameID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `games` */

insert  into `games`(`GameID`,`Cards`,`Trashpile`,`Rounds`) values (1,1,0,0);

/*Table structure for table `players` */

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
  `PlayerID` int(11) NOT NULL AUTO_INCREMENT,
  `BuyCount` int(11) NOT NULL,
  `ActionCount` int(11) NOT NULL,
  `CoinCount` int(11) NOT NULL,
  `VictoryPoints` int(11) NOT NULL,
  `PlayerName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`PlayerID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `players` */

insert  into `players`(`PlayerID`,`BuyCount`,`ActionCount`,`CoinCount`,`VictoryPoints`,`PlayerName`) values (1,0,0,0,3,'Player01');
insert  into `players`(`PlayerID`,`BuyCount`,`ActionCount`,`CoinCount`,`VictoryPoints`,`PlayerName`) values (2,0,0,0,3,'Pascal');

/*Table structure for table `savedgames` */

DROP TABLE IF EXISTS `savedgames`;

CREATE TABLE `savedgames` (
  `GameID` int(11) NOT NULL,
  `GameDate` timestamp NOT NULL,
  PRIMARY KEY (`GameID`,`GameDate`),
  CONSTRAINT `savedgames_ibfk_1` FOREIGN KEY (`GameID`) REFERENCES `games` (`GameID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `savedgames` */

insert  into `savedgames`(`GameID`,`GameDate`) values (1,'2016-03-22 14:21:49');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
