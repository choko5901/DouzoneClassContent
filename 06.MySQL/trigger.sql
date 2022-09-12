-- 트리거(Trigger) : 데이터 무결성을 위해 사용되는 또 다른 개체
-- DML 이벤트 발생 시, 동작
-- 테이블에 부착되는 프로그램 코드(단, view에는 부착 불가능)
	
-- 기본
DROP TABLE people;
CREATE TABLE people(id INT PRIMARY KEY, 
					name VARCHAR(20));

INSERT INTO people VALUES
						(1, 'a'),
						(2, 'b'),
						(3, 'c'),
						(4, 'd'),
						(5, 'e');

	
    select *
    from people;
    
    drop trigger if exists firstTrg;

delimiter $$
create trigger firstTrg
	after delete
	on people
    for each row
begin
	-- 트리거는 리턴이 없음 ! ---> select 로 사용 불가
	set @out_msg = 'people 정보 삭제';
end $$

delimiter ;

select * 
from people;

select @out_msg;

delete from people
where id = 3;

select @out_msg;

-- 2. 정해진 시간에만(13:00~14:00) 입력한 경우만 입력 허용, 그 외 오류 발생
-- 데이터 값이 아닌 table 자체에 저장 가능한 시간대의 제한

drop trigger if exists timeCheckTrg;

delimiter $$
create trigger timeCheckTrg
	before insert
    on order_tbl
    for each row
begin
	if (date_format(sysdate(), '%H:%i') not between '13:00' and '14:30') then
		signal sqlstate '45000' set message_text = '등록시간이 아닙니다! 확인해주세요';
    end if;

end $$
delimiter ;

insert into order_tbl values(3,'3', sysdate());

select *
from order_tbl;


-- 3. 기존 table의 데이터가 업데이트 될 경우 다른 백업 table로 기존 데이터를 이관
-- 원본 table : order_table
-- 백업 table : backup_order
DROP TABLE order_tbl;
CREATE TABLE order_tbl(
	no INT,
	ord_code VARCHAR(10),
	ord_date DATE
);

DROP TABLE backup_order;
CREATE TABLE backup_order(
	no INT,
	ord_code VARCHAR(10),
	ord_date DATE
);

INSERT INTO order_tbl VALUES
	(1, 'c001', sysdate()),
    (2, 'c002', sysdate()),
    (3, 'c003', sysdate()),
    (4, 'c004', sysdate());

drop trigger backUpTrg;

delimiter $$
create trigger backUpTrg
 after update
 on order_tbl
 for each row
 begin
	insert into backup_order
		values(old.no, old.ord_code, old.ord_date);
 
 end $$
delimiter ;

-- 없는 상태

select *
from backup_order;

-- 변경 되기전 상태
select *
from order_tbl;

update order_tbl set ord_code = 'c01'
where no = 1;
-- 변경 후 확인
select *
from order_tbl;
-- 변경되기 전의 데이터 확인 --> backup 
select *
from backup_order;

-- 4. ?기존 table의 데이터가 delete 될때 기존  내용을 backup table로 이동
-- 원본 table : order_tbl2
-- 백업 table : backup_order2

drop trigger backUpTrg2;

delimiter $$
create trigger backUpTrg2
	before delete
    on order_tbl
    for each row
begin
	insert into backup_order
		values(old.no, old.ord_code, old.ord_date);
end $$
delimiter ;

select *
from backup_order;

select *
from order_tbl;

DELETE from order_tbl
where no = 1;

select *
from backup_order;

select *
from order_tbl;