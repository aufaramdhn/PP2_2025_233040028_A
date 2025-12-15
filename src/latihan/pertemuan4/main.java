package latihan.pertemuan4;

import latihan.pertemuan4.controller.PersegiPanjangController;
import latihan.pertemuan4.model.PersegiPanjangModel;
import latihan.pertemuan4.view.PersegiPanjangView;

public class main {
    public static void main(String[] args) {
        PersegiPanjangModel model = new PersegiPanjangModel();

        PersegiPanjangView view = new PersegiPanjangView();

        PersegiPanjangController controller = new PersegiPanjangController(model, view);

        view.setVisible(true);
    }
}
