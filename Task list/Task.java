import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate; // optional

    public Task(String title, String description) {
        this.id = idCounter.getAndIncrement();
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.dueDate = null;
    }

    // Accessors
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getDueDate() { return dueDate; }

    // Mutators
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    // Business helpers
    public void markCompleted() { setCompleted(true); }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String due = (dueDate == null) ? "None" : dueDate.format(f);
        return String.format("[%d] %s %s (Completed: %s) Due: %s",
                id, title, (description.isEmpty() ? "" : "- " + description), completed, due);
    }
}
