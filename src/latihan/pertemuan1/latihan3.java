package latihan.pertemuan1;

import javax.swing.*;
import java.awt.*;

public class latihan3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("jendela Pertamaku");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setLayout(new FlowLayout());

                JLabel label = new JLabel("Teks awal");
                JButton button = new JButton("Klik saya");

                button.addActionListener(e -> label.setText("Tombol Berhasil di Klik!"));

                frame.add(label);
                frame.add(button);

                frame.setVisible(true);
            }
        });
    }
}
