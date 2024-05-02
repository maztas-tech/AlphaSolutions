-- DDL
CREATE TABLE IF NOT EXISTS project(
    projectID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    projectName VARCHAR(70) NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS subProject(
    subProjectID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    subProjectName VARCHAR(70) NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    projectID INT NOT NULL,
    FOREIGN KEY(projectID) REFERENCES project(projectID)
);

CREATE TABLE IF NOT EXISTS task(
    taskID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    taskName VARCHAR(70) NOT NULL,
    taskDescription VARCHAR(256),
    taskTimeEstimate INT NOT NULL,
    projectID INT,
    subProjectID INT,
    FOREIGN KEY(projectID) REFERENCES project(projectID),
    FOREIGN KEY(subProjectID) REFERENCES subProject(subProjectID)
);