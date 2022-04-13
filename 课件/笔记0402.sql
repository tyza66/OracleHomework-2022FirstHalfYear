--2 查询每个员工姓名，工资，奖金，实发工资（工资+奖金）
select first_name,salary,commission_pct,salary*(1+commission_pct) as newsalary from employees;
--通用函数--空值处理函数
--nvl（值1,值2）  若值1为空 则返回值2，反之返回值1
select first_name,salary,nvl(commission_pct,0),salary*(1+nvl(commission_pct,0)) as newsalary from employees;

--escape逃逸字
--17 查询job_id 倒数第5个字符为是下划线的员工信息
select * from employees where job_id like '%/_____' escape '/';
--18 查询last_name中包含%的员工信息
select * from employees where last_name like '%#%%'escape '#';


------------------------------------------------常用函数-----------------------------------------------------

--一、单行函数 进1出1 一一对应

--1,字符函数
--lower字母转小写
select lower('HELLO') from dual;
--upper字母转大写
select upper('world') from dual;
--initcap首字母大写，其余小写
select initcap('HELLO') from dual;
--length返回字符串长度
select length('dhwudheu') from dual;

--concat 拼接字符串（一次仅能拼接两个字符串）
select concat('hello','world') from dual;
--若拼接3个或以上字符串，则需要函数嵌套
select concat(concat('hello','world'),'!!!') from dual;

--substr(字符串,截取起始位置)截取字符串
--字符位置从1开始数的
select substr('yangjianfei',5) from dual;
--substr(字符串,截取起始位置,截取的长度)
select substr('yangjianfei',5,4) from dual;
--起始位置若为负数，则从右向左数
select substr('yangjianfei',-7,4) from dual;
--截取长度不能为负数
select substr('yangjianfei',-7,-4) from dual;

--instr(字符串,查找子串)查找字符串  
--若子串存在 则从左到右开始查找，返回子串第一次出现的起始位置
select instr('songdechaodedededede','de') from dual;
--若子串不存在，则返回0
select instr('songdechao','yangjianfei') from dual;

--instr(字符串,查找子串,起始位置)
select instr('wuhaoyuan','wu',3) from dual;
--若起始位置为负数，则起始位置从右向左数，查找方向也是从右到左
select instr('wuhaoyuan','wu',-3) from dual;

--instr(字符串,查找子串,起始位置,第几次出现)
select instr('zhangbobozi','bo',1,2) from dual;
--若起始位置为负数，则起始位置从右向左数，查找方向也是从右到左
select instr('zhangbobozi','bo',-1,2) from dual;

--lpad(字符串,固定长度,填充的字符)左填充
select lpad('zhangzhenyu',18,'#') from dual;
--rpad右填充
select rpad('mengruirui',18,'$') from dual;

--replace(字符串,查找字符串,替换字符串)替换
select replace('woxihuantongyuzhu','tongyuzhu','fuyumeng') from dual;
--replace(字符串,查找字符串)把查找字符串删掉
select replace('woxihuantongyuzhu','tongyuzhu') from dual;
--replace() 替换是把所有查找的子串 均替换掉
select replace('wotaoyanfuyumeng,woyetaoyantongyuzhu','taoyan','xihuan') from dual;

--chr 将编码转字符
select chr(77) from dual;
--ascii 将第一个字符转编码
select ascii('鲁') from dual;
select ascii('仲') from dual;
select ascii('建') from dual;

select ascii('吴') from dual;
select ascii('军') from dual;


--'&input'表示用户输入字符串
select '&input' from dual;

--trim去掉字符串的前后空格
select trim('     haiyou  wushiwu  fenzhong  xiake   ') from dual;

--练习
--查询员工姓和名字数相等的员工
select * from employees where length(first_name) = length(last_name);

--查询last_name以s结尾的员工（不用like）

--instr函数 判断s出现的位置是不是最后一个
select * from employees where instr(last_name,'s',-1)=length(last_name);
--substr函数 取出最后一个字母与s比较
select * from employees where substr(last_name,-1)='s';

--查询所有的员工姓和名，输出以下格式S.King
--函数实现
select first_name from employees;
select substr(first_name,1,1) from employees;
select concat(substr(first_name,1,1),'.') from employees;
select concat(concat(substr(first_name,1,1),'.'),last_name) from employees;

-- ||实现字符拼接
select substr(first_name,1,1) || '.' || last_name from employees;

--查询所有的电话号码，把分隔符“点”换为“-”之后再输出
select replace(phone_number,'.','-') from employees;

--用户输入一个任意编号，查询此编号的员工
select * from employees where employee_id = '&input';

--用户输入一个关键字，查询last_name包含此关键字的员工（不用LIKE）
select * from employees where instr(last_name,'s')<>0;

--数学函数

--round(数字)四舍五入,默认保存至整数位
select round(3.1415926) from dual;
--round(数字,小数位数)
select round(3.1415926,2) from dual;
--若小数位数为负数，则保留小数点前的位数
select round(31415.26,-2) from dual;

--trunc()截断函数,语法同上
select trunc(3.9999999) from dual;
select trunc(3.9999999,2) from dual;
select trunc(39999.999,-2) from dual;
select trunc(-39999.999,-2) from dual;

--floor(数字) 返回不大于本身的最大整数（向下取整）
select floor(3.99999) from dual;  --3
select floor(-3.11111) from dual; -- -4

--ceil(数字) 向上取整
select ceil(3.000000001) from dual;
select ceil(-2.99999999) from dual;

--mod(被除数,除数) 求模,求余数
select mod(22,7) from dual;

--日期函数
--sysdate 表示当前系统时间
select sysdate from dual;
--日期时间是可以进行加减运算的(单位是天)
select sysdate+3 from dual;
--求25分钟之后的时间
select sysdate+(1/24/60)*25 from dual;

--计算所有员工入职多少天
select trunc(sysdate-hire_date) from employees;

--months_between(日期1，日期2)计算两个日期相差多少个月
select months_between(sysdate,hire_date) from employees;

--add_months(日期，n)给指定日期加减多个月
select add_months(sysdate,1) from dual;
select add_months(sysdate,-1) from dual;

--next_day(日期，星期几)下一个最近的星期几的日期
select next_day(sysdate,'星期五') from dual;
select next_day(sysdate,'星期日') from dual;
--数字 1-7 分别代表 周日--周六
select next_day(sysdate,5) from dual;

--last_day()


--转换函数
--通用函数
--通用函数--空值处理函数
--nvl（值1,值2）  若值1为空 则返回值2，反之返回值1




--多行函数 进n出1
