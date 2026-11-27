class Employee {
    protected String nama;
    protected int salary;

    public Employee(String nama, int salary) {
        this.nama = nama;
        this.salary = salary;
    }

    public void tampilkanInfoDasar() {
        System.out.println("Nama      : " + nama);
        System.out.println("Gaji Pokok: Rp " + salary);
    }
}

class Lecturer extends Employee {
    private int benefits;

    public Lecturer(String nama, int salary, int benefits) {
        super(nama, salary);
        this.benefits = benefits;
    }

    public void tampilkanInfoLecturer() {
        System.out.println("=== Dosen (Lecturer) ===");
        tampilkanInfoDasar();
        System.out.println("Tunjangan : Rp " + benefits);
        System.out.println("Total     : Rp " + (salary + benefits));
        System.out.println();
    }
}

class AdminStaff extends Employee {
    private int mealAllowance;

    public AdminStaff(String nama, int salary, int mealAllowance) {
        super(nama, salary);
        this.mealAllowance = mealAllowance;
    }

    public void tampilkanInfoAdmin() {
        System.out.println("=== Staf Administrasi (AdminStaff) ===");
        tampilkanInfoDasar();
        System.out.println("Uang Makan: Rp " + mealAllowance);
        System.out.println("Total     : Rp " + (salary + mealAllowance));
        System.out.println();
    }
}

class Technician extends Employee {
    private int fieldAllowance;

    public Technician(String nama, int salary, int fieldAllowance) {
        super(nama, salary);
        this.fieldAllowance = fieldAllowance;
    }

    public void tampilkanInfoTechnician() {
        System.out.println("=== Teknisi Lapangan (Technician) ===");
        tampilkanInfoDasar();
        System.out.println("Tunjangan Lapangan: Rp " + fieldAllowance);
        System.out.println("Total             : Rp " + (salary + fieldAllowance));
        System.out.println();
    }
}

public class Soal1Employee {
    public static void main(String[] args) {
        Lecturer dosen = new Lecturer("Budi Santoso", 8000000, 5000000);
        AdminStaff admin = new AdminStaff("Siti Rahma", 5000000, 1000000);
        Technician teknisi = new Technician("Rizky Pratama", 5500000, 1500000);

        dosen.tampilkanInfoLecturer();
        admin.tampilkanInfoAdmin();
        teknisi.tampilkanInfoTechnician();
    }
}