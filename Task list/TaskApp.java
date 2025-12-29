import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;

public class TaskApp {
    private TaskManager manager = new TaskManager();
    private DefaultListModel<Task> listModel = new DefaultListModel<>();

    private JFrame frame;
    private JList<Task> taskList;

    public TaskApp() {
        buildGUI();
        refreshList();
    }

    private void buildGUI() {
        frame = new JFrame("ToDo Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLayout(new BorderLayout(8,8));

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(taskList);

        // Buttons panel
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton addBtn = new JButton("Create Task");
        JButton editBtn = new JButton("Update Task");
        JButton completeBtn = new JButton("Mark Completed");
        JButton deleteBtn = new JButton("Delete Task");
        JButton showAll = new JButton("Show All");
        JButton showCompleted = new JButton("Show Completed");
        JButton saveBtn = new JButton("Save");
        JButton loadBtn = new JButton("Load");

        controls.add(addBtn);
        controls.add(editBtn);
        controls.add(completeBtn);
        controls.add(deleteBtn);
        controls.add(showAll);
        controls.add(showCompleted);
        controls.add(saveBtn);
        controls.add(loadBtn);

        frame.add(scroll, BorderLayout.CENTER);
        frame.add(controls, BorderLayout.NORTH);

        // Button actions
        addBtn.addActionListener(e -> createTaskDialog());
        editBtn.addActionListener(e -> updateTaskDialog());
        completeBtn.addActionListener(e -> markSelectedCompleted());
        deleteBtn.addActionListener(e -> deleteSelectedTask());
        showAll.addActionListener(e -> refreshList());
        showCompleted.addActionListener(e -> refreshCompleted());
        saveBtn.addActionListener(e -> saveAction());
        loadBtn.addActionListener(e -> loadAction());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createTaskDialog() {
        JTextField title = new JTextField(20);
        JTextField desc = new JTextField(30);
        JPanel p = new JPanel(new GridLayout(0,1));
        p.add(new JLabel("Title:")); p.add(title);
        p.add(new JLabel("Description:")); p.add(desc);

        int result = JOptionPane.showConfirmDialog(frame, p, "Create Task", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            manager.createTask(title.getText().trim(), desc.getText().trim());
            refreshList();
        }
    }

    private void updateTaskDialog() {
        Task t = taskList.getSelectedValue();
        if (t == null) { JOptionPane.showMessageDialog(frame, "Select a task to update."); return;}
        JTextField title = new JTextField(t.getTitle(), 20);
        JTextField desc = new JTextField(t.getDescription(), 30);
        JPanel p = new JPanel(new GridLayout(0,1));
        p.add(new JLabel("Title:")); p.add(title);
        p.add(new JLabel("Description:")); p.add(desc);

        int result = JOptionPane.showConfirmDialog(frame, p, "Update Task", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            manager.updateTask(t.getId(), title.getText().trim(), desc.getText().trim());
            refreshList();
        }
    }

    private void markSelectedCompleted() {
        Task t = taskList.getSelectedValue();
        if (t == null) { JOptionPane.showMessageDialog(frame, "Select a task to mark completed."); return;}
        manager.markCompleted(t.getId());
        refreshList();
    }

    private void deleteSelectedTask() {
        Task t = taskList.getSelectedValue();
        if (t == null) { JOptionPane.showMessageDialog(frame, "Select a task to delete."); return;}
        int ok = JOptionPane.showConfirmDialog(frame, "Delete selected task?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            manager.deleteTask(t.getId());
            refreshList();
        }
    }

    private void refreshList() {
        listModel.clear();
        manager.getAllTasks().forEach(listModel::addElement);
    }

    private void refreshCompleted() {
        listModel.clear();
        manager.getCompletedTasks().forEach(listModel::addElement);
    }

    private void saveAction() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                manager.saveToFile(chooser.getSelectedFile());
                JOptionPane.showMessageDialog(frame, "Saved.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Failed to save: " + ex.getMessage());
            }
        }
    }

    private void loadAction() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                manager = TaskManager.loadFromFile(chooser.getSelectedFile());
                refreshList();
                JOptionPane.showMessageDialog(frame, "Loaded.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Failed to load: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskApp::new);
    }
}
