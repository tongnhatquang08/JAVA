package OOP.Btap.Huong_doi_tuong;
import java.util.Scanner;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        toiGian();
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
        toiGian();
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
        toiGian();
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tử số: ");
        tuSo = scanner.nextInt();
        System.out.print("Nhập mẫu số: ");
        mauSo = scanner.nextInt();
        toiGian();
    }

    public void xuat() {
        System.out.println(tuSo + "/" + mauSo);
    }

    public void toiGian() {
        int gcd = GCD(tuSo, mauSo);
        tuSo /= gcd;
        mauSo /= gcd;
    }

    private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public PhanSo cong(PhanSo ps) {
        int ts = tuSo * ps.mauSo + mauSo * ps.tuSo;
        int ms = mauSo * ps.mauSo;
        return new PhanSo(ts, ms);
    }

    public PhanSo tru(PhanSo ps) {
        int ts = tuSo * ps.mauSo - mauSo * ps.tuSo;
        int ms = mauSo * ps.mauSo;
        return new PhanSo(ts, ms);
    }

    public PhanSo nhan(PhanSo ps) {
        int ts = tuSo * ps.tuSo;
        int ms = mauSo * ps.mauSo;
        return new PhanSo(ts, ms);
    }

    public PhanSo chia(PhanSo ps) {
        int ts = tuSo * ps.mauSo;
        int ms = mauSo * ps.tuSo;
        return new PhanSo(ts, ms);
    }

    public static void main(String[] args) {
        PhanSo ps1 = new PhanSo();
        ps1.nhap();

        PhanSo ps2 = new PhanSo();
        ps2.nhap();

        System.out.println("Phân số 1: ");
        ps1.xuat();

        System.out.println("Phân số 2: ");
        ps2.xuat();

        System.out.println("Phép cộng: ");
        PhanSo psTong = ps1.cong(ps2);
        psTong.xuat();

        System.out.println("Phép trừ: ");
        PhanSo psHieu = ps1.tru(ps2);
        psHieu.xuat();

        System.out.println("Phép nhân: ");
        PhanSo psTich = ps1.nhan(ps2);
        psTich.xuat();

        System.out.println("Phép chia: ");
        PhanSo psThuong = ps1.chia(ps2);
        psThuong.xuat();
    }
}




