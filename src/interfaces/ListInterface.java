package interfaces;

import toDoList.RegularTask;
import toDoList.ToDoList;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class ListInterface {
  private ToDoList toDoList;
  public ListInterface() {
    this.toDoList = toDoList;
  }


  public static void main(String[] args) {
    SwingUtilities.invokeLater(ListInterface::run);
  }
  private static void run() {
    ListInterface listInterface = new ListInterface();
    // You can now call the methods of the `listInterface` object, for example:
    listInterface.showHelp(null);
  }


  public void showMessageDialog(String message) {
    JOptionPane.showMessageDialog(null, message);
  }

  public int showConfirmDialog(String message, String title) {
    return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
  }

  public String showInputDialog(String message) {
    return JOptionPane.showInputDialog(null, message);
  }

  public int showOptionDialog(Object[] options, String message, String title) {
    return JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
  }

  public void showTasksListDialog(List<Map.Entry<Integer, RegularTask>> listOfTaskWithId) {
    StringBuilder tasksList = new StringBuilder();
    tasksList.append("======= My ToDo List ======\n");
    for (Map.Entry<Integer, RegularTask> pair : listOfTaskWithId) {
      RegularTask temp = pair.getValue();
      tasksList.append(temp).append("\n");
    }
    tasksList.append("\n");
    showMessageDialog(tasksList.toString());
  }

  public int getIdFromUser() throws IOException {
    String idString = showInputDialog("Please, enter the task number: ");
    int id;
    try {
      id = Integer.parseInt(idString);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Incorrect id number, should be Integer! " + e);
    }

    if (!toDoList.containsTask(id)) {
      throw new IllegalArgumentException("There is NO task with such id");
    }

    return id;
  }

  public String readCorrection() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    toDoList.printMenu();
    System.out.print("What do you want to change? ");
    String correction = br.readLine().toUpperCase();

    while (!toDoList.isValidCorrection(correction)) {
      showMessageDialog("Incorrect command: " + correction);
      System.out.println("Please, enter correct one: ");
      correction = br.readLine().toUpperCase();
    }

    System.out.println();
    return correction;
  }

  public void showHelp(JFrame frame) {
  }
}