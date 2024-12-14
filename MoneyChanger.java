
import java.util.Scanner;

public class MoneyChanger {
    
    static void daftarUang(double idr, double usd, double yen){
        System.out.println("Rupiah\t\tUS Dollar\t\tYen");
        System.out.printf("%.2f\t\t%.2f\t\t%.2f",idr,usd,yen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < args.length; i++) {

        }
    }
}
