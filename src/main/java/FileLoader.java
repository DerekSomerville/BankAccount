import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader {
    private String filePathPrefix = "src/main/resources/";

    public List<String> getData(String fileName){
        List<String> fileData = new ArrayList<String>();
        try {
            File dataFile = new File(filePathPrefix + fileName);
            Scanner fileReader = new Scanner(dataFile);
            while (fileReader.hasNextLine()){
                fileData.add(fileReader.nextLine());
            }
        } catch (IOException ex){
            System.out.println("Example.LoadData.getData failed for " + fileName);
            ex.printStackTrace();
        }
        return fileData;
    }
}
