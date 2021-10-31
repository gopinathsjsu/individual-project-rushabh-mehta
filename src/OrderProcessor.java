public class OrderProcessor {
    public static void main(String[] args){
        // prepare database
        // prepare card database
        // read input order csv file
        // process order
        // generate output total amount csv

        InventoryBuilder inventoryBuilder = new InventoryBuilder();

        // inventory is a singleton class
        Inventory inventory = inventoryBuilder.setDataPath(Path.datasetPath).build();


    }
}
