public class Hotel {
    private final int propertyId;
    private final String hotelName;
    private final String source;

    public Hotel(int propertyId, String hotelName, String source) {
        this.propertyId = propertyId;
        this.hotelName = hotelName;
        this.source = source;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getSource() {
        return source;
    }
}
