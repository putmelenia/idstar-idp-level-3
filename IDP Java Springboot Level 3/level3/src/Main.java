import variable.ApplicationConstan;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean interacting = true;
        Scanner scanner = new Scanner(System.in);
        int mainMenu = 0;
        int childMenu = 0;
        List<List<String>> dataFromCSV = new ArrayList<>();

        do {
            try {
                printText(ApplicationConstan.mainPageMessage);
                mainMenu = scanner.nextInt();

                switch (mainMenu) {
                    case 1 :
                        if (dataFromCSV.isEmpty()) {
                            dataFromCSV = DataReader.readData(ApplicationConstan.path.concat(ApplicationConstan.csv));
                            if(dataFromCSV.isEmpty()){
                                printText(ApplicationConstan.pageNotFound);
                                childMenu = scanner.nextInt();
                                break;
                            }
                        }
                        pengelompokanNilai(dataFromCSV, ApplicationConstan.path.concat(ApplicationConstan.pengelompokkanNilai));
                        printText(ApplicationConstan.generatedPageMessage);
                        childMenu = scanner.nextInt();
                        break;
                    case 2 :
                        if (dataFromCSV.isEmpty()) {
                            dataFromCSV = DataReader.readData(ApplicationConstan.path.concat(ApplicationConstan.csv));
                        }
                        meanMedianModus(dataFromCSV, ApplicationConstan.path.concat(ApplicationConstan.modusMedianMean));
                        printText(ApplicationConstan.generatedPageMessage);
                        childMenu = scanner.nextInt();
                        break;
                    case 3 :
                        if (dataFromCSV.isEmpty()) {
                            dataFromCSV = DataReader.readData(ApplicationConstan.path.concat(ApplicationConstan.csv));
                        }
                        pengelompokanNilai(dataFromCSV, ApplicationConstan.path.concat(ApplicationConstan.pengelompokkanNilai));
                        meanMedianModus(dataFromCSV, ApplicationConstan.path.concat(ApplicationConstan.modusMedianMean));
                        printText(ApplicationConstan.generatedPageMessage);
                        childMenu = scanner.nextInt();
                        break;
                    case 0 :
                        interacting = false;
                        childMenu = 0;
                        break;
                }

                if (childMenu == 0) interacting = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (interacting);
    }

    static void printText(String text) {
        System.out.println(text);
    }

    static void pengelompokanNilai(List<List<String>> dataFromCSV, String writeFileLocationData) {
        if (dataFromCSV.isEmpty()) throw new IllegalArgumentException("List dataFromCSV is empty!");

        List<String> listDataString = DataNilai.toListString(dataFromCSV);
        List<Integer> listDataInteger = DataNilai.toListInteger(listDataString);
        Map<Integer, Integer> groupDataMap = DataNilai.groupingData(listDataInteger);

        List<String> linesOfData = new ArrayList<>(List.of("Berikut Hasil Sebaran Data Nilai: "," ", "Nilai | Frekuensi"));
        linesOfData.addAll(DataNilai.formatLineFromMap(groupDataMap));

        DataTextWriter.WritingFileUsingBufferedWriter(linesOfData, writeFileLocationData);
    }

    static void meanMedianModus(List<List<String>> dataReaderResult, String pathLocation) {
        if (dataReaderResult.isEmpty()) throw new IllegalArgumentException("List data from CSV is empty!");

        List<String> stringList = DataNilai.toListString(dataReaderResult);
        List<Integer> integerList = DataNilai.toListInteger(stringList);
        Map<Integer, Integer> groupData = DataNilai.groupingData(integerList);

        Double mean = DataNilai.findMeanFromList(groupData);
        Integer median = DataNilai.findMedianFromList(integerList);
        Integer modus = DataNilai.findModusFromMap(groupData);
        List<String> linesOfData = new ArrayList<>(List.of("Berikut Hasil Pengolahan Nilai: "," ", "Mean: ".concat(String.valueOf(mean)), "Median: ".concat(String.valueOf(median)),
                "Modus: ".concat(String.valueOf(modus))));

        DataTextWriter.WritingFileUsingBufferedWriter(linesOfData, pathLocation);
    }

}