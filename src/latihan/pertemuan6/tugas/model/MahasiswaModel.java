package latihan.pertemuan6.tugas.model;


public class MahasiswaModel {
    private String nama;
    private String nim;
    private String jurusan;

    public MahasiswaModel(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }
}
