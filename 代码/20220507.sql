--创建序列
CREATE SEQUENCE 序列名
--常用序列设置 若没有设置则默认1开始 增量为1
INCREMENT BY 增量
START WITH 初始值
MAXVALUE 最大值    【nomaxvalue】

--序列例子
CREATE SEQUENCE seq_test
increment by 5
start with 2;

--使用序列  【注意】下一个值应该在当前值之后diaoyong
--nextval 下一个值
--currval 当前值

--只有执行了一次nextval之后序列才可以被启动，不然它是没有被定义的
select seq_test.nextval from dual;

--查询序列的当前值
select seq_test.currval from dual;

--删除序列
DROP SEQUENCE seq_test;

/*
主键约束：字段不重复，且不为空 【设置主键约束的条件要求稳定且唯一】
非空约束：不为空
唯一约束：不能重复
检查约束：必须满足指定条件
外键约束：必须符合指定主表指定主键的数据
*/