import java.io.*;
import java.util.Scanner;

public class CsvItemReader implements FileItemReader {
    BufferedReader br;
    boolean headerRead = false;
    String[] headers = new String[0];
    private void getCSVReader(String path) throws FileNotFoundException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        this.br = new BufferedReader(fr);
    }

    public void open(String path){
        try {
            this.getCSVReader(path);
        } catch (FileNotFoundException e) {
            this.close();
            System.out.println("No such file exists "+path);
        }
    }
    public String[] readHeader(){
        if(!headerRead){
            try {
                this.headers = this.br.readLine().split(",");
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.headerRead = true;
        }
        return this.headers;
    }
    public ItemQuantity readItem(){
        try {
            if(!headerRead){
                readHeader();
            }
            String line = this.br.readLine();
            if(line!=null){
                String[] itemData = line.split(",");
            if(itemData.length!=4){
                return null;
            }
            String category = itemData[0];
            String name = itemData[1];
            int quantity = Integer.parseInt(itemData[2]);
            double price = Double.parseDouble(itemData[3]);
            Item item = new Item(category, name, price);
            return new ItemQuantity(item, quantity);
            }else{
                return null;
            }

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

    class ItemQuantity{
        Item item;
        int quantity;

        public ItemQuantity(Item item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        public Item getItem() {
            return item;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
