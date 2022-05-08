-----------------------------序列----------------------------
--序列对象 ： 提供一系列不重复的数字，【常常用于自动生成主键字段】
select * from student_plus;

--创建序列
create sequence 序列名
--常用序列设置【若没有设置 则默认1开始 增量为1】
increment by 增量
start with 初始值
maxvalue 最大值   【nomaxvalue】

--序列例子
create sequence seq_test
increment by 5
start with 2;

--使用序列  【注】 nextval应该在currval使用之前 调用  否则currval无法使用
--nextval 下一个值
--currval 当前值

--查询序列的下一个值
select seq_test.nextval from dual;
--查询序列的当前值
select seq_test.currval from dual;

--删除序列
drop sequence 序列名

drop sequence seq_test;


---------------------------------约束--------------------------------
/*
primary key 主键约束：字段不重复，且不为空，【设置主键约束的字段 要求 稳定且唯一】
not null 非空约束：不为空
unique 唯一约束：不能重复
check 检查约束：必须满足指定条件
foreign key 外键约束：必须符合指定主表指定主键的数据
*/

drop table student_plus;
/*
以创建学生表为例
学号  唯一标识且稳定--> 主键约束
姓名  非空 
性别    检查约束
联系方式   唯一约束
班号   外键约束
*/

--创建  班级信息表  主(父)表（被参照的表）

create table class_info(
       claid number(2) primary key,
       claname varchar2(30) not null
);

--创建主表后  才可以为从(子)表 添加对应约束
create table student_plus(
     -- 字段名  数据类型(长度) 列级约束
     stuid number(4) primary key,
     stuname varchar2(15) not null,
     stusex char(1) check(stusex='1' or stusex='0'),
     stutel varchar2(15) unique,
     --从表的外键字段 与 主表的主键字段 数据类型及 长度应该一致
     claid number(2),
     --表级约束的定义 ： constraint 约束名 约束类型(要约束的字段)
     constraint student_classinfo_fk foreign key(claid)
     --声明外键约束参考的 主表表名 及主键字段
     references  class_info(claid)
);

--创建班级序列  
create sequence class_info_seq;
select class_info_seq.nextval from dual;
--添加数据 先主表后子表
insert into class_info values(1,'软工4班');
--主键约束效果
insert into class_info values(class_info_seq.nextval,'软工5班');
--非空约束效果
insert into class_info values(class_info_seq.nextval,null);
commit;
select * from class_info

--添加子表数据





select * from student_plus;


