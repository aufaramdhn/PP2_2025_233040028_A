package latihan.pertemuan6.tugas.controller;

import latihan.pertemuan6.tugas.model.MahasiswaModel;
import latihan.pertemuan6.tugas.view.MahasiswaView;
import latihan.pertemuan6.latihan.KoneksiDB;

import javax.swing.*;
import java.sql.*;

public class MahasiswaController {
    private MahasiswaView view;

    public MahasiswaController(MahasiswaView view) {
        this.view = view;

        view.btnSimpan.addActionListener(e -> tambahData());
        view.btnEdit.addActionListener(e -> ubahData());
        view.btnHapus.addActionListener(e -> hapusData());
        view.btnClear.addActionListener(e -> view.kosongkanForm());
        view.btnCari.addActionListener(e -> cariData());

        view.tableMahasiswa.getSelectionModel().addListSelectionListener(e -> {
            int row = view.tableMahasiswa.getSelectedRow();
            if (row >= 0) {
                view.txtNama.setText(view.model.getValueAt(row, 1).toString());
                view.txtNIM.setText(view.model.getValueAt(row, 2).toString());
                view.txtJurusan.setText(view.model.getValueAt(row, 3).toString());
            }
        });

        loadData();
    }

    private void loadData() {
        view.model.setRowCount(0);
        try {
            Connection conn = KoneksiDB.configDB();
            ResultSet res = conn.createStatement()
                    .executeQuery("SELECT * FROM mahasiswa");

            int no = 1;
            while (res.next()) {
                view.model.addRow(new Object[]{
                        no++,
                        res.getString("nama"),
                        res.getString("nim"),
                        res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void tambahData() {
        try {
            MahasiswaModel mhs = new MahasiswaModel(
                    view.txtNama.getText(),
                    view.txtNIM.getText(),
                    view.txtJurusan.getText()
            );

            String sql = "INSERT INTO mahasiswa VALUES (?, ?, ?)";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, mhs.getNama());
            pst.setString(2, mhs.getNim());
            pst.setString(3, mhs.getJurusan());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(view, "Data berhasil ditambahkan");
            loadData();
            view.kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void ubahData() {
        try {
            String sql = "UPDATE mahasiswa SET nama=?, jurusan=? WHERE nim=?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, view.txtNama.getText());
            pst.setString(2, view.txtJurusan.getText());
            pst.setString(3, view.txtNIM.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(view, "Data berhasil diubah");
            loadData();
            view.kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void hapusData() {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nim=?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, view.txtNIM.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(view, "Data berhasil dihapus");
            loadData();
            view.kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void cariData() {
        view.model.setRowCount(0);
        try {
            String key = JOptionPane.showInputDialog("Cari:");
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(
                    "SELECT * FROM mahasiswa WHERE nama LIKE ? OR nim LIKE ?"
            );
            pst.setString(1, "%" + key + "%");
            pst.setString(2, "%" + key + "%");

            ResultSet res = pst.executeQuery();
            int no = 1;
            while (res.next()) {
                view.model.addRow(new Object[]{
                        no++,
                        res.getString("nama"),
                        res.getString("nim"),
                        res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
