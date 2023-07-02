package spot_finder.utilities;

import spot_finder.entity.Data;
import spot_finder.entity.Element;
import spot_finder.entity.Node;
import spot_finder.entity.Value;

import java.util.*;

public class MeshAnalyzer {

     static List<Node> nodes;
    static List<Element> elements;
    static List<Value> values;

    public static List<Value> findViewSpots(String filename, int N) {

       Data data= DataReader.reader(filename);

       nodes=data.getNodes();
       elements=data.getElements();
       values=data.getValues();

        Collections.sort(elements, Comparator.comparingDouble(element -> getValueForElement(element, values)));

        List<Value> viewSpots = new ArrayList<>();
        Set<Integer> visitedNodes = new HashSet<>();

        for (Element element : elements) {
            if (isViewSpot(element, elements, values, visitedNodes)) {
                double value=getValueForElement(element,values);
                Value value1=new Value(element.getId(), value);
                viewSpots.add(value1);
                visitedNodes.addAll(element.getNodes());
                if (viewSpots.size() >= N) {
                    break;
                }
            }
        }

        return viewSpots;


    }

    private static boolean isViewSpot(Element element, List<Element> elements, List<Value> values, Set<Integer> visitedNodes) {
        double elementHeight = getValueForElement(element, values);

        for (Element neighbor : elements) {
            if (element != neighbor && hasSharedNodes(element, neighbor)) {
                double neighborHeight = getValueForElement(neighbor, values);
                if (neighborHeight >= elementHeight) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean hasSharedNodes(Element element1, Element element2) {
        List<Integer> nodeIds1 = element1.getNodes();
        List<Integer> nodeIds2 = element2.getNodes();

        for (int nodeId : nodeIds1) {
            if (nodeIds2.contains(nodeId)) {
                return true;
            }
        }

        return false;
    }

    private static double getValueForElement(Element element, List<Value> values) {
        int elementId = element.getId();

        for (Value value : values) {
            if (value.getElement_id() == elementId) {
                return value.getValue();
            }
        }

        return 0.0;
    }
}
