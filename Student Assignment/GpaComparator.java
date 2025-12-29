import java.util.Comparator;

public class GpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Sort by GPA in ascending order
        return Double.compare(s1.getGpa(), s2.getGpa());
    }
}
