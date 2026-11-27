class Fruits {
    protected String namaBuah;
    protected String warna;

    public Fruits(String namaBuah, String warna) {
        this.namaBuah = namaBuah;
        this.warna = warna;
    }

    public void infoBuah() {
        System.out.println("Nama Buah : " + namaBuah);
        System.out.println("Warna     : " + warna);
    }
}

class CitrusFruit extends Fruits {
    protected double tingkatKeasaman;

    public CitrusFruit(String namaBuah, String warna, double tingkatKeasaman) {
        super(namaBuah, warna);
        this.tingkatKeasaman = tingkatKeasaman;
    }

    public void infoCitrus() {
        infoBuah();
        System.out.println("Keasaman  : " + tingkatKeasaman + " pH");
    }
}

class OrangeFruit extends CitrusFruit {
    protected String asalDaerah;

    public OrangeFruit(String namaBuah, String warna, double tingkatKeasaman, String asalDaerah) {
        super(namaBuah, warna, tingkatKeasaman);
        this.asalDaerah = asalDaerah;
    }

    public void infoJeruk() {
        infoCitrus();
        System.out.println("Asal      : " + asalDaerah);
    }
}

class SweetOrange extends OrangeFruit {
    private boolean tanpaBiji;

    public SweetOrange(String namaBuah, String warna, double tingkatKeasaman, String asalDaerah, boolean tanpaBiji) {
        super(namaBuah, warna, tingkatKeasaman, asalDaerah);
        this.tanpaBiji = tanpaBiji;
    }

    public void tampilkanDetail() {
        System.out.println("=== Jeruk Manis (Multilevel Inheritance) ===");
        infoJeruk();
        System.out.println("Tanpa Biji: " + (tanpaBiji ? "Ya" : "Tidak"));
        System.out.println();
    }
}

public class Soal2Fruits {
    public static void main(String[] args) {
        SweetOrange jerukManis = new SweetOrange("Jeruk Manis", "Oranye", 3.8, "Lokal", true);
        jerukManis.tampilkanDetail();
    }
}