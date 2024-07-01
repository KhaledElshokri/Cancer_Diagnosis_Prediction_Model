package KdTree;


import java.util.*;
import java.io.*;
import java.nio.file.*;

public class KdTreeTest {
    public static void main(String[] args) throws IOException {
    	
    	 long startTime1 = System.currentTimeMillis();
         runTest(50);
         long initialEndTime = System.currentTimeMillis();
         long Runtime = initialEndTime - startTime1;
         System.out.println("Runtime is: " + Runtime + " ms");
    	
            
            
     
    }

    private static void runTest(int size) throws IOException {
        List<kdtree.Node> data = loadData("data_standarised.csv");
        Collections.shuffle(data);
        
        
        int testSize = size / 4; // 1/4 of the data is for testing
        int trainSize = size - testSize; // 3/4 of the data is for training

        List<kdtree.Node> trainData = data.subList(0, trainSize);
        List<kdtree.Node> testData = data.subList(trainSize, size);

        kdtree tree = new kdtree(10, trainData);
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8"); // the results will be outputed in a file called output.txt
       int count =0;
       //int correctCount3 = 0;
       int correctCount5 = 0;
       //int correctCount7 = 0;
        for (kdtree.Node testNode : testData) {
        	   count ++;
               // List<kdtree.Node> nearest3 = tree.findNearest(testNode, 3);
                List<kdtree.Node> nearest5 = tree.findNearest(testNode, 5);
                //List<kdtree.Node> nearest7 = tree.findNearest(testNode, 7);
                //if (calculateAccuracy(testNode, nearest3)) correctCount3++;
               if (calculateAccuracy(testNode, nearest5)) correctCount5++;
                //if (calculateAccuracy(testNode, nearest7)) correctCount7++;

                writer.println("Test data (" + size + " points):");
                writer.println("target: " + testNode);
                //writer.println("3 nearest points: " + nearest3);
               writer.println("5 nearest points: " + nearest5);
               // writer.println("7 nearest points: " + nearest7);
                writer.println(count);
                writer.println();
            }
        //writer.println("Accuracy for k = 3: " + ((double)correctCount3 / count) * 100 + "%");
       writer.println("Accuracy for k = 5: " + ((double)correctCount5 / count) * 100 + "%");
       // writer.println("Accuracy for k = 7: " + ((double)correctCount7 / count) * 100 + "%");
            writer.close();
        }
    private static boolean calculateAccuracy(kdtree.Node testNode, List<kdtree.Node> nearestNodes) {
        int positiveCount = 0;
        int negativeCount = 0;

        for (kdtree.Node node : nearestNodes) {
            if (node.getdiagnosis().equals(testNode.getdiagnosis())) {
                positiveCount++;
            } else {
                negativeCount++;
            }
        }

        boolean majorityDiagnosis = positiveCount > negativeCount ? true : false;
        return majorityDiagnosis;
    }
        
    

    private static List<kdtree.Node> loadData(String filename) throws IOException {
        List<kdtree.Node> data = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/" +filename))) {
            String line;
            reader.readLine(); // Skip the header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String diagnosis = parts[1];
                double[] coords = new double[10];
                for (int i = 0; i < coords.length; ++i) {
                    coords[i] = Double.parseDouble(parts[i + 2]);
                }
                data.add(new kdtree.Node(id, diagnosis, coords));
            }
        }
        return data;
    }
}