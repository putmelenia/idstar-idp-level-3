package variable;

public class ApplicationConstan {
    public static String csv = "data_sekolah.csv";
    public static String pengelompokkanNilai = "pengelompokkan_nilai.txt";
    public static String modusMedianMean = "modus_median_mean.txt";
    public static String path = "src/files/";

    /*Main Menu*/
    public static String mainPage = """
            ----------------------------------------------------------
            Aplikasi Pengolah Nilai Siswa
            ----------------------------------------------------------
            """;
    public static String sourceFile = "Letakkan file csv dengan nama file data_sekolah pada package berikut: " + path;
    public static String mainOption = """
            
            Pilih Menu :
            1. Generate txt untuk menampilkan pengelompokkan nilai
            2. Generate txt untuk menampilkan nilai rata-rata, median, dan modus
            3. Generate kedua file
            0. Exit
            """;
    public static String generatedMessage = """
            File telah di generate di src/files/
            silakan cek
            """;

    public static String notFoundMessage = """
            File tidak ditemukan
            """;
    public static String generatedOption = """
            
            0. Exit
            1. Kembali ke menu utama
            """;
    public static String selectMenu = "\nPilih Menu : ";
    public static String mainPageMessage = mainPage.concat(sourceFile).concat(mainOption).concat(selectMenu);
    public static String generatedPageMessage = mainPage.concat(generatedMessage).concat(generatedOption).concat(selectMenu);
    public static String pageNotFound = mainPage.concat(notFoundMessage).concat(generatedOption);
}
