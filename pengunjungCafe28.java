public class pengunjungCafe28 {
    static void daftarPengunjung(String... namaPengunjung){
        System.out.println("Daftar Nama Pengunjung: ");
        for (int i=0;i<namaPengunjung.length;i++){
            System.out.println ("- "+namaPengunjung[i]);
        }
    }
    public static void main(String[] agrs){
        daftarPengunjung("Ali","Budi","Citra");
        daftarPengunjung("Andi");
        daftarPengunjung("Doni","Eti","Fahmi","Galih");
    }
}
