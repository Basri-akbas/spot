package spot_finder.utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import spot_finder.entity.Data;
import spot_finder.entity.Element;
import spot_finder.entity.Node;
import spot_finder.entity.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static Data reader(String filePath) {


         List<Node> nodes = null;
         List<Element> elements = null;
         List<Value> values = null;

        try {

            String jsonData = Files.readString(Path.of(filePath));

            JSONObject meshData = new JSONObject(jsonData);

            JSONArray nodesArray = meshData.getJSONArray("nodes");
            nodes=new ArrayList<>();

           for (int i = 0; i < nodesArray.length(); i++) {
                JSONObject node = nodesArray.getJSONObject(i);
                int nodeId = node.getInt("id");
                double x = node.getDouble("x");
                double y = node.getDouble("y");

               Node newNode=new Node(nodeId,x,y);
               nodes.add(newNode);

            }

            JSONArray elementsArray = meshData.getJSONArray("elements");
            elements = new ArrayList<>();
            for (int i = 0; i < elementsArray.length(); i++) {
                JSONObject element = elementsArray.getJSONObject(i);
                int elementId = element.getInt("id");
                JSONArray nodeIdsArray = element.getJSONArray("nodes");

                List<Integer> nodeIds = new ArrayList<>();
                for (int j = 0; j < nodeIdsArray.length(); j++) {
                    int nodeId = nodeIdsArray.getInt(j);
                    nodeIds.add(nodeId);
                }

                Element newElement =new Element(elementId, nodeIds);
                elements.add(newElement );

            }

            JSONArray valuesArray = meshData.getJSONArray("values");
            values = new ArrayList<>();
            for (int i = 0; i < valuesArray.length(); i++) {
                JSONObject value = valuesArray.getJSONObject(i);
                int elementId = value.getInt("element_id");
                double scalarValue = value.getDouble("value");

                Value newValue=new Value(elementId,scalarValue);
                values.add(newValue);

            }


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return new Data(nodes,elements,values);

    }
}
