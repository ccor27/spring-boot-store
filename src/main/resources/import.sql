INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('cristian','osorio','cris@gmail.com','cris@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('camilo','osorio','camilo@gmail.com','camilo@gmail.edu.co')
INSERT INTO TEACHERS (name,last_name,email,degree,institutional_email) VALUES('jose','cardona','jose@gmail.com','engineer','jose@gmail.edu.co')
INSERT INTO TEACHERS (name,last_name,email,degree,institutional_email) VALUES('milena','ramirez','milena@gmail.com','engineer','milena@gmail.edu.co')
INSERT INTO SUBJECT (name,description) VALUES('programming I','learn the bases on programming')
INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(1,1);
INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(1,2);
UPDATE SUBJECT SET teacher_id = 1 WHERE id = 1;
--UPDATE REL_STUDENTS_SUBJECTS SET FK_STUDENT = 1;
--UPDATE REL_STUDENTS_SUBJECTS SET FK_SUBJECT = 1;