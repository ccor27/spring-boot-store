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
--create a customer and add an address
insert into customer (name, last_name, email, phone, username, pwd) values ('Archaimbaud', 'Kadwallider', 'akadwallider0@wiley.com', '690-812-7428', 'akadwallider0', '$2a$10$S22x3Jtu9cRyu.zMObhN0.AW9ZdK6jHUbHrj5sTpslqDUjUY1oVTy');
insert into customer (name, last_name, email, phone, username, pwd) values ('Juliet', 'Jay', 'jjay1@nymag.com', '103-128-7608', 'jjay1', '$2a$10$3ccRhUrDxVaRgjDHZ8Pc0ejDv9se7jqxavjDNEkalgQKXYZiqMptq');
insert into customer (name, last_name, email, phone, username, pwd) values ('Mufinella', 'Daily', 'mdaily2@rambler.ru', '897-795-5473', 'mdaily2', '$2a$10$mfEodDi8Nal7kgV3WZl5g.lFNfioQ3DYhuss.UChWWXncUEhPeznK');
insert into customer (name, last_name, email, phone, username, pwd) values ('Nevins', 'Hempshall', 'nhempshall3@accuweather.com', '594-211-9790', 'nhempshall3', '$2a$10$1jDkOW8M.v11yPjQW.mGmOrwp8NXDL9XA6mZbmA2UrDzSugEcAXhy');
insert into customer (name, last_name, email, phone, username, pwd) values ('Octavius', 'Keyho', 'okeyho4@discuz.net', '433-284-6145', 'okeyho4', '$2a$10$cvugr9JtpECScHxlZhwpS.sm8TnUk2UJWQXBPkRxeWXodw7qDeUS2');

insert into customer_roles (customer_id,roles_id) values (1,1)
insert into customer_roles (customer_id,roles_id) values (1,2)
insert into customer_roles (customer_id,roles_id) values (2,2)
insert into customer_roles (customer_id,roles_id) values (3,2)
insert into customer_roles (customer_id,roles_id) values (4,2)
insert into customer_roles (customer_id,roles_id) values (5,2)
--create sales
insert into sale (concept, created_at, price) values ('In hac habitasse platea dictumst.', current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Nullam sit amet turpis elementum ligula vehicula consequat.', current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Nullam porttitor lacus at turpis.', current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Nunc purus.', current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Ut at dolor quis odio consequat varius.', current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Duis bibendum.', current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Donec ut dolor.', current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Suspendisse ornare consequat lectus.',current_timestamp, 0);
insert into sale (concept, created_at, price) values ('Sed sagittis.', current_timestamp, 0);
--add products in the sale
insert into sale_products (sale_id, products_id) values (4, 7);
insert into sale_products (sale_id, products_id) values (4, 8);
insert into sale_products (sale_id, products_id) values (7, 14);



insert into sale_products (sale_id, products_id) values (1, 1);
insert into sale_products (sale_id, products_id) values (1, 2);
insert into sale_products (sale_id, products_id) values (2, 3);
insert into sale_products (sale_id, products_id) values (2, 4);
insert into sale_products (sale_id, products_id) values (3, 5);
insert into sale_products (sale_id, products_id) values (3, 6);


insert into sale_products (sale_id, products_id) values (5, 9);
insert into sale_products (sale_id, products_id) values (5, 10);
insert into sale_products (sale_id, products_id) values (6, 11);
insert into sale_products (sale_id, products_id) values (6, 12);
insert into sale_products (sale_id, products_id) values (7, 13);

insert into sale_products (sale_id, products_id) values (8, 15);
insert into sale_products (sale_id, products_id) values (8, 16);
insert into sale_products (sale_id, products_id) values (9, 17);
insert into sale_products (sale_id, products_id) values (9, 18);
insert into sale_products (sale_id, products_id) values (10, 19);
insert into sale_products (sale_id, products_id) values (10, 20);

