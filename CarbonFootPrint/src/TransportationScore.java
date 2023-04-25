import java.util.Scanner;

public class TransportationScore {
    public static int getUserInputTransportation() {
        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println(ConsoleColours.GREEN_UNDERLINED + "SECTION 5:");
        System.out.println(ConsoleColours.GREEN + "How many miles do you travel in your personal vehicle per year? "
                + ConsoleColours.RESET);
        System.out.println("(Please answer with a whole number without separating commas)"); //added this
        while (!input.hasNextInt()) { // added this
            System.out.println("Remember to input a whole number (without decimals or commas)");
            input.next(); // added this
        }
        int personalMiles = input.nextInt();

        if (personalMiles > 15000) {
            score += 12;
        } else if (personalMiles >= 10000) {
            score += 10;
        } else if (personalMiles >= 1000) {
            score += 6;
        } else if (personalMiles < 1000 && personalMiles >= 0) {
            score += 4;
        }


        System.out.println("How many miles do you travel on public transportation per year? ");
        System.out.println("(Again, please only answer with a whole number without commas)"); //added this
        int publicMiles = input.nextInt();

        if (publicMiles > 20000) {
            score += 12;
        } else if (publicMiles >= 15000) {
            score += 10;
        } else if (publicMiles >= 10000) {
            score += 6;
        } else if (publicMiles >= 1000) {
            score += 4;
        } else if (publicMiles < 1000 && publicMiles >= 0) {
            score += 2;
        }

        System.out.println("Next we will try to work out how far you travel by plane. Below are examples to help");
        System.out.println("Short haul flight example: London to Berlin or Warsaw");
        System.out.println("Medium haul flight example: London to Athens or Cairo ");
        System.out.println("Long haul flight example: anywhere further than the above");
        System.out.println("\nHow many of each type of flight do you take in a typical year? Only enter whole numbers");
        System.out.print("Number of short haul flights: ");
        while (!input.hasNextInt()) {
            System.out.println("Please input a whole number (without decimals or commas)");
            input.next();
        }
        int shortHaulFlights = input.nextInt();
        input.next();

        System.out.print("Number of medium haul flights: ");
        while (!input.hasNextInt()) {
            System.out.println("Please input a whole number (without decimals or commas)");
            input.next();
        }
        int mediumHaulFlights = input.nextInt();

        System.out.print("Number of long haul flights: ");
        while (!input.hasNextInt()) {
            System.out.println("Please input a whole number (without decimals or commas)");
            input.next();
        }
        int longHaulFlights = input.nextInt();
        System.out.println("_________________________________________ \n");
        return score;

//        if (flightMiles < 1000) {
//            score += 2;
//        } else if (flightMiles >= 1000 && flightMiles < 5000) {
//            score += 6;
//        } else if (flightMiles >= 5000) {
//            score += 20;
//        }

    }
}
