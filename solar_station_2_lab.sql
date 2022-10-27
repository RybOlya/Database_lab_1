CREATE DATABASE IF NOT EXISTS `solar_system`;
USE `solar_system` ;

DROP TABLE IF EXISTS `installation`;
DROP TABLE IF EXISTS `client_solar`;
DROP TABLE IF EXISTS `installer_company`;
DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `device`;
DROP TABLE IF EXISTS `contact_info`;
DROP TABLE IF EXISTS `solar_system`;
DROP TABLE IF EXISTS `battery`;
DROP TABLE IF EXISTS `solar_panel`;
DROP TABLE IF EXISTS `time_slots_with_low_rate_tariff`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `efficiency`;
DROP TABLE IF EXISTS `city`;
DROP TABLE IF EXISTS `IP_address`;


CREATE TABLE solar_system (
    id INT NOT NULL AUTO_INCREMENT,
    status varchar(35) NOT NULL,
    is_connected bool NOT NULL,
    feed_in_tariff double(8,2) NOT NULL,
    energy_sold int NOT NULL,
    low_rate_tariff double(8,2) NOT NULL,
    offset_of_control int NOT NULL,
    kWp int NULL COMMENT 'Kilowatt peak output',
    house_fuse int NULL COMMENT 'Value per phase in Amperes (e.g. 25 A or 40A)',
    location int NOT NULL,
    CONSTRAINT solar_system_pk PRIMARY KEY (id)
);

CREATE TABLE city (
    name varchar(35) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (name)
);

CREATE TABLE address (
    id int NOT NULL AUTO_INCREMENT,
    city varchar(35) NOT NULL,
    street varchar(50) NOT NULL,
    building_number int NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (id)
);

CREATE TABLE client (
    id int NOT NULL AUTO_INCREMENT,
    surname varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    address_id int NOT NULL,
    contact_info_id int NOT NULL,
    password varchar(100) NOT NULL,
    is_a_company bool NULL,
    CONSTRAINT client_pk PRIMARY KEY (id)
);

CREATE TABLE client_solar (
    id int NOT NULL AUTO_INCREMENT,
    solar_system_id int NOT NULL,
    client_id int NOT NULL,
    CONSTRAINT client_solar_pk PRIMARY KEY (id)
);

CREATE TABLE IP_address (
    IP_address varchar(15) NOT NULL,
    CONSTRAINT IP_address_pk PRIMARY KEY (IP_address)
);

CREATE TABLE contact_info (
    id int NOT NULL AUTO_INCREMENT,
    phone char(12) NOT NULL,
    email varchar(35) NOT NULL,
    CONSTRAINT contact_info_pk PRIMARY KEY (id)
);
CREATE TABLE solar_panel (
    id int NOT NULL AUTO_INCREMENT,
    model varchar(50) NOT NULL,
    type varchar(35) NOT NULL,
    current_angle float NULL,
    CONSTRAINT solar_panel_pk PRIMARY KEY (id)
);

CREATE TABLE battery (
    id int NOT NULL AUTO_INCREMENT,
	model varchar(50) NOT NULL,
    capacity double(5,2) NOT NULL,
    operating_temperature int NOT NULL DEFAULT 20 COMMENT '°C',
    CONSTRAINT battery_pk PRIMARY KEY NONCLUSTERED (id)
);

CREATE TABLE device (
	model varchar(50) NOT NULL,
    solar_system_id int NULL,
    type varchar(15),
	efficiency_id int NOT NULL,
    IP_address varchar(15) NOT NULL,
    CONSTRAINT device_pk PRIMARY KEY  NONCLUSTERED (model)
);

CREATE TABLE efficiency (
    id int NOT NULL AUTO_INCREMENT,
    consumption int NOT NULL,
    production int NOT NULL,
    current_timing timestamp NULL,
    CONSTRAINT efficiency_pk PRIMARY KEY NONCLUSTERED (id)
);

CREATE TABLE installation (
    id int NOT NULL AUTO_INCREMENT,
    cost int NOT NULL,
    installer_company_id int NOT NULL,
    client_solar_id int NOT NULL,
    CONSTRAINT installation_pk PRIMARY KEY (id)
);

CREATE TABLE installer_company (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(35) NOT NULL,
    address_id int NOT NULL,
    contact_info_id int NOT NULL,
    area_coverage int NOT NULL,
    CONSTRAINT installer_company_pk PRIMARY KEY (id)
);

CREATE TABLE time_slots_with_low_rate_tariff (
    low_rate_tariff double(8,2) NOT NULL AUTO_INCREMENT,
    monday_friday_from time NOT NULL,
    monday_friday_to time NOT NULL,
    saturday_from time NOT NULL,
    saturday_to time NOT NULL,
    sunday_from time NOT NULL,
    sunday_to time NOT NULL,
    CONSTRAINT time_slots_with_low_rate_tariff_pk PRIMARY KEY (low_rate_tariff)
);

ALTER TABLE address 
	ADD INDEX city_index (city),
	ADD CONSTRAINT address_city 
    FOREIGN KEY address_city (city)
		REFERENCES city (name);

ALTER TABLE client 
	ADD INDEX surname_index (surname),
	ADD CONSTRAINT client_address 
    FOREIGN KEY client_address (address_id)
		REFERENCES address (id),
	ADD CONSTRAINT client_contact_info 
    FOREIGN KEY client_contact_info (contact_info_id)
		REFERENCES contact_info (id);
        
ALTER TABLE solar_system 
	ADD INDEX low_rate_tariff_index (low_rate_tariff),
	ADD CONSTRAINT solar_system_address 
    FOREIGN KEY solar_system_address (location)
		REFERENCES address (id),

	ADD CONSTRAINT solar_system_time_slots_with_low_rate_tariff 
    FOREIGN KEY solar_system_time_slots_with_low_rate_tariff (low_rate_tariff)
		REFERENCES time_slots_with_low_rate_tariff (low_rate_tariff);

ALTER TABLE client_solar 
	ADD CONSTRAINT client_solar_client 
    FOREIGN KEY client_solar_client (client_id)
		REFERENCES client (id),
        
	ADD CONSTRAINT client_solar_solar_system 
	FOREIGN KEY client_solar_solar_system (solar_system_id)
		REFERENCES solar_system (id);
        

ALTER TABLE device
    ADD INDEX type_index (type),
    ADD CONSTRAINT device_solar_system
	FOREIGN KEY device_solar_system (solar_system_id)
		REFERENCES solar_system (id),
	
    ADD CONSTRAINT device_IP_address 
    FOREIGN KEY device_IP_address (IP_address)
		REFERENCES IP_address (IP_address),
    
	ADD CONSTRAINT device_efficiency 
    FOREIGN KEY device_efficiency (efficiency_id)
		REFERENCES efficiency (id);

ALTER TABLE installation 
	ADD CONSTRAINT installation_client_solar 
    FOREIGN KEY installation_client_solar (client_solar_id)
		REFERENCES client_solar (id),
        
	ADD CONSTRAINT installation_installer_company 
    FOREIGN KEY installation_installer_company (installer_company_id)
		REFERENCES installer_company (id);

ALTER TABLE installer_company 
	ADD INDEX name_index (name),
    ADD INDEX area_coverage_index (area_coverage),
	ADD CONSTRAINT installer_company_address 
	FOREIGN KEY installer_company_address (address_id)
		REFERENCES address (id),
        
	ADD CONSTRAINT installer_company_contact_info 
    FOREIGN KEY installer_company_contact_info (contact_info_id)
		REFERENCES contact_info (id);



INSERT INTO city VALUES ('Lviv');
INSERT INTO city VALUES ('Drohobych');
INSERT INTO city VALUES ('Sokal');
INSERT INTO city VALUES ('Kyiv');
INSERT INTO city VALUES ('Brovary');
INSERT INTO city VALUES ('Odesa');
INSERT INTO city VALUES ('Zhytomyr');
INSERT INTO city VALUES ('Kosiv');
INSERT INTO city VALUES ('Mykolaiv');
INSERT INTO city VALUES ('Ternopil');

INSERT INTO ip_address VALUES ('192.169.0.101');
INSERT INTO ip_address VALUES ('192.169.0.102');
INSERT INTO ip_address VALUES ('192.169.0.103');
INSERT INTO ip_address VALUES ('192.169.0.104');
INSERT INTO ip_address VALUES ('192.169.0.105');
INSERT INTO ip_address VALUES ('192.169.0.106');
INSERT INTO ip_address VALUES ('192.169.0.107');
INSERT INTO ip_address VALUES ('192.169.0.108');
INSERT INTO ip_address VALUES ('192.169.0.109');
INSERT INTO ip_address VALUES ('192.169.0.110');

INSERT INTO time_slots_with_low_rate_tariff VALUES (0.56,'19:00:00','06:00:00','13:00:00','06:00:00','00:00:00','06:00:00');
INSERT INTO time_slots_with_low_rate_tariff VALUES (0.54,'19:00:00','06:00:00','13:00:00','06:00:00','00:00:00','06:00:00');
INSERT INTO time_slots_with_low_rate_tariff VALUES (0.64,'19:00:00','06:00:00','13:00:00','06:00:00','00:00:00','06:00:00');
INSERT INTO time_slots_with_low_rate_tariff VALUES (0.23,'19:00:00','06:00:00','13:00:00','06:00:00','00:00:00','06:00:00');
INSERT INTO time_slots_with_low_rate_tariff VALUES (0.33,'19:00:00','06:00:00','13:00:00','06:00:00','00:00:00','06:00:00');

INSERT INTO efficiency VALUES (1,65,102,'2022-09-22 17:00:00');
INSERT INTO efficiency VALUES (2,32,54,'2022-09-23 18:00:00');
INSERT INTO efficiency VALUES (3,12,54,'2022-09-22 18:00:00');
INSERT INTO efficiency VALUES (4,114,60,'2022-09-24 19:00:00');
INSERT INTO efficiency VALUES (5,65,102,'2022-09-22 17:00:00');
INSERT INTO efficiency VALUES (6,32,54,'2022-09-23 18:00:00');
INSERT INTO efficiency VALUES (7,12,54,'2022-09-25 13:00:00');
INSERT INTO efficiency VALUES (8,154,60,'2022-09-6 13:00:00');
INSERT INTO efficiency VALUES (9,14,64,'2022-09-26 15:00:00');
INSERT INTO efficiency VALUES (10,184,70,'2022-09-27 16:00:00');

INSERT INTO battery VALUES (1,2001,12.00,25);
INSERT INTO battery VALUES (2,2002,48.00,12);
INSERT INTO battery VALUES (3,2003,13.00,25);
INSERT INTO battery VALUES (4,2004,48.00,12);
INSERT INTO battery VALUES (5,2005,76.00,25);

INSERT INTO address VALUES (1,'Lviv','Dzherelna',3);
INSERT INTO address VALUES (2,'Drohobych','Zelena',253);
INSERT INTO address VALUES (3,'Sokal','Horodotska',120);
INSERT INTO address VALUES (4,'Odesa','Bandery',23);
INSERT INTO address VALUES (5,'Zhytomyr','Konotopska',12);
INSERT INTO address VALUES (6,'Kyiv','Dzherelna',7);
INSERT INTO address VALUES (7,'Drohobych','Dzherelna',24);
INSERT INTO address VALUES (8,'Sokal','Konotopska',150);
INSERT INTO address VALUES (9,'Odesa','Horodotska',33);
INSERT INTO address VALUES (10,'Zhytomyr','Zelena',42);

INSERT INTO contact_info VALUES (1,'380980983453','namyniukmykola@gmail.com');
INSERT INTO contact_info VALUES (2,'380923454125','omelkovika@gmail.com');
INSERT INTO contact_info VALUES (3,'380975834545','kivshvaleria@gmail.com');
INSERT INTO contact_info VALUES (4,'380945349834','larena@gmail.com');
INSERT INTO contact_info VALUES (5,'380945343284','nekryva@gmail.com');
INSERT INTO contact_info VALUES (6,'380566634545','suncity@gmail.com');
INSERT INTO contact_info VALUES (7,'380922229834','energo@gmail.com');
INSERT INTO contact_info VALUES (8,'380945777584','zeus@gmail.com');
INSERT INTO contact_info VALUES (9,'380922224534','dream@gmail.com');
INSERT INTO contact_info VALUES (10,'380945447584','ecolines@gmail.com');

INSERT INTO client VALUES (1,'Namyniuk','Mykola',1,1,'123321',0);
INSERT INTO client VALUES (2,'Omelko','Vicktoria',2,2,'654654',1);
INSERT INTO client VALUES (3,'Kivsh','Valeria',4,3,'453453',1);
INSERT INTO client VALUES (4,'Larena','Marta',4,4,'34345',0);
INSERT INTO client VALUES (5,'Nekryva','Maksym',5,5,'23234',1);


INSERT INTO solar_panel VALUES (1,1001,'monocrystalline',20);
INSERT INTO solar_panel VALUES (2,1002,'polycrystalline',45);
INSERT INTO solar_panel VALUES (3,1003,'monocrystalline',35);
INSERT INTO solar_panel VALUES (4,1004,'polycrystalline',45);
INSERT INTO solar_panel VALUES (5,1005,'monocrystalline',46);

INSERT INTO solar_system VALUES (1,'active',1,6.00,34,0.56,50,0,1,1);
INSERT INTO solar_system VALUES (2,'off',0,3.00,300,0.64,50,0,0,2);
INSERT INTO solar_system VALUES (3,'active',1,5.00,34,0.56,50,0,1,3);
INSERT INTO solar_system VALUES (4,'off',0,5.00,456,0.54,50,0,0,4);
INSERT INTO solar_system VALUES (5,'active',1,4.00,655,0.56,50,0,0,5);
INSERT INTO solar_system VALUES (6,'off',0,3.00,564,0.64,50,0,1,6);
INSERT INTO solar_system VALUES (7,'active',1,3.00,340,0.56,50,0,0,7);
INSERT INTO solar_system VALUES (8,'off',0,6.00,766,0.56,50,0,0,8);
INSERT INTO solar_system VALUES (9,'active',1,8.00,76,0.64,50,0,1,9);
INSERT INTO solar_system VALUES (10,'off',0,9.00,655,0.54,50,0,0,10);

INSERT INTO device VALUES (2001,1,'battery', 1,'192.169.0.101');
INSERT INTO device VALUES (2002,1,'battery', 2,'192.169.0.102');
INSERT INTO device VALUES (2003,2,'battery', 8, '192.169.0.108');
INSERT INTO device VALUES (2004,4,'battery', 9, '192.169.0.109');
INSERT INTO device VALUES (2005,9,'battery', 10,'192.169.0.110');
INSERT INTO device VALUES (1001,10,'solar panel', 3, '192.169.0.103');
INSERT INTO device VALUES (1002,1,'solar panel', 4,'192.169.0.104');
INSERT INTO device VALUES (1003,4,'solar panel', 5,'192.169.0.105');
INSERT INTO device VALUES (1004,7,'solar panel',6,'192.169.0.106');
INSERT INTO device VALUES (1005,8,'solar panel',7,'192.169.0.107');


INSERT INTO client_solar VALUES (1,1,1);
INSERT INTO client_solar VALUES (2,2,2);
INSERT INTO client_solar VALUES (3,3,3);
INSERT INTO client_solar VALUES (4,4,4);
INSERT INTO client_solar VALUES (5,5,5);
INSERT INTO client_solar VALUES (6,6,1);
INSERT INTO client_solar VALUES (7,7,2);
INSERT INTO client_solar VALUES (8,8,3);
INSERT INTO client_solar VALUES (9,9,4);
INSERT INTO client_solar VALUES (10,10,5);

INSERT INTO installer_company VALUES (1,'SunCity',6,6,50);
INSERT INTO installer_company VALUES (2,'Energo',7,7,42);
INSERT INTO installer_company VALUES (3,'Zeus',8,8,76);
INSERT INTO installer_company VALUES (4,'Dream Power',9,9,50);
INSERT INTO installer_company VALUES (5,'EcoLine',10,10,42);

INSERT INTO installation VALUES (1,4000,1,1);
INSERT INTO installation VALUES (2,5000,2,2);
INSERT INTO installation VALUES (3,4000,3,3);
INSERT INTO installation VALUES (4,4555,4,4);
INSERT INTO installation VALUES (5,444,5,5);
INSERT INTO installation VALUES (6,2000,1,6);
INSERT INTO installation VALUES (7,5555,2,7);
INSERT INTO installation VALUES (8,3000,3,8);
INSERT INTO installation VALUES (9,8000,4,9);
INSERT INTO installation VALUES (10,8000,5,10);



