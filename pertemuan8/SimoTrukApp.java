import java.util.Scanner;

/**
 * =======================================================
 * SIMO-TRUK: Laporan Progres Project Pertemuan 7 (Kumulatif P2 - P7)
 * PT Green Global Sumatera (GGS)
 * Materi Tambahan: Memory Management (Calling Sequence, Call Frames, Static)
 * =======================================================
 */

// [P5 & P7] Class untuk objek di Heap Space (Object Space)
class DataTruk {
    // [P7] Variabel Static disimpan di Static Space pada Heap (milik bersama seluruh objek)
    public static String namaPerusahaan = "PT GREEN GLOBAL SUMATERA (GGS)";

    // [P5] Private atribut: Reference Variables (String) & Simple Variable (double) di Heap
    private String kodeTruk;
    private String namaSupir;
    private String platNomor;
    private double tabunganWajib;

    // [P5 & P7] Constructor: Mengalokasikan nilai awal objek di Heap saat dipanggil dengan 'new'
    public DataTruk(String kodeTruk, String namaSupir, String platNomor, double tabunganWajib) {
        this.kodeTruk = kodeTruk;
        this.namaSupir = namaSupir;
        this.platNomor = platNomor;
        setTabunganWajib(tabunganWajib);
    }

    // [P5] Setter dan Getter (Encapsulation)
    public void setKodeTruk(String kodeTruk) { this.kodeTruk = kodeTruk; }
    public String getKodeTruk() { return kodeTruk; }

    public void setNamaSupir(String namaSupir) { this.namaSupir = namaSupir; }
    public String getNamaSupir() { return namaSupir; }

    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }
    public String getPlatNomor() { return platNomor; }

    public void setTabunganWajib(double tabunganWajib) {
        if (tabunganWajib >= 0) {
            this.tabunganWajib = tabunganWajib;
        } else {
            this.tabunganWajib = 50000.0;
        }
    }
    public double getTabunganWajib() { return tabunganWajib; }
}

public class SimoTrukApp {

    // [P7 - Call Frames: Simple Variables]
    // Variabel lokal (totalUangJalan) & parameter primitif (tarifDasar, jumlahRit) disimpan di Call Stack
    public static double hitungUangJalan(double tarifDasar, int jumlahRit) {
        double totalUangJalan = tarifDasar * jumlahRit;
        return totalUangJalan; // Return value dikembalikan ke frame pemanggil, lalu frame ini di-pop
    }

    // [P7 - Call Frames: Simple Variables]
    // Parameter dan variabel lokal primitif (double) dialokasikan di Call Frame method ini
    public static double hitungUangJalanBersih(double uangJalanKotor, double tabunganWajib) {
        double uangBersih = uangJalanKotor - tabunganWajib;
        return uangBersih;
    }

    // [P7 - Call Frames: Reference Variables]
    // Parameter bertipe String (namaSupir, kodeTruk, platNomor) menyimpan referensi ke objek String di Heap
    public static void cetakHeaderLaporan(String namaSupir, String kodeTruk, String platNomor) {
        System.out.println("\n==================================================");
        System.out.println("             REKAP OPERASIONAL HARIAN             ");
        System.out.println("==================================================");
        System.out.printf(" Unit Truk Terpilih : %s (%s)\n", kodeTruk, platNomor);
        System.out.printf(" Nama Supir         : %s \n", namaSupir);
        System.out.println("--------------------------------------------------");
    }

    // [P7 - A Typical Calling Sequence]
    // Tahap 3 dalam urutan pemanggilan method (Frame dipush ke atas frame mulaiOperasional)
    public static void prosesTransaksiHarian(Scanner input) {
        // [P7 - Call Frames: Simple Variables] Variabel primitif di dalam stack frame prosesTransaksiHarian
        int pilihanUnit, pilihanWilayah, pilihanMuatanCisauk;
        double tarifDasar = 0.0;
        double hargaJasaTagih = 0.0;
        int jumlahRit = 1;

        // [P7 - Call Frames: Reference Variables] Variabel referensi String di stack menunjuk ke Heap
        String namaWilayah = "";
        String jenisMuatan = "";

        // [P3 & P7] Mengakses variabel static langsung melalui nama kelas DataTruk
        System.out.println("==================================================");
        System.out.println("  " + DataTruk.namaPerusahaan);
        System.out.println("  SISTEM INFORMASI MANAJEMEN OPERASIONAL");
        System.out.println("==================================================");
        System.out.println("PILIH UNIT TRUCK GGS:");
        System.out.println("1. GGS 1 (Anang / Z 8888 XX)");
        System.out.println("2. GGS 2 (Dani / Z 9999 YY)");
        System.out.print("Masukkan Pilihan Unit [1 / 2] : ");
        pilihanUnit = input.nextInt();

        // [P5 & P7 - Call Frames: Reference Variables]
        // Variabel referensi 'trukAktif' dialokasikan di Call Stack
        DataTruk trukAktif;

        // Keyword 'new' mengalokasikan memori objek DataTruk di area Heap
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

        // [P3] Control Statement pemilihan wilayah tujuan
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

        // [P2] Input jumlah rit
        System.out.print("Masukkan jumlah rit muatan hari ini : ");
        jumlahRit = input.nextInt();

        // [P4 & P7] Pemanggilan method yang membuat Call Frame baru untuk operasi Simple Variables
        double uangJalanKotor = hitungUangJalan(tarifDasar, jumlahRit);
        double uangJalanBersih = hitungUangJalanBersih(uangJalanKotor, trukAktif.getTabunganWajib());

        // [P4, P5 & P7] Pemanggilan method yang meneruskan Reference Variables dari objek Heap
        cetakHeaderLaporan(trukAktif.getNamaSupir(), trukAktif.getKodeTruk(), trukAktif.getPlatNomor());

        // [P2] Menampilkan rincian hasil rekap operasional ke konsol
        System.out.printf(" Tujuan Pengiriman  : %s \n", namaWilayah);
        System.out.printf(" Jenis Muatan       : %s \n", jenisMuatan);
        System.out.println("--------------------------------------------------");
        System.out.printf(" Total Rit          : %d Rit\n", jumlahRit);
        System.out.printf(" Harga Tagihan Jasa : Rp %.2f \n", hargaJasaTagih);
        System.out.printf(" Uang Jalan Kotor   : Rp %.2f \n", uangJalanKotor);
        System.out.printf(" Tabungan Wajib     : Rp %.2f \n", trukAktif.getTabunganWajib());
        System.out.println("--------------------------------------------------");
        System.out.printf(" TRANSFER BERSIH    : Rp %.2f \n", uangJalanBersih);
        System.out.println("==================================================");
        System.out.println(" Status             : [Menunggu Pemuatan]");
    }

    // [P7 - A Typical Calling Sequence]
    // Tahap 2 dalam urutan pemanggilan method (Frame dipush ke atas frame main)
    public static void mulaiOperasional() {
        // [P7 - Call Frames: Reference Variables] Referensi 'input' di stack menunjuk objek Scanner di Heap
        Scanner input = new Scanner(System.in);
        prosesTransaksiHarian(input);
        input.close();
    }

    // [P7 - A Typical Calling Sequence]
    // Tahap 1 (Entry Point): Frame pertama yang dibuat di Runtime Stack saat program dijalankan
    public static void main(String[] args) {
        mulaiOperasional();
    }
}