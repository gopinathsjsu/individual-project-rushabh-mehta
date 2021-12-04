package inventory.builder;

import builder.Builder;
import builder.InventoryBuilder;
import card.Card;
import inventory.CardInventory;
import item.Item;
import reader.CsvCardReader;
import reader.CsvReader;

import java.util.Map;
import java.util.Set;

public class CardInventoryBuilder implements InventoryBuilder {
    private String dataPath;
    public CardInventory build(){
        System.out.println("===============");
        System.out.println("Building Card Inventory!");
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
        printCardInventory(inventory.getInventory());
        System.out.println("Card Inventory built!");
        System.out.println("===============");
        return inventory;
    }

    public CardInventoryBuilder setDataPath(String dataPath) {
        this.dataPath = dataPath;
        return this;
    }

    public void printCardInventory(Set<Card> set){
        for (Card card :
                set ) {
            System.out.println(card);
        }
    }
}
