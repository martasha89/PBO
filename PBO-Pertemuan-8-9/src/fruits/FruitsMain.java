package fruits;

// ===== LEVEL 1: SUPER CLASS =====
// Fruits = induk paling atas, berisi sifat umum semua buah
class Fruits {
    String name; // nama buah
    boolean edible = true; // semua buah di sini bisa dimakan

    void eat() {
        System.out.println(name + " bisa dimakan.");
    }
}

// ===== LEVEL 2 =====
// CitrusFruits mewarisi Fruits, sekaligus menjadi induk bagi Orange
class CitrusFruits extends Fruits {
    String vitamin = "Vitamin C"; // ciri khas buah jeruk-jerukan

    void showVitamin() {
        System.out.println(name + " mengandung " + vitamin + " dan rasanya asam segar.");
    }
}

// ===== LEVEL 3 =====
// Orange mewarisi CitrusFruits (otomatis juga mewarisi Fruits)
class Orange extends CitrusFruits {
    String color = "oranye";

    void showColor() {
        System.out.println(name + " berwarna " + color + ".");
    }
}

// ===== LEVEL 4 =====
// Mandarin mewarisi Orange (otomatis mewarisi CitrusFruits dan Fruits)
class Mandarin extends Orange {
    String origin = "Tiongkok";

    void showOrigin() {
        System.out.println(name + " berasal dari " + origin + ", kulitnya mudah dikupas.");
    }
}

// ===== MAIN CLASS =====
// MULTILEVEL INHERITANCE: Fruits -> CitrusFruits -> Orange -> Mandarin
public class FruitsMain {
    public static void main(String[] args) {
        System.out.println("=== Inheritance Fruits (Multilevel) ===\n");

        Mandarin m = new Mandarin();
        m.name = "Jeruk Mandarin"; // atribut milik Fruits (level 1)

        m.eat(); // method milik Fruits (level 1)
        m.showVitamin(); // method milik CitrusFruits (level 2)
        m.showColor(); // method milik Orange (level 3)
        m.showOrigin(); // method milik Mandarin (level 4)

        System.out.println("\nPengecekan jenis objek:");
        System.out.println("m instanceof Mandarin     : " + (m instanceof Mandarin));
        System.out.println("m instanceof Orange       : " + (m instanceof Orange));
        System.out.println("m instanceof CitrusFruits : " + (m instanceof CitrusFruits));
        System.out.println("m instanceof Fruits       : " + (m instanceof Fruits));
    }
}