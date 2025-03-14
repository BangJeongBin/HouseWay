-- admin 테이블(insert)
insert into admin (admin_id, admin_password, admin_name, admin_photo)
    values ('admin', 'admin', 'admin', 'ddd');


-- user 테이블(insert 30개)
INSERT INTO user (user_name, user_id, user_password, user_addr1, user_addr2, user_phone, user_email, user_gender) VALUES
('홍길동', 'hong', 'hong', '마포구', '대흥동', '010-1111-1111', 'hong@gmail.com', '남'),
('강감찬', 'kang', 'kang', '관악구', '봉천동', '010-2222-2222', 'kang@gmail.com', '남'),
('이순신', 'lee', 'lee', '종로구', '숭인동', '010-3333-3333', 'lee@gmail.com', '남'),
('유관순', 'yu', 'yu', '서대문구', '신촌동', '010-4444-4444', 'yu@gmail.com', '여'),
('김유신', 'kimy', 'kimy', '강남구', '역삼동', '010-5555-5555', 'kimy@gmail.com', '남'),
('신사임당', 'shin', 'shin', '강동구', '천호동', '010-6666-6666', 'shin@gmail.com', '여'),
('장보고', 'jang', 'jang', '영등포구', '여의도동', '010-7777-7777', 'jang@gmail.com', '남'),
('안중근', 'ahn', 'ahn', '동대문구', '청량리동', '010-8888-8888', 'ahn@gmail.com', '남'),
('세종대왕', 'sejong', 'sejong', '성북구', '안암동', '010-9999-9999', 'sejong@gmail.com', '남'),
('정약용', 'jeong', 'jeong', '광진구', '화양동', '010-1010-1010', 'jeong@gmail.com', '남'),
('황진이', 'hwang', 'hwang', '노원구', '상계동', '010-2020-2020', 'hwang@gmail.com', '여'),
('이율곡', 'yulgok', 'yulgok', '양천구', '목동', '010-3030-3030', 'yulgok@gmail.com', '남'),
('김홍도', 'kimh', 'kimh', '도봉구', '창동', '010-4040-4040', 'kimh@gmail.com', '남'),
('김정호', 'kimj', 'kimj', '송파구', '잠실동', '010-5050-5050', 'kimj@gmail.com', '남'),
('박지원', 'park', 'park', '중랑구', '면목동', '010-6060-6060', 'park@gmail.com', '남'),
('원효대사', 'wonhyo', 'wonhyo', '강북구', '수유동', '010-7070-7070', 'wonhyo@gmail.com', '남'),
('허준', 'heo', 'heo', '금천구', '독산동', '010-8080-8080', 'heo@gmail.com', '남'),
('장영실', 'jangy', 'jangy', '관악구', '남현동', '010-9090-9090', 'jangy@gmail.com', '남'),
('이황', 'toegye', 'toegye', '서초구', '방배동', '010-1112-1112', 'toegye@gmail.com', '남'),
('이이', 'yiyi', 'yiyi', '성동구', '성수동', '010-1212-1212', 'yiyi@gmail.com', '남'),
('최영', 'choi', 'choi', '은평구', '불광동', '010-1313-1313', 'choi@gmail.com', '남'),
('강이슬', 'kangis', 'kangis', '양천구', '신정동', '010-1414-1414', 'kangis@gmail.com', '여'),
('박하나', 'parkh', 'parkh', '마포구', '상암동', '010-1515-1515', 'parkh@gmail.com', '여'),
('조선', 'cho', 'cho', '강동구', '둔촌동', '010-1616-1616', 'cho@gmail.com', '남'),
('서희', 'seo', 'seo', '송파구', '가락동', '010-1717-1717', 'seo@gmail.com', '남'),
('나혜석', 'na', 'na', '용산구', '이촌동', '010-1818-1818', 'na@gmail.com', '여'),
('윤봉길', 'yun', 'yun', '도봉구', '방학동', '010-1919-1919', 'yun@gmail.com', '남'),
('이방원', 'lee2', 'lee2', '중구', '을지로동', '010-2021-2021', 'lee2@gmail.com', '남'),
('김구', 'kimk', 'kimk', '종로구', '삼청동', '010-2121-2121', 'kimk@gmail.com', '남'),
('이성계', 'leesi', 'leesi', '성북구', '정릉동', '010-2222-2222', 'leesi@gmail.com', '남');



-- agent 테이블(판매실적 update)
update agent set agent_saleCount = 50 where agent_num = 396603;
update agent set agent_saleCount = 100 where agent_num = 129417;
update agent set agent_saleCount = 200 where agent_num = 2195297;
update agent set agent_saleCount = 300 where agent_num = 4746699;
update agent set agent_saleCount = 400 where agent_num = 16996112;
update agent set agent_saleCount = 500 where agent_num = 22203704;


-- reserv 테이블(insert)
/*insert into reserv (user_id, estate_id, agent_num, agent_name)
    values ('leesi', 44108269, 22203704, '유형우');
insert into reserv (user_id, estate_id, agent_num, agent_name, reserv_state)
    values ('kimk', 44107810, 5825625, '남정일');
insert into reserv (user_id, estate_id, agent_num, agent_name, reserv_state)
    values ('lee2', 44108269, 22203704, '유형우');
insert into reserv (user_id, estate_id, agent_num, agent_name, reserv_state)
    values ('yiyi', 44108269, 22203704, '유형우');
insert into reserv (user_id, estate_id, agent_num, agent_name, reserv_state)
    values ('이은영', 44108269, 22203704, '유형우');
insert into reserv (user_id, estate_id, agent_num, agent_name)
    values ('leesi', 44099932, 519883, '홍석순');*/


-- bookmark 테이블(insert)
/*insert into bookmark (user_id, estate_id)
    values ('leesi', 44099932);
insert into bookmark (user_id, estate_id)
    values ('kimk', 44099932);*/


-- estate 테이블(update)
update estate set estate_viewCount = 500 where estate_id = 44108342;
update estate set estate_viewCount = 400 where estate_id = 44108269;
update estate set estate_viewCount = 300 where estate_id = 44102401;
update estate set estate_viewCount = 600 where estate_id = 44099932;
update estate set estate_viewCount = 200 where estate_id = 44095626;
update estate set estate_viewCount = 100 where estate_id = 44088090;
update estate set estate_viewCount = 50 where estate_id = 44070367;


-- estate 테이블(update)
update estate set estate_state = 0 where estate_id = 44070367;
