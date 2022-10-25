CREATE
    DATABASE IF NOT EXISTS solar_system;
USE
    `solar_system`;

DROP TABLE IF EXISTS `client_solar`;
DROP TABLE IF EXISTS `solar_panel`;
DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `battery`;
DROP TABLE IF EXISTS `IP_address`;

CREATE TABLE IP_address (
    IP_address varchar(15) NOT NULL,
    CONSTRAINT IP_address_pk PRIMARY KEY (IP_address)
);


CREATE TABLE solar_panel (
    id int NOT NULL AUTO_INCREMENT,
    model varchar(50) NOT NULL,
    type varchar(35) NOT NULL,
    current_angle float NULL,
    IP_address varchar(15) NOT NULL,
    CONSTRAINT solar_panel_pk PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (IP_address) REFERENCES IP_address (IP_address)
);

CREATE TABLE client (
    id int NOT NULL AUTO_INCREMENT,
    surname varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    is_a_company bool NULL,
    CONSTRAINT client_pk PRIMARY KEY (id)
);

CREATE TABLE battery (
    id int NOT NULL AUTO_INCREMENT,
	model varchar(50) NOT NULL,
    capacity double(5,2) NOT NULL,
    IP_address varchar(15) NOT NULL,
    operating_temperature int NOT NULL DEFAULT 20 COMMENT '°C',
    CONSTRAINT battery_pk PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (IP_address) REFERENCES IP_address (IP_address)
);

CREATE TABLE client_solar (
    id int NOT NULL AUTO_INCREMENT,
    device_model varchar(50) NOT NULL,
    device_type varchar(15) NOT NULL,
    client_id int NOT NULL,
    CONSTRAINT client_solar_pk PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (client_id) REFERENCES client (id)
);

 insert into IP_address
 values ('192.169.0.101'),
        ('192.169.0.102'),
        ('192.169.0.103'),
        ('192.169.0.104'),
		('192.169.0.105'),
        ('192.169.0.106'),
        ('192.169.0.107'),
        ('192.169.0.108'),
        ('192.169.0.109'),
		('192.169.0.110');


 insert into client
 values (1,'Namyniuk','Mykola','hellolol',1),
        (2,'Omelko','Vicktoria','654654',1),
        (3,'Kivsh','Valeria','453453',1),
        (4,'Larena','Marta','34345',0),
        (5,'Nekryva','Maksym','23234',1);

INSERT INTO battery
VALUES (1,'2001',12.00,'192.169.0.101',25),
	   (2,'2002',48.00,'192.169.0.102',12),
	   (3,'2003',13.00,'192.169.0.103',25),
	   (4,'2004',48.00,'192.169.0.104',12),
	   (5,'2005',76.00,'192.169.0.105',25);


INSERT INTO solar_panel
VALUES (1,'1001','monocrystalline',20,'192.169.0.106'),
	 (2,'1002','polycrystalline',45,'192.169.0.107'),
	 (3,'1003','monocrystalline',35,'192.169.0.108'),
	 (4,'1004','polycrystalline',45,'192.169.0.109'),
	 (5,'1005','monocrystalline',46,'192.169.0.110');

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


/**
CREATE TABLE solarPanel
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    genre       VARCHAR(50) NOT NULL,
    rating      INT         NOT NULL,
    engine      VARCHAR(50) NOT NULL,
    platform_id INT         NOT NULL,
    CONSTRAINT FOREIGN KEY (platform_id) REFERENCES IPaddress (id)
);

CREATE TABLE battery
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    money_on_steam    INT NOT NULL,
    number_of_friends INT NOT NULL,
    user_id           INT NULL,
    CONSTRAINT FK_steam_user_user
        FOREIGN KEY (user_id)
            REFERENCES client (id)
);

CREATE TABLE steam_has_game
(
    steam_id INT NOT NULL,
    game_id  INT NOT NULL,
    PRIMARY KEY (steam_id, game_id),
    CONSTRAINT FOREIGN KEY (steam_id) REFERENCES battery (id),
    CONSTRAINT FOREIGN KEY (game_id) REFERENCES solarPanel (id)
);



 insert into IPaddress
 values (1, 'Windows'),
        (2, 'MacOS'),
        (3, 'Linux');


 insert into client
 values (1, 'Roman', 'Onyshkiv',18,1),
        (2, 'Rostyk','Postolaki', 19, 3),
        (3, 'John', 'Doe', 45, 2),
        (4, 'Gustavo', 'Sus', 55, 2),
       (5, 'Steve', 'Jobless', 70, 1 );


 insert into solarPanel
 values (1, 'MMORPG', 2, 'V8', 1),
        (2, 'Shooter', 100, 'Source 2', 1),
        (3, 'Runner', 0,'Unreal Engine 5', 2),
        (4, 'Indy', 4, 'Unity', 3),
        (5, 'Adventure', 50 ,'Frost Engine', 2);


insert into battery
 values (1, 500, 12, 1 ),
        (2, 100, 500, 2),
        (3, 2, 3, 3 ),
        (4, 100500, 0 , 4 ),
        (5, 1, 1, 5);

 insert into steam_has_game
 values (1,1),
        (1,2),
        (2,1),
        (3,3),
        (4,1),
        (4,2),
        (4,3),
        (4,4),
        (4,5),
        (5,2);


**/