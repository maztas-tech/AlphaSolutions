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
    subProjectID INT,
    FOREIGN KEY(subProjectID) REFERENCES subProject(subProjectID)
);

-- DML
INSERT INTO project(projectName, startDate, endDate)
VALUES
    ('MockProject1', '2023-10-27', '2024-05-29'),
    ('MockProject2', '2023-12-20', '2024-04-20'),
    ('MockProject3', '2023-12-24', '2024-04-10');

INSERT INTO subProject (subProjectName, startDate, endDate, projectID)
VALUES
    ('SubProject 1', '2024-01-15', '2024-02-28', 1),
    ('SubProject 2', '2024-02-20', '2024-03-31', 1),
    ('SubProject 3', '2024-03-25', '2024-04-30', 2),
    ('SubProject 4', '2024-04-10', '2024-05-31', 2);

INSERT INTO task (taskName, taskDescription, taskTimeEstimate, subProjectID)
VALUES
    ('Task 1', 'Complete initial analysis', 8, 1),
    ('Task 2', 'Develop prototype', 16, 2),
    ('Task 3', 'Test prototype functionality', 10, 1),
    ('Task 4', 'Refine design based on feedback', 12, 2),
    ('Task 5', 'Gather user requirements', 6, 3),
    ('Task 6', 'Design user interface', 14, 3),
    ('Task 7', 'Implement backend functionality', 20, 3),
    ('Task 8', 'Perform integration testing', 10, 2);