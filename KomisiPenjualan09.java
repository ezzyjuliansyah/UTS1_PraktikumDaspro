import java.util.Scanner;

public class KomisiPenjualan09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Input omzet
    System.out.print("Masukkan omzet bulanan (Rp): ");
    if (!input.hasNextDouble()) {
      System.out.println("Input tidak valid. Omzet harus berupa angka.");
      input.close();
      return;
    }
    double omzet = input.nextDouble();
    if (omzet < 0) {
      System.out.println("Omzet tidak boleh negatif.");
      input.close();
      return;
    }

    // Input rating
    System.out.print("Masukkan rating (1–100): ");
    if (!input.hasNextInt()) {
      System.out.println("Input tidak valid. Rating harus berupa angka bulat.");
      input.close();
      return;
    }
    int rating = input.nextInt();
    if (rating < 1 || rating > 100) {
      System.out.println("Rating harus antara 1 hingga 100.");
      input.close();
      return;
    }

    // Input sertifikasi
    System.out.print("Apakah memiliki sertifikasi? (true/false): ");
    if (!input.hasNextBoolean()) {
      System.out.println("Input tidak valid. Sertifikasi harus true atau false.");
      input.close();
      return;
    }
    boolean sertifikasi = input.nextBoolean();

    // Hitung komisi
    double persenKomisi = 0;
    double bonus = 0;

    if (rating >= 70) {
      // Tentukan persentase dasar
      if (omzet >= 100_000_000) {
        persenKomisi = 5;
      } else if (omzet >= 50_000_000) {
        persenKomisi = 3;
      } else if (omzet >= 10_000_000) {
        persenKomisi = 2;
      }

      // Tambahan 1% jika rating >= 90
      if (rating >= 90) {
        persenKomisi += 1;
      }

      // Tambahan Rp 500.000 jika sertifikasi
      if (sertifikasi) {
        bonus = 500_000;
      }
    }

    double komisiPersen = omzet * persenKomisi / 100;
    double totalKomisi = komisiPersen + bonus;

    // Output
    System.out.println("\n--- Hasil Perhitungan Komisi ---");
    System.out.println("Omzet: Rp " + String.format("%,.0f", omzet));
    System.out.println("Rating: " + rating);
    System.out.println("Sertifikasi: " + (sertifikasi ? "Ya" : "Tidak"));
    System.out.println("Persentase Komisi: " + persenKomisi + "%");
    System.out.println("Komisi dari Persentase: Rp " + String.format("%,.0f", komisiPersen));
    System.out.println("Bonus Sertifikasi: Rp " + String.format("%,.0f", bonus));
    System.out.println("Total Komisi: Rp " + String.format("%,.0f", totalKomisi));

    input.close();
  }
}