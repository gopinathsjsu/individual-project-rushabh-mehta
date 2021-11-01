package builder;

public interface RestrictionBuilder<E> extends Builder{
    E setRestriction(String category, int quantity);
}
