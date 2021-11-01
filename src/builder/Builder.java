package builder;

import inventory.CardInventory;
import inventory.builder.ItemInventoryBuilder;

public interface Builder<T,E> {
    T build();
    E setDataPath(String dataPath);
}
