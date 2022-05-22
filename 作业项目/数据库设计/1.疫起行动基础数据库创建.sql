-- By：tyza66
--管理人员表id自增
CREATE SEQUENCE ID_quarantine_admin
increment by 1
start with 1;
--select ID_quarantine_admin.nextval from dual;
--科室id自增
CREATE SEQUENCE ID_quarantine_admin
increment by 1
start with 1;
--select ID_quarantine_admin.nextval from dual;
--房间id自增
CREATE SEQUENCE ID_quarantine_room
increment by 1
start with 1;
--select ID_quarantine_room.nextval from dual;
--6.科室表
CREATE TABLE quarantine_department(
department_id	number(5)	PRIMARY KEY,
department_name	varchar2(20) NOT NULL,
department_introduce	varchar2(20)
);
--1.管理人员表
CREATE TABLE quarantine_admin(
admin_id	number(2)	PRIMARY KEY ,
admin_name	varchar2(20)	NOT NULL,
admin_sex	char(1) check(admin_sex='1' or admin_sex='0'),
admin_number	varchar2(15)	UNIQUE NOT NULL,
admin_workDate	date,
admin_workCondition	char(1) check(admin_workCondition='2' or admin_workCondition='1' or admin_workCondition='0'),
admin_password	varchar2(12)	NOT NULL,
department_id	number(5),
constraint KESHI foreign key(department_id) references quarantine_department(department_id)
);
--2.隔离人员表
CREATE TABLE quarantine_quarantine(
quarantine_id	varchar2(18)	PRIMARY KEY,
quarantine_name	varchar2(20)	NOT NULL,
quarantine_sex	char(1)	check(quarantine_sex='1' or quarantine_sex='0'),
quarantine_age	number(2)	,
quarantine_number	varchar2(15)	UNIQUE NOT NULL,
quarantine_checkDate	date	NOT NULL,
quarantine_quarantineDate	date	NOT NULL,
quarantine_travelPath		varchar2(255),
quarantine_password	varchar2(12)	NOT NULL,
department_id	number(5),
admin_id	number(2),
constraint KESHI2 foreign key(department_id) references quarantine_department(department_id),
constraint GUANLIYUAN2 foreign key(admin_id) references quarantine_admin(admin_id)
);
--3.管理表
CREATE TABLE quarantine_administration(
admin_id	number(2),
quarantine_id	varchar2(18),
administration_nucleicAR	varchar2(20)	,
administration_detectionTime	varchar2(20)	,
administration_rates	varchar2(20)	,
constraint SHENFENZHENG3 foreign key(quarantine_id) references quarantine_quarantine(quarantine_id),
constraint GUANLIYUAN3 foreign key(admin_id) references quarantine_admin(admin_id)
);
--4.房间表
CREATE TABLE quarantine_room(
room_id	varchar2(15)	PRIMARY KEY,
room_useCondition	char(1)	check(room_useCondition='1' or room_useCondition='0'),
room_amount	number(3),		
department_id	number(5),
constraint KESHI4 foreign key(department_id) references quarantine_department(department_id)
);
--5.消毒表
CREATE TABLE quarantine_disinfect(
disinfect_disinfect	char(1)	check(disinfect_disinfect='1' or disinfect_disinfect='0'),
room_id	varchar2(15),
admin_id	number(2),
constraint FANGJIAN5 foreign key(room_id) references quarantine_room(room_id),
constraint GUANLIYUAN5 foreign key(admin_id) references quarantine_admin(admin_id)
);