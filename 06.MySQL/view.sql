

-- 10.view.sql


/*

* view 사용을 위한 필수 선행 설정
	1단계 : admin 계정으로 접속
	2단계 : view 생성해도 되는 사용자 계정에게 생성 권한 부여

1. view 에 대한 학습
	- 물리적으로는 미 존재, 단 논리적으로 존재
	- 물리적(create table)
	- 논리적(존재하는 table들에 종속적인 가상 table)

2. 개념
	- 보안을 고려해야 하는 table의 특정 컬럼값 은닉
	또는 여러개의 table의 조인된 데이터를 다수 활용을 해야 할 경우
	특정 컬럼 은닉, 다수 table 조인된 결과의 새로운 테이블 자체를 
	가상으로 db내에 생성시킬수 있는 기법 

3. 문법
	- create와 drop : create view/drop view
	- crud는 table과 동일

4. 종류
	5-1. 단일 view : 별도의 조인 없이 하나의 table로 부터 파생된 view
	5-2. 복합 view : 다수의 table에 조인 작업의 결과값을 보유하는 view
	5-3. 인라인 view : sql의 from 절에 view 문장  

5. 실습 table
	-dept01 table생성 -> dept01_v view 를 생성 -> crud -> view select/dept01 select 
*/

-- 1. test table생성
create table dept02 as select * from dept;


-- 2. dept01 table상의 view를 생성
-- SCOTT 계정으로 view 생성 권한 받은 직후에만 가능
create view v_dept02 as select * from dept02;

desc v_dept02;

select *
from v_dept02;

DROP VIEW v_dept02;


-- 3. ? emp table에서 comm을 제외한 v_emp01 라는 view 생성
drop view v_emp01;

create view v_emp01 as select EMPNO, ENAME, SAL from emp;

select *
from v_emp01;


-- 4. v_dept02에 crud : v_dep02와 dept02 table 변화 동시 검색
create view v_dept02 as select * from dept02;

desc v_dept02;

select *
from v_dept02;

-- test
-- step01 : insert view를 인서트 하면 원본도 변경해버리는 일이 발생 할 수 있다.
select * from v_dept02;
insert into v_dept02 values(50, 'dev', 'moon');

select * from v_dept02;
select * from dept02;
-- DELETE
delete from v_dept02 where deptno = 50;
select * from v_dept02;
select * from dept02;

-- 그럼 반대로 원본 테이블을 삭제 및 변경 하면 view는 어떻게 될까?
-- update
select * 
from dept02;

update dept02 set deptno =50
where loc = 'NEW YORK';

select *
from v_dept02;
-- 원본을 변경해도 v 역시 변경되는 영향이 끼침

-- 삭제
drop table dept02;

select *
from v_dept02;


-- 5. 모든 end user가 빈번히 사용하는 sql문장으로 
-- "해당 직원의 모든 정보 검색(empno, ename, deptno, loc)"하기
/* 개발 방법
- 두개의 join 필수
방법1 : 필요시 늘 join하는 sql문장 실행
방법2 : 이미 조인된 구조의 view를 생성 해 놓고, 필요시 view만 select */

create view v_emp_dept as 
select e.empno, e.ename, e.deptno, d.loc
from dept as d ,  emp as e
where d.DEPTNO=e.DEPTNO;
 
 select *
 from v_emp_dept;



-- 6. 논리적인 가상의 table이 어떤 구조로 되어 있는지 확인 가능한 oracle  자체 table
-- view는 text 기반으로 명령어가 저장 
-- view 에 대한 정보

select *
from information_schema.views
where table_schema = 'scott';


-- view  장점
-- 1. 보안 
-- 2. 복잡한 쿼리 단순화 결과만을 확인

-- 이전에 이야기 했지만 원래 원본과는 분리 하여 사용하기 위한 용도로 view를 이용함
-- 하지만 수업 시간에는 원본과 연동이 잘되어 있는데 그 이유는 scott의 view에 권한을 모든 권한을 주어놨기 때문에 그렇다
-- 원래는 권한이 제한이 되어있어 현업에는 업무별로 권한을 나눠 가지게 되어 , 수정이 불가능 하도록 하는 것이 원칙

select *
from emp
where mgr is not null;

select ename, deptno, sal
from emp
group by DEPTNO
having sal = max(sal);

select *
from salgrade;


select ename ,hiredate, empno
from emp
where substr(hiredate,6,2) = "02" and (empno mod 20) <> 0;


select e.ename ,e.DEPTNO, e.sal, d.dname, s.grade
from emp e, dept d, salgrade s
where substr(hiredate,1,4) <> "1981" and e.DEPTNO= d.DEPTNO;

