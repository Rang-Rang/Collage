
import java.util.Scanner;

public class MoneyChanger {

    static Scanner sc = new Scanner(System.in);
    static double rateUSD = 0.000062;
    static double rateYEN = 0.0096;

    static int maksimumTransaksi = 100;
    static int[] ids = new int[maksimumTransaksi];
    static double[] arrRupiah = new double[maksimumTransaksi];
    static double[] arrUsd = new double[maksimumTransaksi];
    static double[] arrYen = new double[maksimumTransaksi];
    static int jumlahTransaksi = 0;
    static int transaksiId = 1;

    public static void main(String[] args) {

        int opsi;
        do {
            System.out.println("\nMoney Changer");
            System.out.println("1. Masukkan Data");
            System.out.println("2. Lihat Daftar Mata Uang");
            System.out.println("3. Lihat Nilai USD Tertinggi");
            System.out.println("4. Keluar");
            System.out.print("Pilih Opsi: ");

            opsi = sc.nextInt();

            switch (opsi) {
                case 1:
                    inputData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    maxUSD();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    break;
                default:
                    System.err.println("Pilihan invalid. Silahkan coba lagi");
            }

        } while (opsi != 4);
    }

    static void inputData() {
        if (jumlahTransaksi >= maksimumTransaksi) {
            System.out.println("Batas Transaksi telah terpenuhi. tidak bisa tambah data lagi");
            return;
        }
        System.out.print("Masukkan jumlah yang diinput: ");
        int jumInput = sc.nextInt();

        for (int i = 0; i < jumInput; i++) {
            System.out.println("\nData ke-" + (i + 1));
            System.out.print("Masukkan jumlah uang dalam rupiah, Rp");
            double jumlahRp = sc.nextDouble();
            ids[jumlahTransaksi] = transaksiId++;
            arrRupiah[jumlahTransaksi] = jumlahRp;

            arrUsd[jumlahTransaksi] = convUSD(jumlahRp);
            arrYen[jumlahTransaksi] = convYen(jumlahRp);
            jumlahTransaksi++;
        }
        System.out.println("Data telah ditambahkan");
    }

    static double convUSD(double rp) {
        return rp * rateUSD;
    }

    static double convYen(double rp) {
        return rp * rateYEN;
    }

    static void lihatData() {
        if (jumlahTransaksi == 0) {
            System.err.println("Belum ada transaksi");
        } else {
            System.out.println("\nKonversi Mata Uang: ");
            System.out.printf("%-10s %-15s %-15s %-15s\n", "ID", "Rupiah", "USD", "Yen");
            for (int i = 0; i < jumlahTransaksi; i++) {
                System.out.printf("%-10d Rp%-14.2f $%-14.2f ¥%-14.2f\n", ids[i], arrRupiah[i], arrUsd[i], arrYen[i]);
            }
        }
    }

    static void maxUSD() {
        double max = 0;
        for (int i = 0; i < arrUsd.length; i++) {
            if (max < arrUsd[i]) {
                max = arrUsd[i];
            }
        }
        System.out.printf("Nilai USD Tertinggi: $%.2f\n", max);
    }
}
