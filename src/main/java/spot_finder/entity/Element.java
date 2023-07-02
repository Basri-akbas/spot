package spot_finder.entity;

import java.util.ArrayList;
import java.util.List;

public class Element {

    private int id;
    private List<Integer> nodes;

    public Element(int id, List<Integer> nodes) {
        this.id = id;
        this.nodes = nodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Integer> nodes) {
        this.nodes = nodes;
    }
}
