
import java.util.Scanner;

public class MoneyChanger {

    static double USD_RATE = 0.000065;
    static double YEN_RATE = 0.0071;

    static int maksimumTransaksi = 100;
    static int[] ids = new int[maksimumTransaksi];
    static double[] jumlahs = new double[maksimumTransaksi];
    static int jumlahTransaksi = 0;
    static int transaksiId = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMoney Changer");
            System.out.println("1. Masukkan Data");
            System.out.println("2. Liat semua data");
            System.out.println("3. Keluar");
            System.out.println("Pilih Opsi");

            int opsi = sc.nextInt();

            switch (opsi) {
                case 1:
                    inputData(sc);
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan kami!");
                    break;
                default:
                    System.err.println("Pilihan invalid. Silahkan coba lagi");
            }
        }
    }

    static void inputData(Scanner sc) {
        if (jumlahTransaksi >= maksimumTransaksi) {
            System.out.println("Batas Transaksi telah terpenuhi. tidak bisa tambah data lagi");
            return;
        }

        System.out.println("Masukkan jumlah Rupiah: ");
        double jumlah = sc.nextDouble();
        ids[jumlahTransaksi] = transaksiId++;
        jumlahs[jumlahTransaksi++] = jumlah;
        System.out.println("Data telah ditambahkan");
    }

    static void lihatData() {
        if (jumlahTransaksi == 0) {
            System.err.println("Belum ada transaksi");
        } else {
            System.out.println("\nHistori Transaksi: ");
            System.out.printf("%-10s %-15s %-15s %-15s\n", "ID", "Rupiah", "USD", "Yen");
            for (int i = 0; i < jumlahTransaksi; i++) {
                int id = ids[i];
                double rupiah = jumlahs[i];
                double usd = rupiah * USD_RATE;
                double yen = rupiah * YEN_RATE;
                System.out.printf("%-10d %-15.2f %-15.2f %-15 %-15.2f\n", id, rupiah, usd, yen);
            }
        }
    }
}
