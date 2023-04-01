
package interfaces;

import org.junit.jupiter.api.DynamicNode;
import toDoList.RegularTask;
import toDoList.ToDoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleInterface {
  private static final ToDoList todoList = new ToDoList();
  public static void main(String[] args) {
    SwingUtilities.invokeLater(SimpleInterface::run);
  }

  private static void run() {
    JFrame frame = new JFrame("TODO List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 309);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(7, 1));

    JButton button1 = new JButton("HELP");
    panel.add(button1);

    // Add ActionListener to HELP button
    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "This is the help message!");
      }
    });


    JButton button2 = new JButton("New task");
    panel.add(button2);

    button2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
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
            RegularTask newTask = new RegularTask(++taskId, taskHours, taskMinutes,
                    title.getText());
            todoList.newTask(newTask);
            ToDoList currentToDoList = null;
            currentToDoList.newTask(newTask);
            JOptionPane.showMessageDialog(frame, "New task created: " + newTask.toString());
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values for hours and minutes.");
          }
        }
      }
    });

    JButton button3 = new JButton("Check task");
    JTextField textField3 = new JTextField(10);
    panel.add(button3);


    JButton button4 = new JButton("Check task");
    JTextField textField4 = new JTextField(10);
    panel.add(button4);


    JButton button5 = new JButton("Sort task");
    JTextField textField5 = new JTextField(10);
    panel.add(button5);


    JButton button6 = new JButton("Export task");
    JTextField textField6 = new JTextField(10);
    panel.add(button6);


    JButton button7 = new JButton("EXIT");
    JTextField textField7 = new JTextField(10);
    panel.add(button7);


    frame.add(panel);
    frame.setVisible(true);
  }
}
