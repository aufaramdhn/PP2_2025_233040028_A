package latihan.pertemuan6.tugas;

import latihan.pertemuan6.tugas.view.MahasiswaView;
import latihan.pertemuan6.tugas.controller.MahasiswaController;


public class main {
    public static void main(String[] args) {
        MahasiswaView view = new MahasiswaView();
        new MahasiswaController(view);
        view.setVisible(true);
    }
}
