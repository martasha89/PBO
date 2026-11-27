import java.util.Scanner;

public class Quiz3 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Barang[] daftar = new Barang[3] 
        daftar[0] = new Barang("K001", "Keyboard", 150000, 10);
        System.out.print("Pilih menu: ");
        int pilihan = input.nextInt();
        int total = daftar[0].hitungTotal(2); 
        System.out.println(daftar[0].namaBarang); 
    }
}

class barang(
    Barang(String n, int h, int s) {
        namaBarang = n;
        harga = h;
        stok = s;
    }
}