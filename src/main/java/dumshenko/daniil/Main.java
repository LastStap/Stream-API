package dumshenko.daniil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student("Poroshenko", 23, 2.0);
        Student student2 = new Student("Zelensky", 18, 9.0);
        Student student3 = new Student("Kuchma", 15, 5.0);
        Student student4 = new Student("Yanukovich", 19, 0.0);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        studentList.stream()
                .filter(student -> student.getGrade() < 4.0)
                .forEach(System.out::println);

        Optional<Student> topStudent = studentList.stream()
                .max(Comparator.comparingDouble(Student::getGrade));
        topStudent.ifPresent(student -> System.out.println("Top student: " + student));

        long count = studentList.stream()
                .filter(student -> student.getAge() > 20)
                .count();
        System.out.println("Number of students older than 20: " + count);

        List<Student> sortedListOfStudents = studentList.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .collect(Collectors.toList());
        System.out.println(sortedListOfStudents);

        Optional<Student> checkingIfAnyStudentHaveGrade5 = studentList.stream()
                .filter(student -> student.getGrade() == 5.0)
                .findAny();
        if (checkingIfAnyStudentHaveGrade5.isEmpty()) {
            throw new RuntimeException("No such student");
        }
        System.out.println(checkingIfAnyStudentHaveGrade5);

        studentList.stream()
                .filter(student -> student.getGrade() > 4.0)
                .forEach(student -> System.out.println(student.getName()));

        boolean checkingIfAnyStudentHaveGrade52 = studentList.stream()
                .anyMatch(student -> student.getGrade() == 5.0);
        System.out.println(checkingIfAnyStudentHaveGrade52);
    }
}
