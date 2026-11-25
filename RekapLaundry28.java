import java.util.Scanner;

public class RekapLaundry28 {
    static String[] namaLayanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
    static int[] hargaPerKg = {6000, 8000, 5000, 12000};
    static String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    // 1. Fungsi untuk menginputkan data berat cucian
    static void inputData(int[][] data) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < data.length; i++) {
            System.out.println("\nInput berat cucian (kg) untuk layanan " + namaLayanan[i] + ":");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  " + namaHari[j] + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    // 2. Fungsi untuk menampilkan seluruh data dalam bentuk tabel
    static void tampilTabel(int[][] data) {
        System.out.println("\n==================== REKAP BERAT CUCIAN (KG) ====================");
        System.out.printf("%-15s %-11s", "Layanan", "Harga/kg");
        for (String hari : namaHari) {
            System.out.printf("%-8s", hari);
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-15s Rp%-9d", namaLayanan[i], hargaPerKg[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-8d", data[i][j]);
            }
            System.out.println();
        }
        System.out.println("===================================================================");
    }

    // 3. Fungsi totalPerLayanan
    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    // 4. Fungsi untuk menampilkan layanan dengan total berat cucian tertinggi
    static void layananTertinggi(int[][] data) {
        int idxMax = 0;
        int beratMax = totalPerLayanan(data, 0);

        for (int i = 1; i < data.length; i++) {
            int totalSekarang = totalPerLayanan(data, i);
            if (totalSekarang > beratMax) {
                beratMax = totalSekarang;
                idxMax = i;
            }
        }
        System.out.println("\nLayanan dengan berat tertinggi : " + namaLayanan[idxMax] + " (" + beratMax + " kg)");
    }

    // 5. Fungsi hariTersibuk
    static int hariTersibuk(int[][] data) {
        int idxHariMax = 0;
        int beratHariMax = 0;

        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (totalHari > beratHariMax) {
                beratHariMax = totalHari;
                idxHariMax = j;
            }
        }
        return idxHariMax;
    }

    // 6. Fungsi untuk menghitung dan menampilkan pendapatan setiap layanan serta total pendapatan
    static void tampilPendapatan(int[][] data) {
        long totalPendapatan = 0;
        System.out.println("\n--- Rincian Pendapatan Selama 6 Hari ---");
        for (int i = 0; i < data.length; i++) {
            int totalKg = totalPerLayanan(data, i);
            long pendapatanLayanan = (long) totalKg * hargaPerKg[i];
            totalPendapatan += pendapatanLayanan;
            System.out.printf("%-15s : %d kg x Rp%,d = Rp%,d%n",
                    namaLayanan[i], totalKg, hargaPerKg[i], pendapatanLayanan);
        }
        System.out.printf("Total Pendapatan Keseluruhan : Rp%,d%n", totalPendapatan);
    }

    public static void main(String[] args) {
        int[][] dataCucian = new int[4][6];

        inputData(dataCucian);
        tampilTabel(dataCucian);
        layananTertinggi(dataCucian);

        int idxSibuk = hariTersibuk(dataCucian);
        System.out.println("Hari tersibuk                  : " + namaHari[idxSibuk]);

        tampilPendapatan(dataCucian);
    }
}