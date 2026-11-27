import java.util.Scanner; // [P2] Import library untuk input data

// ==========================================
// [P7] INTERFACE (Materi P7: Abstraksi Kontrak Cetak)
// ==========================================
interface CetakLaporan {
    void cetakHeaderLaporan(); // Method tanpa body (abstrak)
}

// ==========================================
// [P7] CLASS INDUK / SUPERCLASS (Materi P7: Inheritance Dasar)
// ==========================================
class Kendaraan {
    // [P7] Access Modifier 'protected' (Bisa diakses langsung oleh class anak DataTruk)
    protected String kodeTruk;
    protected String namaSupir;
    protected String platNomor;

    // [P5] Constructor Class Induk
    public Kendaraan(String kodeTruk, String namaSupir, String platNomor) {
        this.kodeTruk = kodeTruk;
        this.namaSupir = namaSupir;
        this.platNomor = platNomor;
    }

    // [P5] Getter untuk mengambil data
    public String getKodeTruk() { return kodeTruk; }
    public String getNamaSupir() { return namaSupir; }
    public String getPlatNomor() { return platNomor; }

    // [P7] Method yang nantinya di-Override oleh class anak (Polimorfisme)
    public void infoKendaraan() {
        System.out.println("Unit Kendaraan: " + kodeTruk + " (" + platNomor + ")");
    }
}

// ==========================================
// [P5 & P7] CLASS ANAK / SUBCLASS (Materi P5: Encapsulation & P7: Inheritance, Polymorphism, Interface)
// ==========================================
class DataTruk extends Kendaraan implements CetakLaporan {
    // [P7] Access Modifier 'private' (Materi Encapsulation & Akses Terbatas)
    private double tabunganWajib;

    // [P5] Constructor Class Anak memanggil super constructor (super)
    public DataTruk(String kodeTruk, String namaSupir, String platNomor, double tabunganWajib) {
        super(kodeTruk, namaSupir, platNomor); // Memanggil constructor class Kendaraan
        setTabunganWajib(tabunganWajib); // Menggunakan setter untuk validasi
    }

    // [P5 & P7] Setter & Getter untuk Tabungan Wajib (Private Attribute)
    public void setTabunganWajib(double tabunganWajib) {
        if (tabunganWajib >= 0) {
            this.tabunganWajib = tabunganWajib;
        } else {
            this.tabunganWajib = 50000.0; // Default jika input negatif
        }
    }
    public double getTabunganWajib() { return tabunganWajib; }

    // [P7] OVERRIDING (Polimorfisme) -> Mengubah isi method dari class Kendaraan
    @Override
    public void infoKendaraan() {
        System.out.printf("Unit Truk Terpilih : %s (%s)\n", kodeTruk, platNomor);
        System.out.printf("Nama Supir         : %s\n", namaSupir);
    }

    // [P7] OVERLOADING (Polimorfisme) -> Method nama sama, beda parameter untuk bonus supir
    public double hitungBonus(int totalRit) {
        return totalRit * 20000.0; // Bonus standar Rp 20.000 / rit
    }
    public double hitungBonus(int totalRit, double persenBonus) {
        return (totalRit * 20000.0) * (1 + persenBonus); // Overloading dengan persentase
    }

    // [P7] Implementasi Method dari Interface CetakLaporan
    @Override
    public void cetakHeaderLaporan() {
        System.out.println("==========================================");
        System.out.println("       REKAP OPERASIONAL HARIAN           ");
        System.out.println("==========================================");
    }
}

// ==========================================
// CLASS UTAMA (MAIN PROGRAM)
// ==========================================
public class SimoTrukApp {

    // [P4] Fungsi Statis dengan parameter & return value
    public static double hitungUangJalan(double tarifDasar, int jumlahRit) {
        return tarifDasar * jumlahRit; // [P2 & P4] Ekspresi aritmatika perkalian
    }

    public static double hitungUangJalanBersih(double uangJalanKotor, double tabunganWajib) {
        return uangJalanKotor - tabunganWajib; // [P2 & P4] Ekspresi aritmatika pengurangan
    }

    public static void main(String[] args) {
        // [P2] Deklarasi objek Scanner untuk input data
        Scanner input = new Scanner(System.in);

        // [P2 & P3] Deklarasi Variabel dan Tipe Data
        int pilihanUnit, pilihanWilayah, pilihanMuatanCisauk;
        double tarifDasar = 0.0;
        double hargaJasaTagih = 0.0;
        int jumlahRit = 1;

        String namaWilayah = "", jenisMuatan = "";

        // [P3] Tampilan Menu Awal
        System.out.println("==========================================");
        System.out.println("  PT GREEN GLOBAL SUMATERA (GGS)          ");
        System.out.println("  SISTEM INFORMASI MANAJEMEN OPERASIONAL  ");
        System.out.println("==========================================");
        System.out.println("PILIH UNIT TRUCK GGS:");
        System.out.println("1. GGS 1 (Anang / Z 8888 XX)");
        System.out.println("2. GGS 2 (Dani / Z 9999 YY)");
        System.out.print("Masukkan Pilihan Unit [1 / 2] : ");
        pilihanUnit = input.nextInt();

        // [P5 & P7] Menggunakan Polimorfisme & Encapsulation
        DataTruk trukAktif;

        // [P3] Control Statement: Switch-Case
        switch (pilihanUnit) {
            case 1:
                trukAktif = new DataTruk("GGS 1", "Anang", "Z 8888 XX", 50000.0);
                break;
            case 2:
                trukAktif = new DataTruk("GGS 2", "Dani", "Z 9999 YY", 50000.0);
                break;
            default:
                trukAktif = new DataTruk("GGS Umum", "Tidak Dikenal", "-", 50000.0);
                break;
        }

        // [P3] Control Statement: If-Else Pilihan Wilayah
        System.out.println("\nPILIH WILAYAH TUJUAN PENGIRIMAN:");
        System.out.println("1. PT Trias Beton (Pasir dari Stockpile MCA)");
        System.out.println("2. Cisauk (Muatan Opsional Pasir / Split)");
        System.out.println("3. PT Istimewa Beton Bogor (Split dari Cilegon)");
        System.out.print("Masukkan Pilihan Wilayah [1 - 3] : ");
        pilihanWilayah = input.nextInt();

        if (pilihanWilayah == 1) {
            namaWilayah = "PT Trias Beton";
            jenisMuatan = "Pasir (Per Rit)";
            hargaJasaTagih = 900000.0;
            tarifDasar = 400000.0;
        } else if (pilihanWilayah == 2) {
            namaWilayah = "Cisauk";
            System.out.println("\nPILIH JENIS MUATAN DI CISAUK:");
            System.out.println("1. Pasir");
            System.out.println("2. Split");
            System.out.print("Masukkan Pilihan Muatan [1 / 2] : ");
            pilihanMuatanCisauk = input.nextInt();

            if (pilihanMuatanCisauk == 1) {
                jenisMuatan = "Pasir (Cisauk)";
                hargaJasaTagih = 1200000.0;
                tarifDasar = 1300000.0;
            } else {
                jenisMuatan = "Split (Cisauk)";
                hargaJasaTagih = 1200000.0;
                tarifDasar = 1300000.0;
            }
        } else if (pilihanWilayah == 3) {
            namaWilayah = "PT Istimewa Beton Bogor";
            jenisMuatan = "Split dari Cilegon (Per Kubik)";
            hargaJasaTagih = 1300000.0;
            tarifDasar = 1300000.0;
        } else {
            namaWilayah = "Wilayah Lainnya";
            jenisMuatan = "Umum";
            hargaJasaTagih = 0.0;
            tarifDasar = 0.0;
        }

        // [P2] Input Jumlah Rit
        System.out.print("Masukkan jumlah rit muatan hari ini : ");
        jumlahRit = input.nextInt();

        // [P4] Perhitungan Uang Jalan
        double uangJalanKotor = hitungUangJalan(tarifDasar, jumlahRit);
        double uangJalanBersih = hitungUangJalanBersih(uangJalanKotor, trukAktif.getTabunganWajib());

        System.out.println();
        // [P7] Memanggil Method dari Interface
        trukAktif.cetakHeaderLaporan();

        // [P7] Memanggil Method Overriding milik DataTruk
        trukAktif.infoKendaraan();

        System.out.println("------------------------------------------");
        System.out.printf("Tujuan Pengiriman : %s\n", namaWilayah);
        System.out.printf("Jenis Muatan      : %s\n", jenisMuatan);
        System.out.println("------------------------------------------");
        System.out.printf("Total Rit         : %d Rit\n", jumlahRit);
        System.out.printf("Harga Tagihan Jasa: Rp %.2f\n", hargaJasaTagih);
        System.out.printf("Uang Jalan Kotor  : Rp %.2f\n", uangJalanKotor);
        System.out.printf("Tabungan Wajib    : Rp %.2f\n", trukAktif.getTabunganWajib());
        System.out.println("------------------------------------------");
        System.out.printf("TRANSFER BERSIH   : Rp %.2f\n", uangJalanBersih);
        System.out.println("==========================================");
        System.out.println("Status            : [Menunggu Pemuatan]");
        System.out.println("==========================================");

        input.close();
    }
}