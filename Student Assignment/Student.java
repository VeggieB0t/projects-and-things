public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private double gpa;
    private String major;

    // Constructor
    public Student(String id, String name, double gpa, String major) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.major = major;
    }

    // Accessors
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    // compareTo method (sort by ID)
    @Override
    public int compareTo(Student s) {
        return this.id.compareTo(s.getId());
    }

    // toString method
    @Override
    public String toString() {
        return "Student[id:" + id + ", name:" + name + ", gpa:" + gpa + ", major:" + major + "]";
    }
}