package pertemuan_07;

public class ReferenceDemo {

    static void ubahUmur(Mahasiswa m, int umurBaru) {
        m.umur = umurBaru;              // mengubah objek di heap
    }

    public static void main(String[] args) {
        System.out.println("=== C. Call Frames - Reference Variables ===");

        // variabel referensi di stack, objek di heap
        Mahasiswa m1 = new Mahasiswa("Budi", 20);
        Mahasiswa m2 = new Mahasiswa("Sari", 21);
        Mahasiswa m3 = m1;              // m3 menunjuk objek yang sama dengan m1

        System.out.println("Sebelum ubahUmur : " + m1);
        ubahUmur(m3, 25);
        System.out.println("Sesudah ubahUmur : " + m1);

        // array: referensi di stack, isi array di heap
        String[] daftar = new String[3];
        daftar[0] = m1.nama;
        daftar[1] = m2.nama;
        daftar[2] = "Rina";
        for (String s : daftar) {
            System.out.println("Nama: " + s);
        }

        System.out.println("Jumlah objek Mahasiswa (static): " + Mahasiswa.jumlah);

        m2 = null;                      // objek Sari siap di-garbage collect
        System.gc();
    }
}