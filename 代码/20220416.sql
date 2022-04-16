--7-1查询员工表中工资排名在6到10的数据
select * from (select rownum rn,employee_id,first_name,salary from (select * from employees order by salary desc)) where rn between 6 and 10;

-- 查询大于60号部门任何一个员工工资的员工信息（用min可以替代any）
select * from employees where salary>(select m from (select department_id,max(salary) m from employees group by department_id) where department_id=60);

-- 
