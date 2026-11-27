public class Quiz1 {
    public static void main(String[] args) {
        Buku buku1 = new Buku("Pemrograman Java", "Andi", 2024);
        Buku buku2 = new Buku("Dasar Pemrograman", "Budi", 2023);
 
        buku1.tampilkanInfo();
        System.out.println();
        buku2.tampilkanInfo();
    }
}
 
class Buku {
    String judul;
    String penulis;
    int tahunTerbit;
 
    Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }
 
    void tampilkanInfo() {
        System.out.println("=== DATA BUKU ===");
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
    }
}
 
 