--students
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('cristian','osorio','cris@gmail.com','cris@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('camilo','osorio','camilo@gmail.com','camilo@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('samuel','osorio','samuel@gmail.com','samuel@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('jaco','ramirez','jaco@gmail.com','jaco@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('peter','albeiro','peter@gmail.com','peter@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('juan','zuluaga','juan@gmail.com','juan@gmail.edu.co')

--teachers
INSERT INTO TEACHERS (name,last_name,email,degree,institutional_email) VALUES('jose','cardona','jose@gmail.com','engineer','jose@gmail.edu.co')
INSERT INTO TEACHERS (name,last_name,email,degree,institutional_email) VALUES('milena','ramirez','milena@gmail.com','engineer','milena@gmail.edu.co')

--Subjects
INSERT INTO SUBJECT (name,description) VALUES('programming I','learn the bases on programming')
INSERT INTO SUBJECT (name,description) VALUES('programming II','learn java basic')

--relation subject - student
--INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(1,1);
--INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(1,2);
--INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(1,3);
--INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(2,4);
--INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(2,5);
--INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(2,6);

--UPDATE SUBJECT SET teacher_id = 1 WHERE id = 1;
--UPDATE SUBJECT SET teacher_id = 2 WHERE id = 2;

