import java.awt.*;
import javax.swing.*;

public class ToDoListApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoListApp().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        // Frame setup
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Components
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JTextField taskInput = new JTextField();
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        // Panel for input and buttons
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        // Action Listeners
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskInput.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            var selectedIndices = taskList.getSelectedIndices();
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                listModel.remove(selectedIndices[i]);
            }
        });

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Display the GUI
        frame.setVisible(true);
    }
}
