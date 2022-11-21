DROP TABLE IF EXISTS users;
CREATE TABLE users(id INTEGER AUTO_INCREMENT PRIMARY KEY, parentid INTEGER, name VARCHAR(50), color VARCHAR(50));

INSERT INTO users(parentid,name,color) VALUES (0,'Warrior','red');
INSERT INTO users(parentid,name,color) VALUES (0,'Wizard','green');
INSERT INTO users(parentid,name,color) VALUES (0,'Priest','white');
INSERT INTO users(parentid,name,color) VALUES (0,'Rogue','yellow');
INSERT INTO users(parentid,name,color) VALUES (1,'Fighter','blue');
INSERT INTO users(parentid,name,color) VALUES (1,'Paladin','lighblue');
INSERT INTO users(parentid,name,color) VALUES (1,'Ranger','lighgreen');
INSERT INTO users(parentid,name,color) VALUES (2,'Mage','grey');
INSERT INTO users(parentid,name,color) VALUES (2,'Specialist wizard','lightgrey');
INSERT INTO users(parentid,name,color) VALUES (3,'Cleric','red');
INSERT INTO users(parentid,name,color) VALUES (3,'Druid','green');
INSERT INTO users(parentid,name,color) VALUES (3,'Priest of specific mythos','white');
INSERT INTO users(parentid,name,color) VALUES (4,'Thief','yellow');
INSERT INTO users(parentid,name,color) VALUES (4,'Bard','blue');
INSERT INTO users(parentid,name,color) VALUES (13,'Assassin','lighblue');

