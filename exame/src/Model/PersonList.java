package Model;

public class PersonList {

    private String name;
    private String lastname;
    private String grade1;
    private String grade2;

    public PersonList(String name, String lastname, String grade1, String grade2) {

        this.name = name;
        this.lastname = lastname;
        this.grade1 = grade1;
        this.grade2 = grade2;

    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGrade1() {
        return grade1;
    }

    public String getGrade2() {
        return grade2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGrade1(String grade1) {
        this.grade1 = grade1;
    }

    public void setGrade2(String grade2) {
        this.grade2 = grade2;
    }
}
