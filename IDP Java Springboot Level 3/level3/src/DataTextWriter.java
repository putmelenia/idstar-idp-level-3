import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataTextWriter {

    public static void WritingFileUsingBufferedWriter(List<String> data, String location){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(location));

            try{
                data.forEach( value -> {
                    try {
                        writer.write(value);
                        writer.write(System.getProperty("line.separator"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                writer.close();
                System.out.println("File telah di generate di " + location);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
