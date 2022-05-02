package com.example.Linguine;

public class Student extends Member{

    private Long Student_id;

    public Student(String Name, String Id, String Password,
                   String PH, String Email, Long Student_id, String Nickname) {
        setName(Name);
        setId(Id);
        setPassword(Password);
        setPH(PH);
        setEmail(Email);
        setStudent_id(Student_id);
        setNickname(Nickname);
    }

    public Long getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(Long student_id) {
        Student_id = student_id;
    }
}
