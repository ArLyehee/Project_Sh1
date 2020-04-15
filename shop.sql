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
('admin', '1234', '����', '010-1111-1111');
insert into admin(id, pwd, name, phone) values
('manager', 'manager', '�Ŵ���', '010-2222-2222');

insert into usermember(id, pwd, name, email, zip_num, address, address2, phone) values
('gildong','gildong','ȫ�浿', 'gildong.email.com','122-110','����� ������ ������1�� 1���� 21ȣ','�������Ʈ 101�� 1013ȣ','010-1234-4321');

insert into usermember(id, pwd, name, email, zip_num, address,address2, phone) values
('user','1234','������', 'kimuser@email.com','123-111', '����� ���ı� ���2��','������ ����Ʈ 201�� 505ȣ','010-1111-2222');

insert into usermember(id, pwd, name, email, zip_num, address,address2, phone) values
('one', '1111', '�質��', 'kim@email.com', '133-110', '����� ������ ������2�� 1���� 21ȣ','�ֹξ���Ʈ 102�� 807ȣ','010-7777-7777');
insert into usermember(id, pwd, name, email, zip_num, address,address2, phone) values
('two', '2222', '�̹���', 'Leeback@email.com',  '123-111', '����� ���ı� ���2��', '������ ����Ʈ 201�� 505ȣ','010-1234-4567');



insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '���� Ƽ����', '1', '12000', '10000', '2000', '���Ա� ���� Ƽ���� �Դϴ�.','t1.jpg');

insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '�ι��� Ƽ����', '1', '18000', '17000', '1000', '����ϰ� ������ Ƽ���� �Դϴ�.','t2.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '������ ����', '1', '19000','18000','1000','������ ������ ���� �Դϴ�.','t3.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '����� ����', '1', '25000', '23000','2000','����ϰ� ������ ���� �Դϴ�.', 't4.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, 'û ��Ű����', '2', '27000','25000','2000','���ϰ� ������ ���ִ� û ��Ű�� �Դϴ�.','p1.jpg','y');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '����� ����', '2', '27000', '26000', '1000', '���༺�� ���� ���� ���� �Դϴ�.','p2.jpg','y');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '������', '2', '27000','26500', '500','������ ������ �Դϴ�.','p3.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '�����', '3', '28000', '27500', '500', '������ �Ա����� ����� �Դϴ�.', 'o1.jpg');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '�ٶ�����', '3', '36500', '36000','500', '����ϰ� �Ա����� �ٶ����� �Դϴ�.','o2.jpg','y');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '�ĵ�����' , '3', '25000', '23000', '2000', '������ ���� �ĵ����� �Դϴ�.', 'o3.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '�ϴ��ϴ� ���ǽ�' , '4', '30000', '28000', '2000','�ϴ��ϴ��� ���ǽ� �Դϴ�','s1.jpg','y');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '��﹫�� ���ǽ�', '4', '32000', '30000','2000','��﹫�̰� �� ���ǽ� �Դϴ�.','s2.jpg');


insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(
product_seq.nextval, '�տ��ǽ�', '4', '28000', '27000', '1000', '���� �տ��ǽ� �Դϴ�.', 's3.jpg','n');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '���۶�', '5', '27000', '26000', '1000', '�̻� ���۶� �Դϴ�.','j1.jpg');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '����' , '5', '19500', '19000', '500','ź�������� ���� ���� �Դϴ�.','j2.jpg');


insert into product(pseq, name, kind, price1, price2, price3, content, image) values(
product_seq.nextval, '�����', '5', '18000', '17500',' 500','ź�������� ���� ����� �Դϴ�.', 'j3.jpg');  



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
values(qna_seq.nextval, '������ ����', '������ ���� �Դϴ�', 'gildong');
update qna SET reply='�亯���� �Դϴ�', rep='2';

insert into qna (qseq, subject, content, id)
values(qna_seq.nextval, '�ֹ� ����', '�ֹ����� ���� �Դϴ�.', 'gildong');


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