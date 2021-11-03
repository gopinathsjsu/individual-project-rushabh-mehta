package inventory.builder;

import builder.Builder;
import builder.InventoryBuilder;
import card.Card;
import inventory.CardInventory;
import reader.CsvCardReader;
import reader.CsvReader;

public class CardInventoryBuilder implements InventoryBuilder {
    private String dataPath;
    public CardInventory build(){
        System.out.println("Building card inventory!");
        CardInventory inventory = CardInventory.getInstance();
        CsvReader<Card> reader = new CsvCardReader();
        Card card;
        int count = 0;
        reader.open(this.dataPath);
        reader.readHeader();
        while((card = reader.read()) != null){
            count++;
            inventory.add(card);
        }
        System.out.println(count+" cards added.");
        System.out.println("Card Inventory built!");
        return inventory;
    }

    public CardInventoryBuilder setDataPath(String dataPath) {
        this.dataPath = dataPath;
        return this;
    }
}
