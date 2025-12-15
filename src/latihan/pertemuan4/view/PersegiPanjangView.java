package latihan.pertemuan4.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PersegiPanjangView extends JFrame {
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasilLuas = new JLabel("-");
    private JButton btnHitungLuas = new JButton("Hitung Luas");
    private JLabel lblHasilKeliling = new JLabel("-");
    private JButton btnHitungKeliling = new JButton("Hitung Keliling");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLayout(new GridLayout(8, 2, 10, 10));
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasilLuas);
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKeliling);
        this.add(new JLabel(""));
        this.add(btnHitungLuas);
        this.add(new JLabel(""));
        this.add(btnHitungKeliling);
        this.add(new JLabel(""));
        this.add(btnReset);
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    public void setHasilLuas(double hasilLuas) {
        lblHasilLuas.setText(String.valueOf(hasilLuas));
    }

    public void setHasilKeliling(double hasilKeliling) {
        lblHasilKeliling.setText(String.valueOf(hasilKeliling));
    }

    public void resetFields() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasilLuas.setText("-");
        lblHasilKeliling.setText("-");
    }

    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addHitungLuasListener(ActionListener listener) {
        btnHitungLuas.addActionListener(listener);
    }

    public void addHitungKelilingListener(ActionListener listener) {
        btnHitungKeliling.addActionListener(listener);
    }

    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}
