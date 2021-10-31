public class CardInventoryBuilder {
    private String dataPath;
    public CardInventory build(){
        CardInventory inventory = CardInventory.getInstance();
        CsvReader<Card> reader = new CsvCardReader();
        Card card;
        int count = 0;
        reader.open(this.dataPath);
        reader.readHeader();
        while((card = (Card)reader.read()) != null){
            count++;
            inventory.addCard(card);
        }
        System.out.println(inventory.getInventory());
        System.out.println(count+" cards added.");
        System.out.println("Card Inventory built!");
        return inventory;
    }

    public CardInventoryBuilder setDataPath(String dataPath) {
        this.dataPath = dataPath;
        return this;
    }
}
