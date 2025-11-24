package latihan.pertemuan2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konversi celcius ke fahrenheit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 3, 10, 10));

        JLabel celciusLabel = new JLabel("Celcius");
        JTextField celciusField = new JTextField();
        JButton convertButton = new JButton("Convert");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit");
        JLabel resultLabel = new JLabel("");

        frame.add(celciusLabel);
        frame.add(celciusField);
        frame.add(convertButton);
        frame.add(fahrenheitLabel);
        frame.add(resultLabel);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(celciusField.getText());
                    double fahrenheit = (celcius * 9/5) + 32;
                    resultLabel.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Input tidak valid");
                }
            }
        };

        convertButton.addActionListener(listener);

        frame.setVisible(true);
    }
}
