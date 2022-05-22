--测试用表
INSERT INTO quarantine_department values(ID_quarantine_department.nextval,'第一科室','测试');
SELECT * FROM quarantine_department;
INSERT INTO quarantine_admin values(ID_quarantine_admin.nextval,'SDM','1','15909808523',to_date('2022-5-22','yyyy-mm-dd'),'1','123456',2);
SELECT * FROM quarantine_admin;