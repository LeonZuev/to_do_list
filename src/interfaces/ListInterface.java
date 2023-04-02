package interfaces;

import toDoList.RegularTask;
import toDoList.ToDoList;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ListInterface {
  private ToDoList toDoList;
  private Component parentComponent;

  public ListInterface(ToDoList toDoList, JFrame mainFrame) {
    this.toDoList = toDoList;
    this.parentComponent = mainFrame; // Set parentComponent to mainFrame
    WindowSetting windowSetting = new WindowSetting(); // Create an instance of WindowSetting
    WindowSetting.setWindowOnTargetMonitor(mainFrame); // Call setWindowOnTargetMonitor method
  }

  public void showMessageDialog(String message) {
    JOptionPane.showMessageDialog(parentComponent,
            message);
  }

  public int showConfirmDialog(String message, String title) {
    return JOptionPane.showConfirmDialog(parentComponent, message, title,
            JOptionPane.YES_NO_OPTION);
  }

  public String showInputDialog(String message) {
    return JOptionPane.showInputDialog(parentComponent, message);
  }

  public int showOptionDialog(Object[] options, String message, String title) {
    return JOptionPane.showOptionDialog(parentComponent, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
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

  public int getIdFromUser() {
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

  /*  public String readCorrection() throws IOException {
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
    }*/
  public String readCorrection() {
    String correction = (String) JOptionPane.showInputDialog(parentComponent,
            "What do you want to change?", "Correct Task", JOptionPane.PLAIN_MESSAGE,
            null, toDoList.getValidCorrections(), "TITLE");

    return correction;
  }

  public void showHelp(JFrame frame) {
    StringBuilder helpMessage = new StringBuilder();
    helpMessage.append("======= Help =======\n");
    helpMessage.append("Valid commands:\n");
    helpMessage.append("- ADD: Add a task\n");
    helpMessage.append("- DELETE: Delete a task\n");
    helpMessage.append("- VIEW: View task list\n");
    helpMessage.append("- EDIT: Edit a task\n");
    helpMessage.append("- HELP: Show help\n");
    helpMessage.append("- EXIT: Exit the application\n");

    showMessageDialog(helpMessage.toString());
  }


  public void correctTask() {
    try {
      int taskId = getIdFromUser();

      String correction = readCorrection();
      if (correction != null && toDoList.isValidCorrection(correction)) {
        String newValue = showInputDialog("Enter the new value: ");
      }
      else {
        showMessageDialog("Incorrect command: " + correction);
      }
    } catch (IllegalArgumentException e) {
      showMessageDialog(e.getMessage());
    }

  }

  public void sortTasks() {
    String[] options = {"ID", "TIME", "FINISH"};
    String sortType = (String) JOptionPane.showInputDialog(
            parentComponent,
            "Select sorting type:",
            "Sort tasks",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]);

    if (sortType == null) {
      return;
    }
    List<Map.Entry<Integer, RegularTask>> listOfTaskWithTime = toDoList.listToDo();
    while (!sortType.equals("FINISH")) {
      switch (sortType) {
        case "ID":
          toDoList.checkList();
          break;
      }
      sortType = (String) JOptionPane.showInputDialog(
              parentComponent,
              "Select sorting type:",
              "Sort Tasks",
              JOptionPane.PLAIN_MESSAGE,
              null,
              options,
              options[0]);

      if (sortType == null) {
        return;
      }
    }
    showTasksListDialog(listOfTaskWithTime);
  }
}
