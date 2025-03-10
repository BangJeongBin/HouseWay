-- 나중에 cascade 추가 해야함. 지금은 개발의 편의를 위해 안적음.
-- 종속성 순서대로 내림차순 했으니 데이터 삽입시 위에서 부터 삽입하면 됨.

-- 관리자
CREATE TABLE if not exists admin (
    admin_id       VARCHAR(18),                   -- 관리자 아이디
    admin_password VARCHAR(64)  NOT NULL,         -- 관리자 비밀번호
    admin_name     VARCHAR(64)  UNIQUE NOT NULL,  -- 관리자 이름(admin)
    admin_photo    VARCHAR(128) NOT NULL,         -- 관리자 사진
    PRIMARY KEY (admin_id)
);


-- 공인중개사
CREATE TABLE if not exists agent (
    agent_num       INT          AUTO_INCREMENT,    -- 공인중개사 번호
    agent_name      VARCHAR(64)  NOT NULL,          -- 공인중개사 이름(아이디)
    agent_phone     VARCHAR(64)  UNIQUE NOT NULL,   -- 공인중개사 연락처(비밀번호)
    agent_photo     VARCHAR(64)  NOT NULL,          -- 공인중개사 사진
    office_name     VARCHAR(64)  NOT NULL,          -- 공인중개사 사무실 이름
    office_address  VARCHAR(128) NOT NULL,          -- 공인중개사 사무실 주소
    agent_local     VARCHAR(18)  NOT NULL,          -- 공인중개사 사무실(구)
    agent_intro     VARCHAR(225) NULL,              -- 공인중개사 설명
    agent_salecount Int          NULL    DEFAULT 0, -- 공인중개사 판매실적
    PRIMARY KEY (agent_num)
);


-- 일반 회원
CREATE TABLE if not exists user (
    user_num        INT          AUTO_INCREMENT,             -- 회원 번호
    user_name       VARCHAR(64)  NOT NULL,                   -- 회원 이름
    user_id         VARCHAR(18)  UNIQUE    NOT NULL,         -- 회원 아이디
    user_password   VARCHAR(64)  NOT NULL,                   -- 회원 비밀번호
    user_addr1      VARCHAR(64)  NOT NULL,                   -- 회원 구 주소
    user_addr2      VARCHAR(64)  NULL,                       -- 회원 동 주소
    user_phone      VARCHAR(64)  NULL,                       -- 회원 연락처
    user_email      VARCHAR(64)  NULL,                       -- 회원 이메일
    user_gender     VARCHAR(18)  NOT NULL,                   -- 회원 성별
    user_regdate    DATETIME     DEFAULT current_timestamp,  -- 회원 등록일
    PRIMARY KEY (user_num)
);


-- 매물
CREATE TABLE if not exists estate (
    estate_id        VARCHAR(64),                        -- 매물 아이디
    agent_num        INT     NOT  NULL,                  -- 공인중개사 번호
    estate_title     VARCHAR(64)  NOT NULL,              -- 매물 이름
    estate_desc      VARCHAR(225) NOT NULL,              -- 매물 설명
    estate_addr      VARCHAR(64)  NOT NULL,              -- 매물 full 주소
    estate_gu        VARCHAR(64)  NOT NULL,              -- 매물 주소(구)
    estate_lat       DOUBLE       NOT NULL,              -- 매물 위도
    estate_lng       DOUBLE       NOT NULL,              -- 매물 경도
    estate_deposit   INT          NOT NULL,              -- 매물 보증금
    estate_rent      INT          NOT NULL,              -- 매물 월세
    estate_area      VARCHAR(64)  NOT NULL,              -- 매물 전용면적
    estate_amount    VARCHAR(64)  NOT NULL,              -- 매물 관리비
    estate_type      VARCHAR(64)  NOT NULL,              -- 매물 전, 월세 구분
    estate_service   VARCHAR(64)  NOT NULL,              -- 매물 타입
    estate_roomType  VARCHAR(64)  NOT NULL,              -- 방 타입
    estate_parking   VARCHAR(64)  NOT NULL,              -- 매물 주차여부
    estate_elev      VARCHAR(64)  NOT NULL DEFAULT 'f',  -- 매물 엘리베이터 여부
    estate_moveDate  VARCHAR(64)  NULL,                  -- 매물 입주 가능 날짜
    estate_option    VARCHAR(64)  NULL,                  -- 매물 옵션
    estate_viewCount INT          NOT NULL DEFAULT 0,    -- 매물 조회수
    estate_state     INT     NOT  NULL DEFAULT 1,        -- 매물 판매상태(판매시 0)
    PRIMARY KEY (estate_id),
    foreign key (agent_num) references agent (agent_num)
);


-- 매물 이미지
CREATE TABLE if not exists image (
    image_num    INT         AUTO_INCREMENT,  -- 매물 이미지 번호
    estate_id    VARCHAR(64) NOT NULL,        -- 매물 번호
    images_thumb VARCHAR(64) NOT NULL,        -- 매물 이미지 썸네일
    img1         VARCHAR(64) NOT NULL,        -- 매물 이미지 1
    img2         VARCHAR(64) NULL,            -- 매물 이미지 2
    img3         VARCHAR(64) NULL,            -- 매물 이미지 ...
    img4         VARCHAR(64) NULL,
    img5         VARCHAR(64) NULL,
    img6         VARCHAR(64) NULL,
    img7         VARCHAR(64) NULL,
    img8         VARCHAR(64) NULL,
    img9         VARCHAR(64) NULL,
    PRIMARY KEY (image_num),
    foreign key (estate_id) references estate (estate_id)
);


-- 게시판
CREATE TABLE if not exists board (
    board_num      INT           AUTO_INCREMENT,             -- 게시판 번호
    user_id        VARCHAR(18)   NOT NULL,                   -- 작성자 번호
    board_category VARCHAR(64)   NOT NULL,                   -- 게시판 동네
    board_title    VARCHAR(100)  NOT NULL,                   -- 게시판 제목
    board_cont     VARCHAR(225)  NOT NULL,                   -- 게시판 내용
    board_regdate  DATETIME      DEFAULT current_timestamp,  -- 게시판 작성일자
    board_update   DATETIME      NULL,                       -- 게시판 수정일자
    board_views    INT           NULL     DEFAULT 0,         -- 게시판 조회수
    board_rank     INT           NULL     DEFAULT 0,         -- 게시판 등급(공지사항은 1)
    PRIMARY KEY (board_num),
    foreign key (user_id) references user (user_id)
);


-- 북마크(관심목록)
CREATE TABLE if not exists bookmark (
    bookmark_num INT         AUTO_INCREMENT,  -- 북마크 번호
    user_id      VARCHAR(18) NOT NULL,        -- 북마크한 유저
    estate_id    VARCHAR(64) NOT NULL,        -- 북마크된 매물
    PRIMARY KEY (bookmark_num),
    foreign key (user_id) references user (user_id),
    foreign key (estate_id) references estate (estate_id)
);


-- 예약
CREATE TABLE if not exists reserv (
    reserv_num     INT          AUTO_INCREMENT,             -- 예약 번호
    user_id        VARCHAR(18)  NOT NULL,                   -- 예약한 유저
    estate_id      VARCHAR(64)  NOT NULL,                   -- 예약된 매물
    agent_num      INT          NOT NULL,                   -- 예약된 매물 공인중개사
    reserv_state   INT          NULL DEFAULT 1,             -- 예약 상태(예약검토, 예약반려, 예약성공)
    reserv_regdate DATETIME     DEFAULT current_timestamp,  -- 예약 일시
    PRIMARY KEY (reserv_num),
    foreign key (user_id) references user (user_id),
    foreign key (estate_id) references estate (estate_id),
    foreign key (agent_num) references agent (agent_num)
);


-- 판매내역
CREATE TABLE if not exists sales (
    sales_num   INT          AUTO_INCREMENT,             -- 판매 번호
    user_id     VARCHAR(18)  NOT NULL,                   -- 구매한 유저
    estate_id   VARCHAR(64)  NOT NULL,                   -- 판매된 매물 번호
    sales_date  DATETIME     DEFAULT current_timestamp,  -- 판매 일시
    sales_price INT          NOT NULL,                   -- 판매 총 금액
    PRIMARY KEY (sales_num),
    foreign key (user_id) references user (user_id),
    foreign key (estate_id) references estate (estate_id)
);
