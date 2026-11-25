import java.util.Scanner;

public class KubusLimas28 {
    // 1. Menghitung luas persegi (sisi * sisi)
    static int luasPersegi(int s) {
        return s * s;
    }

    // 2. Menghitung volume kubus (sisi^3)
    static int volumeKubus(int s) {
        return s * s * s;
    }

    // 3. Menghitung luas permukaan kubus (6 * luas persegi) dengan memanggil luasPersegi
    static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    // 4. Menghitung volume limas persegi ((luas alas * tinggi) / 3) bertipe double
    static double volumeLimasPersegi(int s, int t) {
        return (luasPersegi(s) * (double) t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU KALKULATOR KUBUS & LIMAS PERSEGI ===");
            System.out.println("1. Luas Persegi");
            System.out.println("2. Volume Kubus");
            System.out.println("3. Luas Permukaan Kubus");
            System.out.println("4. Volume Limas Persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-4): ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan panjang sisi (s): ");
                    int s1 = sc.nextInt();
                    System.out.println("Luas Persegi = " + luasPersegi(s1));
                    break;

                case 2:
                    System.out.print("Masukkan panjang sisi kubus (s): ");
                    int s2 = sc.nextInt();
                    System.out.println("Volume Kubus = " + volumeKubus(s2));
                    break;

                case 3:
                    System.out.print("Masukkan panjang sisi kubus (s): ");
                    int s3 = sc.nextInt();
                    System.out.println("Luas Permukaan Kubus = " + luasPermukaanKubus(s3));
                    break;

                case 4:
                    System.out.print("Masukkan panjang sisi alas (s): ");
                    int s4 = sc.nextInt();
                    System.out.print("Masukkan tinggi limas (t): ");
                    int t4 = sc.nextInt();
                    System.out.printf("Volume Limas Persegi = %.2f%n", volumeLimasPersegi(s4, t4));
                    break;

                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 0-4.");
                    break;
            }
        } while (pilihan != 0);

        sc.close();
    }
}