import java.util.Scanner;

public class TransportationScore {
    public static int[] getUserInputTransportation() {
        Scanner input = new Scanner(System.in);
        int[] totalKm = new int[3];

        System.out.println(ConsoleColours.GREEN_UNDERLINED + "SECTION 5:");
        System.out.println(ConsoleColours.GREEN + "Next we will try to work out how far you travel via different modes " +
                "of transport." + ConsoleColours.RESET);
        System.out.println("How many kilometres do you travel in a personal vehicle per year? ");
        System.out.println("As a guide, the average Londoner who uses a car travels about 600km as a car driver and " +
                "300km as a passenger. \nThis does not include trips outside Greater London, so you would need to add " +
                "holiday trips and adhoc travel on top");
        System.out.println("(Please answer with a whole number without commas)");

        while (!input.hasNextInt()) {
            System.out.println("Remember to input a whole number (without decimals or commas)");
            input.next();
        }
        int personalKm = input.nextInt();
        System.out.println("personalK" + personalKm);


        System.out.println("\nHow many kilometres do you travel on public transportation per year?");
        System.out.println("As a guide, the average person travels about 1700km within Greater London");
        System.out.println("(Please answer with a whole number without commas)");
        while (!input.hasNextInt()) {
            System.out.println("Remember to input a whole number (without decimals or commas)");
            input.next();
        }
        int publicKm = input.nextInt();


        System.out.println("\nNext we will try to estimate how much air travel you do. Below is some guidance:");
        System.out.println("- Example of a short haul flight: London to Berlin or Warsaw");
        System.out.println("- Example of a medium haul flight: London to Athens or Cairo ");
        System.out.println("- A long haul flight is anywhere further than the above");
        System.out.println("\nHow many of each type of trip do you make in a typical year? " +
                "(Count flying out and back as 1 trip. Please only enter whole numbers)");

        System.out.print("Number of short haul trips: ");
        while (!input.hasNextInt()) {
            System.out.println("Please input a whole number (without decimals or commas)");
            input.next();
        }
        int shortHaulFlights = input.nextInt();

        System.out.print("Number of medium haul trips: ");
        while (!input.hasNextInt()) {
            System.out.println("Please input a whole number (without decimals or commas)");
            input.next();
        }
        int mediumHaulFlights = input.nextInt();

        System.out.print("Number of long haul trips: ");
        while (!input.hasNextInt()) {
            System.out.println("Please input a whole number (without decimals or commas)");
            input.next();
        }
        int longHaulFlights = input.nextInt();

        // Adding all types of flights to calculate total km
            // Assumption: average short haul = 1000, average medium haul = 2500, average long haul = 10000
            // multiplied by 2 to account for each leg
        int travelKm = (shortHaulFlights * 1000 * 2) + (mediumHaulFlights * 2500 * 2) + (longHaulFlights * 10000 * 2);
        totalKm[0] = personalKm;
        totalKm[1] = publicKm;
        totalKm[2] = travelKm;

        System.out.println("_________________________________________ \n");
        return totalKm;
    }

    public static int TransportationCalculation(int[] totalKm) {
        int score = 0;
        int personalKm = totalKm[0];
        int publicKm = totalKm[1];
        int travelKm = totalKm[2];

        // private vehicle
        if (personalKm > 5000) {
            score += 8;
        } else if (personalKm >= 1500) {
            score += 6;
        } else if (personalKm > 0) {
            score += 4;
        }

        // public transport
        if (publicKm >= 5000) {
            score += 6;
        } else if (publicKm >= 1500) {
            score += 4;
        } else if (publicKm > 0) {
            score += 2;
        }

        // air travel
        if (travelKm <= 4000) {
            score += 2;
        } else if (travelKm < 10000) {
            score += 6;
        } else {
            score += 20;
        }
        return score;
    }
}
