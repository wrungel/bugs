package frol;

public class PropertyValue<T, V> {
    private final Property<T, V> property;
    private final Donor<? extends V> valueDonor;

    public PropertyValue(Property<T, V> property, Donor<? extends V> valueDonor) {
        this.property = property;
        this.valueDonor = valueDonor;
    }

    public Property<T, V> property() {
        return this.property;
    }

    public V value() {
        return this.valueDonor.value();
    }
}
