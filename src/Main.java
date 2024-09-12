import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Helpers helpers = new Helpers();

        List<Hotel> hotels = Arrays.asList(
                new Hotel(1, "ABC, cdf", "agoda"),
                new Hotel(2, "ABC cdf", "expedia"),
                new Hotel(3, "XYZ & DEF", "agoda"),
                new Hotel(4, "XYZ and DEF", "expedia"),
                new Hotel(5, "GHI", "agoda")
        );

        // Execute the matching function
        Map<Integer, Integer> seenMap = new HashMap<>();
        List<Map<String, Object>> matchedResults = helpers.matchHotels(hotels, seenMap);

        // Print matched results
        System.out.println("Matched Results:");
        matchedResults.forEach(System.out::println);

        // Print seen map
        System.out.println("\nSeen Map:");
        seenMap.forEach((propertyId, seen) -> System.out.println("Property ID: " + propertyId + ", Seen: " + seen));

    }
}