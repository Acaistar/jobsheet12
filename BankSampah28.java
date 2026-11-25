import java.util.Scanner;

public class BankSampah28 {
    static Scanner sc = new Scanner(System.in);

    // a. Fungsi inputSetoran: menerima parameter n dan mengembalikan array double[]
    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    // b. Fungsi tampilSetoran: menampilkan berat setoran setiap nasabah
    static void tampilSetoran(double[] setoran) {
        System.out.println("\n=== DAFTAR SETORAN NASABAH ===");
        for (int i = 0; i < setoran.length; i++) {
            System.out.printf("Nasabah ke-%d : %.2f kg%n", (i + 1), setoran[i]);
        }
    }

    // c. Fungsi totalSetoran: menghitung dan mengembalikan total berat setoran
    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    // d. Fungsi hitungSaldo: menghitung saldo dalam rupiah berdasarkan berat dan harga per kg
    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    // e. Fungsi nasabahTerbanyak: mengembalikan indeks nasabah dengan setoran terbesar
    static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    // f. Fungsi main
    public static void main(String[] args) {
        final double HARGA_PER_KG = 3000.0;

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran(n);

        tampilSetoran(dataSetoran);

        System.out.println("\n=== SALDO SETIAP NASABAH (Rp3.000/kg) ===");
        for (int i = 0; i < dataSetoran.length; i++) {
            double saldo = hitungSaldo(dataSetoran[i], HARGA_PER_KG);
            System.out.printf("Nasabah ke-%d : Rp%,.2f%n", (i + 1), saldo);
        }

        double totalBerat = totalSetoran(dataSetoran);
        System.out.printf("\nTotal berat setoran seluruh nasabah : %.2f kg%n", totalBerat);

        int idxTerbanyak = nasabahTerbanyak(dataSetoran);
        System.out.printf("Nasabah dengan setoran terbanyak    : Nasabah ke-%d (%.2f kg)%n",
                (idxTerbanyak + 1), dataSetoran[idxTerbanyak]);

        sc.close();
    }
}