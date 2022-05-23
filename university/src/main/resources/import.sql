
-- department table
insert into department (id, name) values (1, 'Physical Sciences');
insert into department (id, name) values (2, 'Clinical Medicine');
insert into department (id, name) values (3, 'Biological Sciences');
insert into department (id, name) values (4, 'Arts and Humanities');
insert into department (id, name) values (5, 'Technology');
insert into department (id, name) values (6, 'Humanities & Social Sciences');

-- professor table
insert into professor (id, name, department_id) values (1, 'John Doe', 5);
insert into professor (id, name, department_id) values (2, 'Frida Mcintosh', 2);
insert into professor (id, name, department_id) values (3, 'Grace Avery', 1);
insert into professor (id, name, department_id) values (4, 'Ada Osborne', 3);
insert into professor (id, name, department_id) values (5, 'Rowan Graves', 1);
insert into professor (id, name, department_id) values (6, 'Selena Owen', 5);
insert into professor (id, name, department_id) values (7, 'Sarahi Barry', 2);
insert into professor (id, name, department_id) values (8, 'Camden Lin', 1);
insert into professor (id, name, department_id) values (9, 'Daniel Hicks', 5);
insert into professor (id, name, department_id) values (10, 'Timothy Hickman', 4);

-- course table
insert into course (id, name, department_id, credits) values(1, 'Pure Mathematics and Mathematical Statistics', 1, 3);
insert into course (id, name, department_id, credits) values(2, 'Applied Mathematics and Theoretical Physics', 1, 4);
insert into course (id, name, department_id, credits) values(3, 'Earth Science', 1, 7);
insert into course (id, name, department_id, credits) values(4, 'Astronomy', 1, 6);
insert into course (id, name, department_id, credits) values(5, 'Physics', 1, 8);
insert into course (id, name, department_id, credits) values(6, 'Geography', 1, 7);
insert into course (id, name, department_id, credits) values(7, 'Materials Science and Metallurgy', 1, 5);
insert into course (id, name, department_id, credits) values(8, 'Chemistry', 1, 1);
insert into course (id, name, department_id, credits) values(9, 'Clinical Biochemistry', 2, 3);
insert into course (id, name, department_id, credits) values(10, 'Clinical Neuroscience', 2, 5);

-- schedule table
insert into schedule (professor_id, course_id, semester, year) values(5, 3, 6, 2012);
insert into schedule (professor_id, course_id, semester, year) values(7, 3, 1, 2013);
insert into schedule (professor_id, course_id, semester, year) values(5, 7, 6, 2010);
insert into schedule (professor_id, course_id, semester, year) values(2, 10, 2, 2004);
insert into schedule (professor_id, course_id, semester, year) values(5, 1, 1, 2011);
insert into schedule (professor_id, course_id, semester, year) values(2, 9, 4, 2005);
insert into schedule (professor_id, course_id, semester, year) values(7, 10, 6, 2009);
insert into schedule (professor_id, course_id, semester, year) values(5, 6, 4, 2007);
insert into schedule (professor_id, course_id, semester, year) values(7, 9, 1, 2014);
insert into schedule (professor_id, course_id, semester, year) values(9, 9, 5, 2011);

-- manually alter sequence to avoid create issues
alter sequence course_id_seq restart with 11;
alter sequence department_id_seq restart with 7;
alter sequence professor_id_seq restart with 11;
alter sequence schedule_id_seq restart with 11;
