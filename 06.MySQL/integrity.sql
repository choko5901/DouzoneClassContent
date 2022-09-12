-- 9.integrity.sql
-- DB 자체적으로 강제적인 제약 사항 설정
-- 개발자 능력 + 시스템(HW/SW) 다 유기적으로 연계
-- 설정은 개발자의 책임

select *
from dept;

/* dept : emp
1. 공통컬럼 : deptno
2. 어떤 table의 deptno가 종속적인지?
	- 고유한 값을 제시하는 테이블 : DEPT (부모 테이블 , 메인 테이블)
	- 고유한 값을 사용하는 테이블 : EMP (자식, 종속)
3. 제약 사항
	1. dept의 deptno값은 중복 불허, 반드시 값이 있어야만 함
		- 중복이 불허 : UNIQUE
        - 반드시 값이 있어야 함 : NOT NULL
        - UNIQUE + NOT NULL --> PRIMARY KEY (기본키), PK
        - 용도 : 구분을 위한 기준 데이터 
		
	2. emp의 deptno는 반드시 dept의 deptno에서 제시한 데이터에 한해서만 사용 가능
		-empno 사번: 중복 불허, NOT NULL - PK
        - DEPTNO : DEPT라는 테이블의 데이터에 접근 가능한 종속 컬럼 = 참조
				---> FOREIGN KEY (외래키), FK
	
		
4. 참고
	1. create 방식
		1. 타입 명시에서 무에서 유
		2. 유에서 유 존재하는 table로 부터 복제
			- dept_copy table 중복 데이터가 여러개 저장 가능하다는 것은 deptno에 중복 허락
				의미없는 부서 정보를 보유한 구조	
			- 복제시 제약조건은 반영이 안됌, 차후에 명시적으로 추가 설정
			
5. 제약조건 설정 방법
	1. table 생성시
		1. 컬럼명시시 설정
		2. 컬럼들 다 기술후에 마지막에 설정
		
	2. 복제 직후 추가 설정
		- alter
*/

/* 학습내용

1. table 생성시 제약조건을 설정하는 기법 

2. 제약 조건 종류
	emp와 dept의 관계
	
	2-1. PK[primary key] - 기본키, 중복불가, null불가, 데이터들 구분을 위한 핵심 데이터
			: not null + unique
	2-2. not null - 반드시 데이터 존재
	2-3. unique - 중복 불가 
	2-4. check - table 생성시 규정한 범위의 데이터만 저장 가능 
	2-5. default - insert시에 특별한 데이터 미저장시에도 자동 저장되는 기본 값
					- 자바 관점에는 멤버 변수 선언 후 객체 생성 직후 멤버 변수 기본값으로 초기화
    2-6. FK[foreign key] 
		- 외래키[참조키], 다른 table의 pk를 참조하는 데이터 
		- table간의 주종 관계가 형성
		- pk 보유 table이 부모, 참조하는 table이 자식
		- 부모의 미 존재하는 데이터를 자식에서 새로 생성가능? 불가 
		- 자식 table들이 존재할 경우 부모table만 삭제 가능? 불가
		- 해결책 : 관계를 해제도 가능하나 가급적 분석설계시 완벽하리만큼 고민후 설계
	
3. 제약조건 선언 위치
	3-1. 컬럼 레벨 단위
		- 컬럼선언 라인에 제약조건 설정 

	3-2. 테이블 레벨 단위 
		- 모든 컬럼 선언 직후 별도로 제약조건 설정 

4. 이미 존재하는 table의 제약조건 수정(추가, 삭제)명령어
	4-1. 제약조건 추가
		ALTER TABLE 테이블이름 ADD [CONSTRAINT 제약조건이름] PRIMARY KEY (필드이름)
		
	4-2. 제약조건 삭제(drop)
		ALTER TABLE 테이블이름 DROP PRIMARY KEY
		
*/
-- 1. db에 설정한 table의 제약조건 정보를 보유하고 있는
-- information_schema.table_constraints;
select *
from information_schema.table_constraints;


/* constraint_type : 제약조건 정보 컬럼
*/
desc information_schema.table_constraints;

select *
from information_schema.table_constraints
where CONSTRAINT_SCHEMA = 'scott';

-- 2. 사용자 정의 제약 조건명 명시하기

drop table emp02;
create table emp02(
	empno int,
    ename varchar(10),
    constraint emp02_empno_nn primary key (empno)
);

select *
from information_schema.table_constraints
where CONSTRAINT_SCHEMA = 'scott';




-- 3. 사용자 정의 제약조건명 설정 후 위배시 출력되는 메세지에 사용자정의 제약조건명
-- 확인 가능 : not null을 제외한 제약조건명은 에러 발생시 가시적인 확인 가능



-- 4. pk설정 : 선언 위치에 따른 구분 학습
-- 컬럼 레벨단위 



-- 5. 외래키[참조키]
-- 이미 제약 조건이 설정된 dept table의 pk컬럼인 deptno값을 기준으로 
-- emp02의 deptno에도 반영(참조키, 외래키, fk)
drop table emp02;
-- 컬럼 레벨 단위	 
create table emp02(
	empno int,
    ename varchar(10),
    deptno int
);
 
-- 컬럼레벨
alter table emp02 add  constraint emp02_deptno_fk foreign key (deptno) REFERENCES dept (deptno);


-- 테이블 레벨
drop table emp02;
create table emp02(
	empno int,
    ename varchar(10),
    deptno int,
    foreign key (deptno) references dept (deptno)
);





-- 6. emp01과 dept01 table 생성
-- emp --> emp01 / dept --> dept01 
DROP TABLE EMP01;
DROP TABLE DEPT01;

CREATE TABLE EMP01 AS SELECT * FROM EMP;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;

SELECT *
FROM EMP01;

SELECT * 
FROM DEPT01;

SELECT * FROM information_schema.table_constraints
WHERE constraint_schema = 'scott';

-- 테이블 생성시 원래 존재 하던 테이블을 복사하여 생성하면 데이터는 넘어온다 
-- 그러나, 제약 조건은 그대로 넘어 오지 않음 !!(복사 안됨)
-- 따라서, 복사 테이블 생성하면 필요에따라 제약 조건을 추가 해줘야 한다.




-- 7. 이미 존재하는 table에 제약조건 추가하는 명령어 
-- dept01 : 주(부모), emp01 : 종(자식)

-- ? emp01에 제약조건 추가해 보기
alter table emp01
add constraint emp01_deptno_fk foreign key (deptno) references dept01 (deptno);
-- 에러 발생 이유 : 복사해온 emp01 과 dept01 테이블에는 pk 지정이 안되어있어
-- 따라서 어떤 테이블에도 fk 값을 줄 수 없음

-- 해결 방안 emp01 에 empno, dept01 deptno 가 pk 로 지정 후 fk 설정 해주면 된다

-- 기본키 설정
alter table emp01
add constraint primary key (empno);
alter table dept01
add constraint primary key (deptno);
-- 기본키 설정 확인
SELECT * FROM information_schema.table_constraints
WHERE constraint_schema = 'scott';
-- 외래키 설정
alter table emp01
add constraint emp01_deptno_fk foreign key (deptno) references dept01 (deptno);
-- 외래키 설정 확인
SELECT * FROM information_schema.table_constraints
WHERE constraint_schema = 'scott';

-- 8. 참조 당하는 key의 컬럼이라 하더라도 자식 table에서 미 사용되는 데이터에 한해서는
-- 삭제 가능  
select *
from dept01;

delete from dept01 where deptno = 40 ; 

select *
from dept01;
-- ERROR CODE 1451
delete from dept01 where deptno = 30 ; 

-- dept01 deptno 는 emp01에서 외래키로 쓰고 있는데 
-- 40번은 emp01에서 사용하지 않기 떄문에 삭제가 가능했지만 30번은 emp01에서 사용중에 있으니 삭제가 불가능하다
-- 이를 해결 하기 위해서는 참조 하는 테이블(emp01)에서 foreign key 제약 조건에 추가 설정을 해줘야함
-- 1. ON delete : 참조 되는 테이블의 값이 삭제 될때 동작하는 설정
-- 2. ON update : 참조 되는 테이블의 값이 수정 될때 동작하는 설정
/*
- restict : 참조 테이블에 데이터가 있으면, 참조 되는 테이블의 데이터를 삭제, 수정 x
- cascade : 참조 테이블에 데이터를 수정 혹은 삭제하면 , 참조 하는 테이블의 데이터도 수정 혹은 삭제 0 
- set null : 참조 테이블에 데이터를 수정 혹은 삭제하면, 참조 하는 테이블의 데이터는 NULL
- set default : 참조 테이블에 데이터를 수정 혹은 삭제 하면 참조하는 테이블의 데이터는 default 값

*/


-- set null test
alter table emp01 drop constraint emp01_deptno_fk;

alter table emp01 add constraint emp01_deptno_fk foreign key (deptno) references dept01 (deptno) on delete set null ;


delete from dept01 where deptno = 30 ; 

select *
from dept01;

select *
from emp01;

rollback;

-- case cade test 외래키가 삭제 되면 이를 참조하는 데이터도 삭제 하는 방식
alter table emp01 drop constraint emp01_deptno_fk;

alter table emp01 add constraint emp01_deptno_fk foreign key (deptno) references dept01 (deptno) on delete cascade ;
delete from dept01 where deptno = 10 ; 

select *
from dept01;

select *
from emp01;

rollback;

-- 9. 참조되는 컬럼 데이터라 하더라도 삭제 가능한 명령어 on delete cascade
-- *** 현업에선 부득이하게 이미 개발중에 table 구조를 변경해야 할 경우가 간혹 발생
-- 자식 존재 유무 완전 무시하고 부모 table삭제 



-- 10. check : if 조건식과 같이 저장 직전의 데이터의 유효 유무 검증하는 제약조건 
-- age값이 1~300까지만 DB에 저장
drop table emp05;

create table emp05(
	ename varchar(10),
    age smallint check(age BETWEEN 1 and 300)
);

desc emp05;

insert into emp05 values('IT', 301);

select *
from emp05;



-- 11. ? gender라는 컬럼에는 데이터가 M 또는 F만 저장되어야 함
drop table emp05;
create table emp05(
	name varchar(10),
    gender char(1) check(gender = 'm' or gender= 'f')
);
insert into emp05 values('IT', 'm');

select *
from emp05;

-- 12. default : insert시에 데이터를 생략해도 자동으로 db에 저장되는 기본값 
drop table emp05;

create table emp05(
 id varchar(10) primary key,
 grade varchar(20) default 'BRONZE'
);

-- default값이 들어가려면 디펄트가 아닌 값들 컬럼명을 꼭 명시
insert into emp05 values('chart');
-- 요로케
insert into emp05(id) values('server');

select *
from emp05;

