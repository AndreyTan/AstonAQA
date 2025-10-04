package lesson6;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Academia {
    private HashSet<Student> students = new HashSet<>(20);
    private ArrayList<String> groups;
    private DecimalFormat df;

    public Academia() {
        df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        groups = new ArrayList<>(4);
        addNewGroup("math group");
        addNewGroup("model group");
        addNewGroup("prog group");
        addNewGroup("phys group");
    }

    public void createStudentsWithRandomPerformance(int countStud, int course, String group) {
        for (int i = 0; i < countStud; i++) {
            addNewStudent("Student " + (i + 1), course, group);
        }
    }

    public void addNewGroup(String group) {
        this.groups.add(group);
    }

    public String getTitleGroup(int i) throws IndexOutOfBoundsException {
        if (i >= 0 && i < this.groups.size())
            return this.groups.get(i);
        else
            throw new IndexOutOfBoundsException("Некорректный индекс");
    }

    public void addNewStudent(String name, int course, String group) {
        Student stud = new Student(name, group, course);
        fillRandomAcademicPerformance(stud.getAcademInfo());
        this.students.add(stud);
    }

    public HashSet<Student> getStudents() {
        return this.students;
    }

    public void expellingStudents() {
        System.out.println("\n...Удаляем студентов...\n");
        HashSet<Student> verifiedStuds = new HashSet<>(this.students.size());
        int countDeleted = 0;

        for (Student student : this.students) {
            double avgMark = calculateAverageMark(student);
            if (avgMark >= 3) {
                System.out.printf("%s средняя оценка: %.2f\n", student.getName(), avgMark);
                verifiedStuds.add(student);
            } else {
                countDeleted++;
                System.out.printf("\tудаляем %s средняя оценка: %.2f\n", student.getName(), avgMark);
            }
        }

        this.students = verifiedStuds;
        System.out.printf("Удалённых студентов: %d, оставшихся: %d\n", countDeleted, this.students.size());
    }

    public void transferToNewCourse() {
        System.out.println("\n...переводим студентов на новый курс...\n");
        for (Student student : this.students) {
            double avgMark = calculateAverageMark(student);

            if (avgMark >= 3) {
                System.out.printf("%s средняя оценка: %.2f переводим\n", student.getName(), avgMark);
                student.upCourse();
            } else {
                System.out.printf("\t%s средняя оценка: %.2f непереводим\n", student.getName(), avgMark);
            }
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
            return Double.parseDouble(df.format(globalMark / countMarks).replace(',','.'));
    }


}
