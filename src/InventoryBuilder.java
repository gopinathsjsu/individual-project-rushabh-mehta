public class InventoryBuilder {
    private String dataPath;
    public Inventory build(){
        Inventory inventory = Inventory.getInstance();
        FileItemReader reader = new CsvItemReader();
        reader.open(this.dataPath);
        int count = 0;
        String line;
        reader.next(); // skip the header row
        while((line = reader.next()) != null){
            count++;
            inventory.addItem(line);
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
