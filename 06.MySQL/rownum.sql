
﻿-- 11.rownum.sql

-- *** 인라인 뷰
	-- 검색시 빈번히 활용되는 스펙
	-- 다수의 글들이 있는 게시판에 필수로 사용(paging 처리)
	-- 서브쿼리의 일종으로 from절에 위치하여 테이블처럼 사용
	-- 원리 : sql문 내부에 view를 정의하고 이를 테이블처럼 사용 

-- 부서번호가 10번인 사번, 사원명, 위치 출력
-- 인라인 뷰 사용시 꼭 별칭 붙여라
select * 
from emp;

select e.empno, e.ename, d.loc
from (select * from emp where DEPTNO =10) as e, dept as d
where e.DEPTNO=d.DEPTNO;

-- 스칼라 서브쿼리 : select 절에서 사용되는 서브 쿼리 (반듯이 하나의 결과 만을 반환하는 서브쿼리)
select empno, ename, job, sal, (select grade from salgrade where e.SAL between LOSAL and HISAL ) as salgrade
from emp as e;


-- dept의 deptno를 내림차순(desc)으로 검색, rownum
set @ROWNUM :=0;
select @ROWNUM := @ROWNUM +1 as 행번호 , empno
from emp;

-- ? deptno의 값이 오름차순으로 정렬해서 30번 까지만 검색, rownum 포함해서 검색


-- rownum 초기화
-- from절에서 : (select @rownum :=0) AS rownum; AS 필수!
set @ROWNUM :=0;

select @ROWNUM := @ROWNUM +1 , DEPTNO
from DEPT, (select @ROWNUM := 0) as 행번호
WHERE DEPTNO <= 30
order by deptno asc;



-- where 절에서 초기화
select @ROWNUM := @ROWNUM + 1 , deptno
from dept
where (@ROWNUM := 0) = 0;

-- emp table
-- ? deptno의 값이 오름차순으로 정렬해서 상위 3개의 데이터만 검색, rownum 포함해서 검색
-- 해결책 : 인라인 뷰
-- 검색한 결과의 순번을 순차적으로 적용해서 재정렬 순번 반영
-- 인라인 view : sql의 from 절에 view 문장

select *
from (select @rownum := @rownum + 1 as rownum, deptno
	from emp, (select @rownum :=0) as rownum0
    order by deptno asc) as s 
where rownum <=3;

-- limit : 지정한 행의 개수 만큼 출력 하는 기능
-- limit 시작, 행의 개수 : limit offset 시작
select *
from emp
order by hiredate desc
limit 5 offset 0;

-- 게시글 (페이지네이션)







-- 1. emp  table의 입사일이 신입(내림)부터 5명의 사원만 검색 
-- 힌트 rownum 컬럼, view 도 사용해서 활용 
-- 인라인 뷰 형식의 쿼리문



-- 2. 인라인 뷰를 사용하여 급여를 많이 받는 순서대로 3명만 이름과 급여 검색 



























