import java.util.Scanner;

public class MoneyChanger {

    static Scanner sc = new Scanner(System.in);

    static int maksimumTransaksi = 100;
    static double[][] transaksiData = new double[maksimumTransaksi][3];
    static int[] ids = new int[maksimumTransaksi];
    static int jumlahTransaksi = 0;
    static int transaksiId = 1;

    public static void main(String[] args) {
        int opsi;
        do {
            System.out.println("\nMoney Changer");
            System.out.println("1. Masukkan Data");
            System.out.println("2. Lihat Daftar Mata Uang");
            System.out.println("3. Lihat Nilai USD Tertinggi");
            System.out.println("4. Edit Data");
            System.out.println("5. Hapus Data");
            System.out.println("6. Keluar");
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
                    editData();
                    break;
                case 5:
                    hapusData();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    break;
                default: 
                    System.err.println("Pilihan invalid. Silahkan coba lagi");
                    break;
            }
        } while (opsi != 6);
    }

    static void inputData() {
        if (jumlahTransaksi >= maksimumTransaksi) {
            System.out.println("Batas Transaksi telah terpenuhi. Tidak bisa tambah data lagi.");
            return;
        }
        System.out.print("Masukkan jumlah data yang ingin diinput: ");
        int jumInput = sc.nextInt();

        for (int i = 0; i < jumInput; i++) {
            if (jumlahTransaksi >= maksimumTransaksi) {
                System.out.println("Batas Transaksi telah terpenuhi.");
                break;
            }

            System.out.println("\nData ke-" + (i + 1));
            System.out.print("Masukkan jumlah uang dalam rupiah: Rp");
            double jumlahRp = sc.nextDouble();

            ids[jumlahTransaksi] = transaksiId++;
            transaksiData[jumlahTransaksi][0] = jumlahRp;
            transaksiData[jumlahTransaksi][1] = convUSD(jumlahRp);
            transaksiData[jumlahTransaksi][2] = convYen(jumlahRp);
            jumlahTransaksi++;
        }
        System.out.println("Data telah ditambahkan.");
    }

    static double convUSD(double rp) {
        double rateUSD = 0.000062;
        return rp * rateUSD;
    }

    static double convYen(double rp) {
        double rateYEN = 0.0096;
        return rp * rateYEN;
    }

    static void lihatData() {
        if (jumlahTransaksi == 0) {
            System.err.println("Belum ada transaksi.");
            return;
        }

        System.out.println("+----------+----------------+----------------+----------------+");
        System.out.printf("| %-8s | %-14s | %-14s | %-14s |%n", "ID", "Rupiah", "USD", "Yen");
        System.out.println("+----------+----------------+----------------+----------------+");
        for (int i = 0; i < jumlahTransaksi; i++) {
            System.out.printf("| %-8d | Rp%-12.2f | $%-12.2f  | \u00a5%-12.2f  |%n", ids[i], transaksiData[i][0], transaksiData[i][1], transaksiData[i][2]);
        }
        System.out.println("+----------+----------------+----------------+----------------+");
    }

    static void maxUSD() {
        if (jumlahTransaksi == 0) {
            System.err.println("Belum ada transaksi.");
            return;
        }
        double max = transaksiData[0][1];
        for (int i = 1; i < jumlahTransaksi; i++) {
            if (transaksiData[i][1] > max) {
                max = transaksiData[i][1];
            }
        }
        System.out.printf("\nNilai USD Tertinggi: $%.2f\n", max);
    }

    static void editData() {
        System.out.print("Masukkan ID transaksi yang ingin diedit: ");
        int idEdit = sc.nextInt();
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (ids[i] == idEdit) {
                System.out.print("Masukkan jumlah uang baru dalam rupiah: Rp");
                double jumlahRpBaru = sc.nextDouble();
                transaksiData[i][0] = jumlahRpBaru;
                transaksiData[i][1] = convUSD(jumlahRpBaru);
                transaksiData[i][2] = convYen(jumlahRpBaru);
                System.out.println("Data berhasil diubah.");
                return;
            }
        }
        System.err.println("ID tidak ditemukan.");
    }

    static void hapusData() {
        System.out.print("Masukkan ID transaksi yang ingin dihapus: ");
        int idHapus = sc.nextInt();
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (ids[i] == idHapus) {
                for (int j = i; j < jumlahTransaksi - 1; j++) {
                    ids[j] = ids[j + 1];
                    transaksiData[j] = transaksiData[j + 1];
                }
                ids[jumlahTransaksi - 1] = 0;
                transaksiData[jumlahTransaksi - 1] = new double[3];
                jumlahTransaksi--;
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }
        System.err.println("ID tidak ditemukan.");
    }
}
