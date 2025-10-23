import java.util.Scanner;
public class Bilangan09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan angka pertama: ");
        if (sc.hasNextInt()) {
            System.out.println("Input tidak valid! Harus berupa angka.");
            return;
        }
        int a = sc.nextInt();

        System.out.print("Masukkan angka kedua: ");
        if (sc.hasNextInt()) {
            System.out.println("Input tidak valid! Harus berupa angka.");
            return;
        }
        int b = sc.nextInt();

        System.out.print("Masukkan angka ketiga: ");
        if (sc.hasNextInt()) {
            System.out.println("Input tidak valid! Harus berupa angka.");
            return;
        }
        int c = sc.nextInt();

        // Menentukan nilai terkecil
        int terkecil = a;
        if (b < terkecil) {
            terkecil = b;
        }
        if (c < terkecil) {
            terkecil = c;
        }

        // Menentukan apakah ada angka yang sama dengan terkecil
        if (a == b && b == c) {
            System.out.println("Semua angka sama yaitu: " + a);
        } else if ((a == terkecil && b == terkecil) ||
                   (a == terkecil && c == terkecil) ||
                   (b == terkecil && c == terkecil)) {
            System.out.print("Ada beberapa angka terkecil yaitu: ");
            if (a == terkecil) System.out.print(a + " ");
            if (b == terkecil && b != a) System.out.print(b + " ");
            if (c == terkecil && c != a && c != b) System.out.print(c + " ");
            System.out.println();
        } else {
            System.out.println("Angka terkecil adalah: " + terkecil);
        }

        sc.close();
    }
}
