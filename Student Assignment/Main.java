import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Map<String, Student> studentMap = new HashMap<>();

        // Create student objects
        students.add(new Student("S001", "Alice", 3.8, "CS"));
        students.add(new Student("S003", "Charlie", 3.9, "Physics"));
        students.add(new Student("S002", "Bob", 3.5, "Math"));

        // Add students to map
        for (Student s : students) {
            studentMap.put(s.getId(), s);
        }

        // Display original list
        System.out.println("Original List:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by ID
        System.out.println("\nSorted by ID:");
        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by GPA
        System.out.println("\nSorted by GPA:");
        students.sort(new GpaComparator());
        for (Student s : students) {
            System.out.println(s);
        }

        // Search by ID
        System.out.println("\nSearch by ID 'S002':");
        System.out.println(studentMap.get("S002"));
    }
}
