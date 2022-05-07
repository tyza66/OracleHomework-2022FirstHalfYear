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