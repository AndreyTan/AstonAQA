package lesson6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class Academia {
    private HashSet<Student> _students;
    private String[] _groups;

    public Academia(int countStud) {
        Random rand = new Random();
        _students = new HashSet<>(countStud);
        _groups = new String[]{"math_1", "prog_1", "buss_1", "model_1"};

        for (int i = 0; i < countStud; i++) {
            int course = rand.nextInt(1, 3);
            Student stud = new Student("Student " + (i + 1), _groups[rand.nextInt(0, _groups.length)] + course, course);
            fillRandomAcademicPerformance(stud.getAcademInfo());
            _students.add(stud);
        }
    }

    public HashSet<Student> getStudents() {
        return _students;
    }

    public void expellingStudents(double transitionThreshold) {
        HashSet<Student> verifiedStuds = new HashSet<>(_students.size());
        int countDeleted = 0;
        for (Student student : _students) {
            if (calculateAverageMark(student) >= transitionThreshold)
                verifiedStuds.add(student);
            else
                countDeleted++;
        }

        _students = verifiedStuds;
        System.out.printf("Удалённых студентов: %d, оставшихся: %d", countDeleted, _students.size());
    }

    public void transferToNewCourse(double transferThreshold) {
        for (Student student : _students) {
            if (calculateAverageMark(student) >= transferThreshold)
                student.upCourse();
        }
    }


    public static HashMap<CollegeSubjects, String> getAcademicPerformance() {
        HashMap<CollegeSubjects, String> hm = new HashMap<>(5);
        hm.put(CollegeSubjects.Mathematics, "");
        hm.put(CollegeSubjects.Modeling, "");
        hm.put(CollegeSubjects.ComputerScience, "");
        hm.put(CollegeSubjects.PhysicalEducation, "");
        hm.put(CollegeSubjects.Programming, "");

        return hm;
    }

    public void fillRandomAcademicPerformance(HashMap<CollegeSubjects, String> hm) {
        if (hm != null) {
            for (Map.Entry<CollegeSubjects, String> perf : hm.entrySet()) {
                perf.setValue(getRandomMarks());
            }
        }

    }

    private String getRandomMarks() {
        StringBuilder marks = new StringBuilder();
        Random random = new Random();
        int countMarks = random.nextInt(4, 13);
        for (int i = 0; i < countMarks; i++) {
            if (random.nextInt(1, 100) > 20)
                marks.append(random.nextInt(2, 6));
            else
                marks.append(2);
            if (i + 1 != countMarks)
                marks.append(" ");
        }
        return marks.toString();
    }

    public double calculateAverageMark(Student student) {
        int countMarks = 0;
        double globalMark = 0;

        for (Map.Entry<CollegeSubjects, String> item : student.getAcademInfo().entrySet()) {
            String[] strMarks = item.getValue().split(" ");
            for (String strMark : strMarks) {
                countMarks++;
                globalMark += Integer.parseInt(strMark);
            }
        }

        if (countMarks == 0)
            return 0;
        else
            return globalMark / countMarks;
    }


}
