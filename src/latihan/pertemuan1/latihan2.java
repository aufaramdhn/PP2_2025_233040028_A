package latihan.pertemuan1;

import javax.swing.*;

public class latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("jendela Pertamaku");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JLabel label = new JLabel("Ini adalah JLabel");

                frame.add(label);

                frame.setVisible(true);
            }
        });
    }
}
