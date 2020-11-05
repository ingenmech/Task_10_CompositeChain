package by.epam.evm.text.data.component;

public class Leaf implements Component {

    private final LeafType type;
    private final String value;

    public Leaf(LeafType type, String value) {
        this.type = type;
        this.value = value;
    }

    public LeafType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        if (type != leaf.type) {
            return false;
        }
        return value != null ? value.equals(leaf.value) : leaf.value == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
