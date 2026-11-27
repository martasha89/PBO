package person;

// ===== INTERFACE 1 =====
// Interface hanya berisi kerangka method (abstract), isinya ditulis di kelas yang meng-implement
interface Learner {
    void study();
}

// ===== INTERFACE 2 =====
interface Organizer {
    void joinOrganization();
}

// ===== INTERFACE 3 =====
interface Teacher {
    void teach();
}

// ===== INTERFACE 4 =====
interface Researcher {
    void doResearch();
}

// ===== SUPER CLASS =====
// Person induk berisi data umum semua orang
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("Halo, nama saya " + name + ", umur " + age + " tahun.");
    }
}

// ===== SUB CLASS 1 =====
// Student: extends 1 class (Person) + implements 2 interface (Learner, Organizer)
class Student extends Person implements Learner, Organizer {
    String nim;

    Student(String name, int age, String nim) {
        super(name, age);
        this.nim = nim;
    }

    @Override
    public void study() { // wajib di-override dari Learner
        System.out.println(name + " (NIM " + nim + ") sedang belajar Java di VS Code.");
    }

    @Override
    public void joinOrganization() { // wajib di-override dari Organizer
        System.out.println(name + " aktif di Himpunan Mahasiswa Informatika.");
    }
}

// ===== SUB CLASS 2 =====
// Lecturer: extends Person + implements Teacher dan Researcher
class Lecturer extends Person implements Teacher, Researcher {
    String nidn;

    Lecturer(String name, int age, String nidn) {
        super(name, age);
        this.nidn = nidn;
    }

    @Override
    public void teach() {
        System.out.println(name + " (NIDN " + nidn + ") mengajar Pemrograman Berorientasi Objek.");
    }

    @Override
    public void doResearch() {
        System.out.println(name + " meneliti tentang kecerdasan buatan.");
    }
}

// ===== SUB CLASS 3 =====
// Alumni: extends Person + implements Learner dan Researcher
class Alumni extends Person implements Learner, Researcher {
    String graduationYear;

    Alumni(String name, int age, String graduationYear) {
        super(name, age);
        this.graduationYear = graduationYear;
    }

    @Override
    public void study() {
        System.out.println(name + " (lulusan " + graduationYear + ") kuliah lagi S2.");
    }

    @Override
    public void doResearch() {
        System.out.println(name + " menulis tesis tentang basis data.");
    }
}

// ===== MAIN CLASS =====
public class PersonMain {
    public static void main(String[] args) {
        System.out.println("=== Inheritance Person (Multiple via Interface) ===\n");

        Student s = new Student("Tiara", 21, "20250801066");
        Lecturer l = new Lecturer("Dewi Setiowati", 35, "0312345678");
        Alumni a = new Alumni("Rina", 27, "2022");

        s.introduce(); // dari Person
        s.study(); // dari interface Learner
        s.joinOrganization(); // dari interface Organizer
        System.out.println();

        l.introduce();
        l.teach(); // dari interface Teacher
        l.doResearch(); // dari interface Researcher
        System.out.println();

        a.introduce();
        a.study(); // dari interface Learner
        a.doResearch(); // dari interface Researcher
    }
}