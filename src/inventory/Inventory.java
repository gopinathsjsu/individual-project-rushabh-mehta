package inventory;

public interface Inventory<T,E> {
    boolean add(T object);
    E getInventory();
}