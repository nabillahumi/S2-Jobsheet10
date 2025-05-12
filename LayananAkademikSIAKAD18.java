import java.util.Scanner;

public class LayananAkademikSIAKAD18 {
    
     public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        AntrianLayanan18 antrian = new AntrianLayanan18(5);
        int pilihan;

        do {
            System.out.println("\n=== Menu Antrian Layanan Akademik ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Layani Mahasiswa");
            System.out.println("3. Lihat Antrian Terdepan");
            System.out.println("4. Lihat Semua Antrian");
            System.out.println("5. Cek Jumlah Antrian");
            System.out.println("6. Lihat Antrian Terakhir");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIN : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    Mahasiswa18 mhs = new Mahasiswa18(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    Mahasiswa18 dilayani = antrian.layaniMahasiswa();
                    if (dilayani != null) {
                        System.out.println("Melayani Mahasiswa : ");
                        dilayani.tampilkanData();   
                    }
                    break;
                case 3:
                    antrian.lihatTerdepan();
                    break;
                case 4:
                    antrian.tampilkanSemua();;
                    break;
                case 5:
                    System.out.println("Jumlah antrian : " + antrian.getJumlahAntrian());
                    break;
                case 6:
                    antrian.lihatAkhir();
                    break;
                case 0:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }

        } while (pilihan != 0);

        sc.close();
    }
}
