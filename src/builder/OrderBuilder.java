package builder;

public interface OrderBuilder<E> extends Builder{
    E setDataPath(String dataPath);
}
