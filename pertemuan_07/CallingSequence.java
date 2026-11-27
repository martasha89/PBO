package pertemuan_07;

public class CallingSequence {

    static void m2() {
        System.out.println("Starting m2");
        System.out.println("m2 calling m3");
        m3();
        System.out.println("m2 calling m4");
        m4();
        System.out.println("Leaving m2");
        return;                         // frame m2 di-pop
    }

    static void m3() {
        System.out.println("Starting m3");
        System.out.println("Leaving m3");
        return;                         // frame m3 di-pop, kontrol kembali ke m2
    }

    static void m4() {
        System.out.println("Starting m4");
        System.out.println("Leaving m4");
        return;                         // frame m4 di-pop, kontrol kembali ke m2
    }

    public static void main(String[] args) {
        System.out.println("=== A. Typical Calling Sequence ===");
        System.out.println("Starting main");
        System.out.println("main calling m2");
        m2();
        System.out.println("Leaving main");
    }
}