interface Workable {
    void bekerja();
}

interface Reportable {
    void buatLaporan();
}

class Person {
    protected String nama;
    protected int umur;

    public Person(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public void perkenalan() {
        System.out.println("Nama: " + nama + " | Umur: " + umur + " tahun");
    }
}

class Student extends Person implements Workable {
    private String jurusan;

    public Student(String nama, int umur, String jurusan) {
        super(nama, umur);
        this.jurusan = jurusan;
    }

    @Override
    public void perkenalan() {
        super.perkenalan();
        System.out.println("Status: Mahasiswa Jurusan " + jurusan);
    }

    @Override
    public void bekerja() {
        System.out.println("Aktivitas: Mengerjakan tugas praktikum dan proyek.");
    }
}

class Driver extends Person implements Workable, Reportable {
    private String nomorArmada;

    public Driver(String nama, int umur, String nomorArmada) {
        super(nama, umur);
        this.nomorArmada = nomorArmada;
    }

    @Override
    public void perkenalan() {
        super.perkenalan();
        System.out.println("Peran: Pengemudi Armada " + nomorArmada);
    }

    @Override
    public void bekerja() {
        System.out.println("Aktivitas: Mengoperasikan pengiriman muatan armada.");
    }

    @Override
    public void buatLaporan() {
        System.out.println("Laporan: Mencatat jumlah rit dan kondisi kendaraan harian.");
    }
}

class ProjectManager extends Person implements Workable, Reportable {
    private String divisi;

    public ProjectManager(String nama, int umur, String divisi) {
        super(nama, umur);
        this.divisi = divisi;
    }

    @Override
    public void perkenalan() {
        super.perkenalan();
        System.out.println("Peran: Project Manager Divisi " + divisi);
    }

    @Override
    public void bekerja() {
        System.out.println("Aktivitas: Mengatur jadwal proyek dan koordinasi tim.");
    }

    @Override
    public void buatLaporan() {
        System.out.println("Laporan: Menyusun rekap progres dan anggaran proyek.");
    }
}

public class Soal3Person {
    public static void main(String[] args) {
        Student mhs = new Student("Tiara", 21, "Teknik Informatika");
        Driver supir = new Driver("Dani", 34, "GGS-02");
        ProjectManager pm = new ProjectManager("Indra", 29, "Infrastruktur");

        System.out.println("=== Profil 1 ===");
        mhs.perkenalan();
        mhs.bekerja();
        System.out.println();

        System.out.println("=== Profil 2 ===");
        supir.perkenalan();
        supir.bekerja();
        supir.buatLaporan();
        System.out.println();

        System.out.println("=== Profil 3 ===");
        pm.perkenalan();
        pm.bekerja();
        pm.buatLaporan();
    }
}