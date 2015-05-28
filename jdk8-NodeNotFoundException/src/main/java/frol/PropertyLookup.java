package frol;

public interface PropertyLookup<T> {
    <V> V valueOf(Property<? super T, V> var1, V var2);

    <V> V valueOf(Property<? super T, V> var1, Donor<? extends V> var2);
}
