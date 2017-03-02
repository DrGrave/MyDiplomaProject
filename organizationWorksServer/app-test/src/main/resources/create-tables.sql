SET FOREIGN_KEY_CHECKS=0
;

/* Drop Tables */

DROP TABLE IF EXISTS `Attorney` CASCADE
;

DROP TABLE IF EXISTS `Group` CASCADE
;

DROP TABLE IF EXISTS `InClass` CASCADE
;

DROP TABLE IF EXISTS `M2M_Group_Timeteable` CASCADE
;

DROP TABLE IF EXISTS `M2M_Professor_Subject` CASCADE
;

DROP TABLE IF EXISTS `Marks` CASCADE
;

DROP TABLE IF EXISTS `Professor` CASCADE
;

DROP TABLE IF EXISTS `Queue` CASCADE
;

DROP TABLE IF EXISTS `Recension` CASCADE
;

DROP TABLE IF EXISTS `Student` CASCADE
;

DROP TABLE IF EXISTS `Subject` CASCADE
;

DROP TABLE IF EXISTS `Timeteable` CASCADE
;

DROP TABLE IF EXISTS `TypeInclass` CASCADE
;

DROP TABLE IF EXISTS `TypeOfAttorney` CASCADE
;

DROP TABLE IF EXISTS `TypeOfWork` CASCADE
;

DROP TABLE IF EXISTS `UserCredentials` CASCADE
;

DROP TABLE IF EXISTS `Work` CASCADE
;

/* Create Tables */

CREATE TABLE `Attorney`
(
`IdAttornery` INT NOT NULL AUTO_INCREMENT,
`IdProfessor` INT NULL,
`idStudent` INT NULL,
`IdSubject` INT NULL,
`IdTypeOfAttorney` INT NULL,
CONSTRAINT `PK_Attorney` PRIMARY KEY (`IdAttornery` ASC)
)

;

CREATE TABLE `Group`
(
`IdGroup` INT NOT NULL AUTO_INCREMENT,
`NumberOfGroup` VARCHAR(50) NOT NULL,
`idStudentStarosta` INT NULL,
`idStudent` INT NULL,
CONSTRAINT `PK_Group` PRIMARY KEY (`IdGroup` ASC)
)

;

CREATE TABLE `InClass`
(
`IdInclass` INT NOT NULL AUTO_INCREMENT,
`idStudent` INT NULL,
`idTypeInclass` INT NULL,
`IdTimeteable` INT NULL,
CONSTRAINT `PK_InClass` PRIMARY KEY (`IdInclass` ASC)
)

;

CREATE TABLE `M2M_Group_Timeteable`
(
`IdGroup` INT NOT NULL,
`IdTimeteable` INT NOT NULL,
CONSTRAINT `PK_M2M_Group_Timeteable` PRIMARY KEY (`IdTimeteable` ASC, `IdGroup` ASC)
)

;

CREATE TABLE `M2M_Professor_Subject`
(
`IdSubject` INT NOT NULL,
`IdProfessor` INT NOT NULL,
CONSTRAINT `PK_M2M_Professor_Subject` PRIMARY KEY (`IdSubject` ASC, `IdProfessor` ASC)
)

;

CREATE TABLE `Marks`
(
`IdMark` INT NOT NULL AUTO_INCREMENT,
`Mark` INT NOT NULL,
`IdTimeteable` INT NULL,
`IdOfWork` INT NULL,
`idStudent` INT NULL,
CONSTRAINT `PK_Marks` PRIMARY KEY (`IdMark` ASC)
)

;

CREATE TABLE `Professor`
(
`IdProfessor` INT NOT NULL AUTO_INCREMENT,
`ProfessorName` VARCHAR(128) NOT NULL,
`ProfessorSurname` VARCHAR(128) NOT NULL,
`ProfessorPatronum` VARCHAR(128) NOT NULL,
CONSTRAINT `PK_Professor` PRIMARY KEY (`IdProfessor` ASC)
)

;

CREATE TABLE `Queue`
(
`IdQueue` INT NOT NULL AUTO_INCREMENT,
`idStudent` INT NOT NULL,
`IdOfWork` INT NOT NULL,
`IdTimeteable` INT NOT NULL,
CONSTRAINT `PK_Queue` PRIMARY KEY (`IdQueue` ASC)
)

;

CREATE TABLE `Recension`
(
`IdRecension` INT NOT NULL,
`TexRecension` TEXT NOT NULL,
`IdQueue` INT NOT NULL,
`Acapted` SMALLINT NOT NULL,
`idStudent` INT NOT NULL,
CONSTRAINT `PK_Recension` PRIMARY KEY (`IdRecension` ASC)
)

;

CREATE TABLE `Student`
(
`idStudent` INT NOT NULL AUTO_INCREMENT,
`Name` VARCHAR(128) NOT NULL,
`Surname` VARCHAR(128) NOT NULL,
`Patronum` VARCHAR(128) NOT NULL,
`Email` VARCHAR(50) NOT NULL,
`IdGroup` INT NOT NULL,
CONSTRAINT `PK_User` PRIMARY KEY (`idStudent` ASC)
)

;

CREATE TABLE `Subject`
(
`IdSubject` INT NOT NULL AUTO_INCREMENT,
`NameOfSubject` VARCHAR(50) NOT NULL,
`IdProfessor` INT NULL,
CONSTRAINT `PK_Subject` PRIMARY KEY (`IdSubject` ASC)
)

;

CREATE TABLE `Timeteable`
(
`IdTimeteable` INT NOT NULL AUTO_INCREMENT,
`DateOfWork` DATE NOT NULL,
`TimeOfStartWork` DATE NOT NULL,
`TimeOfEndWork` DATE NOT NULL,
`IdProfessor` INT NOT NULL,
`Auditory` VARCHAR(10) NOT NULL,
`IdSubject` INT NOT NULL,
CONSTRAINT `PK_Timeteable` PRIMARY KEY (`IdTimeteable` ASC)
)

;

CREATE TABLE `TypeInclass`
(
`idTypeInclass` INT NOT NULL AUTO_INCREMENT,
`NameInclass` VARCHAR(50) NOT NULL,
CONSTRAINT `PK_TypeInclass` PRIMARY KEY (`idTypeInclass` ASC)
)

;

CREATE TABLE `TypeOfAttorney`
(
`IdTypeOfAttorney` INT NOT NULL AUTO_INCREMENT,
`NameOfAttorney` VARCHAR(50) NOT NULL,
CONSTRAINT `PK_TypeOfAttorney` PRIMARY KEY (`IdTypeOfAttorney` ASC)
)

;

CREATE TABLE `TypeOfWork`
(
`IdTypeOfWork` INT NOT NULL AUTO_INCREMENT,
`NameOfTypeOfWork` VARCHAR(50) NOT NULL,
CONSTRAINT `PK_TypeOfWork` PRIMARY KEY (`IdTypeOfWork` ASC)
)

;

CREATE TABLE `UserCredentials`
(
`IdUserCredentials` INT NOT NULL AUTO_INCREMENT,
`Login` VARCHAR(128) NOT NULL,
`Password` VARCHAR(128) NOT NULL,
`Type` INT NOT NULL,
`IdUser` INT NOT NULL,
CONSTRAINT `PK_UserCredentials` PRIMARY KEY (`IdUserCredentials` ASC)
)

;

CREATE TABLE `Work`
(
`IdOfWork` INT NOT NULL AUTO_INCREMENT,
`NumberOfWork` INT NOT NULL,
`NameOfWork` VARCHAR(128) NOT NULL,
`TextOfWork` TEXT NOT NULL,
`IdSubject` INT NOT NULL,
`IdTypeOfWork` INT NULL,
CONSTRAINT `PK_Work` PRIMARY KEY (`IdOfWork` ASC)
)

;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE `Attorney`
ADD INDEX `IXFK_Attorney_Professor` (`IdProfessor` ASC)
;

ALTER TABLE `Attorney`
ADD INDEX `IXFK_Attorney_Student` (`idStudent` ASC)
;

ALTER TABLE `Attorney`
ADD INDEX `IXFK_Attorney_Subject` (`IdSubject` ASC)
;

ALTER TABLE `Attorney`
ADD INDEX `IXFK_Attorney_TypeOfAttorney` (`IdTypeOfAttorney` ASC)
;

ALTER TABLE `InClass`
ADD INDEX `IXFK_InClass_Student` (`idStudent` ASC)
;

ALTER TABLE `InClass`
ADD INDEX `IXFK_InClass_Timeteable` (`IdTimeteable` ASC)
;

ALTER TABLE `InClass`
ADD INDEX `IXFK_InClass_TypeInclass` (`idTypeInclass` ASC)
;

ALTER TABLE `M2M_Group_Timeteable`
ADD INDEX `IXFK_M2M_Group_Timeteable_Group` (`IdGroup` ASC)
;

ALTER TABLE `M2M_Group_Timeteable`
ADD INDEX `IXFK_M2M_Group_Timeteable_Timeteable` (`IdTimeteable` ASC)
;

ALTER TABLE `M2M_Professor_Subject`
ADD INDEX `IXFK_M2M_Professor_Subject_Professor` (`IdProfessor` ASC)
;

ALTER TABLE `M2M_Professor_Subject`
ADD INDEX `IXFK_M2M_Professor_Subject_Subject` (`IdSubject` ASC)
;

ALTER TABLE `Marks`
ADD INDEX `IXFK_Marks_Student` (`idStudent` ASC)
;

ALTER TABLE `Marks`
ADD INDEX `IXFK_Marks_Timeteable` (`IdTimeteable` ASC)
;

ALTER TABLE `Marks`
ADD INDEX `IXFK_Marks_Work` (`IdOfWork` ASC)
;

ALTER TABLE `Queue`
ADD INDEX `IXFK_Queue_Student` (`idStudent` ASC)
;

ALTER TABLE `Queue`
ADD INDEX `IXFK_Queue_Timeteable` (`IdTimeteable` ASC)
;

ALTER TABLE `Queue`
ADD INDEX `IXFK_Queue_Work` (`IdOfWork` ASC)
;

ALTER TABLE `Recension`
ADD INDEX `IXFK_Recension_Queue` (`IdQueue` ASC)
;

ALTER TABLE `Recension`
ADD INDEX `IXFK_Recension_Student` (`idStudent` ASC)
;

ALTER TABLE `Student`
ADD INDEX `IXFK_Student_Group` (`IdGroup` ASC)
;

ALTER TABLE `Timeteable`
ADD INDEX `IXFK_Timeteable_Professor` (`IdProfessor` ASC)
;

ALTER TABLE `Timeteable`
ADD INDEX `IXFK_Timeteable_Subject` (`IdSubject` ASC)
;

ALTER TABLE `Work`
ADD INDEX `IXFK_Work_Subject` (`IdSubject` ASC)
;

ALTER TABLE `Work`
ADD INDEX `IXFK_Work_TypeOfWork` (`IdTypeOfWork` ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE `Attorney`
ADD CONSTRAINT `FK_Attorney_Professor`
FOREIGN KEY (`IdProfessor`) REFERENCES `Professor` (`IdProfessor`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Attorney`
ADD CONSTRAINT `FK_Attorney_Student`
FOREIGN KEY (`idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Attorney`
ADD CONSTRAINT `FK_Attorney_Subject`
FOREIGN KEY (`IdSubject`) REFERENCES `Subject` (`IdSubject`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Attorney`
ADD CONSTRAINT `FK_Attorney_TypeOfAttorney`
FOREIGN KEY (`IdTypeOfAttorney`) REFERENCES `TypeOfAttorney` (`IdTypeOfAttorney`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `InClass`
ADD CONSTRAINT `FK_InClass_Student`
FOREIGN KEY (`idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `InClass`
ADD CONSTRAINT `FK_InClass_Timeteable`
FOREIGN KEY (`IdTimeteable`) REFERENCES `Timeteable` (`IdTimeteable`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `InClass`
ADD CONSTRAINT `FK_InClass_TypeInclass`
FOREIGN KEY (`idTypeInclass`) REFERENCES `TypeInclass` (`idTypeInclass`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `M2M_Group_Timeteable`
ADD CONSTRAINT `FK_M2M_Group_Timeteable_Group`
FOREIGN KEY (`IdGroup`) REFERENCES `Group` (`IdGroup`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `M2M_Group_Timeteable`
ADD CONSTRAINT `FK_M2M_Group_Timeteable_Timeteable`
FOREIGN KEY (`IdTimeteable`) REFERENCES `Timeteable` (`IdTimeteable`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `M2M_Professor_Subject`
ADD CONSTRAINT `FK_M2M_Professor_Subject_Professor`
FOREIGN KEY (`IdProfessor`) REFERENCES `Professor` (`IdProfessor`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `M2M_Professor_Subject`
ADD CONSTRAINT `FK_M2M_Professor_Subject_Subject`
FOREIGN KEY (`IdSubject`) REFERENCES `Subject` (`IdSubject`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Marks`
ADD CONSTRAINT `FK_Marks_Student`
FOREIGN KEY (`idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Marks`
ADD CONSTRAINT `FK_Marks_Timeteable`
FOREIGN KEY (`IdTimeteable`) REFERENCES `Timeteable` (`IdTimeteable`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Marks`
ADD CONSTRAINT `FK_Marks_Work`
FOREIGN KEY (`IdOfWork`) REFERENCES `Work` (`IdOfWork`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Queue`
ADD CONSTRAINT `FK_Queue_Student`
FOREIGN KEY (`idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Queue`
ADD CONSTRAINT `FK_Queue_Timeteable`
FOREIGN KEY (`IdTimeteable`) REFERENCES `Timeteable` (`IdTimeteable`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Queue`
ADD CONSTRAINT `FK_Queue_Work`
FOREIGN KEY (`IdOfWork`) REFERENCES `Work` (`IdOfWork`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Recension`
ADD CONSTRAINT `FK_Recension_Queue`
FOREIGN KEY (`IdQueue`) REFERENCES `Queue` (`IdQueue`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Recension`
ADD CONSTRAINT `FK_Recension_Student`
FOREIGN KEY (`idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Timeteable`
ADD CONSTRAINT `FK_Timeteable_Professor`
FOREIGN KEY (`IdProfessor`) REFERENCES `Professor` (`IdProfessor`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Timeteable`
ADD CONSTRAINT `FK_Timeteable_Subject`
FOREIGN KEY (`IdSubject`) REFERENCES `Subject` (`IdSubject`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Work`
ADD CONSTRAINT `FK_Work_Subject`
FOREIGN KEY (`IdSubject`) REFERENCES `Subject` (`IdSubject`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Work`
ADD CONSTRAINT `FK_Work_TypeOfWork`
FOREIGN KEY (`IdTypeOfWork`) REFERENCES `TypeOfWork` (`IdTypeOfWork`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
;