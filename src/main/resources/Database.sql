CREATE
    DATABASE IF NOT EXISTS solar_system;
USE
    `solar_system`;


DROP TABLE IF EXISTS `installer_company`;
DROP TABLE IF EXISTS `client_solar`;
DROP TABLE IF EXISTS `contact_info`;
DROP TABLE IF EXISTS `solar_panel`;
DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `battery`;
DROP TABLE IF EXISTS `IP_address`;

CREATE TABLE contact_info (
    id int NOT NULL AUTO_INCREMENT,
    phone char(12) NOT NULL,
    email varchar(35) NOT NULL,
    CONSTRAINT contact_info_pk PRIMARY KEY (id)
);

CREATE TABLE installer_company (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(35) NOT NULL,
    contact_info_id int NOT NULL,
    area_coverage int NOT NULL,
    CONSTRAINT FOREIGN KEY (contact_info_id) REFERENCES contact_info (id),
    CONSTRAINT installer_company_pk PRIMARY KEY (id)
);

CREATE TABLE ip_address (
    id int NOT NULL AUTO_INCREMENT,
    ip_address varchar(15) NOT NULL,
    CONSTRAINT IP_address_pk PRIMARY KEY (id)
);


CREATE TABLE solar_panel (
    id int NOT NULL AUTO_INCREMENT,
    model varchar(50) NOT NULL,
    type varchar(35) NOT NULL,
    current_angle float NULL,
    ip_address_id int NOT NULL,
    CONSTRAINT solar_panel_pk PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (ip_address_id) REFERENCES ip_address (id)
);

CREATE TABLE client (
    id int NOT NULL AUTO_INCREMENT,
    surname varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    contact_info_id int NOT NULL,
    password varchar(100) NOT NULL,
    is_a_company bool NULL,
    CONSTRAINT FOREIGN KEY (contact_info_id) REFERENCES contact_info (id),
    CONSTRAINT client_pk PRIMARY KEY (id)
);

CREATE TABLE battery (
    id int NOT NULL AUTO_INCREMENT,
	model varchar(50) NOT NULL,
    capacity double(5,2) NOT NULL,
	ip_address_id int NOT NULL,
    operating_temperature int NOT NULL DEFAULT 20 COMMENT '°C',
    CONSTRAINT battery_pk PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (ip_address_id) REFERENCES ip_address (id)
);

CREATE TABLE client_solar (
    id int NOT NULL AUTO_INCREMENT,
    device_model varchar(50) NOT NULL,
    device_type varchar(15) NOT NULL,
    client_id int NOT NULL,
    CONSTRAINT client_solar_pk PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (client_id) REFERENCES client (id)
);

 insert into ip_address
 values (1,'192.169.0.101'),
        (2,'192.169.0.102'),
        (3,'192.169.0.103'),
        (4,'192.169.0.104'),
		(5,'192.169.0.105'),
        (6,'192.169.0.106'),
        (7,'192.169.0.107'),
        (8,'192.169.0.108'),
        (9,'192.169.0.109'),
		(10,'192.169.0.110');

INSERT INTO contact_info VALUES (1,'380980983453','namyniukmykola@gmail.com'),
								(2,'380923454125','omelkovika@gmail.com'),
                                (3,'380975834545','kivshvaleria@gmail.com'),
                                (4,'380945349834','larena@gmail.com'),
                                (5,'380945343284','nekryva@gmail.com'),
                                (6,'380566634545','suncity@gmail.com'),
                                (7,'380922229834','energo@gmail.com'),
                                (8,'380945777584','zeus@gmail.com'),
                                (9,'380922224534','dream@gmail.com'),
                                (10,'380945447584','ecolines@gmail.com');

 insert into client
 values (1,'Namyniuk','Mykola',1,'hellolol',1),
        (2,'Omelko','Vicktoria',2,'654654',1),
        (3,'Kivsh','Valeria',3,'453453',1),
        (4,'Larena','Marta',4,'34345',0),
        (5,'Nekryva','Maksym',5,'23234',1);

insert into installer_company
values (1,'SunCity',6,50),
	   (2,'Energo',7,42),
	   (3,'Zeus',8,76),
	   (4,'Dream Power',9,150),
	   (5,'EcoLine',10,42);

insert into battery
values (1,'2001',12.00,1,25),
	   (2,'2002',48.00,2,12),
	   (3,'2003',13.00,3,25),
	   (4,'2004',48.00,4,12),
	   (5,'2005',76.00,5,25);


INSERT INTO solar_panel
VALUES (1,'1001','monocrystalline',20,6),
	 (2,'1002','polycrystalline',45,7),
	 (3,'1003','monocrystalline',35,8),
	 (4,'1004','polycrystalline',45,9),
	 (5,'1005','monocrystalline',46,10);

 insert into client_solar
 values (1,'2001','battery',1),
        (2,'1001','panel',1),
        (3,'2002','battery',2),
        (4,'1002','panel',2),
        (5,'2003','battery',3),
        (6,'1003','panel',3),
        (7,'1004','battery',4),
        (8,'1004','panel',4),
        (9,'2005','battery',5),
        (10,'1005','panel',5);