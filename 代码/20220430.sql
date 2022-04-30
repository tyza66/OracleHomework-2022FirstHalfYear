/*
1、员工表(yuangong)
结构：	
        yuangongId(员工编号 )		数字(4) /主键
        yuangongName(员工姓名 )	20个长可变长字符串
        yuangongZhiWei(员工职位) 	20个长可变长字符串
        jingLiId(经理编号 )		数字(4)
        ruzhiriqi(入职日期 )		日期
        jibengongzi(基本工资 )		数字(6,2)
        jiangjin(奖金 )			数字(6,2)
        bumenId(部门编号) 		数字(2)/部门表 
数据：
7369, '任盈盈', '职员', 7902, '1980-12-17', 800, NULL, 20
7499, '杨逍', '销售人员', 7698, '1981-2-20', 1600, 300, 30
7521, '范遥', '销售人员', 7698, '1981-2-22', 1250, 500, 30
7566, '任我行', '经理', 7839, '1981-4-2', 2975, NULL, 20
7654, '金毛狮王', '销售人员', 7698, '1981-9-28', 1250, 1400, 30
7698, '张无忌', '经理', 7839, '1981-5-1', 2850, NULL, 30
7782, '苏荃', '经理', 7839, '1981-6-9', 2450, NULL, 10
7788, '东方不败', '分析员', 7566, '1982-12-9', 3000, NULL, 20
7839, '韦小宝', '总裁', NULL, '1981-11-17', 5000, NULL, 10
7844, '紫衫龙王', '销售人员', 7698, '1981-9-8', 1500, 0, 30
7876, '向问天', '职员', 7788, '1983-1-12', 1100, NULL, 20
7900, '小昭', '职员', 7698, '1981-12-3', 950, NULL, 30
7902, '令狐冲', '分析员', 7566, '1981-12-3', 3000, NULL, 20
7934, '双儿', '职员', 7782, '1982-1-23', 1300, NULL, 10

*/
CREATE TABLE yuangong(
        yuangongId	number(4) PRIMARY KEY,
        yuangongName varchar2(20),
        yuangongZhiWei	varchar2(20),
        jingLiId	number(4),
        ruzhiriqi		date,
        jibengongzi	number(6,2),
        jiangjin		number(6,2),
        bumenId 		number(2)
);
INSERT INTO yuangong VALUES(7369, '任盈盈', '职员', 7902, to_date('1980-12-17','yyyy-mm-dd'), 800, NULL, 20);
INSERT INTO yuangong VALUES(7499, '杨逍', '销售人员', 7698, to_date('1981-2-20','yyyy-mm-dd'), 1600, 300, 30);
INSERT INTO yuangong VALUES(7521, '范遥', '销售人员', 7698, to_date('1981-2-22','yyyy-mm-dd'), 1250, 500, 30);
INSERT INTO yuangong VALUES(7566, '任我行', '经理', 7839, to_date('1981-4-2','yyyy-mm-dd'), 2975, NULL, 20);
INSERT INTO yuangong VALUES(7654, '金毛狮王', '销售人员', 7698, to_date('1981-9-28','yyyy-mm-dd'), 1250, 1400, 30);
INSERT INTO yuangong VALUES(7698, '张无忌', '经理', 7839, to_date('1981-5-1','yyyy-mm-dd'), 2850, NULL, 30);
INSERT INTO yuangong VALUES(7782, '苏荃', '经理', 7839, to_date('1981-6-9','yyyy-mm-dd'), 2450, NULL, 10);
INSERT INTO yuangong VALUES(7788, '东方不败', '分析员', 7566, to_date('1982-12-9','yyyy-mm-dd'), 3000, NULL, 20);
INSERT INTO yuangong VALUES(7839, '韦小宝', '总裁', NULL, to_date('1981-11-17','yyyy-mm-dd'), 5000, NULL, 10);
INSERT INTO yuangong VALUES(7844, '紫衫龙王', '销售人员', 7698, to_date('1981-9-8','yyyy-mm-dd'), 1500, 0, 30);
INSERT INTO yuangong VALUES(7876, '向问天', '职员', 7788, to_date('1983-1-12','yyyy-mm-dd'), 1100, NULL, 20);
INSERT INTO yuangong VALUES(7900, '小昭', '职员', 7698, to_date('1981-12-3','yyyy-mm-dd'), 950, NULL, 30);
INSERT INTO yuangong VALUES(7902, '令狐冲', '分析员', 7566, to_date('1981-12-3','yyyy-mm-dd'), 3000, NULL, 20);
INSERT INTO yuangong VALUES(7934, '双儿', '职员', 7782, to_date('1982-1-23','yyyy-mm-dd'), 1300, NULL, 10);
/*
2、部门表(bumen)
结构：
	bumenId(部门编号) 		数字(2)/主键
        	bumenName(部门名称 )	20个可变长长字符串
        	bumendizhi(部门所在地) 	20个可变长长字符串
数据：
10, '总部', '神龙岛'
20, '技术部', '黑木崖'
30, '市场部', '光明顶'
40, '行政部', '嵩山'
*/
CREATE TABLE bumen(
          bumenId 		number(2),
        	bumenName	varchar2(20),
        	bumendizhi 	varchar2(20)
);
INSERT INTO bumen VALUES(10, '总部', '神龙岛');
INSERT INTO bumen VALUES(20, '技术部', '黑木崖');
INSERT INTO bumen VALUES(30, '市场部', '光明顶');
INSERT INTO bumen VALUES(40, '行政部', '嵩山');
--二、
--1、为部门表添加指定数据
INSERT INTO bumen(bumenId) VALUES(999);
--2、为员工表添加指定数据
INSERT INTO yuangong(yuangongId) VALUES(666);
--3、改变员工职位为'职员'为'普通员工'
UPDATE INTO yuangong SET yuangongZhiWei = '普通员工' WHERE yuangongZhiWei = '职员';
--4、所有基本工资不足1200的上涨20%
UPDATE INTO yuangong SET jibengongzi = jibengongzi*1.2 WHERE jibengongzi < 1200;
--5、所有部门编号是10的奖金为300
UPDATE INTO yuangong SET jiangjin = 300 WHERE bumenId = 10;
--6、入职日期1982以前部门编号为30的涨工资10%
UPDATE INTO yuangong SET jibengongzi = jibengongzi*1.1 WHERE (ruzhiriqi < to_date('1982-1-1','yyyy-mm-dd')) AND bumenId = 30;
--7、将双儿开除
DELETE FROM yuangong WHERE yuangongName = '双儿';
--8、将部门标号为20的员工删除
DELETE FROM yuangong WHERE bumenId = 20;
--9、将韦小宝的职位改为总裁助理，基本工资改为原来的50%
UPDATE INTO yuangong SET yuangongZhiWei = '总裁助理',jibengongzi = jibengongzi*0.5 WHERE yuangongName = '韦小宝';
--10、将工资最高的人的职务升为总裁
UPDATE INTO yuangong SET yuangongZhiWei = '总裁' WHERE jibengongzi = MAX(jibengongzi);
--11、清空 员工表
DELETE yuangong;
--四、查询
-----------------------------------4---------------------------------------------
--1、查询员工表所有数据
SELECT * FROM YUANGONG;
--2、查询总裁的基本工资
SELECT * FROM YUANGONG WHERE yuangongZhiWei = '总裁';
--3、所有奖金为空的员工
SELECT * FROM YUANGONG WHERE jiangjin IS NULL;
--4、查询基本工资最高的三个人
SELECT * FROM YUANGONG where rownum <= 3 ORDER BY jibengongzi DESC;
--5、查询技术部的所在地
SELECT bumendizhi FROM bumen WHERE bumenName = '技术部';
--6、查询部门编号为30且奖金大于300元的员工信息
SELECT * FROM YUANGONG WHERE yuangongZhiWei = '总裁';
--7、查询部门编号为20的员工中基本工资最高的员工姓名和工资
--8、查询位于'嵩山'、'黑木崖'、'南海神宫'的部门信息
--9、查询入职日期在1981-5-1到1981-12-31之间的所有员工
--10、查询所有名字为三个字的员工的员工编号,姓名	
--11、查询10号部门的所有经理和20号部门的所有职员的详细信息
--12、查询姓名中没有‘王’字的员工的详细信息
--13、查询员工姓名，将工作年限最长的员工排在最前面
--14、查询'任我行'的基本工资
--15、查询基本工资比'任我行'多的所有员工的姓名和基本工资
--16、查询各个部门经理的基本工资
--17、查询与'东方不败'从事相同工作的员工的详细信息
--18、查询市场部员工的姓名
--19、查询某些员工的姓名和基本工资，
--条件是他们的基本工资与部门30中某一
--个员工的基本工资相同
--20、查询奖金收入比基本工资高的员工的详细信息	

-----------------------------------5---------------------------------------------
--21、查询不同部门的平均基本工资	
--22、查询所有基本工资高于平均基本工资（平均基本工资为所有部门员工的基本工资平均数）的销售人员
--23、显示各种职位的最低基本工资
--24、查询每个部门的人数
--25、查询每个部门入职最早的员工的入职时间和部门编号
--26、显示所有职员的姓名及其所在部门的名称
--27、显示所有员工的姓名、所在部门名称和基本工资
--28、显示不同部门不同职位的平均基本工资,部门名称，职位
--29、查询部门平均工资大于员工平均工资（全体员工平均工资）的部门编号和平均工资
--30、查询没有员工的部门名称
--31、查询 部门当中每个员工基本工资都大于1200的部门名称

-----------------------提高----------------------------------------------------
--32、查询在神龙岛工作员工的编号，姓名，工作部门，工作所在地
--33、查询各个部门员工的人数
--34、查询各个岗位员工基本工资大于平均基本工资（平均基本工资包括所有员工）的人数和员工职位
--35、查询基本工资相同的员工的基本工资和姓名
--36、查询员工的基本工资排名第3-6位的姓名和基本工资
--37、查询员工的基本信息，附加其上级的姓名
--38、查询员工的基本信息，附加其基本工资的排名(基本工资相同的按奖金订先后，如果奖金相同则并列)
--39、查询部门中基本工资不小于2000的人数不止1人的部门名称和人数
--40、员工表中，每页显示4条，显示当前第3页数据



















