--8 查询工资超过8000员工编号，姓名，部门编号，部门名称，职务编号，职务名称（三表联查）

select e.employee_id,e.first_name,d.department_id,d.department_name,j.job_id,j.job_title
from employees e,departments d,jobs j
where e.department_id = d.department_id and e.job_id = j.job_id and e.salary > 8000;


--9 查询所有部门的编号，部门的名称，部门经理ID，部门经理的姓名
select d.department_id,d.department_name,d.manager_id,manager.first_name 
from departments d,employees manager
where d.manager_id = manager.employee_id;

select * from employees;
select * from departments;

--10 查询每个员工的编号，姓名，工资，工资级别（不等值联表）
select * from job_grades;

select e.employee_id,e.first_name,e.salary,jg.grade_level
from employees e,job_grades jg
where e.salary between jg.lowest_sal and jg.highest_sal;

--11 查询员工编号，姓名，部门编号，部门名称（外连接，没有部门的员工也返回）

--1999标准（语义化）
left outer join 

--没有部门的员工也返回--> 员工表信息完整 --> 外连接员工表
--左外连接
select e.employee_id,e.first_name,d.department_id,d.department_name
from employees e left outer join  departments d
on e.department_id = d.department_id;
--右外连接
select e.employee_id,e.first_name,d.department_id,d.department_name
from  departments d right outer join  employees e
on e.department_id = d.department_id;

--12 查询员工编号，姓名，部门编号，部门名称（外连接，没有员工的部门也返回）
--左外连接 left outer join
select e.employee_id,e.first_name,d.department_id,d.department_name
from  departments d left outer join employees e
on e.department_id = d.department_id;
--右外连接  right join   【outer可省】
select e.employee_id,e.first_name,d.department_id,d.department_name
from  employees e  right join  departments d
on e.department_id = d.department_id;

--全外连接 full outer join
select e.employee_id,e.first_name,d.department_id,d.department_name
from  employees e  full outer join  departments d
on e.department_id = d.department_id;

--内连接 inner join
select e.employee_id,e.first_name,d.department_id,d.department_name
from  employees e  inner join  departments d
on e.department_id = d.department_id;

--叉集cross join
select e.employee_id,e.first_name,d.department_id,d.department_name
from  employees e  cross join  departments d;

--13 查询所有部门的编号，部门的名称，部门经理ID，部门经理的姓名（没有经理的部门也返回）
--没有经理的部门也返回-->部门信息完整-->外连接部门表
select d.department_id,d.department_name,d.manager_id,manager.first_name 
from departments d left outer join employees manager
on d.manager_id = manager.employee_id;

--自链接（两张相同的表连接）

--14 查询员工编号，姓名，员工管理者的编号，员工管理者的姓名（自连接）
select e.employee_id,e.first_name,e.manager_id,m.employee_id 
from employees e,employees m
where e.manager_id = m.employee_id;

--15 查询员工编号，姓名，员工管理者的编号，员工管理者的姓名（没有管理者的员工也返回）
select e.employee_id,e.first_name,e.manager_id,m.employee_id 
from employees e left outer join employees m
on e.manager_id = m.employee_id;

/*
联表问题
笛卡尔积--->内连接【等值连接，不等值连接】
--->外连接【左外，右外，全外】
--->自链接【两张一样的表连接】
*/

-------------------------------------------------分组----------------------------------------------
--多行函数
/*最大  max
最小  min
平均  avg
总和  sum
计数  count
*/
select * from employees

--查询 所有员工的工资平均值,最大值，最小值，总和，数量
select avg(salary),max(salary),min(salary),sum(salary),count(salary) from employees;


--1 查询每个部门的编号，该部门员工工资的总和  先分组
select department_id,sum(salary)
from employees
group by department_id
having department_id is not null;

--2 查询每个部门的最高工资
select department_id,max(salary)
from employees
group by department_id
having department_id is not null;
--3 查询每个部门的平均工资
select department_id,avg(salary)
from employees
group by department_id
having department_id is not null;

--4 查询部门最高工资超过10000的部门名称
--【出现分组后，仅能直接查询分组依靠的字段或聚合函数】
select d.department_name,max(e.salary)
from employees e,departments d
--分组前过滤，不允许使用聚合函数（此时未执行）
where e.department_id = d.department_id
group by d.department_name
--分组后过滤
having max(e.salary)>10000;

--5 查询部门平均工资超过13000的部门
select department_id,avg(salary)
from employees
group by department_id
having avg(salary) > 13000;


/*
sql查询语句的书写顺序与执行顺序
              书写顺序   执行顺序
select           1          7
distinct         2          8
from             3          1
join             4          3
on               5          2
where            6          4
group by         7          5-->执行聚合函数
having           8          6
order by         9          9
*/

--**1 分组统计各部门下工资>500的员工的平均工资
select  department_id,avg(salary)
from employees
where salary>500 and department_id is not null
group by department_id;
2 统计各部门下平均工资大于1700的部门 

3 算出部门80中得到最多奖金的员工奖金

4 算出每个职位的员工数和最低工资 

5 列出员工表中每个部门的员工数，和部门no

--**6 分组统计每个部门下，每种职位的平均奖金（也要算没奖金的人）和总工资(包括奖金)
--聚合函数默认不会计算null值
select commission_pct from employees;
select sum(commission_pct) from employees;
select avg(commission_pct) from employees;

select department_id,job_id,avg(nvl(commission_pct,0)*salary),sum(salary*(1+nvl(commission_pct,0)))
from employees
where department_id is not null
--分组可以多个字段
group by department_id,job_id;

7 列出员工表中每个部门的员工数（员工数必须大于3），和部门名称 
