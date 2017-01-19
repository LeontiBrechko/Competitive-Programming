package lib.util;

public class Pair {
    private int key;
    private double value;

    public Pair(int key, double value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Pair && this.key == ((Pair) obj).key;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(key);
    }
}
