public class Quiz2 {
        public static void main(String[] args) {
        // Ini kondisi normalnya
        Mahasiswa m1 = new Mahasiswa("2026001", "Sinta", 80, 75, 90);
        m1.tampilkanData();
        System.out.println();
 
        // uji nilai tdk valid, nilai lama hrs tetap
        System.out.println("--- Uji ubah nilai tidak valid ---");
        m1.setNilaiUTS(150);
        m1.setNilaiTugas(-5);
        m1.setNilaiUAS(101);
        System.out.println("Nilai Tugas sekarang : " + m1.getNilaiTugas());
        System.out.println("Nilai UTS sekarang   : " + m1.getNilaiUTS());
        System.out.println("Nilai UAS sekarang   : " + m1.getNilaiUAS());
        System.out.println();
 
        // uji ubah nilai valid
        System.out.println("--- Uji ubah nilai valid ---");
        m1.setNilaiUTS(85);
        m1.tampilkanData();
        System.out.println();
 
        // mahasiswa yg tidak lulus
        Mahasiswa m2 = new Mahasiswa("2026002", "Rudi", 50, 40, 55);
        m2.tampilkanData();
    }
}
 
class Mahasiswa {
    private String nim;
    private String nama;
    private int nilaiTugas;
    private int nilaiUTS;
    private int nilaiUAS;
 
    Mahasiswa(String nim, String nama, int nilaiTugas, int nilaiUTS, int nilaiUAS) {
        this.nim = nim;
        this.nama = nama;
        // lewat setter biarr nilainya ikut divalidasi
        setNilaiTugas(nilaiTugas);
        setNilaiUTS(nilaiUTS);
        setNilaiUAS(nilaiUAS);
    }
 
    // getternya
    public String getNim() {
        return nim;
    }
 
    public String getNama() {
        return nama;
    }
 
    public int getNilaiTugas() {
        return nilaiTugas;
    }
 
    public int getNilaiUTS() {
        return nilaiUTS;
    }
 
    public int getNilaiUAS() {
        return nilaiUAS;
    }
 
    // setter, nilai harus 0 - 100
    public void setNilaiTugas(int nilai) {
        if (nilai >= 0 && nilai <= 100) {
            this.nilaiTugas = nilai;
        } else {
            System.out.println("Nilai tugas " + nilai + " ditolak (harus 0-100)");
        }
    }
 
    public void setNilaiUTS(int nilai) {
        if (nilai >= 0 && nilai <= 100) {
            this.nilaiUTS = nilai;
        } else {
            System.out.println("Nilai UTS " + nilai + " ditolak (harus 0-100)");
        }
    }
 
    public void setNilaiUAS(int nilai) {
        if (nilai >= 0 && nilai <= 100) {
            this.nilaiUAS = nilai;
        } else {
            System.out.println("Nilai UAS " + nilai + " ditolak (harus 0-100)");
        }
    }
 
    public double hitungNilaiAkhir() {
        return (nilaiTugas * 0.3) + (nilaiUTS * 0.3) + (nilaiUAS * 0.4);
    }
 
    public String tentukanStatus() {
        if (hitungNilaiAkhir() >= 60) {
            return "LULUS";
        } else {
            return "TIDAK LULUS";
        }
    }
 
    public void tampilkanData() {
        System.out.println("=== HASIL PENILAIAN MAHASISWA ===");
        System.out.println("NIM          : " + nim);
        System.out.println("Nama         : " + nama);
        System.out.println("Nilai Tugas  : " + nilaiTugas);
        System.out.println("Nilai UTS    : " + nilaiUTS);
        System.out.println("Nilai UAS    : " + nilaiUAS);
        System.out.println();
        System.out.printf("Nilai Akhir  : %.2f%n", hitungNilaiAkhir());
        System.out.println("Status       : " + tentukanStatus());
    }
}
 
 