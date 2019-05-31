
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MergeFilesFrame extends JFrame {
  private JTextArea jtx = new JTextArea(10, 10);
  private JButton btn1 = new JButton("添加要合并的文件到列表");
  private JButton btn3 = new JButton("合并");
  List<File> pathList = new ArrayList<File>();
  private JTextField fTarget = new JTextField(20);
  private JLabel labelTarget = new JLabel("复制地址");;
  private JButton btn2 = new JButton("选择目标文件");

  public MergeFilesFrame() {
    Box box = Box.createVerticalBox();
    btn1.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        jtx.setText(jtx.getText() + "\n" + file.getAbsolutePath());
        pathList.add(file);
      }
    });

    box.add(btn1);
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
    box.add(p2);
    box.add(jtx);
    btn3.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        writeFiles(pathList, fTarget.getText());
      }
    });
    box.add(btn3);
    add(box);
    setTitle("文件合并");
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }

  /**
   * 请设计完善该方法，将files中的文件合并写入到fileName所代表的文件中
   *
   * @param files
   * @param fileName
   */
  public void writeFiles(List<File> files, String fileName) {
    try {
      byte[] b1;
      FileWriter output = new FileWriter(fileName);
      BufferedWriter fos = new BufferedWriter(output);
      for (int i = 0; i < files.size(); i++) {
        File file = files.get(i);
        FileReader input = new FileReader(file);
        BufferedReader fis = new BufferedReader(input);
        b1 = new byte[fis.available()];
        fis.read(b1);
        fos.write(b1);
      }
      fis.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  // try
  // {
  // byte[] b1;
  // FileOutputStream fos = new FileOutputStream(fileName);
  // for (int i = 0; i < files.size(); i++) {
  // File file = files.get(i);
  // FileInputStream fis = new FileInputStream(file);
  // b1 = new byte[fis.available()];
  // fis.read(b1);
  // fos.write(b1);
  // }
  // }catch(
  // Exception e)
  // {
  // e.printStackTrace();
  // }
  // }

  public static void main(String[] args) {
    new MergeFilesFrame();
  }
}
