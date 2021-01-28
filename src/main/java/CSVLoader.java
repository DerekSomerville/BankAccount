import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

    private String delimitor = ",";
    private FileLoader fileLoader = new FileLoader();

    CSVLoader(){
        System.out.println("First constructor CSV Loader");
    }

    public void setFileLoader(FileLoader loadData){
        this.fileLoader = loadData;
    }

    public void setDelimitor(String delimitor){
        this.delimitor = delimitor;
    }

    protected List<String[]> getData(String fileName,List<String> rawFileData){
        List<String[]> fileData = new ArrayList<String[]>();
        for (String row: rawFileData){
            fileData.add(row.split(delimitor));
        }
        return fileData;
    }

    public List<String[]> getData(String fileName){
        List<String> rawFileData = fileLoader.getData(fileName);
        return getData(fileName,rawFileData);
    }

}
