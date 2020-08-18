--사용자(회원) 정보를 저장할 테이블
CREATE TABLE users(
	id VARCHAR2(100) primary key,
	pwd VARCHAR2(100) NOT NULL,
	email VARCHAR2(100),
	profile VARCHAR2(100),  --프로필 이미지 경로를 저장할 칼럼
	regdate DATE 
);

CREATE TABLE board_gallery(
	num NUMBER PRIMARY KEY,
	writer VARCHAR2(100),
	caption VARCHAR2(200),
	imagePath VARCHAR2(100),
	regdate DATE 
);

CREATE SEQUENCE board_gallery_seq;

CREATE TABLE board_cafe(
	num NUMBER PRIMARY KEY,
	writer VARCHAR2(100) NOT NULL,
	title VARCHAR2(100) NOT NULL,
	content CLOB,
	viewcount NUMBER,
	regdate date
);

CREATE SEQUENCE board_cafe_seq;

CREATE TABLE board_cafe_comment(
	num NUMBER PRIMARY KEY,  --댓글의 글 번호
	writer VARCHAR2(100),	--댓글 작성자 아이디
	content VARCHAR2(500),	--댓글 내용
	target_id VARCHAR2(100),	--댓글의 대상자 아이디 (누구한테 답글을 달았는지 > 리플단 대상 아이디)
	ref_group NUMBER,	--원래 글의 글 번호로 저장을 해서 해당 게시물에 대한 댓글을 가져올 수 있다.
	comment_group NUMBER,	--댓글+리플을 순서대로 정렬하기 그룹으로 묶어 저장
	deleted CHAR(3) DEFAULT 'no',
	regdate DATE
);
-- num과 comment_group가 같으면 원글의 댓글, 다르면 리플
--insert 시점에 num과 comment_group를 .nextval하면 글 번호가 다르게 저장 되므로 insert하기 전 미리 글 번호를 얻어와서 이용
CREATE SEQUENCE  board_cafe_comment_seq;