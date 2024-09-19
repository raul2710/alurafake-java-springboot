CREATE TABLE Course(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    code varchar(15) NOT NULL,
    instructor varchar(50) NOT NULL,
    emailInstructor varchar(50) NOT NULL,
    description varchar(200) NOT NULL,
    hoursToComplete integer NOT NULL,
    inactiveDateTime datetime,
    status enum('INACTIVE', 'ACTIVE') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'ACTIVE',

    PRIMARY KEY (id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;