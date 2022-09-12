-- 트랜잭션 Transaction, Tx
-- 더 이상 쪼갤 수 없는 기능 단위
-- DB의 상태를 변경 시킬 수 있는 작업 단위



-- 하나의 트랜잭션의 예
-- 인출(돈이 줄어듬)  select, update -> 은행 검색 select -> 계좌 체크  select-> 입금 (돈이 증가) select, update

-- 게시글 : 작성 ( 인서트) --> 메인페이지에서 내가 작성한 글 확인 (select)
-- select -> insert -> select

-- 특징

-- 1. 원자성 : 하나의 트랜잭션의 결과가 모두 반영 되거나 혹은 반영 되지 않아야 한다!
-- 2. 일관성 : 결과가 동일한 결과를 출력할 수 있어야 한다!
-- 3. 영구성 : 결과가 DB에 영구적으로 남아야 한다 (commit)
-- 4. 독립성 : 하나의 트랜젝션이 끝나고나서야 다른 트렌젝션이 일어나야함 즉 하나의 트렌제셕은 다른 트랜젝션에 영향을 주지 않는다

-- commit 확인

show variables like '%commit%';
set autocommit = 0 ;

-- 트랜 잭션의 시작 ~ 종료

start transaction;

select *
from emp01;

insert into emp01 (empno, ename, deptno)
values (9999, 'it', 20);

select *

from emp01;

commit;

rollback;


