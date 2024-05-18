CREATE SCHEMA IF NOT EXISTS procalc_db;
USE procalc_db;
-- DDL
CREATE TABLE IF NOT EXISTS project
(
    projectID   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    projectName VARCHAR(70)     NOT NULL,
    startDate   DATE            NOT NULL,
    endDate     DATE            NOT NULL
    );

CREATE TABLE IF NOT EXISTS subProject
(
    subProjectID   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    subProjectName VARCHAR(70)     NOT NULL,
    startDate      DATE            NOT NULL,
    endDate        DATE            NOT NULL,
    projectID      INT,
    FOREIGN KEY (projectID) REFERENCES project (projectID)
    );

CREATE TABLE IF NOT EXISTS task
(
    taskID           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    taskName         VARCHAR(70)     NOT NULL,
    taskDescription  VARCHAR(256),
    taskTimeEstimate INT             NOT NULL,
    subProjectID     INT,
    FOREIGN KEY (subProjectID) REFERENCES subProject (subProjectID)
    );

CREATE TABLE IF NOT EXISTS department
(
    departmentNO   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    departmentName VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS profile
(
    profileID    INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username     VARCHAR(70)     NOT NULL,
    firstName    VARCHAR(70)     NOT NULL,
    lastName     VARCHAR(70)     NOT NULL,
    roleName     VARCHAR(70)     NOT NULL,
    pw		 VARCHAR(200)	 NOT NULL,
    departmentNO INT,
    FOREIGN KEY (departmentNO) REFERENCES department (departmentNO)
    );

CREATE TABLE IF NOT EXISTS profile_project
(
    profileID INT,
    projectID INT,
    FOREIGN KEY (profileID) REFERENCES profile (profileID),
    FOREIGN KEY (projectID) REFERENCES project (projectID)
    );

CREATE TABLE IF NOT EXISTS ekspertise
(
    ekspertiseID   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ekspertiseName VARCHAR(50),
    level          INT,
    experience     INT
    );


CREATE TABLE IF NOT EXISTS profile_ekspertise
(
    profileID    INT,
    ekspertiseID INT,
    FOREIGN KEY (profileID) REFERENCES profile (profileID),
    FOREIGN KEY (ekspertiseID) REFERENCES ekspertise (ekspertiseID)
    );


-- DML
INSERT INTO project (projectName, startDate, endDate)
VALUES ('Project Alpha', '2023-01-01', '2023-12-31'),
       ('Project Beta', '2023-03-01', '2023-10-31');


INSERT INTO subProject (subProjectName, startDate, endDate, projectID)
VALUES ('Alpha Sub 1', '2023-01-01', '2023-06-30', 1),
       ('Alpha Sub 2', '2023-07-01', '2023-12-31', 1),
       ('Beta Sub 1', '2023-03-01', '2023-06-30', 2),
       ('Beta Sub 2', '2023-07-01', '2023-10-31', 2);


INSERT INTO task (taskName, taskDescription, taskTimeEstimate, subProjectID)
VALUES ('Task A1', 'Description for Task A1', 10, 1),
       ('Task A2', 'Description for Task A2', 15, 1),
       ('Task A3', 'Description for Task A3', 20, 2),
       ('Task B1', 'Description for Task B1', 25, 3),
       ('Task B2', 'Description for Task B2', 30, 4);


INSERT INTO department (departmentName)
VALUES ('Engineering'),
       ('Marketing'),
       ('HR');


INSERT INTO profile (username, firstName, lastName, roleName, pw, departmentNO)
VALUES ('jdoe', 'John', 'Doe', 'Manager','første', 1),
       ('asmith', 'Anna', 'Smith', 'Collaborator','anden', 2),
       ('bjones', 'Bob', 'Jones', 'Collaborator','tredje', 3);


INSERT INTO profile_project (profileID, projectID)
VALUES (1, 1),
       (1, 2),
       (2, 1);


INSERT INTO ekspertise (ekspertiseName, level, experience)
VALUES ('Java', 5, 10),
       ('SQL', 4, 8),
       ('Project Management', 3, 5);


INSERT INTO profile_ekspertise (profileID, ekspertiseID)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 3);