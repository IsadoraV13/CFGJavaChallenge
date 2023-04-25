import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recommendation {
    public static void scoreMeaning(int score) {
        System.out.println("A low score is better than a high one as it means lower CO2 emissions.");
        if (score <= 49) {
            System.out.println("Your score is less than 50, meaning your carbon footprint is relatively small, "
                    + ConsoleColours.GREEN_BOLD_BRIGHT + "WELL DONE!!" + ConsoleColours.RESET);
            System.out.println("Of course, there are always more ways to keep working at reducing your carbon footprint.\n");
        } else {
            System.out.println("Your score is higher than 50, meaning you may want to start looking at ways " +
                    "to reduce the carbon footprint of your daily habits.\n");
        }
    }


    public static void recommendationMessage(int userFoodChoiceScore, int userWaterConsumptionScore,
                                             int userWasteAndRecyclingScore, int userTransportationScore) {
        String tips;
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColours.YELLOW_BRIGHT + "Would you like some tips on how to reduce your CO2 emission? (Y / N)"
                + ConsoleColours.RESET);
        tips = input.nextLine().toLowerCase();
        while (!tips.equals("y") && !tips.equals("n")) {
            System.out.println("Please only respond with 'Y' or 'N'");
            tips = input.nextLine();
        }

        if (tips.equals("y") ){
            List<String> recommendation = new ArrayList<>();
            if (userFoodChoiceScore >= 8) {
                recommendation.add("- start varying your diet to include more wild meat");
            }

            if (userWaterConsumptionScore >= 3) {
                recommendation.add("- being mindful of how frequently you run the dishwasher and/or washing machine");
            }

            if (userWasteAndRecyclingScore >= 38) {
                recommendation.add("- recycling more of your household waste; your local council will have information " +
                        "about what can be recycled and on what days it is collected");
            }

            if (userTransportationScore >= 38) {
                recommendation.add("- using public transport, cycling or walking for short distances. " +
                        "For longer distances, opt for rail travel or consider setting up video calls " +
                        "to cut back on any unnecessary business travel, for example");
            }
            System.out.println(ConsoleColours.YELLOW + "You may want to consider the following:");

            if (!recommendation.isEmpty()) {
                recommendation.forEach(System.out::println);
            } else {
            System.out.println("- Reducing the overall amount of non-recyclable waste you produce");
            System.out.println("- Taking shorter showers and/or turning off the tap when brushing your teeth");
            System.out.println("- Cutting back on AC or heating, where you can as they require a lot of energy, " +
                    "usually sourced from fossil fuels");
            }
            System.out.println("\nFor more information on items that can't be recycled at home: https://www.recyclenow.com");
            }
        System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT +
                "\n_______________________THANK YOU FOR USING OUR CALCULATOR_______________________ \n" + ConsoleColours.RESET);
    }
}
