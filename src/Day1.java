import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Day1 {

    public static void main(String[] args) {

        String filePath = "input.txt";

        List<Integer> leftColumn = new ArrayList<>();
        List<Integer> rightColumn = new ArrayList<>();

        int total = 0, difference = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.trim().split("\\s+");
                if (parts.length == 2) {
                    leftColumn.add(Integer.parseInt(parts[0]));
                    rightColumn.add(Integer.parseInt(parts[1]));
                }
            }

            Collections.sort(leftColumn);
            Collections.sort(rightColumn);


            System.out.println(difference = Day1.totalDistance(leftColumn, rightColumn));
            System.out.println(total = Day1.similarityScore(leftColumn, rightColumn));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static int totalDistance(List<Integer> leftColumn, List<Integer> rightColumn)
    {

        int diff = 0;
        for(int i=0; i<(leftColumn.size()+rightColumn.size())/2; i++)
        {
           diff = diff + Math.abs(leftColumn.get(i) - rightColumn.get(i));

        }
        return diff;

    }

    public static int similarityScore(List<Integer> leftColumn, List<Integer> rightColumn)
    {
        int sum = 0, count = 0;
        for(int i=0; i<(leftColumn.size()+rightColumn.size())/2; i++)
        {
            count = 0;
            for(int j=0; j<(leftColumn.size()+rightColumn.size())/2; j++)
            {
                if(Objects.equals(leftColumn.get(i), rightColumn.get(j)))
                {
                    count++;
                }
            }
            sum = sum + (leftColumn.get(i)*count);

        }

        return sum;

    }

}
