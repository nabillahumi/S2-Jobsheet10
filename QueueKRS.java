public class QueueKRS {
    
    DataMahasiswa[] antrian;
    int front, rear, size, jumlah;
    int totalDilayani;

    // Konstruktor
    public QueueKRS(int jumlah) {
        this.jumlah = jumlah;
        antrian = new DataMahasiswa[jumlah];
        front = 0;
        rear= -1;
        size = 0;
        totalDilayani = 0;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == jumlah) {
            return true;
        }
        else {
            return false;
        }
    }

    public void clear() {
        front = 0;
        rear = -1;
        jumlah = 0;
        System.out.println("Seluruh antrian telah dihapus.");
    }

    public void tambahData(DataMahasiswa m) {
        if (IsFull()) {
            System.out.println("Antrian sudah penuh.");
            return;
        }
        rear = (rear + 1) % jumlah;
        antrian[rear] = m;
        size++;
        System.out.println(m.namaLengkap + " berhasil masuk ke antrian.");
    }

    public void prosesDataKRS() {
        if (size < 2) {
            System.out.println("Minimal dua mahasiswa dibutuhkan untuk proses.");
            return;
        }

        System.out.println("Proses KRS untuk 2 mahasiswa:");
        int jumlahYangDiproses = 0;
        while (jumlahYangDiproses < 2 && size > 0) {
            DataMahasiswa m = antrian[front];
            m.infoMahasiswa();
            front = (front + 1) % jumlah;
            size--;
            totalDilayani++;
            jumlahYangDiproses++;
        }
    }

    public void tampilSemua() {
        if (IsEmpty()) {
            System.out.println("Belum ada antrian.");
            return;
        }

        System.out.println("Daftar antrian mahasiswa:");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % jumlah;
            System.out.print((i + 1) + ". ");
            antrian[idx].infoMahasiswa();
        }
    }

    public void tampilTerdepan() {
        if (size < 2) {
            System.out.println("Antrian kurang dari dua mahasiswa.");
            return;
        }

        System.out.println("Dua mahasiswa pertama dalam antrian:");
        for (int i = 0; i < 2; i++) {
            int idx = (front + i) % jumlah;
            antrian[idx].infoMahasiswa();
        }
    }

    public void tampilTerakhir() {
        if (IsEmpty()) {
            System.out.println("Tidak ada mahasiswa di antrian.");
        } else {
            System.out.println("Mahasiswa terakhir di antrian:");
            antrian[rear].infoMahasiswa();
        }
    }

    public int hitungAntrian() {
        return size;
    }

    public int totalMahasiswaDilayani() {
        return totalDilayani;
    }

    public int sisaKuotaDosen() {
        return 30 - totalDilayani;
    }

    public int jumlahBelumDiproses() {
        return size;
    }
}
