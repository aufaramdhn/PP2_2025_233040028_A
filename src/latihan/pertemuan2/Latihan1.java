package latihan.pertemuan2;

import java.awt.*;
import javax.swing.*;

public class Latihan1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        frame.add(new JTextField(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 4, 5, 5));

        centerPanel.add(new JButton("7"));
        centerPanel.add(new JButton("8"));
        centerPanel.add(new JButton("9"));
        centerPanel.add(new JButton("/"));
        centerPanel.add(new JButton("4"));
        centerPanel.add(new JButton("5"));
        centerPanel.add(new JButton("6"));
        centerPanel.add(new JButton("*"));
        centerPanel.add(new JButton("1"));
        centerPanel.add(new JButton("2"));
        centerPanel.add(new JButton("3"));
        centerPanel.add(new JButton("-"));
        centerPanel.add(new JButton("0"));
        centerPanel.add(new JButton("."));
        centerPanel.add(new JButton("="));
        centerPanel.add(new JButton("+"));

        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
