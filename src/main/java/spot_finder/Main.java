package spot_finder;

import spot_finder.entity.Value;
import spot_finder.utilities.MeshAnalyzer;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger=Logger.getLogger(Main.class.getName());

    public static void main(String[] args)  {

        if (args.length < 2) {
            System.out.println("Usage: java -jar [program name].jar <mesh file> <number of view spots>");
            return;
        }

        String jsonFilePath = args[0];
        int number = Integer.parseInt(args[1]);

        List<Value> viewSpots = MeshAnalyzer.findViewSpots(jsonFilePath,number);

      /*  logger.info("View Spots");
        for (Value viewSpot: viewSpots) {
            logger.info("{ element_id: "+viewSpot.getElement_id()+", value :<"+viewSpot.getValue()+">}");

        }*/

       System.out.println("View Spots");
        for (Value viewSpot: viewSpots) {
            System.out.println("{ element_id: "+viewSpot.getElement_id()+", value :<"+viewSpot.getValue()+">}");

        }

    }
}
