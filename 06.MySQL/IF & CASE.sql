-- 프로그래밍
-- step01
-- 변수
-- 사용자 정의
-- 지역 : 프로시저, 트리거

-- 사용자 정의 변수
-- 한정 데이터만 값 지정 가능 : 정수, 실수, 10진수, 2진수, NULL
-- SESSION 단위 실행

-- 사용법
-- @변수명
select @var;

-- 선언만 한 것은 NULL
set @height = 183;
set @height := 183;

select @height;

set @name = 'name';

select @name;

set @deptno1 =3;
set @deptno2 =23;

select @deptno1 + @deptno2;



-- 지역변수

-- 시스템 변수 : GLOBAL / 세션 @@변수명
-- 서버 전체에 영향을 미치는 변수

show global variables;
show session variables like '%buffer%';
show local variables;

-- STEP02
/*
DELIMITER $$
CREATE PROCEDURE 프로시저명
BEGIN

END $$
DELIMITER ;

CALL 프로시저명();
*/

-- 조건문
-- 기본 조건문 
-- IF(조건문, 참 일때의 값, 거짓일 때의 값)
set @num = 30;
select if (@num <2, '참', '거짓');
-- emp 테이블 -> sal 2500 이상이면 expected, 그렇지 않으면 uhm 출력?
select if (sal >= 2500, 'expected' , 'uhm')
from emp;


/*
IF <거짓 / 참> THEN
	SQL
ELSE
	SQL
END IF;
*/
set @var1 = 100;
/*
select if @var1 = 100 then
	select '100이 맞습니다';
else
	select '100이 아닙니다';
end if;
*/



-- CASE 
/*
CASE 
	WHEN 조건1 THEN 결과값
    WHEN 조건2 THEN 결과값
    ELSE 기본결과값
END
*/
select grade,
	case
		when grade = 1 then '아이언'
        when grade = 2 then '브론즈'
        when grade = 3 then '실버'
        when grade = 4 then '골드'
        when grade = 5 then '플레'
        end as 등급
from salgrade;


-- CASE문을 IF로 변환?
SELECT GRADE,
	IF(GRADE = 1, '아이언', 
		IF(GRADE = 2, '브론즈', 
			IF(GRADE = 3, '실버',
				IF(GRADE = 4, '골드',
					IF(GRADE = 5, '플래티넘', '없는등급'))))) AS 등급
FROM SALGRADE;


-- 스토어드 프로시져 Stored Procedure : 쿼리의 집합으로 특정 기능 (동작)을 일괄 처리 하기 위해 사용되는 mysql의 한 객체
/*
DELIMITER $$
CREATE PROCEDURE 프로시저명(매개변수 IN or OUT)
BEGIN
	프로그래밍
END $$
DELIMITER ;

CALL 프로시저명();
*/

-- 생성 및 사용
drop procedure if exists firstProc;

delimiter $$

create procedure firstProc()
begin
	select * from emp;

end $$
delimiter ;

call firstproc();

-- ifProc
drop procedure if exists ifProc;

delimiter $$
create procedure ifProc()
begin
	declare var1 int; -- var1 로컬 변수 선언
    set var1 = 20;
    
    if var1 = 10 then
		select '10이 맞습니다';
	elseif var1 = 20 then
		select '20이 맞습니다';
	else
		select '이외 값';
    end if;

end $$
delimiter ;

call ifProc();


-- 매개변수 

-- 직원번호 7369 직원의 입사일이 5년 넘었다면? --> '5년 이상' / '5년 미만'
drop procedure if exists ifPorc2;

delimiter $$
create procedure ifProc2()
begin
	declare hiredate date;
    declare day int;
	select e.hiredate into hiredate
    from emp e
    where empno = 7369;
    
    set day = datediff(current_date(), hiredate);
    
	IF (day / 365) >= 5 THEN
		SELECT '5년 이상';
	ELSE 
		SELECT '5년 미만';
	END IF;

end $$
delimiter ;

call ifProc2();

-- while : 1 ~ 100 합
drop procedure if exists whileProc;

delimiter $$
create procedure whileProc()
begin
	declare i int;
    declare sum int;
    set i = 0;
    set sum = 0;
    
	while ( i <= 100) do
		set sum = sum + i;
        set i = i + 1;
    end while;
    
    select sum;
end $$
delimiter ;

call whileProc();

-- 오류처리
-- declare 액션 handler for 오류조건 처리문장;
-- 액션 : countinue/ exit  
-- 오류조건 : 처리할 오류 종류

-- error 1146 : not exist
select *
from no_table;

drop procedure if exists errorProc;

delimiter $$
create procedure errorProc()
begin
	declare continue handler for 1146 select 'no table';
    select * from no_table;

end $$
delimiter ;

call errorProc();

-- 동적 sql : 미리 준비한 쿼리를 나중에 실행 하는 것
prepare waitingQuery from 'select * from emp';

execute waitingQuery;

deallocate prepare waitingQuery;

execute waitingQuery;

--
drop table if exists log_tbl;

create table log_tbl(
	id bigint auto_increment primary key ,
    log_time datetime

);

set @logtime = current_timestamp();

prepare logQuery from 'INSERT INTO log_tbl (log_time) values(?)';

execute logQuery using @logtime;

select *
from log_tbl;




-- 출력값이 있는 프로시져 
-- 입력값 IN : empno  -- >  OUT : loc
drop procedure if exists getLoc;

delimiter $$
create procedure getLoc(IN in_empno int, OUt out_loc varchar(20))
begin
	select d.loc into out_loc
    from emp e , dept d
    where e.DEPTNO = d.DEPTNO and e.EMPNO = in_empno;
end $$
delimiter ;

call getLoc(7369, @out_loc);

select @out_loc;


-- 프로시져 확인



-- 스토어드 함수 
/*
DELIMITER $$
CREATE function 함수명(매개변수)
	returns 반환 타입
BEGIN
	프로그래밍
	return 반환값;
END $$
DELIMITER ;

select 함수명();
*/

-- 사번으로 사원이름 검색하는 함수
set global log_bin_trust_function_creators =1 ;

drop function if exists getName;

delimiter $$
create function getName(in_empno int)
	returns varchar(20)
begin
	declare out_ename varchar(20);
    
	select ename into out_ename
    from emp
    where emp.empno = in_empno;
    
    return out_ename;
end $$
delimiter ;


select getName(7369);

-- procedure vs function
-- in/out O vs X
-- returns/return X vs O










