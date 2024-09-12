import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Helpers {
    public  String preprocessName(String name) {
        // Convert name to lowercase
        name = name.toLowerCase();
        // Replace '&' with 'and'
        name = name.replace("&", "and");
        // Remove commas
        name = name.replace(",", "");
        // Remove extra spaces
        name = name.trim().replaceAll("\\s+", " ");
        return name;
    }

    public List<Map<String, Object>> matchHotels(List<Hotel> hotels, Map<Integer, Integer> seenMap) {
        // Preprocess hotel names and group by processed name
        Map<String, List<Hotel>> processedNames = hotels.stream()
                .collect(Collectors.groupingBy(hotel -> preprocessName(hotel.getHotelName())));

        List<Map<String, Object>> matchedResults = new ArrayList<>();

        // Check for matches and update 'seen' map
        for (List<Hotel> hotelList : processedNames.values()) {
            if (hotelList.size() > 1) {
                // If multiple entries have the same processed name, assume they are a match
                for (Hotel hotel : hotelList) {
                    seenMap.put(hotel.getPropertyId(), 1);
                    Map<String, Object> result = new HashMap<>();
                    result.put("property_id", hotel.getPropertyId());
                    result.put("hotel_name", hotel.getHotelName());
                    result.put("source", hotel.getSource());
                    matchedResults.add(result);
                }
            }
        }

        return matchedResults;
    }
}
