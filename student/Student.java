package student;

import java.util.Objects;

public class Student {

    private String name;
    private String gender;
    private String stream;
    private String password;
    private int regNo;
    private int form;

    public Student(String name, String gender, String stream,
                   int regNo, int form, String password) {
        this.name = name;
        this.gender = gender;
        this.stream = stream;
        this.regNo = regNo;
        this.form = form;
        this.password = password;
    }

    // Getters
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getStream() { return stream; }
    public String getPassword() { return password; }
    public int getRegNo() { return regNo; }
    public int getForm() { return form; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return regNo == student.regNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo);
    }

    @Override
    public String toString() {
        return name + "," + gender + "," + form + "," +
               stream + "," + regNo + "," + password;
    }
}
