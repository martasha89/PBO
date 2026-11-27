package pertemuan_07;

public class CallFrameVariables {

    static double hitungLuas(double n) {
        double temp;                    // local variable (stack)
        temp = n * n;
        return temp;                    // frame hitungLuas di-pop
    }

    public static void main(String[] args) {
        System.out.println("=== B. Call Frames - Simple Variables ===");
        double sisi = 4.5;              // variabel sederhana di frame main
        double luas;
        luas = hitungLuas(sisi);        // frame hitungLuas di-push ke stack
        System.out.println("Luas persegi sisi " + sisi + " = " + luas);
    }
}