drop table admin;
create table admin(
    id varchar2(20) primary key,
    pwd varchar2(20),
    name varchar2(40), 
    phone varchar2(20)
);

alter table product drop primary key cascade;
drop table product;
create table product(
    pseq       number(5)     primary key,
    name       varchar2(100),
    kind       char(1),   
    price1     number(7)     default '0',
    price2     number(7)     default '0',
    price3     number(7)     default '0',
    content    varchar2(1000),
    image      varchar2(50)  default 'default.jpg',
    useyn      char(1)       default 'y',
    bestyn     char(1)       default 'n',
    regdate     date         default sysdate  
);

drop sequence product_seq;
create sequence product_seq start with 1;

alter table usermember drop primary key cascade;
drop table usermember;
create table usermember(
    id         varchar2(20)  primary key,
    pwd        varchar2(20),     
    name       varchar2(40),
    email      varchar2(40),
    zip_num    varchar2(7),
    address    varchar2(100),
    address2   varchar2(100),
    phone      varchar2(20),
    useyn      char(1)       default 'y',
    indate     date          default sysdate
);

alter table cart drop primary key cascade;
drop table cart;

delete from cart;
create table cart (
  cseq         number(10)    primary key,  
  id           varchar2(16)   references usermember(id),  
  pseq         number(5)     references product(pseq), 
  quantity     number(5)     default 1,        
  result       char(1)       default '1',      
  indate       date          default SYSDATE   
);
drop sequence cart_seq;
create sequence cart_seq start with 1;

alter table orders drop primary key cascade;
drop table orders;
create table orders(
  oseq		number(10)	primary key,
  id		varchar2(16)	references usermember(id),
  indate	date		default sysdate
);

drop sequence orders_seq;
create sequence orders_seq start with 1;

alter table order_detail drop primary key cascade;
drop table order_detail;
create table order_detail(
   odseq	number(10)	primary key,
   oseq		number(10)	references orders(oseq),
   pseq		number(5)	references product(pseq),
   quantity	number(5)	default 1,
   result	char(1)		default '1'
);

drop sequence order_detail_seq;
create sequence order_detail_seq start with 1;

alter table qna drop primary key cascade;
drop table qna;
create table qna(
   qseq		number(5)	primary key,
   subject	varchar2(300),
   content	varchar2(1000),
   reply	varchar2(1000),
   id		varchar2(20),
   rep		char(1)		default '1',
   indate	date default sysdate
);

drop sequence qna_seq;
create sequence qna_seq start with 1;


insert into admin(id, pwd, name, phone) values
('admin', '1234', '어드민', '010-1111-1111');
insert into admin(id, pwd, name, phone) values
('manager', 'manager', '매니저', '010-2222-2222');

insert into usermember(id, pwd, name, email, zip_num, address, address2, phone) values
('gildong','gildong','홍길동', 'gildong.email.com','122-110','서울시 성동구 성수동1가 1번지 21호','서울아파트 101동 1013호','010-1234-4321');

insert into usermember(id, pwd, name, email, zip_num, address,address2, phone) values
('user','1234','김유저', 'kimuser@email.com','123-111', '서울시 송파구 잠실2동','리센츠 아파트 201동 505호','010-1111-2222');

insert into usermember(id, pwd, name, email, zip_num, address,address2, phone) values
('one', '1111', '김나리', 'kim@email.com', '133-110', '서울시 성동구 성수동2가 1번지 21호','주민아파트 102동 807호','010-7777-7777');
insert into usermember(id, pwd, name, email, zip_num, address,address2, phone) values
('two', '2222', '이백합', 'Leeback@email.com',  '123-111', '서울시 송파구 잠실2동', '리센츠 아파트 201동 505호','010-1234-4567');



insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '편한 티셔츠', '1', '12000', '10000', '2000', '막입기 편한 티셔츠 입니다.','t1.jpg');

insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '민무늬 티셔츠', '1', '18000', '17000', '1000', '깔끔하고 단정한 티셔츠 입니다.','t2.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '가벼운 남방', '1', '19000','18000','1000','가볍고 심플한 남방 입니다.','t3.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '깔끔한 셔츠', '1', '25000', '23000','2000','깔끔하고 단정한 셔츠 입니다.', 't4.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '청 스키니진', '2', '27000','25000','2000','편하고 스판이 들어가있는 청 스키니 입니다.','p1.jpg','y');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '편안한 바지', '2', '27000', '26000', '1000', '신축성이 좋고 편한 바지 입니다.','p2.jpg','y');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '슬랙스', '2', '27000','26500', '500','일자형 슬랙스 입니다.','p3.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '가디건', '3', '28000', '27500', '500', '가볍게 입기좋은 가디건 입니다.', 'o1.jpg');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '바람막이', '3', '36500', '36000','500', '편안하고 입기편한 바람막이 입니다.','o2.jpg','y');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '후드집업' , '3', '25000', '23000', '2000', '가볍고 편한 후드집업 입니다.', 'o3.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '하늘하늘 원피스' , '4', '30000', '28000', '2000','하늘하늘한 원피스 입니다','s1.jpg','y');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '방울무늬 원피스', '4', '32000', '30000','2000','방울무늬가 들어간 원피스 입니다.','s2.jpg');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '롱원피스', '4', '28000', '27000', '1000', '편한 롱원피스 입니다.', 's3.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '선글라스', '5', '27000', '26000', '1000', '이쁜 선글라스 입니다.','j1.jpg');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '반지' , '5', '19500', '19000', '500','탄생석으로 만든 반지 입니다.','j2.jpg');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '목걸이', '5', '18000', '17500',' 500','탄생석으로 만든 목걸이 입니다.', 'j3.jpg');  



insert into cart(cseq,id, pseq, quantity) values(cart_seq.nextval, 'gildong', 1, 1);



insert into orders(oseq, id) values(orders_seq.nextval, 'gildong');
insert into orders(oseq, id) values(orders_seq.nextval, 'gildong');
insert into orders(oseq, id) values(orders_seq.nextval, 'user');


insert into order_detail(odseq, oseq, pseq, quantity) 
values(order_detail_seq.nextval, 1, 1, 1);
insert into order_detail(odseq, oseq, pseq, quantity) 
values(order_detail_seq.nextval, 1, 2, 5);
insert into order_detail(odseq, oseq, pseq, quantity) 
values(order_detail_seq.nextval, 2,  4, 3);
insert into order_detail(odseq, oseq, pseq, quantity) 
values(order_detail_seq.nextval, 3, 3, 1);
insert into order_detail(odseq, oseq, pseq, quantity) 
values(order_detail_seq.nextval, 3, 2, 1);
insert into order_detail(odseq, oseq, pseq, quantity) 
values(order_detail_seq.nextval, 3, 6, 2);
insert into order_detail(odseq, oseq, pseq, quantity) 
values(order_detail_seq.nextval, 3, 1, 2);

insert into qna (qseq, subject, content, id)
values(qna_seq.nextval, '사이즈 문의', '사이즈 문의 입니다', 'gildong');
update qna SET reply='답변내용 입니다', rep='2';

insert into qna (qseq, subject, content, id)
values(qna_seq.nextval, '주문 문의', '주문관련 문의 입니다.', 'gildong');


commit;



create or replace view cart_view
as
select o.cseq, o.id, o.pseq, m.name mname, p.name pname, 
o.quantity, o.indate, p.price2, o.result 
from cart o, usermember m, product p 
where o.id = m.id and o.pseq = p.pseq
and result='1';

create or replace view order_view
as
select d.odseq, o.oseq, o.id, o.indate, d.pseq,d.quantity, m.name mname,
m.zip_num, m.address,m.address2, m.phone, p.name pname, p.price2, d.result   
from orders o, order_detail d, usermember m, product p 
where o.oseq=d.oseq and o.id = m.id and d.pseq = p.pseq;
           

create or replace view best_pro_view
as
select pseq, name, price2, image 
from( select rownum, pseq, name, price2, image 
      from product  
      where bestyn='y' 
      order by regdate desc)
where  rownum <=4;


create or replace view new_pro_view
as
select pseq, name, price2, image 
from( select rownum, pseq, name, price2, image 
      from product  
      where useyn='y' 
      order by regdate desc)
where  rownum <=4;


commit;


@D:\db\zip.sql

select * from usermember;

SELECT * FROM admin;

SELECT * FROM order_view;

SELECT * FROM order_detail;

SELECT * FROM usermember ORDER BY id DESC;

SELECT * FROM  product;

SELECT * FROM qna;

SELECT  pseq,
        name,
        price1,
        price2,
        regdate,
        useyn
FROM (
        select pseq,
                name,
                price1,
                price2,
                regdate,
                useyn,
                row_number() over(ORDER by pseq DESC)as rNum
        from product
                    )mp
WHERE rNum betWeen 1 and 5
ORDER BY pseq DESC;

SELECT  id,
			        name,
			        email,
			        zip_num,
			        address,
			        phone,
			        indate
			FROM (
			        SELECT  id,
					        name,
					        email,
					        zip_num,
					        address,
					        phone,
					        indate,
			                row_number() OVER(ORDER BY id ASC) AS RNUM
			        FROM usermember
			                    )MP
			WHERE RNUM BETWEEN 1 AND 5
			ORDER BY id ASC;

alter table files drop primary key cascade;
drop table files;
CREATE table files(
            fno int not null primary key,
            bno int not null,
            filename varchar(200) not null,
            fileOriName varchar(300) not null,
            fileurl varchar(500) not null
            );

commit;
SELECT * FROM qna ORDER BY qseq DESC;