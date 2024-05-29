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

create TABLE IF NOT EXISTS role
(
    roleID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    roleName VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS profile
(
    profileID    INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username     VARCHAR(70)     NOT NULL,
    firstName    VARCHAR(70)     NOT NULL,
    lastName     VARCHAR(70)     NOT NULL,
    pw		     VARCHAR(200)	 NOT NULL,
    roleID       INT,
    departmentNO INT,
    FOREIGN KEY (roleID) REFERENCES role (roleID),
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