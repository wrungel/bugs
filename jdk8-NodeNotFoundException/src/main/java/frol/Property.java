package frol;

public class Property<T, V> {
    public Property() {
    }

    public static <T, V> Property<T, V> newProperty() {
        return new Property();
    }
}
