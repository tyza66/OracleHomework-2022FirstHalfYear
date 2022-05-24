CREATE SEQUENCE ID_message_info
increment by 1
start with 1;
CreatE Table message_info(
m_id int primary key,
phone varchar(11),
m_time date,
passage varchar2(255)
--constraint DIANHUA foreign key(phone) references quarantine_quarantine(quarantine_number)
);
select * from message_info;
insert INTO message_info values(1,'123456',to_date('1980-12-17','yyyy-mm-dd'),'gou');
insert INTO message_info values(2,'123457',to_date('1980-12-17','yyyy-mm-dd'),'mao');
