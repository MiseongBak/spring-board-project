INSERT INTO member(name, email, password) VALUES(
    '윤서준',
    'SeojunYoon@hanbit.co.kr',
    '$2a$12$RcpH.VTfxOznGNDAgWEFBuY/5q4uW5YeqxXDFu9bHSuGi5Hi9gaqa'
);

INSERT INTO member(name, email, password) VALUES(
    '윤광철',
    'KwangcheolYoon@hanbit.co.kr',
    '$2a$12$RcpH.VTfxOznGNDAgWEFBuY/5q4uW5YeqxXDFu9bHSuGi5Hi9gaqa'
);

INSERT INTO member(name, email, password) VALUES(
    '공미영',
    'MiyeongKong@hanbit.co.kr',
    '$2a$12$RcpH.VTfxOznGNDAgWEFBuY/5q4uW5YeqxXDFu9bHSuGi5Hi9gaqa'
);

INSERT INTO member(name, email, password) VALUES(
    '김도윤',
    'DoyunKim@hanbit.co.kr',
    '$2a$12$RcpH.VTfxOznGNDAgWEFBuY/5q4uW5YeqxXDFu9bHSuGi5Hi9gaqa'
);

INSERT INTO authority(authority, member_id) VALUES('ROLE_ADMIN', 2);

INSERT INTO article(title, description, created, updated, member_id) VALUES('첫 번째 게시글 목록', '첫 번째 게시글 본문', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT INTO article(title, description, created, updated, member_id) VALUES('두 번째 게시글 목록', '두 번째 게시글 본문', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);
INSERT INTO article(title, description, created, updated, member_id) VALUES('세 번째 게시글 목록', '세 번째 게시글 본문', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3);
INSERT INTO article(title, description, created, updated, member_id) VALUES('네 번째 게시글 목록', '네 번째 게시글 본문', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 4);