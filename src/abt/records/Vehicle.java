package abt.records;

public record Vehicle(String type, int capacity, EVehicle eVehicle) {
    public static final String BUS = "Bus";

    public Vehicle {
        if (capacity > 100) throw new RuntimeException("Exceeds capacity");
    }

    record EVehicle(int batteryCapacity) {
        EVehicle {
            if (batteryCapacity < 0) throw new RuntimeException("Throw away!");
        }
    }
}
