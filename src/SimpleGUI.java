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
    JButton button = new JButton("Click me!");
    JTextField textField = new JTextField(20);

    // Добавление слушателя событий для кнопки
    button.addActionListener(new ActionListener() {
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
}