import java.util.Scanner;

public class MainKRS {
    
     public static void main(String[] args) {

        QueueKRS krsQueue = new QueueKRS(10);
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Sistem Antrian KRS ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Proses KRS (2 Mahasiswa)");
            System.out.println("3. Kosongkan Antrian");
            System.out.println("4. Lihat Semua Antrian");
            System.out.println("5. Lihat 2 Terdepan");
            System.out.println("6. Lihat Mahasiswa Terakhir");
            System.out.println("7. Jumlah Antrian Sekarang");
            System.out.println("8. Total Mahasiswa Diproses");
            System.out.println("9. Sisa Kuota DPA");
            System.out.println("10. Mahasiswa Belum Diproses");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // bersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Lengkap : ");
                    String nama = sc.nextLine();
                    System.out.print("NIM          : ");
                    String nim = sc.nextLine();
                    System.out.print("Jurusan      : ");
                    String jurusan = sc.nextLine();
                    System.out.print("Kelas        : ");
                    String kelas = sc.nextLine();
                    DataMahasiswa mhs = new DataMahasiswa(nim, nama, jurusan, kelas);
                    krsQueue.tambahData(mhs);
                    break;
                case 2:
                    krsQueue.prosesDataKRS();
                    break;
                case 3:
                    krsQueue.clear();
                    break;
                case 4:
                    krsQueue.tampilSemua();
                    break;
                case 5:
                    krsQueue.tampilTerdepan();
                    break;
                case 6:
                    krsQueue.tampilTerakhir();
                    break;
                case 7:
                    System.out.println("Total antrian saat ini: " + krsQueue.hitungAntrian());
                    break;
                case 8:
                    System.out.println("Mahasiswa yang sudah dilayani: " + krsQueue.totalMahasiswaDilayani());
                    break;
                case 9:
                    System.out.println("Sisa kuota dosen pembimbing: " + krsQueue.sisaKuotaDosen());
                    break;
                case 10:
                    System.out.println("Mahasiswa belum diproses: " + krsQueue.jumlahBelumDiproses());
                    break;
                case 0:
                    System.out.println("Keluar dari sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak dikenali.");
                    break;
            }

        } while (pilihan != 0);
    }
}
