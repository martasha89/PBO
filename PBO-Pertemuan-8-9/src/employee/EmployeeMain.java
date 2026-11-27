package employee;

// ===== SUPER CLASS =====
// Employee kelas induk, berisi atribut & method umum milik semua pegawai
class Employee {
    String name; // nama pegawai
    int salary; // gaji pokok

    // Constructor untuk mengisi nama dan gaji
    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method umum yang akan diwariskan ke semua kelas anak
    void showInfo() {
        System.out.println("Nama : " + name);
        System.out.println("Gaji : " + salary);
    }
}

// ===== SUB CLASS 1 =====
// Lecturer mewarisi Employee (extends) lalu menambah atribut benefits dan subject
class Lecturer extends Employee {
    int benefits; // tunjangan dosen
    String subject; // mata kuliah yang diampu

    Lecturer(String name, int salary, int benefits, String subject) {
        super(name, salary); // memanggil constructor Employee
        this.benefits = benefits;
        this.subject = subject;
    }

    @Override
    void showInfo() { // method overriding
        System.out.println("Jabatan : Lecturer (Dosen)");
        super.showInfo(); // memakai method milik Employee
        System.out.println("Tunjangan: " + benefits);
        System.out.println("Mengampu : " + subject);
    }
}

// ===== SUB CLASS 2 =====
// Staff pegawai administrasi, punya atribut department dan overtime
class Staff extends Employee {
    String department; // bagian/unit kerja
    int overtime; // uang lembur

    Staff(String name, int salary, String department, int overtime) {
        super(name, salary);
        this.department = department;
        this.overtime = overtime;
    }

    @Override
    void showInfo() {
        System.out.println("Jabatan : Staff Administrasi");
        super.showInfo();
        System.out.println("Bagian  : " + department);
        System.out.println("Lembur  : " + overtime);
    }
}

// ===== SUB CLASS 3 =====
// Manager pimpinan, punya atribut bonus dan jumlah anggota tim
class Manager extends Employee {
    int bonus; // bonus kinerja
    int teamSize; // jumlah anak buah

    Manager(String name, int salary, int bonus, int teamSize) {
        super(name, salary);
        this.bonus = bonus;
        this.teamSize = teamSize;
    }

    @Override
    void showInfo() {
        System.out.println("Jabatan : Manager");
        super.showInfo();
        System.out.println("Bonus   : " + bonus);
        System.out.println("Anggota : " + teamSize + " orang");
    }
}

// ===== SUB CLASS 4 =====
// Security petugas keamanan, punya atribut shift jaga
class Security extends Employee {
    String shift; // jadwal jaga

    Security(String name, int salary, String shift) {
        super(name, salary);
        this.shift = shift;
    }

    @Override
    void showInfo() {
        System.out.println("Jabatan : Security");
        super.showInfo();
        System.out.println("Shift   : " + shift);
    }
}

// ===== MAIN CLASS =====
// HIERARCHICAL INHERITANCE: satu superclass (Employee) punya 4 subclass
public class EmployeeMain {
    public static void main(String[] args) {
        System.out.println("=== Inheritance Employee (Hierarchical) ===\n");

        Lecturer e1 = new Lecturer("Budi Santoso", 8000000, 5000000, "Pemrograman Berorientasi Objek");
        Staff e2 = new Staff("Siti Aminah", 5000000, "Akademik", 750000);
        Manager e3 = new Manager("Rudi Hartono", 12000000, 3000000, 15);
        Security e4 = new Security("Agus Salim", 4000000, "Malam (22.00 - 06.00)");

        e1.showInfo();
        System.out.println();
        e2.showInfo();
        System.out.println();
        e3.showInfo();
        System.out.println();
        e4.showInfo();
    }
}