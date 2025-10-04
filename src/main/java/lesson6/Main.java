package lesson6;


import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Academia academia = new Academia();

        academia.createStudentsWithRandomPerformance(15,1,academia.getTitleGroup(0));
        academia.createStudentsWithRandomPerformance(17,3,academia.getTitleGroup(1));
        academia.createStudentsWithRandomPerformance(16,2,academia.getTitleGroup(2));

        academia.transferToNewCourse();
        academia.expellingStudents();


        printStudents(academia.getStudents(), 2);

        /*-----------------------*/
        System.out.println("\n\tТелефонный справочник\t\n");
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