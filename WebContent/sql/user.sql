CREATE  TABLE `user` (
  `user_id` VARCHAR(20) NOT NULL ,
  `user_name` VARCHAR(20) NULL ,
  `password` VARCHAR(20) NULL ,
  `postcode` VARCHAR(8) NULL ,
  `address` VARCHAR(50) NULL ,
  `email` VARCHAR(50) NULL ,
  `job` VARCHAR(30) NULL ,
  `birthday` DATE NULL ,
  PRIMARY KEY (`user_id`)
);

insert into user values('hong','honggil','hong','111-11','busan','hong@n.com','student','2014-12-15');
