-- Advisors Table
CREATE TABLE Advisors (
    advisor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    specialization VARCHAR(50),
    CONSTRAINT uq_advisors_email UNIQUE (email)
);

-- Courses Table
CREATE TABLE Courses (
    course_code CHAR(6) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    instructor VARCHAR(50) NOT NULL
);

-- Students Table
CREATE TABLE Students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    dob DATE NOT NULL,
    advisor_id INT,
    CONSTRAINT fk_students_advisor 
        FOREIGN KEY (advisor_id) 
        REFERENCES Advisors(advisor_id)
        ON DELETE SET NULL
);


-- Enrollment Table
CREATE TABLE Enrollment (
    student_id INT NOT NULL,
    course_code CHAR(6) NOT NULL,
    enrollment_date DATE NOT NULL ,
    status ENUM('enrolled', 'completed', 'dropped') NOT NULL DEFAULT 'enrolled',
    CONSTRAINT pk_enrollment PRIMARY KEY (student_id, course_code),
    CONSTRAINT fk_enrollment_student 
        FOREIGN KEY (student_id) 
        REFERENCES Students(student_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_enrollment_course 
        FOREIGN KEY (course_code) 
        REFERENCES Courses(course_code)
        ON DELETE CASCADE
);
