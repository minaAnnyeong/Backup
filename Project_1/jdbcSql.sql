DROP TABLE teltable5;

CREATE TABLE teltable5 (
    id   NUMBER(5),
    name VARCHAR2(20),
    tel  VARCHAR2(20),
    d    DATE
);

SELECT * FROM teltable5;

INSERT INTO teltable5 VALUES (
    1,
    'kim',
    '010-7777-8888',
    '20240908'
);

// COMMIT: