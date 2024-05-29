INSERT INTO project (projectName, startDate, endDate)
VALUES ('Project Alpha_H2', '2023-01-01', '2023-12-31'),
       ('Project Beta_H2', '2023-03-01', '2023-10-31');


INSERT INTO subProject (subProjectName, startDate, endDate, projectID)
VALUES ('Alpha Sub 1_H2', '2023-01-01', '2023-06-30', 1),
       ('Alpha Sub 2_H2', '2023-07-01', '2023-12-31', 1),
       ('Beta Sub 1_H2', '2023-03-01', '2023-06-30', 2),
       ('Beta Sub 2_H2', '2023-07-01', '2023-10-31', 2);


INSERT INTO task (taskName, taskDescription, taskTimeEstimate, subProjectID)
VALUES ('Task A1_H2', 'Description for Task A1', 10, 1),
       ('Task A2_H2', 'Description for Task A2', 15, 1),
       ('Task A3_H2', 'Description for Task A3', 20, 2),
       ('Task B1_H2', 'Description for Task B1', 25, 3),
       ('Task B2_H2', 'Description for Task B2', 30, 4);


INSERT INTO department (departmentName)
VALUES ('Engineering_H2'),
       ('Marketing_H2'),
       ('HR_H2');

INSERT INTO role (roleName)
VALUES ('Manager_H2'),
       ('Collaborator_H2');


INSERT INTO profile (username, firstName, lastName, roleID, pw, departmentNO)
VALUES ('jdoe_H2', 'John_H2', 'Doe_H2', 1,'første', 1),
       ('asmith_H2', 'Anna_H2', 'Smith_H2', 2,'anden', 2),
       ('bjones_H2', 'Bob_H2', 'Jones_H2', 2,'tredje', 3);


INSERT INTO profile_project (profileID, projectID)
VALUES (1, 1),
       (1, 2),
       (2, 1);


INSERT INTO ekspertise (ekspertiseName, level, experience)
VALUES ('Java_H2', 5, 10),
       ('SQL_H2', 4, 8),
       ('Project Management_H2', 3, 5);


INSERT INTO profile_ekspertise (profileID, ekspertiseID)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 3);