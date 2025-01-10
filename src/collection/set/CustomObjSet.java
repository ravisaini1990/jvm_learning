package collection.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CustomObjSet {

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Ravi", 123));
        students.add(new Student("John", 1234));
        students.add(new Student("Merry", 12345));

        System.out.println(students);

        //add duplicate object - it add so provide hashcode implementation to avoid it in student class
        students.add(new Student("Merry", 12345));

        //after implementation its not allowing duplicate
        System.out.println(students);

        //since we used rollno as unique , so not allowing it now
        students.add(new Student("Paul", 123));
        System.out.println(students);
    }
}

class Student {
    String name;
    int rollNumber;

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }
}
