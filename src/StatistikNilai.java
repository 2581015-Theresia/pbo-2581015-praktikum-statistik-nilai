import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {
    static final int SELESAI = -1;

    public static void main (String[] args)  {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> daftarNilai = new ArrayList<>();

        System.out.println("========== STATISTIK NILAI KELAS ==========");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;
        int nomor = 1;

        while (true) {
            System.out.print("Nilai ke-" + nomor ":");
            nilai = scanner.nextInt();

            if (nilai == SELESAI){
           break;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("Ditolak, harus 0-100");
                continue;
            }

            daftarNilai.add(nilai);
            nomor++;
        }

        System.out.println();

        if (daftarNilai.isEmpty()) {
            System.out.println ("Belum ada nilai iyang dimasukkan.");
            scanner.close();
            return;
        }


    }
}