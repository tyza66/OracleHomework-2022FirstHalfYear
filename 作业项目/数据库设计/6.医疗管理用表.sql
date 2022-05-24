CREATE SEQUENCE ID_medical
increment by 1
start with 1;
CreatE Table medical(
me_id int primary key,
m_time date,
patient_name varchar2(10),
doctor_name varchar2(10),
classify varchar2(10)
);
--drop table medical
insert into medical values (12,to_date('2022-5-24','yyyy-mm-dd'),'Ð¡ºì','asd','ºí¿Æ');
