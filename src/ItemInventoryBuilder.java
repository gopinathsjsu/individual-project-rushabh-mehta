public class ItemInventoryBuilder {
    private String dataPath;
    public ItemInventory build(){
        ItemInventory inventory = ItemInventory.getInstance();
        CsvReader<CsvItemReader.ItemQuantity> reader = new CsvItemReader();
        CsvItemReader.ItemQuantity itemQuantity;
        int count = 0;
        reader.open(this.dataPath);
        reader.readHeader();
        while((itemQuantity = (CsvItemReader.ItemQuantity) reader.read()) != null){
            count++;
            inventory.addItem(itemQuantity.getItem(),itemQuantity.getQuantity());
        }
        System.out.println(inventory.getInventory());
        System.out.println(count+" items added.");
        System.out.println("Inventory built!");
        return inventory;
    }

    public ItemInventoryBuilder setDataPath(String dataPath) {
        this.dataPath = dataPath;
        return this;
    }
}
