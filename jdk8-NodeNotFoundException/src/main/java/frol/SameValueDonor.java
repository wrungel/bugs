package frol;

public class SameValueDonor<T> implements Donor<T> {
    private final T value;

    public SameValueDonor(T value) {
        this.value = value;
    }

    public T value() {
        return this.value;
    }
}

