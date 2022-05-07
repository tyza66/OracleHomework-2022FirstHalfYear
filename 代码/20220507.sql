--创建序列
CREATE SEQUENCE 序列名
--常用序列设置
INCREMENT BY 增量
START WITH 初始值
MAXVALUE 最大值    【nomaxvalue】

--序列例子
CREATE SEQUENCE seq_test
increment by 5
start with 2;

--使用序列