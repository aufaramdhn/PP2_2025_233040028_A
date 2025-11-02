package latihan.pertemuan1;

import javax.swing.*;
import java.awt.*;

public class latihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setLayout(new BorderLayout());

                JLabel label = new JLabel("Label di atas (NORTH)");
                JButton button = new JButton("Tombol di bawah (SOUTH)");

                button.addActionListener(e -> label.setText("Tombol di SOUTH diklik!"));

                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);

                frame.add(new JButton("Button WEST"), BorderLayout.WEST);
                frame.add(new JButton("Button EAST"), BorderLayout.EAST);
                frame.add(new JButton("Button CENTER"), BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
}
