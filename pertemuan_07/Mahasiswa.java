package pertemuan_07;

public class Mahasiswa {
    String nama;                        // referensi ke String di heap
    int umur;                           // variabel sederhana
    static int jumlah = 0;              // variabel static

    Mahasiswa(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        jumlah++;
    }

    @Override
    public String toString() {
        return "Mahasiswa{nama='" + nama + "', umur=" + umur + "}";
    }
}