public class AntrianLayanan18 {
        
    Mahasiswa18[] data;
    int front;
    int rear;
    int size;
    int max;

    //constructor
    public AntrianLayanan18(int max) {
        this.max = max;
        this.data = new Mahasiswa18[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    //method isEmpty
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    //method isFull
    public boolean isFull() {
        if (size == max) {
            return true;
        }
        else {
            return false;
        }
    }

    //method enqueue
    public void tambahAntrian(Mahasiswa18 mhs) {
        if (isFull()) {
            System.out.println("Antrian sudah penuh");
            return;
        } 
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " sudah ditambahkan ke antrian");
    }
    
    //method dequeue
    public Mahasiswa18 layaniMahasiswa() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return null;
        } 
        Mahasiswa18 mhs = data[front];
        front = (front + 1) % max;
        size--;
        return mhs;
    }

    //method peek
    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
        }
        else {
            System.out.println("Mahasiswa terdepan : ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[front].tampilkanData();
        }
    }

    //method print
    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        System.out.println("Daftar Antrian : ");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    //method size
    public int getJumlahAntrian() {
        return size;
    }

    //method lihatAkhir
    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            System.out.println("Mahasiswa paling belakang : ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[rear].tampilkanData();
        }
    }
}
