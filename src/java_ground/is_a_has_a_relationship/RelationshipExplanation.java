package java_ground.is_a_has_a_relationship;

//Is-a (Inheritance)   - Child classes share behavior and type.
// Has-a (Composition) - Classes contain objects of other classes for functionality.

import java.util.List;

public class RelationshipExplanation {

    public static void main(String[] args) {
        Student student = new Student();
        student.introduce();  // Inherited method
        student.study();      // Student's own method

        Professor professor = new Professor();
        professor.introduce(); // Inherited method
        professor.teach();     // Professor's own method
    }

}

class Person {
    private String name;
    private int age;

    public void introduce() {
        System.out.println("Hi, I am " + name);
    }
}

class Student extends Person {  // Student is-a Person
    private String studentId;
    private List<Course> courses; // Student has-many Courses

    public void study() {
        System.out.println("Studying...");
    }
}

class Professor extends Person {  // Professor is-a Person
    private String employeeId;

    public void teach() {
        System.out.println("Teaching...");
    }
}

class Department {
    private String name;
    private Professor head;
}

class Course {
    private String courseName;
    private Professor professor;  // Course has-a Professor
}


