--INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('cristian','osorio','cris@gmail.com','cris@gmail.edu.co')
--INSERT INTO STUDENTS (name,last_name,email,institutional_email) VALUES('camilo','osorio','camilo@gmail.com','camilo@gmail.edu.co')
--INSERT INTO TEACHERS (name,last_name,email,degree,institutional_email) VALUES('jose','cardona','jose@gmail.com','engineer','jose@gmail.edu.co')
--INSERT INTO TEACHERS (name,last_name,email,degree,institutional_email) VALUES('milena','ramirez','milena@gmail.com','engineer','milena@gmail.edu.co')-
--INSERT INTO SUBJECT (name,description) VALUES('programming I','learn the bases on programming')
--INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(1,1);
--INSERT INTO REL_STUDENTS_SUBJECTS (subject_id,student_id) VALUES(1,2);
--UPDATE SUBJECT SET teacher_id = 1 WHERE id = 1;
--UPDATE REL_STUDENTS_SUBJECTS SET FK_STUDENT = 1;
--UPDATE REL_STUDENTS_SUBJECTS SET FK_SUBJECT = 1;


--create some products


insert into product (name, description, price, amount, bar_code, origin) values ('Nantucket - Kiwi Berry Cktl.', 'Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 2847.01, 45, 'NASDAQ', 'Indonesia');
insert into product (name, description, price, amount, bar_code, origin) values ('Horseradish Root', 'Etiam faucibus cursus urna.', 7738.53, 83, 'NASDAQ', 'Portugal');
insert into product (name, description, price, amount, bar_code, origin) values ('Wine - Casablanca Valley', 'Fusce consequat. Nulla nisl.', 7187.37, 44, 'NYSE', 'China');
insert into product (name, description, price, amount, bar_code, origin) values ('Papayas', 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.', 3299.74, 100, 'NASDAQ', 'Philippines');
insert into product (name, description, price, amount, bar_code, origin) values ('Tart - Lemon', 'Suspendisse potenti.', 7001.01, 67, 'NYSE', 'Thailand');
insert into product (name, description, price, amount, bar_code, origin) values ('Soup V8 Roasted Red Pepper', 'Donec ut mauris eget massa tempor convallis.', 8197.49, 78, 'NASDAQ', 'Philippines');
insert into product (name, description, price, amount, bar_code, origin) values ('Thermometer Digital', 'Suspendisse potenti. In eleifend quam a odio.', 985.3, 31, 'NYSE', 'Mexico');
insert into product (name, description, price, amount, bar_code, origin) values ('Cardamon Ground', 'In sagittis dui vel nisl.', 5603.28, 21, 'NASDAQ', 'Mexico');
insert into product (name, description, price, amount, bar_code, origin) values ('Truffle Cups - White Paper', 'Aliquam non mauris.', 4787.59, 61, 'NYSE', 'Poland');
insert into product (name, description, price, amount, bar_code, origin) values ('French Kiss Vanilla', 'Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla.', 9243.77, 58, 'NASDAQ', 'China');
insert into product (name, description, price, amount, bar_code, origin) values ('Lettuce - Mini Greens, Whole', 'Suspendisse potenti. Nullam porttitor lacus at turpis.', 6306.05, 86, 'NYSE', 'Colombia');
insert into product (name, description, price, amount, bar_code, origin) values ('Soup - Campbells', 'In blandit ultrices enim.', 9592.32, 47, 'NASDAQ', 'Greece');
insert into product (name, description, price, amount, bar_code, origin) values ('Squash - Acorn', 'Nulla tellus.', 142.5, 50, 'NASDAQ', 'Thailand');
insert into product (name, description, price, amount, bar_code, origin) values ('Breadfruit', 'Maecenas pulvinar lobortis est.', 9262.47, 61, 'NYSE', 'Belarus');
insert into product (name, description, price, amount, bar_code, origin) values ('Wine - White, Ej Gallo', 'In sagittis dui vel nisl. Duis ac nibh.', 5937.48, 43, 'NASDAQ', 'China');
insert into product (name, description, price, amount, bar_code, origin) values ('Cafe Royale', 'Suspendisse potenti. In eleifend quam a odio.', 5862.28, 17, 'NYSE', 'Indonesia');
insert into product (name, description, price, amount, bar_code, origin) values ('Container - Clear 16 Oz', 'Aliquam non mauris.', 2481.99, 58, 'NASDAQ', 'Azerbaijan');
insert into product (name, description, price, amount, bar_code, origin) values ('Wine - Bourgogne 2002, La', 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 6094.08, 69, 'NASDAQ', 'United States');
insert into product (name, description, price, amount, bar_code, origin) values ('Yogurt - Peach, 175 Gr', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', 7234.33, 35, 'NYSE', 'China');
insert into product (name, description, price, amount, bar_code, origin) values ('Stock - Beef, White', 'Morbi porttitor lorem id ligula.', 9788.85, 48, 'NASDAQ', 'Indonesia');

--create couple roles
INSERT INTO role (authority) VALUES ('ADMIN')
INSERT INTO role (authority) VALUES ('CUSTOMER')
--create some address
insert into address (street, country, zip_code, city, state) values ('2336 Mcguire Way', 'United States', '92619', 'Irvine', 'California');
insert into address (street, country, zip_code, city, state) values ('39 Declaration Place', 'United States', '95113', 'San Jose', 'California');
insert into address (street, country, zip_code, city, state) values ('5666 Darwin Crossing', 'United States', '33915', 'Cape Coral', 'Florida');
insert into address (street, country, zip_code, city, state) values ('868 Rockefeller Circle', 'United States', '44760', 'Canton', 'Ohio');
insert into address (street, country, zip_code, city, state) values ('9085 Northwestern Drive', 'United States', '21229', 'Baltimore', 'Maryland');
insert into address (street, country, zip_code, city, state) values ('964 Nelson Court', 'United States', '32808', 'Orlando', 'Florida');
insert into address (street, country, zip_code, city, state) values ('9 Melvin Park', 'United States', '40215', 'Louisville', 'Kentucky');
insert into address (street, country, zip_code, city, state) values ('24 Hermina Trail', 'United States', '85067', 'Phoenix', 'Arizona');
insert into address (street, country, zip_code, city, state) values ('00724 Fieldstone Junction', 'United States', '33436', 'Boynton Beach', 'Florida');
insert into address (street, country, zip_code, city, state) values ('80 Victoria Court', 'United States', '20319', 'Washington', 'District of Columbia');
insert into address (street, country, zip_code, city, state) values ('9 Hazelcrest Street', 'United States', '30311', 'Atlanta', 'Georgia');
insert into address (street, country, zip_code, city, state) values ('023 Anthes Crossing', 'United States', '99210', 'Spokane', 'Washington');
insert into address (street, country, zip_code, city, state) values ('78172 Russell Crossing', 'United States', '77228', 'Houston', 'Texas');
insert into address (street, country, zip_code, city, state) values ('83 Moulton Trail', 'United States', '92165', 'San Diego', 'California');
insert into address (street, country, zip_code, city, state) values ('7633 Donald Point', 'United States', '10039', 'New York City', 'New York');
insert into address (street, country, zip_code, city, state) values ('646 Bartillon Way', 'United States', '08650', 'Trenton', 'New Jersey');
insert into address (street, country, zip_code, city, state) values ('61 Johnson Place', 'United States', '31136', 'Atlanta', 'Georgia');
insert into address (street, country, zip_code, city, state) values ('4460 Magdeline Park', 'United States', '75210', 'Dallas', 'Texas');
insert into address (street, country, zip_code, city, state) values ('69267 Nelson Drive', 'United States', '10024', 'New York City', 'New York');
insert into address (street, country, zip_code, city, state) values ('54695 Vernon Way', 'United States', '94263', 'Sacramento', 'California');
--create a customer and add an address
insert into customer (name, last_name, email, phone, username, pwd) values ('Archaimbaud', 'Kadwallider', 'akadwallider0@wiley.com', '690-812-7428', 'akadwallider0', 'yv3ZhL');
insert into customer (name, last_name, email, phone, username, pwd) values ('Juliet', 'Jay', 'jjay1@nymag.com', '103-128-7608', 'jjay1', 'eH5WfS5Np');
insert into customer (name, last_name, email, phone, username, pwd) values ('Mufinella', 'Daily', 'mdaily2@rambler.ru', '897-795-5473', 'mdaily2', 'ocqca8');
insert into customer (name, last_name, email, phone, username, pwd) values ('Nevins', 'Hempshall', 'nhempshall3@accuweather.com', '594-211-9790', 'nhempshall3', 'lPeVnRhtf');
insert into customer (name, last_name, email, phone, username, pwd) values ('Octavius', 'Keyho', 'okeyho4@discuz.net', '433-284-6145', 'okeyho4', '29XuVogKMiA');
insert into customer (name, last_name, email, phone, username, pwd) values ('Evan', 'Buck', 'ebuck5@ebay.co.uk', '973-263-0678', 'ebuck5', 'dTEXpwAax27');
insert into customer (name, last_name, email, phone, username, pwd) values ('Ilysa', 'Bhar', 'ibhar6@cornell.edu', '649-912-3907', 'ibhar6', 'ivlsj0MF');
insert into customer (name, last_name, email, phone, username, pwd) values ('Anabella', 'Jellybrand', 'ajellybrand7@jimdo.com', '228-772-0262', 'ajellybrand7', '2NcLppAPE8J');
insert into customer (name, last_name, email, phone, username, pwd) values ('Clementius', 'Helliar', 'chelliar8@mozilla.org', '358-138-8304', 'chelliar8', 'NhmVZi');
insert into customer (name, last_name, email, phone, username, pwd) values ('Ronna', 'Campbell-Dunlop', 'rcampbelldunlop9@deviantart.com', '635-339-2221', 'rcampbelldunlop9', '7VvpDih2L8G');
insert into customer (name, last_name, email, phone, username, pwd) values ('Leonardo', 'Byres', 'lbyresa@amazon.de', '443-377-0545', 'lbyresa', 'tfNdFSqsMOI');
insert into customer (name, last_name, email, phone, username, pwd) values ('Aguste', 'Buxy', 'abuxyb@woothemes.com', '832-979-0026', 'abuxyb', 'RloJ3kDTr6');
insert into customer (name, last_name, email, phone, username, pwd) values ('Tresa', 'Glasman', 'tglasmanc@gov.uk', '165-794-7605', 'tglasmanc', 'Md3f2Y3s');
insert into customer (name, last_name, email, phone, username, pwd) values ('Abner', 'Lonergan', 'alonergand@usda.gov', '204-543-4621', 'alonergand', 'XsOcxlev');
insert into customer (name, last_name, email, phone, username, pwd) values ('Tera', 'Hugk', 'thugke@chronoengine.com', '409-463-4108', 'thugke', 'dr6Kurm');
insert into customer (name, last_name, email, phone, username, pwd) values ('Merola', 'Burkin', 'mburkinf@smugmug.com', '924-728-3246', 'mburkinf', 'cBWYVqe');
insert into customer (name, last_name, email, phone, username, pwd) values ('Milty', 'Brunke', 'mbrunkeg@nature.com', '337-759-3222', 'mbrunkeg', 'nk43V6okOrO');
insert into customer (name, last_name, email, phone, username, pwd) values ('Ethelbert', 'Souten', 'esoutenh@dot.gov', '576-355-8306', 'esoutenh', 'H6eP7iMYk');
insert into customer (name, last_name, email, phone, username, pwd) values ('Ophelia', 'Badcock', 'obadcocki@intel.com', '964-286-3334', 'obadcocki', 'L42PeE');
insert into customer (name, last_name, email, phone, username, pwd) values ('Nils', 'Romand', 'nromandj@dyndns.org', '382-361-1555', 'nromandj', 'OO74SWNNsl');
UPDATE customer SET address_id=2 WHERE id = 1;

--create sales
insert into sale (concept, created_at, price, customer_id) values ('In hac habitasse platea dictumst.', current_timestamp, 0, 3);
insert into sale (concept, created_at, price, customer_id) values ('Nullam sit amet turpis elementum ligula vehicula consequat.', current_timestamp, 0, 5);
insert into sale (concept, created_at, price, customer_id) values ('Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', current_timestamp, 0, 7);
insert into sale (concept, created_at, price, customer_id) values ('Nullam porttitor lacus at turpis.', current_timestamp, 0, 10);
insert into sale (concept, created_at, price, customer_id) values ('Nunc purus.', current_timestamp, 0, 7);
insert into sale (concept, created_at, price, customer_id) values ('Ut at dolor quis odio consequat varius.', current_timestamp, 0, 4);
insert into sale (concept, created_at, price, customer_id) values ('Duis bibendum.', current_timestamp, 0, 4);
insert into sale (concept, created_at, price, customer_id) values ('Donec ut dolor.', current_timestamp, 0, 3);
insert into sale (concept, created_at, price, customer_id) values ('Suspendisse ornare consequat lectus.',current_timestamp, 0, 6);
insert into sale (concept, created_at, price, customer_id) values ('Sed sagittis.', current_timestamp, 0, 5);
--add products in the sale
insert into sale_products (sale_id, products_id) values (1, 1);
insert into sale_products (sale_id, products_id) values (1, 2);
insert into sale_products (sale_id, products_id) values (2, 3);
insert into sale_products (sale_id, products_id) values (2, 4);
insert into sale_products (sale_id, products_id) values (3, 5);
insert into sale_products (sale_id, products_id) values (3, 6);
insert into sale_products (sale_id, products_id) values (4, 7);
insert into sale_products (sale_id, products_id) values (4, 8);
insert into sale_products (sale_id, products_id) values (5, 9);
insert into sale_products (sale_id, products_id) values (5, 10);
insert into sale_products (sale_id, products_id) values (6, 11);
insert into sale_products (sale_id, products_id) values (6, 12);
insert into sale_products (sale_id, products_id) values (7, 13);
insert into sale_products (sale_id, products_id) values (7, 14);
insert into sale_products (sale_id, products_id) values (8, 15);
insert into sale_products (sale_id, products_id) values (8, 16);
insert into sale_products (sale_id, products_id) values (9, 17);
insert into sale_products (sale_id, products_id) values (9, 18);
insert into sale_products (sale_id, products_id) values (10, 19);
insert into sale_products (sale_id, products_id) values (10, 20);