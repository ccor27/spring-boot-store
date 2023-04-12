--create some products
insert into product (name, description, price, amount, bar_code, origin) values ('Nantucket - Kiwi Berry Cktl.', 'Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 2847.01, 45, 'A-0010-Z', 'Indonesia');
insert into product (name, description, price, amount, bar_code, origin) values ('Horseradish Root', 'Etiam faucibus cursus urna.', 7738.53, 83, 'A-0020-Z', 'Portugal');
insert into product (name, description, price, amount, bar_code, origin) values ('Wine - Casablanca Valley', 'Fusce consequat. Nulla nisl.', 7187.37, 44, 'A-0030-Z', 'China');
insert into product (name, description, price, amount, bar_code, origin) values ('Papayas', 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.', 3299.74, 100, 'A-0040-Z', 'Philippines');
insert into product (name, description, price, amount, bar_code, origin) values ('Tart - Lemon', 'Suspendisse potenti.', 7001.01, 67, 'A-0050-Z', 'Thailand');
insert into product (name, description, price, amount, bar_code, origin) values ('Soup V8 Roasted Red Pepper', 'Donec ut mauris eget massa tempor convallis.', 8197.49, 78, 'A-0060-Z', 'Philippines');
insert into product (name, description, price, amount, bar_code, origin) values ('Thermometer Digital', 'Suspendisse potenti. In eleifend quam a odio.', 985.3, 31, 'A-0070-Z', 'Mexico');
insert into product (name, description, price, amount, bar_code, origin) values ('Cardamon Ground', 'In sagittis dui vel nisl.', 5603.28, 21, 'A-0080-Z', 'Mexico');
insert into product (name, description, price, amount, bar_code, origin) values ('Truffle Cups - White Paper', 'Aliquam non mauris.', 4787.59, 61, 'A-0090-Z', 'Poland');
insert into product (name, description, price, amount, bar_code, origin) values ('French Kiss Vanilla', 'Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla.', 9243.77, 58, 'A-0100-Z', 'China');
insert into product (name, description, price, amount, bar_code, origin) values ('Lettuce - Mini Greens, Whole', 'Suspendisse potenti. Nullam porttitor lacus at turpis.', 6306.05, 86, 'A-0110-Z', 'Colombia');
insert into product (name, description, price, amount, bar_code, origin) values ('Soup - Campbells', 'In blandit ultrices enim.', 9592.32, 47, 'A-0120-Z', 'Greece');
insert into product (name, description, price, amount, bar_code, origin) values ('Squash - Acorn', 'Nulla tellus.', 142.5, 50, 'A-0130-Z', 'Thailand');
insert into product (name, description, price, amount, bar_code, origin) values ('Breadfruit', 'Maecenas pulvinar lobortis est.', 9262.47, 61, 'A-0140-Z', 'Belarus');
insert into product (name, description, price, amount, bar_code, origin) values ('Wine - White, Ej Gallo', 'In sagittis dui vel nisl. Duis ac nibh.', 5937.48, 43, 'A-0150-Z', 'China');
insert into product (name, description, price, amount, bar_code, origin) values ('Cafe Royale', 'Suspendisse potenti. In eleifend quam a odio.', 5862.28, 17, 'A-0160-Z', 'Indonesia');
insert into product (name, description, price, amount, bar_code, origin) values ('Container - Clear 16 Oz', 'Aliquam non mauris.', 2481.99, 58, 'A-0170-Z', 'Azerbaijan');
insert into product (name, description, price, amount, bar_code, origin) values ('Wine - Bourgogne 2002, La', 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 6094.08, 69, 'A-0180-Z', 'United States');
insert into product (name, description, price, amount, bar_code, origin) values ('Yogurt - Peach, 175 Gr', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', 7234.33, 35, 'A-0190-Z', 'China');
insert into product (name, description, price, amount, bar_code, origin) values ('Stock - Beef, White', 'Morbi porttitor lorem id ligula.', 9788.85, 48, 'A-0200-Z', 'Indonesia');
--products sold
--insert into product_sold (name,bar_code,amount,total_price) values('Nantucket - Kiwi Berry Cktl.','NASDAQ',10)
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
insert into customer (name, last_name, email, phone, username, pwd,address_id) values ('Archaimbaud', 'Kadwallider', 'akadwallider0@wiley.com', '690-812-7428', 'akadwallider0', '$2a$10$S22x3Jtu9cRyu.zMObhN0.AW9ZdK6jHUbHrj5sTpslqDUjUY1oVTy',1);
insert into customer (name, last_name, email, phone, username, pwd,address_id) values ('Juliet', 'Jay', 'jjay1@nymag.com', '103-128-7608', 'jjay1', '$2a$10$3ccRhUrDxVaRgjDHZ8Pc0ejDv9se7jqxavjDNEkalgQKXYZiqMptq',2);
insert into customer (name, last_name, email, phone, username, pwd,address_id) values ('Mufinella', 'Daily', 'mdaily2@rambler.ru', '897-795-5473', 'mdaily2', '$2a$10$mfEodDi8Nal7kgV3WZl5g.lFNfioQ3DYhuss.UChWWXncUEhPeznK',3);
insert into customer (name, last_name, email, phone, username, pwd,address_id) values ('Nevins', 'Hempshall', 'nhempshall3@accuweather.com', '594-211-9790', 'nhempshall3', '$2a$10$1jDkOW8M.v11yPjQW.mGmOrwp8NXDL9XA6mZbmA2UrDzSugEcAXhy',4);
insert into customer (name, last_name, email, phone, username, pwd,address_id) values ('Octavius', 'Keyho', 'okeyho4@discuz.net', '433-284-6145', 'okeyho4', '$2a$10$cvugr9JtpECScHxlZhwpS.sm8TnUk2UJWQXBPkRxeWXodw7qDeUS2',5);

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
--add products in the sale
--insert into sale_products (sale_id, products_id) values (1, 1);
--insert into sale_products (sale_id, products_id) values (1, 2);
--insert into sale_products (sale_id, products_id) values (2, 3);
--insert into sale_products (sale_id, products_id) values (2, 4);
--insert into sale_products (sale_id, products_id) values (3, 5);
--insert into sale_products (sale_id, products_id) values (3, 6);
--insert into sale_products (sale_id, products_id) values (4, 7);
--insert into sale_products (sale_id, products_id) values (4, 8);
--insert into sale_products (sale_id, products_id) values (5, 9);
--insert into sale_products (sale_id, products_id) values (5, 10);
--create record
insert into record default values;
--add sale
insert into record_sale_set (record_id,sale_set_id) values (1,1);
insert into record_sale_set (record_id,sale_set_id) values (1,2);
--add record into customer
update customer set record_id=1 where id=1;

