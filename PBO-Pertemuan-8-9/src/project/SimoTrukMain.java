package project;

// ===== SUPER CLASS =====
class ArmadaTruk {
    String kodeTruk;
    String namaSupir;
    String platNomor;
    double uangJalanDasar;
    double tabunganWajib;

    ArmadaTruk(String kodeTruk, String namaSupir, String platNomor, double uangJalanDasar, double tabunganWajib) {
        this.kodeTruk = kodeTruk;
        this.namaSupir = namaSupir;
        this.platNomor = platNomor;
        this.uangJalanDasar = uangJalanDasar;
        this.tabunganWajib = tabunganWajib;
    }

    double hitungUangBersih(int jumlahRit) {
        return (uangJalanDasar * jumlahRit) - tabunganWajib;
    }

    void tampilkanInfo(int jumlahRit) {
        System.out.println("Unit Truk      : " + kodeTruk + " (" + platNomor + ")");
        System.out.println("Nama Supir     : " + namaSupir);
        System.out.println("Jumlah Rit     : " + jumlahRit);
        System.out.println("Transfer Bersih: Rp " + hitungUangBersih(jumlahRit));
    }
}

// ===== SUB CLASS 1 =====
class DumpTrukPasir extends ArmadaTruk {
    String tujuan;
    double tarifTagihPerRit;

    DumpTrukPasir(String kodeTruk, String namaSupir, String platNomor, double uangJalanDasar, double tabunganWajib, String tujuan, double tarifTagihPerRit) {
        super(kodeTruk, namaSupir, platNomor, uangJalanDasar, tabunganWajib);
        this.tujuan = tujuan;
        this.tarifTagihPerRit = tarifTagihPerRit;
    }

    @Override
    void tampilkanInfo(int jumlahRit) {
        System.out.println("=== Armada Muatan Pasir ===");
        super.tampilkanInfo(jumlahRit);
        System.out.println("Tujuan         : " + tujuan);
        System.out.println("Total Tagihan  : Rp " + (tarifTagihPerRit * jumlahRit));
    }
}

// ===== SUB CLASS 2 =====
class DumpTrukSplit extends ArmadaTruk {
    String tujuan;
    double tarifTagihPerRit;

    DumpTrukSplit(String kodeTruk, String namaSupir, String platNomor, double uangJalanDasar, double tabunganWajib, String tujuan, double tarifTagihPerRit) {
        super(kodeTruk, namaSupir, platNomor, uangJalanDasar, tabunganWajib);
        this.tujuan = tujuan;
        this.tarifTagihPerRit = tarifTagihPerRit;
    }

    @Override
    void tampilkanInfo(int jumlahRit) {
        System.out.println("=== Armada Muatan Split ===");
        super.tampilkanInfo(jumlahRit);
        System.out.println("Tujuan         : " + tujuan);
        System.out.println("Total Tagihan  : Rp " + (tarifTagihPerRit * jumlahRit));
    }
}

// ===== MAIN CLASS =====
public class SimoTrukMain {
    public static void main(String[] args) {
        System.out.println("=== SIMO-TRUK GGS - IMPLEMENTASI INHERITANCE ===\n");

        DumpTrukPasir trukPasir = new DumpTrukPasir("GGS 1", "Anang", "Z 8888 XX", 400000, 50000, "PT Trias Beton", 900000);
        DumpTrukSplit trukSplit = new DumpTrukSplit("GGS 2", "Dani", "Z 9999 YY", 1300000, 50000, "PT Istimewa Beton Bogor", 1300000);

        trukPasir.tampilkanInfo(2);
        System.out.println();
        trukSplit.tampilkanInfo(1);
    }
}