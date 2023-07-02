package spot_finder.entity;

public class Value {

    private int element_id;;

    private double value;

    public Value(int element_id, double value) {
        this.element_id = element_id;
        this.value = value;
    }

    public int getElement_id() {
        return element_id;
    }

    public void setElement_id(int element_id) {
        this.element_id = element_id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
