/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        textField.setText("Hello, World!");
      }
    });

    // Создание панели для размещения компонентов
    JPanel panel = new JPanel();
    panel.add(textField);
    panel.add(button);

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
