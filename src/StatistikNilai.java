import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class StatistikNilai {
    static final int SELESAI = -1;

    public static void main (String[] args)  {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> daftarNilai = new ArrayList<>();

        System.out.println("========== STATISTIK NILAI KELAS ==========");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;


        do {
            nilai = scanner.nextInt();

            if (nilai == SELESAI){
           break;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("Ditolak, harus 0-100");
                continue;
            }

            daftarNilai.add(nilai);
        } while (nilai != SELESAI);

        System.out.println();

        if (daftarNilai.isEmpty()) {
            System.out.println ("Belum ada nilai iyang dimasukkan.");
            scanner.close();
            return;
        }

        System.out.println("Nilai tersimpan :" + daftarNilai);

        int jumlah = daftarNilai.size();
        int total = 0;

        // Nilai awal diambil dari elemen pertama karena
        // elemen tersebut merupakan nilai sah yang tersedia.
        // Nilai berikutnya dibandingkan melalui loop.
        int tertinggi = daftarNilai.get(0);
        int terendah = daftarNilai.get(0);

        // Index: 0=A, 1=B, 2=C, 3=D, 4=E.
        int[] jumlahGrade = new int[5];

        for (int n : daftarNilai) {
            total +=n;

            if (n>tertinggi){
                tertinggi = n;
            }
            if (n<terendah){
                terendah=n;
            }

            if (n >= 90) {
                jumlahGrade[0]++;
            } else if (n >= 80) {
                jumlahGrade[1]++;
            } else if (n >= 70) {
                jumlahGrade[2]++;
            } else if (n >= 60) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }

        double rataRata = (double) total / jumlah;

        // Putaran kedua diperlukan karena rata-rata baru diketahui
        // setelah semua nilai dijumlahkan pada putaran pertama.

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
        // Mencetak distribusi grade menggunakan loop.
        String[] namaGrade = {"A", "B", "C", "D", "E"};

        System.out.print("Distribusi : ");
        for (int i = 0; i < jumlahGrade.length; i++)
        { if (i > 0) {
            System.out.print(" ");
        }
        System.out.print(namaGrade[i] + "=" + jumlahGrade[i]);
        }
        System.out.println();
        // Mengurutkan salinan agar daftar asli tetap utuh.
        ArrayList<Integer> terurut = new ArrayList<>(daftarNilai);
        Collections.sort(terurut);
        System.out.println("Terurut : " + terurut);
        System.out.println("Urutan asli : " + daftarNilai);
        scanner.close();
    }
}