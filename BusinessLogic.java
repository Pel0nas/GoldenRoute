import java.util.Scanner;

public class BusinessLogic {
    public static void main(String[] args) {

        double cargoMass = getInput("Enter the mass of the cargo");

        while(cargoMass < 0) {
            cargoMass = getInput("Please enter a sensible size of mass");
        }

        double acceleration = calcAcceleration(cargoMass);
        double time = calcTakeoffTime(acceleration);
        double distance = calcTakeoffDistance(acceleration, time);

        System.out.println("distance: " + distance
                + "m\n" + "time: " + time + " seconds");

        if (isOverweight(cargoMass)) {
            System.out.println("Weight to cut off is: " + weightToCutOff(cargoMass) + "kg");
        }
    }

    public static double getInput(String prompt) {
        Scanner input = new Scanner(System.in);

        System.out.println(prompt);
        return input.nextDouble();
    }

    public static double calcAcceleration(double cargoMass) {
        final double PLANE_MASS = 35000;
        final double TOTAL_ENGINE_POWER = 100000;

        return TOTAL_ENGINE_POWER / (cargoMass + PLANE_MASS);
    }

    public static double calcTakeoffTime(double acceleration) {
        final double TAKEOFF_SPEED = 140;

        return TAKEOFF_SPEED / acceleration;
    }

    public static double calcTakeoffDistance(double acceleration, double time) {
        return 0.5 * acceleration * Math.pow(time, 2);
    }

    public static boolean isOverweight(double cargoMass) {
        return calcTakeoffTime(calcAcceleration(cargoMass)) > 60;
    }

    public static double weightToCutOff(double cargoMass) {
        final double PLANE_MASS = 35000;
        final double TOTAL_ENGINE_POWER = 100000;
        final double MAX_TAKEOFF_TIME = 60;
        final double SPEED = 140;

        double maxCargoMass = (TOTAL_ENGINE_POWER / (SPEED / MAX_TAKEOFF_TIME)) - PLANE_MASS;

        return cargoMass - maxCargoMass;
    }
}
