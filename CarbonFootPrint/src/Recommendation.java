import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recommendation {
    public static void scoreMeaning(int score) {
        if (score <= 39) {
            System.out.println("Your score is less than 40, meaning your carbon footprint is relatively small, "
                    + ConsoleColours.GREEN_BOLD_BRIGHT + "WELL DONE!!" + ConsoleColours.RESET);
            System.out.println("Of course, there are always more ways to keep working at reducing your footprint.\n");
        } else {
            System.out.println("Your score is higher than 40, meaning you may want to start looking at ways " +
                    "to reduce the carbon footprint linked to your daily habits.\n");
        }
    }


    public static void recommendationMessage(int userFoodChoiceScore, int userWaterConsumptionScore,
                                             int userWasteAndRecyclingScore, int userTransportationScore) {
        String tips;
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColours.YELLOW_BRIGHT + "Would you like some tips on how to reduce your carbon " +
                "footprint? (Y / N)" + ConsoleColours.RESET);
        tips = input.nextLine().toLowerCase();
        while (!tips.equals("y") && !tips.equals("n")) {
            System.out.println("Please only respond with 'Y' or 'N'");
            tips = input.nextLine();
        }

        if (tips.equals("y") ){
            List<String> recommendation = new ArrayList<>();
            if (userFoodChoiceScore >= 8) {
                recommendation.add("- varying your diet to cut back on meat or opting for wild meat");
            }

            if (userWaterConsumptionScore >= 3) {
                recommendation.add("- being mindful of how frequently you run the dishwasher and/or washing machine");
            }

            if (userWasteAndRecyclingScore >= 28) {
                recommendation.add("- recycling more of your household waste; your local council will have information " +
                        "about what can be recycled and on what days it is collected");
            }

            if (userTransportationScore >= 18) {
                recommendation.add("- using public transport, cycling or walking for short distances");
                recommendation.add("- opting for rail travel for longer domestic distances, or considering video calls " +
                        "to cut back on unnecessary local or foreign business travel");
            }
            System.out.println(ConsoleColours.YELLOW + "You may want to consider the following:");

            if (!recommendation.isEmpty()) {
                recommendation.forEach(System.out::println);
            } else {
            System.out.println("- reducing the overall amount of waste you produce, e.g. by repurposing or donating");
            System.out.println("- taking shorter showers and/or turning off the tap when brushing your teeth");
            System.out.println("- cutting back on AC or heating where you can as they require a lot of energy, " +
                    "usually sourced from fossil fuels");
            }
            System.out.println(ConsoleColours.YELLOW_UNDERLINED + "\nUseful Links");
            System.out.println(ConsoleColours.YELLOW + "Where to recycle items that can't be recycled at home based on your postcode: https://www.recyclenow.com"
                    + ConsoleColours.RESET);
            }
        System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT +
                "\n_______________________THANK YOU FOR USING OUR CALCULATOR_______________________ \n" + ConsoleColours.RESET);
    }
}
