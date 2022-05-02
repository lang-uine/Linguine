package com.example.Linguine;

public class Professor extends Member{

    private Long Professor_id;

    public Professor(String Name, String Id, String Password,
                     String PH, String Email, Long Professor_id, String Nickname) {
        setName(Name);
        setId(Id);
        setPassword(Password);
        setPH(PH);
        setEmail(Email);
        setProfessor_id(Professor_id);
        setNickname(Nickname);

    }

    public Long getProfessor_id() {
        return Professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        Professor_id = professor_id;
    }
}
