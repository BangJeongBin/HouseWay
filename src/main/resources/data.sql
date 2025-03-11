-- admin 테이블
insert into admin (admin_id, admin_password, admin_name, admin_photo)
    values ('admin', 'admin', 'admin', 'ddd');


-- user 테이블
--insert into user (user_name, user_id, user_password, user_addr1, user_addr2, user_phone, user_email, user_gender)
--    values ('홍길동', 'hong', 'hong', '마포구', '대흥동', '010-1111-1111', 'hong@gmail.com', '남');
--insert into user (user_name, user_id, user_password, user_addr1, user_addr2, user_phone, user_email, user_gender)
--    values ('강감찬', 'kang', 'kang', '관악구', '봉천동', '010-2222-2222', 'kang@gmail.com', '남');
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



-- agent 테이블
insert into agent (agent_name, agent_phone, agent_photo, office_name, office_address, agent_local, agent_intro)
    values ('김길자', '010-0000-0000', 'aaa.jpg', '가나다공인중개사', '서울시 마포구 대흥동 111-1', '마포구', '안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!');
insert into agent (agent_name, agent_phone, agent_photo, office_name, office_address, agent_local, agent_intro)
    values ('황근출', '010-9999-9999', 'bbb.jpg', '라마바공인중개사', '서울시 마포구 대흥동 222-2', '서대문구', '안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!안녕하세요!');
