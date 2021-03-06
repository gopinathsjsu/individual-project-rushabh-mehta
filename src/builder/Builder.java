package builder;

import inventory.CardInventory;
import inventory.builder.ItemInventoryBuilder;

public interface Builder<T> {
    T build();
}
