public class QueueKRS {
    
    DataMahasiswa[] data;
    int front, rear, size, max;
    int totalDilayani;

    // Konstruktor
    public QueueKRS(int max) {
        this.max = max;
        data = new DataMahasiswa[max];
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
        if (size == max) {
            return true;
        }
        else {
            return false;
        }
    }

    public void clear() {
        front = 0;
        rear = -1;
        max = 0;
        System.out.println("Seluruh antrian telah dihapus.");
    }

    public void tambahData(DataMahasiswa m) {
        if (IsFull()) {
            System.out.println("Antrian sudah penuh.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = m;
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
            DataMahasiswa m = data[front];
            m.infoMahasiswa();
            front = (front + 1) % max;
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
            int idx = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[idx].infoMahasiswa();
        }
    }

    public void tampilTerdepan() {
        if (size < 2) {
            System.out.println("Antrian kurang dari dua mahasiswa.");
            return;
        }

        System.out.println("Dua mahasiswa pertama dalam antrian:");
        for (int i = 0; i < 2; i++) {
            int idx = (front + i) % max;
            data[idx].infoMahasiswa();
        }
    }

    public void tampilTerakhir() {
        if (IsEmpty()) {
            System.out.println("Tidak ada mahasiswa di antrian.");
        } else {
            System.out.println("Mahasiswa terakhir di antrian:");
            data[rear].infoMahasiswa();
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
