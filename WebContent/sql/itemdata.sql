create table item(
  item_id int primary key auto_increment,
  item_name varchar(20),
  price int,
  description varchar(50),
  picture_url varchar(20)
);

﻿insert into item values(1,'레몬',50,'레몬에 포함된 구연산은 피로회복에 좋습니다. 비타민 C도 풍부합니다.','lemon.jpg');
insert into item values(2,'오렌지',100,'비타민 C가 풍부합니다. 생과일 주스로 마시면 좋습니다.','orange.jpg');
insert into item values(3,'키위',200,'비타민 C가 매우 풍부합니다. 다이어트나 미용에 좋습니다.','kiui.jpg');
insert into item values(4,'포도',300,'폴리페놀을 다량 함유하고 있어 항산화 작용을 합니다.' ,'budou.jpg');
insert into item values(5,'딸기',800,'비타민 C나 플라보노이드를 다량 함유하고 있습니다.','ichigo.jpg');
insert into item values(6,'귤',1000,'시네피린을 함유하고 있어 감기 예방에 좋다고 합니다.','mikan.jpg');