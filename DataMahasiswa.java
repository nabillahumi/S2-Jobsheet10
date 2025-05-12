public class DataMahasiswa {
    
     String nim, namaLengkap, jurusan, kelasMahasiswa;

    // Konstruktor
    public DataMahasiswa(String nim, String namaLengkap, String jurusan, String kelasMahasiswa) {
        this.nim = nim;
        this.namaLengkap = namaLengkap;
        this.jurusan = jurusan;
        this.kelasMahasiswa = kelasMahasiswa;
    }

    // Tampilkan info mahasiswa
    public void infoMahasiswa() {
        System.out.println(nim + " - " + namaLengkap + " - " + jurusan + " - " + kelasMahasiswa);
    }
}
