package inventory;

import card.Card;

import java.util.HashSet;
import java.util.Set;

public class CardInventory implements Inventory<Card,Set<Card>>{
    private Set<Card> inventory;
    private static CardInventory instance = null;

    private CardInventory() {
        inventory = new HashSet<>();
    }

    public static CardInventory getInstance(){
        if(instance==null){
            instance = new CardInventory();
        }
        return instance;
    }

    public boolean add(Card card){
        inventory.add(card);
        return true;
    }

    public Set<Card> getInventory() {
        return inventory;
    }
}
