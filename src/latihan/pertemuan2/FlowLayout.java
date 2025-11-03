package latihan.pertemuan2;

import javax.swing.*;

public class FlowLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();

        panel.add(new JButton("Tombol 1"));
        panel.add(new JButton("Tombol 2"));
        panel.add(new JButton("Tombol Tiga"));
        panel.add(new JButton("Tombol Empat Panjang"));
        panel.add(new JButton("Tombol 5"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
