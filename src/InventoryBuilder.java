public class InventoryBuilder {
    private String dataPath;
    public Inventory build(){
        Inventory inventory = Inventory.getInstance();
        FileItemReader reader = new CsvItemReader();
        CsvItemReader.ItemQuantity itemQuantity;
        int count = 0;
        reader.open(this.dataPath);
        reader.readHeader();
        while((itemQuantity = reader.readItem()) != null){
            count++;
            inventory.addItem(itemQuantity.getItem(),itemQuantity.getQuantity());
        }
        System.out.println(inventory.getInventory());
        System.out.println(count+" items added.");
        System.out.println("Inventory built!");
        return inventory;
    }

    public InventoryBuilder setDataPath(String dataPath) {
        this.dataPath = dataPath;
        return this;
    }
}
