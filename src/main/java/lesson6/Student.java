package lesson6;

import java.util.HashMap;

public class Student {
    private String _name;
    private String _group;
    private int _course;
    private HashMap<CollegeSubjects, String> _academicPerformance;

    public Student(String name, String group, int course) {
        this._name = name;
        this._group = group;
        this._course = course;
        this._academicPerformance = Academia.getAcademicPerformance();
    }

    public String getName() {
        return _name;
    }

    public int getCourse() {
        return _course;
    }

    public HashMap<CollegeSubjects, String> getAcademInfo() {
        return _academicPerformance;
    }

    public void upCourse() {
        _course++;
    }


}
