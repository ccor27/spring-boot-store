--ADMIN
INSERT INTO ADMINS (name,last_name,email) VALUES('admin','admin','admin@gmail.com')
--students
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('cristian','osorio','cris@gmail.com','cris@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('camilo','osorio','camilo@gmail.com','camilo@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('samuel','osorio','samuel@gmail.com','samuel@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('jaco','ramirez','jaco@gmail.com','jaco@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('peter','albeiro','peter@gmail.com','peter@gmail.edu.co')
INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('juan','zuluaga','juan@gmail.com','juan@gmail.edu.co')

--teachers
INSERT INTO TEACHERS (name,last_name,email,institutional_email,degree) VALUES('jose','cardona','jose@gmail.com','jose@gmail.edu.co','engineer')
INSERT INTO TEACHERS (name,last_name,email,degree,institutional_email) VALUES('milena','ramirez','milena@gmail.com','milena@gmail.edu.co','engineer')
INSERT INTO TEACHERS (name,last_name,email,degree,institutional_email) VALUES('fredy','orozco','fredy@gmail.com','fredy@gmail.edu.co','engineer')

--users to students and teachers
--students
INSERT INTO USERS (username,pwd) VALUES('cristian','cristian123')
INSERT INTO USERS (username,pwd) VALUES('camilo','camilo123')
INSERT INTO USERS (username,pwd) VALUES('samuel','samuel123')
INSERT INTO USERS (username,pwd) VALUES('jaco','jaco123')
INSERT INTO USERS (username,pwd) VALUES('peter','peter123')
INSERT INTO USERS (username,pwd) VALUES('juan','juan123')
--teachers
INSERT INTO USERS (username,pwd) VALUES('jose','jose123')
INSERT INTO USERS (username,pwd) VALUES('milena','milena123')
INSERT INTO USERS (username,pwd) VALUES('fredy','fredy123')
--admin
INSERT INTO USERS (username,pwd) VALUES('admin','admin123')

--roles
INSERT INTO ROLES (role_name) VALUES ('ADMIN')
INSERT INTO ROLES (role_name) VALUES ('STUDENT')
INSERT INTO ROLES (role_name) VALUES ('TEACHER')

--relationship between users and roles
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(1,2)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(2,2)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(3,2)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(4,2)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(5,2)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(6,2)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(7,3)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(8,3)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(9,3)
INSERT INTO USERS_ROLES (user_id,role_id) VALUES(10,1)

--relationship between users and students
UPDATE STUDENTS SET user_id=1 WHERE id=1
UPDATE STUDENTS SET user_id=2 WHERE id=2
UPDATE STUDENTS SET user_id=3 WHERE id=3
UPDATE STUDENTS SET user_id=4 WHERE id=4
UPDATE STUDENTS SET user_id=5 WHERE id=5
UPDATE STUDENTS SET user_id=6 WHERE id=6
--relationship between users and teachers
UPDATE TEACHERS SET user_id=7 WHERE id=1
UPDATE TEACHERS SET user_id=8 WHERE id=2
UPDATE TEACHERS SET user_id=9 WHERE id=3
--relationship between users and admin
UPDATE ADMINS SET user_id=10 WHERE id=1



--Subjects
INSERT INTO SUBJECT (name,description,note_one,note_two,note_three,note_four,final_note) VALUES('programming I','learn the bases on programming',0,0,0,0,0)
INSERT INTO SUBJECT (name,description,note_one,note_two,note_three,note_four,final_note) VALUES('programming II','learn java basic II',0,0,0,0,0)
INSERT INTO SUBJECT (name,description,note_one,note_two,note_three,note_four,final_note) VALUES('programming III','learn java basic III',0,0,0,0,0)
INSERT INTO SUBJECT (name,description,note_one,note_two,note_three,note_four,final_note) VALUES('programming VI','learn java basic VI',0,0,0,0,0)
INSERT INTO SUBJECT (name,description,note_one,note_two,note_three,note_four,final_note) VALUES('programming V','learn java basic V',0,0,0,0,0)

--relationship between subject and teachers
UPDATE SUBJECT SET teacher_id = 1 WHERE id = 1;
UPDATE SUBJECT SET teacher_id = 1 WHERE id = 2;
UPDATE SUBJECT SET teacher_id = 1 WHERE id = 3;
UPDATE SUBJECT SET teacher_id = 2 WHERE id = 4;
UPDATE SUBJECT SET teacher_id = 2 WHERE id = 5;

--courses
INSERT INTO COURSES (name,is_approve) VALUES('first semester',0)
INSERT INTO COURSES (name,is_approve) VALUES('second semester',0)
INSERT INTO COURSES (name,is_approve) VALUES('third semester',0)

--relationship between courses and student
--INSERT INTO REL_COURSE_STUDENT (course_id,student_id) VALUES(1,1)
INSERT INTO REL_COURSE_STUDENT (course_id,student_id) VALUES(1,2)
INSERT INTO REL_COURSE_STUDENT (course_id,student_id) VALUES(2,3)
INSERT INTO REL_COURSE_STUDENT (course_id,student_id) VALUES(2,4)
INSERT INTO REL_COURSE_STUDENT (course_id,student_id) VALUES(3,5)
INSERT INTO REL_COURSE_STUDENT (course_id,student_id) VALUES(3,6)

--relationship between subject and course
UPDATE SUBJECT SET course_id=1 WHERE id=1;
UPDATE SUBJECT SET course_id=2 WHERE id=2;
UPDATE SUBJECT SET course_id=3 WHERE id=3;



