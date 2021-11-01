package builder;

public interface InventoryBuilder<E> extends Builder{
    E setDataPath(String dataPath);
}
