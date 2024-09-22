CREATE TABLE Registration(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    courseCode varchar(15) NOT NULL,
    studentEmail varchar(50) NOT NULL,

    PRIMARY KEY (id, courseCode, studentEmail),

    FOREIGN KEY (courseCode) REFERENCES Course(code),
    FOREIGN KEY (studentEmail) REFERENCES User(email)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;