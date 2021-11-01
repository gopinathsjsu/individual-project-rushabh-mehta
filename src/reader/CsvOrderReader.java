package reader;

import item.Item;
import order.OrderItem;

import java.io.*;

public class CsvOrderReader implements CsvReader<OrderItem> {
    BufferedReader br;
    boolean headerRead = false;
    String[] headers = new String[0];
    private void getCsvReader(String path) throws FileNotFoundException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        this.br = new BufferedReader(fr);
    }

    public void open(String path){
        try {
            this.getCsvReader(path);
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
    public OrderItem read(){
        try {
            if(!headerRead){
                readHeader();
            }
            String line = this.br.readLine();
            if(line!=null){
                String[] itemData = line.split(",");
                if(itemData.length!=3){
                    return null;
                }
                String name = itemData[0];
                int quantity = Integer.parseInt(itemData[1]);
                String card = itemData[2];
                return new OrderItem(name, quantity, card);
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
}
