
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class UserMonitorFrame extends JFrame {
  private JTextField fSource = new JTextField(20);
  private JTextField fTarget = new JTextField(20);
  private JLabel labelSource = new JLabel("文件地址");
  private JLabel labelTarget = new JLabel("复制地址");;
  private JButton btn1 = new JButton("选择源文件");
  private JButton btn2 = new JButton("选择目标文件夹");
  private JButton btn3 = new JButton("复制");

  public UserMonitorFrame() {
    JPanel p1 = new JPanel();
    p1.add(labelSource);
    p1.add(fSource);
    p1.add(btn1);
    btn1.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        fSource.setText(file.getAbsolutePath());
      }
    });
    JPanel p2 = new JPanel();
    p2.add(labelTarget);
    p2.add(fTarget);
    p2.add(btn2);
    btn2.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        fTarget.setText(file.getAbsolutePath());
      }
    });
    JPanel p3 = new JPanel();
    p3.setLayout(new FlowLayout(FlowLayout.CENTER));
    p3.add(btn3);
    btn3.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        copyFileUtil(fSource.getText(), fTarget.getText());
      }
    });
    Box box = Box.createVerticalBox();
    box.add(p1);
    box.add(p2);
    box.add(p3);
    add(box);
    setTitle("文件复制");
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }

  public void copyFileUtil(String source, String target) {
    try {
      File file = new File(source);
      target = target + "\\" + file.getName();
      FileReader input = new FileReader(file);
      BufferedReader fis = new BufferedReader(input);
      FileWriter output = new FileWriter(target);
      BufferedWriter fos = new BufferedWriter(output);
      int n = 0;
      while ((n = fis.read()) != -1) {
        fos.write(n);
      }
      fis.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // try {
    // File file = new File(source);
    // target = target + "\\" + file.getName();
    // int n = 0;
    // FileInputStream fis = new FileInputStream(source);
    // FileOutputStream fos = new FileOutputStream(target);
    // while ((n = fis.read()) != -1) {
    // fos.write(n);
    // }
    // fis.close();
    // fos.close();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
  }

  public static void main(String[] args) {
    new UserMonitorFrame();
  }
}
