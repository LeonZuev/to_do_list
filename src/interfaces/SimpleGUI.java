/*package interfaces;

import toDoList.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SimpleGUI extends JFrame {
  public SimpleGUI() {
    // Настройка параметров окна
    setTitle("Simple GUI");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Создание компонентов интерфейса
    JButton button1 = new JButton("HELP");
    JTextField textField1 = new JTextField(20);

    JButton button2 = new JButton("New task");
    JTextField textField2 = new JTextField(20);
    //panel.add(textField2);

    JButton button3 = new JButton("Check task");
    JTextField textField3 = new JTextField(20);

    JButton button4 = new JButton("Check task");
    JTextField textField4 = new JTextField(20);

    JButton button5 = new JButton("Sort task");
    JTextField textField5 = new JTextField(20);

    JButton button6 = new JButton("Export task");
    JTextField textField65 = new JTextField(20);

    JButton button7 = new JButton("EXIT");
    JTextField textField7 = new JTextField(20);

    // Добавление слушателя событий для кнопки
    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textField1.setText("Hello, World!");
      }
    });

    button2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Если метод createRegularTask статический
        try {
          Main.createRegularTask();
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }

        // Если метод createRegularTask НЕ статический
        // TaskManager taskManager = new TaskManager();
        // taskManager.createRegularTask();
      }
    });

    // Создание панели для размещения компонентов
    JPanel panel = new JPanel();
    panel.add(textField1);
    panel.add(button1);

    panel.add(button2);

    // Добавление панели в окно
    getContentPane().add(panel);

    // Отображение окна
    setVisible(true);
  }

  public static void main(String[] args) {
    // Запуск графического интерфейса в отдельном потоке
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SimpleGUI();
      }
    });
  }
}*/
