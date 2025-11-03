package latihan.pertemuan1;

import javax.swing.*;
import java.awt.*;

public class tugas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setLayout(new BorderLayout());

                JLabel label = new JLabel("Label di atas (NORTH)");
                JButton bSouth = new JButton("Tombol di bawah (SOUTH)");

                bSouth.addActionListener(e -> label.setText("Tombol di SOUTH diklik!"));

                frame.add(label, BorderLayout.NORTH);
                frame.add(bSouth, BorderLayout.SOUTH);

                JButton bWest = new JButton("Button WEST");
                JButton bEast = new JButton("Button EAST");
                JButton bCenter = new JButton("Button CENTER");

                bWest.addActionListener(e -> label.setText("Tombol di WEST diklik!"));
                bEast.addActionListener(e -> label.setText("Tombol di EAST diklik!"));
                bCenter.addActionListener(e -> label.setText("Tombol di CENTER diklik!"));

                frame.add(bWest, BorderLayout.WEST);    
                frame.add(bEast, BorderLayout.EAST);
                frame.add(bCenter, BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
}
