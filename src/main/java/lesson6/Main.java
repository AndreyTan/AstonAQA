package lesson6;


import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Academia academia = new Academia(25);

        printStudents(academia.getStudents(), 1);
        academia.expellingStudents(3);

        academia.transferToNewCourse(3);
        printStudents(academia.getStudents(), 2);

        /*-----------------------*/

        TelephoneDirectory td = new TelephoneDirectory();
        td.get("Miller");
        td.add("3751537685975", "Peterson");
        td.add("3754234156789", "Morris");
        td.add("3751274589643", "Peterson");
        td.get("Morris");
        td.get("Peterson");
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\nСтуденты, обучающиеся на " + course + " курсе:");
        for (Student student : students) {
            if (student.getCourse() == course)
                System.out.println(student.getName());
        }
        System.out.println("----------------------");
    }

}