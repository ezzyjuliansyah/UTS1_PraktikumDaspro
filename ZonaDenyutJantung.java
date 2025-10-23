import java.util.Scanner;

public class ZonaDenyutJantung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input usia
        System.out.print("Masukkan usia Anda (tahun): ");
        if (!input.hasNextInt()) {
            System.out.println("Input tidak valid. Usia harus berupa angka bulat.");
            input.close();
            return;
        }
        int usia = input.nextInt();
        if (usia < 10) {
            System.out.println("Usia minimal adalah 10 tahun.");
            input.close();
            return;
        }

        // Input HR
        System.out.print("Masukkan denyut jantung saat latihan (HR): ");
        if (!input.hasNextInt()) {
            System.out.println("Input tidak valid. HR harus berupa angka bulat.");
            input.close();
            return;
        }
        int hr = input.nextInt();
        if (hr <= 100) {
            System.out.println("HR harus lebih dari 100.");
            input.close();
            return;
        }

        // Hitung MHR dan %MHR
        int mhr = 220 - usia;
        double persenMHR = ((double) hr / mhr) * 100;
        int persenMHRdibulatkan = (int) Math.round(persenMHR);

        // Tentukan kategori dan saran
        String kategori, saran;
        if (persenMHR < 50) {
            kategori = "Sangat ringan";
            saran = "Cocok untuk pemanasan awal.";
        } else if (persenMHR < 60) {
            kategori = "Ringan";
            saran = "Zona latihan dasar.";
        } else if (persenMHR < 70) {
            kategori = "Sedang";
            saran = "Peningkatan aerobik ringan.";
        } else if (persenMHR < 80) {
            kategori = "Kuat";
            saran = "Meningkatkan kapasitas kardiovaskular.";
        } else if (persenMHR <= 85) {
            kategori = "Sangat berat";
            saran = "Berisiko bagi pemula, durasi latihan sebaiknya dibatasi.";
        } else {
            kategori = "Di luar zona aman";
            saran = "Denyut jantung terlalu tinggi. Konsultasikan dengan profesional.";
        }

        // Output
        System.out.println("\n--- Hasil Evaluasi ---");
        System.out.println("Detak Jantung Maksimal (MHR): " + mhr);
        System.out.println("Persentase MHR: " + persenMHRdibulatkan + "%");
        System.out.println("Kategori Intensitas: " + kategori);
        System.out.println("Saran: " + saran);

        input.close();
    }
}