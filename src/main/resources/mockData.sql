CREATE SCHEMA IF NOT EXISTS procalc_db;
USE procalc_db;

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
    projectID INT,
    FOREIGN KEY(projectID) REFERENCES project(projectID)
);

CREATE TABLE IF NOT EXISTS task(
    taskID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    taskName VARCHAR(70) NOT NULL,
    taskDescription VARCHAR(256),
    taskTimeEstimate INT NOT NULL,
    subProjectID INT,
    FOREIGN KEY(subProjectID) REFERENCES subProject(subProjectID)
);

-- DML
INSERT INTO project (projectName, startDate, endDate)
VALUES
    ('MockProject1_H2', '2023-10-27', '2024-05-29'),
    ('MockProject2_H2', '2023-12-20', '2024-04-20'),
    ('MockProject3_H2', '2023-12-24', '2024-04-10');


INSERT INTO subProject (subProjectName, startDate, endDate, projectID)
VALUES
    ('SubProject 1_H2', '2024-01-15', '2024-02-28', 1),
    ('SubProject 2_H2', '2024-02-20', '2024-03-31', 1),
    ('SubProject 3_H2', '2024-03-25', '2024-04-30', 2),
    ('SubProject 4_H2', '2024-04-10', '2024-05-31', 2);


INSERT INTO task (taskName, taskDescription, taskTimeEstimate, subProjectID)
VALUES
    ('Task 1_H2', 'Complete initial analysis_H2', 8, 1),
    ('Task 2_H2', 'Develop prototype_H2', 16, 2),
    ('Task 3_H2', 'Test prototype functionality_H2', 10, 1),
    ('Task 4_H2', 'Refine design based on feedback_H2', 12, 2),
    ('Task 5_H2', 'Gather user requirements_H2', 6, 3),
    ('Task 6_H2', 'Design user interface_H2', 14, 3),
    ('Task 7_H2', 'Implement backend functionality_H2', 20, 3),
    ('Task 8_H2', 'Perform integration testing_H2', 10, 1),
    ('Task 9_H2', 'Conduct user testing_H2', 8, 4),
    ('Task 10_H2', 'Document project findings_H2', 10, 4),
    ('Task 11_H2', 'Prepare final presentation_H2', 12, 4);