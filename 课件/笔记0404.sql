--last_day()表示指定日期所在月的最后一天
select last_day(sysdate) from dual;

--round函数,默认四舍五入到天
select round(sysdate) from dual;
select round(sysdate+1/2) from dual;
--round(日期,日期单位)
select round(sysdate,'month') from dual;
select round(sysdate+12,'month') from dual;
--四舍五入到年
select round(sysdate,'year') from dual;
select round(add_months(sysdate,3),'year') from dual;

--trunc函数,用法同上
select trunc(sysdate) from dual;
select trunc(sysdate,'month') from dual;
select trunc(sysdate,'year') from dual;



--转换函数:字符，数字，日期

--字符与数字之间可隐式转换
select '5'+2 from dual;
--数字与日期之间无法转换

--字符与日期的转换
--to_char(日期,'模板')将日期转换为字符串
select to_char(sysdate,'yyyy-mm-dd') from dual;
--年月日，时分秒
select to_char(sysdate,'yyyy.mm.dd hh:mi:ss') from dual;
--fm表示去掉不影响的0,hh24表示24小时制，am表示显示上下午，day表示星期几
select to_char(sysdate,'fmyyyy-mm-dd hh24:mi:ss am day') from dual;

--to_date(字符串,'模板')  字符串格式与模板格式必须一致
select to_date('1990-04-04','yyyy-mm-dd') from dual;

--查询95年以前入职的员工
select * from employees where hire_date < to_date('1995-1-1','yyyy-mm-dd');

--练习
--查询7月或者8月入职的员工
select * from employees where to_char(hire_date,'mm') in(7,8);

--查询17号入职的员工
select to_char(sysdate,'dd') from dual;

select * from employees where to_char(hire_date,'dd') = 17;


--通用函数
--通用函数--空值处理函数
--nvl（值1,值2）  若值1为空 则返回值2，反之返回值1
select nvl(commission_pct,0) from employees;
--nvl2（值1，值2，值3）  若值1为空 则返回值3，反之返回值2
select nvl2(commission_pct,'有',0) from employees;
--nullif（值1，值2） 判断若值1 <> 值2，则返回值1，否则返回空
select nullif(3,3) from dual;
select nullif(3,4) from dual;



--多行函数 进n出1
