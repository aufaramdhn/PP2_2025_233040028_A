package latihan.pertemuan2;

import java.awt.*;
import javax.swing.*;


public class CGridLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.setLayout(new GridLayout(3, 2, 5, 5));

        frame.add(new JLabel("Label 1"));
        frame.add(new JTextField());
        frame.add(new JLabel("Label 2"));
        frame.add(new JTextField());
        frame.add(new JButton("Login"));
        frame.add(new JButton("Cancel"));

        frame.setVisible(true);
    }
}
