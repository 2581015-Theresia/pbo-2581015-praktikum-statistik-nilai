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
            System.out.print("Nilai ke-" + nomor + ":");
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

        System.out.println("Nilai tersimpan :" + daftarNilai);

        int jumlah = daftarNilai.size();
        int total = 0;
        int tertinggi = daftarNilai.get(0);
        int terendah = daftarNilai.get(0);

        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeE = 0;

        for (int n : daftarNilai) {
            total +=n;

            if (n>tertinggi){
                tertinggi = n;
            }
            if (n<terendah){
                terendah=n;
            }

            if (n >= 90) {
                gradeA++;
            } else if (n >= 80) {
                gradeB++;
            } else if (n >= 70) {
                gradeC++;
            } else if (n >= 60) {
                gradeD++;
            } else {
                gradeE++;
        }
    }

        double rataRata = (double) total / jumlah;
        int diAtasRataRata = 0;
        for (int n : daftarNilai) {
            if (n > rataRata) {
                diAtasRataRata++;
            }
        }
        System.out.println("Jumlah : " + jumlah);
        System.out.printf(java.util.Locale.forLanguageTag("id-ID"), "Rata-rata : %.2f%n", rataRata);
        System.out.println("Tertinggi : " + tertinggi);
        System.out.println("Terendah : " + terendah);
        System.out.println("Di atas rata2 : " + diAtasRataRata + " orang");
        System.out.println("Distribusi : A=" + gradeA + " B=" + gradeB + " C=" + gradeC + " D=" + gradeD + " E=" + gradeE);

        ArrayList<Integer> terurut = new ArrayList<>(daftarNilai);
        Collections.sort(terurut);

        System.out.println("Terurut : " + terurut);
        System.out.println("Urutan asli : " + daftarNilai);
        scanner.close();

    }
}