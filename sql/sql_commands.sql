#Create database/schema:

create database localdatabase;

===================================================
CREATE TABLE Messages(
MessageID int,
MessageText varchar(255),
Gender varchar(255),
Age varchar(255)
); 


ALTER TABLE `localdatabase`.`messages` 
CHANGE COLUMN `MessageID` `MessageID` INT(11) NULL AUTO_INCREMENT COMMENT '' ,
ADD UNIQUE INDEX `MessageID_UNIQUE` (`MessageID` ASC)  COMMENT '',
ADD PRIMARY KEY (`MessageID`)  COMMENT '';


=================================================
CREATE TABLE `department` (
    `department_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `dept_name` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`department_id`)
)
AUTO_INCREMENT=115

 
CREATE TABLE `employee` (
    `employee_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NULL DEFAULT NULL,
    `lastname` VARCHAR(50) NULL DEFAULT NULL,
    `birth_date` DATE NULL DEFAULT NULL,
    `cell_phone` VARCHAR(15) NULL DEFAULT NULL,
    `department_id` BIGINT(20) NULL DEFAULT NULL,
    PRIMARY KEY (`employee_id`),
    INDEX `FK_DEPT` (`department_id`),
    CONSTRAINT `FK_DEPT` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
)

==================================================
CREATE TABLE `meeting` (
    `meeting_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `subject` VARCHAR(50) NOT NULL,
    `meeting_date` DATE NOT NULL,
    PRIMARY KEY (`meeting_id`)
)

CREATE TABLE `employee_meeting` (
    `employee_id` BIGINT(10) NOT NULL,
    `meeting_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`employee_id`, `meeting_id`),
    INDEX `FK_MEETING` (`meeting_id`),
    CONSTRAINT `FK_EMPLOYEE` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
    CONSTRAINT `FK_MEETING` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`meeting_id`)
)