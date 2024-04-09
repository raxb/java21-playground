package abt.records;

import java.util.Arrays;

public class RecordsMain {
    /*
    https://openjdk.org/jeps/395
    https://openjdk.org/jeps/440
     */

    public static void main(String[] args) {
        Vehicle.EVehicle eVehicle = new Vehicle.EVehicle(15000);
        Record vehicle = new Vehicle("Traveller", 10, eVehicle);
        System.out.println(vehicle);

        Record vehicle2 = new Vehicle("Traveller", 10, new Vehicle.EVehicle(15000));
        System.out.println("vehicle2.equals(vehicle) is " + vehicle2.equals(vehicle));//this is true!

        try {
            Record vehicle1 = new Vehicle("Monster Bus", 150, new Vehicle.EVehicle(25000));
            System.out.println(vehicle1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        MobileOS[] mobileOS = new MobileOS[]{new Android("Kit-Kat"), new Linux("Debian"), new iOS(14), new Oxygen(1),
                new Oxygen(5)};

        Arrays.stream(mobileOS).forEach(os -> {
            switch (os) {
                case Linux l -> System.out.println(l.distribution());
                case Android android -> System.out.println(android.name());
                case Oxygen oxygen when oxygen.customVersion()>2 -> System.out.println(oxygen.customVersion());
                case Oxygen oy -> System.out.println("Oxygen requires beefing up! "+oy.customVersion());
                case null -> System.out.println("null");
                case iOS ios -> System.out.println(ios.version());
            }
        });
    }
}
