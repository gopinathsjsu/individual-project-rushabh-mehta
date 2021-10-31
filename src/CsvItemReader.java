import java.io.*;
import java.util.Scanner;

public class CsvItemReader implements FileItemReader {
    BufferedReader br;

    private void getCSVScanner(String path) throws FileNotFoundException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        this.br = new BufferedReader(fr);
    }

    public void open(String path){
        try {
            this.getCSVScanner(path);
        } catch (FileNotFoundException e) {
            this.close();
            System.out.println("No such file exists "+path);
        }
    }
    public String next(){
        try {
            return this.br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void close(){
        try {
            this.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
