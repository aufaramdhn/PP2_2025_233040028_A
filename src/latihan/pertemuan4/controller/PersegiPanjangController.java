package latihan.pertemuan4.controller;

import latihan.pertemuan4.model.PersegiPanjangModel;
import latihan.pertemuan4.view.PersegiPanjangView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    private PersegiPanjangView view;
    private PersegiPanjangModel model;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        this.view.addHitungLuasListener(new HitungLuasListener());
        this.view.addHitungKelilingListener(new HitungKelilingListener());
        this.view.addResetListener(new ResetListener());
    }

    class HitungLuasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double panjang = view.getPanjang();
                double lebar = view.getLebar();

                model.setPanjang(panjang);
                model.setLebar(lebar);
                model.hitungLuas();

                double hasil = model.getLuas();
                view.setHasilLuas(hasil);
            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Input tidak valid! Harap masukkan angka yang benar.");
            }
        }
    }

    class HitungKelilingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double panjang = view.getPanjang();
                double lebar = view.getLebar();

                model.setPanjang(panjang);
                model.setLebar(lebar);
                model.hitungKeliling();

                double hasil = model.getKeliling();
                view.setHasilKeliling(hasil);
            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Input tidak valid! Harap masukkan angka yang benar.");
            }
        }
    }

    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetFields();
        }
    }
}
