package interfaces;

import toDoList.RegularTask;
import toDoList.ToDoList;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainInterface {
  private static final ToDoList todoList = new ToDoList();
  public static void main(String[] args) {
    SwingUtilities.invokeLater(MainInterface::run);
  }
  private static void run() {
    JFrame frame = new JFrame("TODO List");

    ListInterface listInterface = new ListInterface(todoList, frame);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 309);
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(7, 1));

    JButton button1 = new JButton("HELP");
    panel.add(button1);

    // Add ActionListener to HELP button
    button1.addActionListener(e -> JOptionPane.showMessageDialog(frame, "This is the help message!"));

    JButton button2 = new JButton("New task");
    panel.add(button2);

    button2.addActionListener(e -> {
      JTextField title = new JTextField();
      JTextField hours = new JTextField();
      JTextField minutes = new JTextField();
      Object[] fields = {"Title: ", title, "Hours", hours, "Minutes", minutes};
      int option = JOptionPane.showConfirmDialog(frame, fields, "New Task",
              JOptionPane.OK_CANCEL_OPTION);
      if (option == JOptionPane.OK_OPTION) {
        try {
          int taskHours = Integer.parseInt(hours.getText());
          int taskMinutes = Integer.parseInt(minutes.getText());
          int taskId = todoList.getNextTaskId();
          RegularTask newTask = new RegularTask(taskId, taskHours, taskMinutes,
                  title.getText());
          todoList.newTask(newTask);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric " +
                  "values for hours and minutes.");
        }
      }
    });

    JButton button3 = new JButton("Check task");
    panel.add(button3);

    button3.addActionListener(e -> {
      JTextArea textArea = new JTextArea();
      JScrollPane scrollPane = new JScrollPane(textArea);
      textArea.setEditable(false);
      for (RegularTask task : todoList.getCurrentTasks()) {
        textArea.append(task.toString() + "\n");
      }
      JOptionPane.showMessageDialog(frame, scrollPane, "Current Tasks",
              JOptionPane.PLAIN_MESSAGE);
    });

    JButton button4 = new JButton("Correct task");
    panel.add(button4);

    button4.addActionListener(e -> listInterface.correctTask());

    JButton button5 = new JButton("Sort task");
    panel.add(button5);

    button5.addActionListener(e -> listInterface.sortTasks());

    JButton button6 = new JButton("Export task");
    panel.add(button6);

    button6.addActionListener(e -> {
      try {
        todoList.exportTaskList(); // Replace currentToDoList with todoList
        JOptionPane.showMessageDialog(frame, "Task list exported successfully!");
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(frame, "Error exporting task list: " +
                ex.getMessage());
      }
    });

    JButton button7 = new JButton("EXIT");
    panel.add(button7);

    button7.addActionListener(e -> {
      int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?",
              "Exit Confirmation", JOptionPane.YES_NO_OPTION);
      if (option == JOptionPane.YES_OPTION) {
        System.exit(0);
      }
    });

    frame.add(panel);
    frame.setVisible(true);
  }
}
