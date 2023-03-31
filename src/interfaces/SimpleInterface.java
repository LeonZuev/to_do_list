package interfaces;

import javax.swing.*;
import java.awt.*;

public class SimpleInterface {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("TODO List");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 309);

      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(7,1));

      JButton button1 = new JButton("HELP");
      JTextField textField1 = new JTextField(20);
      panel.add(button1);
      /*panel.add(textField1);*/

      JButton button2 = new JButton("New task");
      JTextField textField2 = new JTextField(10);
      panel.add(button2);
      /*panel.add(textField2);*/

      JButton button3 = new JButton("Check task");
      JTextField textField3 = new JTextField(10);
      panel.add(button3);
      /*panel.add(textField3);*/

      JButton button4 = new JButton("Check task");
      JTextField textField4 = new JTextField(10);
      panel.add(button4);
      /*panel.add(textField4);*/

      JButton button5 = new JButton("Sort task");
      JTextField textField5 = new JTextField(10);
      panel.add(button5);
      /*panel.add(textField5);*/

      JButton button6 = new JButton("Export task");
      JTextField textField6 = new JTextField(10);
      panel.add(button6);
      /*panel.add(textField6);*/

      JButton button7 = new JButton("EXIT");
      JTextField textField7 = new JTextField(10);
      panel.add(button7);
      /*panel.add(textField7);*/

      frame.add(panel);
      frame.setVisible(true);
    });
  }
}