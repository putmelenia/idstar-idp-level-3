import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReader {
    public static final String delimiter = ";";
    public static List<List<String>> readData(String dataFile){
        List<List<String>> data = new ArrayList<>();

        try {
            File file = new File (dataFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            List<String> dataValue;

            while((line = bufferedReader.readLine()) != null){
                dataValue = Arrays.asList(line.split(delimiter));
                data.add(dataValue);
            }
            bufferedReader.close();
        } catch (FileNotFoundException fileNotFoundException){
            System.out.println("File "+dataFile+" not found");
        }catch (IOException e) {
            System.out.println("Error reding file "+dataFile);
        }
        return data;
    }
}
