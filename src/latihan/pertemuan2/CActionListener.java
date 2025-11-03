package latihan.pertemuan2;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Tekan tombol di bawah:");
        JButton button = new JButton("Klik Saya");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                label.setText("Tombol telah diklik!");
            }
        };

        button.addActionListener(listener);

        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}
