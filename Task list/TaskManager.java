import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Task> tasks = new ArrayList<>();

    // Create
    public Task createTask(String title, String description) {
        Task t = new Task(title, description);
        tasks.add(t);
        return t;
    }

    // Read
    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public List<Task> getCompletedTasks() {
        return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }

    public Optional<Task> findById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }

    // Update
    public boolean updateTask(int id, String newTitle, String newDescription) {
        Optional<Task> o = findById(id);
        if (o.isPresent()) {
            Task t = o.get();
            t.setTitle(newTitle);
            t.setDescription(newDescription);
            return true;
        }
        return false;
    }

    // Mark Completed
    public boolean markCompleted(int id) {
        Optional<Task> o = findById(id);
        if (o.isPresent()) {
            o.get().markCompleted();
            return true;
        }
        return false;
    }

    // Delete
    public boolean deleteTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    // Persistence (optional)
    public void saveToFile(File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
        }
    }

    public static TaskManager loadFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (TaskManager) ois.readObject();
        }
    }
}
