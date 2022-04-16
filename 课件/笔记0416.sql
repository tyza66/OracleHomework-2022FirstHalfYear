
------------------子查询--------------------

--0 查询last_name为Abel 的工资
select salary from employees where last_name = 'Abel';

--1 谁的工资比Abel高？
select * from employees where salary > 11000;

--()中的查询语句为子查询 可以单独执行
--包含子查询的查询 语句叫主查询
--一条sql实现 多个小步骤的 复杂查询
--单行子查询
select * from employees 
where salary > (select salary from employees where last_name = 'Abel');

--2 查询工资最低的员工的信息-子查询执行顺序在主查询之前
select * from employees where salary = (select min(salary) from employees);

--3 查询和149号员工同部门的其他员工的信息
select * from employees 
where department_id = 149号员工的部门编号 and employee_id <> 149;
--149号员工的部门编号
select department_id from employees where employee_id = 149;
--整合
select * from employees 
where department_id = (select department_id from employees where employee_id = 149) 
and employee_id <> 149;

--4 查询比202号员工的部门经理的工资还高的员工信息
--1，查询工资必指定人 高的员工信息
select * from employees where salary > 202号员工的部门经理的工资
--2，查询某人工资
select salary from employees where employee_id = 202号员工的部门经理编号
--3，查某个人的经理编号
select manager_id from employees where employee_id = 202;

--整合
select * from employees 
where salary > (select salary from employees 
                       where employee_id = (select manager_id from employees 
                                                   where employee_id = 202))
                                                   
--5 查询员工编号，姓名，工资，员工表的工资总和(子查询也可以放在select子句中)
select e.employee_id,e.first_name||e.last_name fullname,
       e.salary,e.salary*(1+nvl(e.commission_pct,0)) fullsalary,
       (select sum(salary*(1+nvl(commission_pct,0))) from employees)
from employees e;

--伪列  rownum
select rownum,employee_id,first_name||last_name fullname from employees;
--【注1】rownum与*不可以同时存在
select rownum,* from employees;

--6 查询工资最高的前5名员工的信息
select rownum,employee_id,first_name,salary from employees
order by salary desc;
--[将先查询后排序的顺序 改为 先排序后执行]
select rownum,employee_id,first_name,salary from (select * from employees order by salary desc)
where rownum<6;

--【注2】rownum本身必须从1开始数
--7 查询员工表中第6到第12条数据
select rownum,employee_id,first_name,salary from employees 
where rownum between 6 and 12;

select * from (select rownum rn,employee_id,first_name,salary from employees)
where rn between 6 and 12;

--7-1，查询员工表中工资排名在6到10的数据
select * from (select rownum rn,employee_id,first_name,salary from (select * from employees order by salary desc))
where rn between 6 and 10;

--多行子查询
8 查询所有是部门经理的员工信息
select distinct manager_id from employees;

select * from employees where employee_id in(select distinct manager_id from employees);
9 查询所有不是部门经理的员工

select * from employees 
where employee_id not in(select distinct manager_id from employees where manager_id is not null);

select * from employees 
where employee_id not in(select distinct nvl(manager_id,0) from employees);


--10 查询大于60号部门中某一个员工工资的员工信息
select * from employees where salary > 60号部门最低工资

select * from employees where salary > (select min(salary) from employees where department_id='60');
--any表示结果集中的任意一个  in表示 等于结果集的任意一个
select * from employees where salary > any(select salary from employees where department_id='60');

--11 查询大于60号部门所有员工工资的员工信息
select * from employees where salary > (select max(salary) from employees where department_id='60');
--all表示结果集中的每一个
select * from employees where salary > all(select salary from employees where department_id='60');


--12 查询所有员工人数不少于3人的部门信息

--1,员工人数 部门信息 来自与 员工表和部门表 ===> 联表查询
select e.*,d.*
from employees e,departments d
where e.department_id = d.department_id;

--2, 员工人数不少于3人的部门信息 ====>  分组  ==> 先查询所有部门信息 及部门人数
select d.*,count(e.employee_id)
from employees e,departments d
where e.department_id = d.department_id
group by d.department_id,d.department_name,d.manager_id,d.location_id;

--3,员工人数不少于3人

select d.*,count(e.employee_id)
from employees e,departments d
where e.department_id = d.department_id
group by d.department_id,d.department_name,d.manager_id,d.location_id
having count(e.employee_id) >= 3;


select d.department_id,d.department_name,d.manager_id,d.location_id,count(e.employee_id)
from employees e,departments d
where e.department_id = d.department_id
group by d.department_id,d.department_name,d.manager_id,d.location_id
having count(e.employee_id) >= 3;


----------------------相关子查询---------------------

--13 查询员工编号，姓名，部门编号，工资，本部门工资的总和
select e.employee_id,e.first_name,e.department_id,e.salary,本部门工资的总和
from employees e

--本部门工资的总和
select sum(salary) from employees where department_id = 员工所在的部门编号

--整合【相关子查询不能单独执行，且子查询中包含主查询相关内容】
select e.employee_id,e.first_name,e.department_id,
e.salary,(select sum(salary) from employees where department_id =e.department_id)
from employees e

14 查询所有工资超过本部门平均工资的员工的信息
