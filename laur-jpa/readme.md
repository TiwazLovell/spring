# JPA Fundamentals

These examples are from the following course [JPA fundamentals](https://www.youtube.com/playlist?list=PLEocw3gLFc8USLd90a_TicWGiMThDtpOJ).

***Lesson 3 - @Enumerated and @Temporal***

- basic example with @Embeddable + @Embedded

***Lesson 4 - @AttributeOverride and Composed Primary keys***

- example for using @AttributeOverrides - @AttributeOverride

- composed primary key example using @IdClass

- comspoed primary key example using @EmbeddedId

***Lesson 5 - Relationships, @OneToOne and Secondary Tables***

- @SecondaryTable example

CREATE TABLE `jpa`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company` INT NULL,
  `street` VARCHAR(45) NULL,
  `number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`miscellaneous` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `details` VARCHAR(45) NULL,
  `company` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
	
- @OneToOne unidirectional

CREATE TABLE `jpa`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kcal` INT NULL,
  `product` INT NULL,
  PRIMARY KEY (`id`));

- @OneToOne bidirectional 

***Lesson 7 - @ManyToMany***

- @ManyToMany unidirectional

CREATE TABLE `jpa`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`professor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`professor_student` (
  `professor` INT NOT NULL,
  `student` VARCHAR(45) NULL);

- @ManyToMany bidirectional

***Lesson 8 - @AssocationOverride and @ElementCollection***

- exemplu cu @AssocationOverride dar pentru @JoinColumn

CREATE TABLE `jpa`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `department` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `jpa`.`employee` 
ADD COLUMN `contract_no` VARCHAR(45) NULL AFTER `department`,
CHANGE COLUMN `department` `department` INT NULL DEFAULT NULL ;

- exemplu cu @AssocationOverride dar pentru @JoinTable

CREATE TABLE `jpa`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`professor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`student_prof` (
  `student` INT NULL,
  `prof` VARCHAR(45) NULL);

- exemplu cu @ElementCollection, @CollectionTable

CREATE TABLE `jpa`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`phone` (
  `number` VARCHAR(45) NOT NULL,
  `person` INT NULL)

***Lesson 10 - Inheritance strategies & @MappedSupperClass***

- @Inheritance(strategy = InheritanceType.SINGLE_TABLE)

CREATE TABLE `jpa`.`animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `dtype` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

- @Inheritance(strategy = InheritanceType.JOINED)

CREATE TABLE `jpa`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`chocolate` (
  `id` INT NOT NULL,
  `kcal` INT NULL,
  PRIMARY KEY (`id`));

- @MappedSuperclass 

CREATE TABLE `jpa`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(45) NULL,
  `gas` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`bicycle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

***Leson 12 - JPQL and using queries***

- JPQL examples

CREATE TABLE `jpa`.`product` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`));

INSERT INTO `jpa`.`product` (`id`, `name`, `price`) VALUES ('1', 'P1', '10');
INSERT INTO `jpa`.`product` (`id`, `name`, `price`) VALUES ('2', 'P2', '15');
INSERT INTO `jpa`.`product` (`id`, `name`, `price`) VALUES ('3', 'P3', '5');
INSERT INTO `jpa`.`product` (`id`, `name`, `price`) VALUES ('4', 'P4', '20');
INSERT INTO `jpa`.`product` (`id`, `name`, `price`) VALUES ('5', 'P5', '15');

- JPQL example between tables with relationship

CREATE TABLE `jpa`.`department` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jpa`.`employee` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `department_id` INT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `jpa`.`department` (`id`, `name`) VALUES ('1', 'DEV');
INSERT INTO `jpa`.`department` (`id`, `name`) VALUES ('2', 'HR');

INSERT INTO `jpa`.`employee` (`id`, `name`, `department_id`) VALUES ('1', 'Daniel', '1');
INSERT INTO `jpa`.`employee` (`id`, `name`, `department_id`) VALUES ('2', 'Radu', '1');
INSERT INTO `jpa`.`employee` (`id`, `name`, `department_id`) VALUES ('3', 'Larisa', '2');

***Lesson 13 - JPA architecture***

CREATE TABLE `jpa`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

***Lesson 15 - Criteria Query***
 
CREATE TABLE `jpa`.`product` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`));
 
INSERT INTO `jpa`.`product` (`id`, `name`, `price`) VALUES ('1', 'P1', '10');
INSERT INTO `jpa`.`product` (`id`, `name`, `price`) VALUES ('2', 'P2', '15');
INSERT INTO `jpa`.`product` (`id`, `name`, `price`) VALUES ('3', 'P3', '20');



