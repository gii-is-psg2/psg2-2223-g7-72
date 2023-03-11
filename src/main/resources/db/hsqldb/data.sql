INSERT INTO users(username,password,enabled) VALUES ('admin1','4dm1n',TRUE),
('owner1','0wn3r',TRUE),('owner2','0wn3r',TRUE),('owner3','0wn3r',TRUE),
('owner4','0wn3r',TRUE),('owner5','0wn3r',TRUE),('owner6','0wn3r',TRUE),
('owner7','0wn3r',TRUE),('owner8','0wn3r',TRUE),('owner9','0wn3r',TRUE),
('owner10','0wn3r',TRUE),('vet1','v3t',TRUE),('japarejo','psg2',TRUE);

INSERT INTO authorities(id,username,authority) VALUES (1,'admin1','admin'),
(2,'owner1','owner'),(3,'owner2','owner'),(4,'owner3','owner'),
(5,'owner4','owner'),(6,'owner5','owner'),(7,'owner6','owner'),
(8,'owner7','owner'),(9,'owner8','owner'),(10,'owner9','owner'),
(11,'owner10','owner'),(12,'vet1','veterinarian'),(13,'japarejo','admin');

INSERT INTO vets(id, first_name,last_name) VALUES (1, 'James', 'Carter'),
(2, 'Helen', 'Leary'),(3, 'Linda', 'Douglas'),(4, 'Rafael', 'Ortega'),
(5, 'Henry', 'Stevens'),(6, 'Sharon', 'Jenkins');

INSERT INTO specialties VALUES (1, 'radiology'),(2, 'surgery'),(3, 'dentistry');

INSERT INTO vet_specialties VALUES (2, 1),(3, 2),(3, 3),(4, 2),(5, 1);

INSERT INTO types VALUES (1, 'cat'), (2, 'dog'), (3, 'lizard'), (4, 'snake'),
(5, 'bird'), (6, 'hamster'), (7,'parrot'), (8, 'goldfish'), (9,'mouse');

INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023', 'owner1'),
(2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749', 'owner2'),
(3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763', 'owner3'),
(4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198', 'owner4'),
(5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765', 'owner5'),
(6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654', 'owner6'),
(7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387', 'owner7'),
(8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683', 'owner8'),
(9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435', 'owner9'),
(10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487', 'owner10');

INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES 
(1, 'Leo', '2010-09-07', 1, 1),(2, 'Basil', '2012-08-06', 6, 2),
(3, 'Rosy', '2011-04-17', 2, 3),(4, 'Jewel', '2010-03-07', 2, 3),
(5, 'Iggy', '2010-11-30', 3, 4),(6, 'George', '2010-01-20', 4, 5),
(7, 'Samantha', '2012-09-04', 1, 6),(8, 'Max', '2012-09-04', 1, 6),
(9, 'Lucky', '2011-08-06', 5, 7),(10, 'Mulligan', '2007-02-24', 2, 8),
(11, 'Freddy', '2010-03-09', 5, 9),(12, 'Lucky', '2010-06-24', 2, 10),
(13, 'Sly', '2012-06-08', 1, 10);

INSERT INTO visits(id,pet_id,visit_date,description) VALUES 
(1, 7, '2013-01-01', 'rabies shot'),(2, 8, '2013-01-02', 'rabies shot'),
(3, 8, '2013-01-03', 'neutered'), (4, 7, '2013-01-04', 'spayed');

INSERT INTO pet_hotel(id,pet_id,owner_id,start,finish) VALUES 
(1, 1, 1, '2023-04-10', '2023-04-13'),
(2, 1, 1, '2023-04-15', '2023-04-16'),
(3, 1, 1, '2023-05-04', '2023-05-06');

