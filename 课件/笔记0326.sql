--作业
select * from EMPLOYEES t;
select * from regions ;
select * from countries;
select * from locations;   
select * from departments;
select * from jobs   ;
select * from job_history;
select * from job_grades;

--删除数据
delete from job_grades;

--RDBMS 关系型数据库管理系统  
--SQL 结构化查询语言
/*
SQL组成
-DQL(数据查询语言)
-DML(数据操作语言)
-DDL(数据定义语言)
-TCL(事务控制语言)
-DCL(数据控制语言)

SQL标准
1992
1999  -语义化left outer join
*/

--基本查询
--1，查询所有字段
select * from employees;

--2，查询指定字段
select employee_id from employees;

--3，在员工表查询所有部门id    distinct-去除所有重复的数据
select distinct department_id from employees;

--4，在员工表查询所有员工的employee_id，first_name,salary
select employee_id，first_name,salary from employees;

--5，查询所有员工涨薪20后的薪资 可以使用算术运算符的
select employee_id，first_name,salary,salary+20 from employees;

--6，查询所有员工的完整姓名
select first_name,last_name from employees;

--7，  ||用来字段与字段的合并，
select first_name || last_name from employees;
--8，  || 或字段与字符串的连接   字符串使用单引号''
select first_name || '·' || last_name from employees;
--9，  给字段起别名  空格 或 as
select first_name || '·' || last_name fullname  from employees;
select first_name || '·' || last_name as fullname  from employees;
--10，双引号"" 强制使用指定大小写表示
select first_name || '·' || last_name as "fullname" from employees;

--11，查询符合自定义条件的记录 where子句 条件
--比较运算符 >  <  >=  <=  =   <>
--查询工资高于2000的员工信息
select * from employees where salary > 4000;

--12，查询所有 commission_pct(绩效百分比) 低于0.2 的人
--null空值参与任何的条件中 结果均为假
select * from employees where commission_pct < 0.2;
--null空值参与任何的计算中 结果均null
select commission_pct+0.1 from employees;

--13，查询所有入职日期在1998年之前的员工信息
--日期比较 注意默认的日期格式'DD-MM-YYYY'
select * from employees where hire_date < '1-1月-1998';

--14，逻辑运算符  and  or  not
--查询60部门 工资高于4000的员工信息
select * from employees where department_id = 60 and salary > 4000;

--15，特殊比较运算符
--1）在两个值之间（包含边界）   between 下限 and 上限
--查询工资在 4000--10000之间的员工信息
select * from employees where salary between 4000 and 10000;
--2) 等于 值列表中的一个  in(值列表)
--查询90，60，50部门的所有员工信息
select * from employees where department_id in(90,60,50);

--3) 判断是否为空  is null
select * from employees where commission_pct is null;
--4) 模糊查询  like  配合通配符
-- %表示 0个或至少1个任意字符
--查询 first_name 以'S'开头的员工信息
select * from employees where first_name like 'S%';
-- _表示1个任意字符
--查询 first_name 以'S'开头,长度为6个字的员工信息
select * from employees where first_name like 'S_____';
--【练习】
--查询所有 first_name中含有'e'的员工信息
select * from employees where first_name like '%e%';

--16,特殊比较运算符 与 逻辑非
select * from employees where salary not between 4000 and 10000;
select * from employees where department_id not in(90,60,50);
select * from employees where first_name not like '%e%';

select * from employees where commission_pct is not null;

--17，排序order by   desc  asc(可不写)
--查询所有员工信息，要求按照工资降序排序  desc 降序
select * from employees order by salary desc;

--对所有员工进行排序 工资降序，若工资相同，则按照 入职日期降序排列
select * from employees order by salary desc,hire_date desc;

--虚拟表 dual
select 3+5 from dual;
select substr('abcdefghijklmn',3,4) from dual;
select ascii('兮') from dual;
