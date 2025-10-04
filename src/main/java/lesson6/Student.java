package lesson6;

import java.util.HashMap;

public class Student {
    private String name;
    private String group;
    private int course;
    private HashMap<CollegeSubjects, String> academicPerformance;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.academicPerformance = Academia.getAcademicPerformance();
    }

    public String getName() {
        return this.name;
    }

    public int getCourse() {
        return this.course;
    }

    public HashMap<CollegeSubjects, String> getAcademInfo() {
        return this.academicPerformance;
    }

    public void upCourse() {
        this.course++;
    }


}
