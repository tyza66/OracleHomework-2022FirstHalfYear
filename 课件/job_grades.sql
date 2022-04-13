prompt PL/SQL Developer import file
prompt Created on 2022Äê4ÔÂ9ÈÕ by xiaoxi
set feedback off
set define off
prompt Creating JOB_GRADES...
create table JOB_GRADES
(
  grade_level VARCHAR2(3),
  lowest_sal  NUMBER,
  highest_sal NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for JOB_GRADES...
alter table JOB_GRADES disable all triggers;
prompt Loading JOB_GRADES...
insert into JOB_GRADES (grade_level, lowest_sal, highest_sal)
values ('A', 1000, 2999);
insert into JOB_GRADES (grade_level, lowest_sal, highest_sal)
values ('B', 3000, 5999);
insert into JOB_GRADES (grade_level, lowest_sal, highest_sal)
values ('C', 6000, 9999);
insert into JOB_GRADES (grade_level, lowest_sal, highest_sal)
values ('D', 10000, 14999);
insert into JOB_GRADES (grade_level, lowest_sal, highest_sal)
values ('E', 15000, 24999);
insert into JOB_GRADES (grade_level, lowest_sal, highest_sal)
values ('F', 25000, 40000);
commit;
prompt 6 records loaded
prompt Enabling triggers for JOB_GRADES...
alter table JOB_GRADES enable all triggers;
set feedback on
set define on
prompt Done.
