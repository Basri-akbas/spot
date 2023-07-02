package spot_finder.entity;

import java.util.List;

public class Data {
    private List<Node> nodes;
    private List<Element> elements;
    private List<Value> values;

    public Data(List<Node> nodes, List<Element> elements, List<Value> values) {
        this.nodes = nodes;
        this.elements = elements;
        this.values = values;
    }

    public Data() {
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }


}