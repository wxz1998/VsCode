
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileGUI extends JFrame {
    private JLabel label = new JLabel("请输入文件夹路径：");
    private JTextField jtf = new JTextField(30);
    private JButton btn = new JButton("确认");
    private JTextArea jta = new JTextArea(10, 30);

    public FileGUI() {
        this.setTitle("File类常用方法练习");
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(jtf);
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText(getPathList(jtf.getText()));
            }
        });
        this.add(panel, BorderLayout.NORTH);
        this.add(jta);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public String getPathList(String folder) {
        File file = new File(folder);
        StringBuilder path = new StringBuilder("");
        if (file.isDirectory()) {
            File[] fileArray = file.listFiles();
            System.out.println("---file.listFiles()---");
            for (int i = 0; i < fileArray.length; i++) {
                path.append(fileArray[i].getAbsolutePath() + "\n");
                System.out.println(fileArray[i].getAbsolutePath());
            }
        } else {
            path.append("不是有效文件夹路径，请重新输入：");
        }
        return path.toString();
    }

    public static void main(String[] args) {
        new FileGUI();
    }

}
/**
 * */