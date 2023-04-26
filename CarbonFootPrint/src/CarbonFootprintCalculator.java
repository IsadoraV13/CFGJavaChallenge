import java.util.List;

import static java.lang.Thread.sleep;

public class CarbonFootprintCalculator {
    public static void main(String[] args) {
        System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT + "Welcome to our Carbon Footprint Calculator!\n" + ConsoleColours.RESET);

        // Call methods to get user input and pass to relevant variables
        String numberOfHouseMembers = HomeSizeScore.getUserInputNumberOfHouseMembers();
        String homeSize = HomeSizeScore.getUserInputHouseSize();
        String foodChoice = FoodChoicesScore.getUserInputFoodChoices();
        String garbageCans = WasteAndRecyclingScore.getUserInputWasteProduction();
        List<String> recycling = WasteAndRecyclingScore.getUserInputRecycling();
        int dishWasherFrequency = WaterConsumptionScore.getUserInputDishWasherWaterConsumption();
        int washingMachineFrequency = WaterConsumptionScore.getUserInputWashingMachineWaterConsumption();
        int[] totalTravel = TransportationScore.getUserInputTransportation();

        // Calculate user's total score
        int totalScore = HomeSizeScore.homeSizeCalculation(homeSize, numberOfHouseMembers) +
                FoodChoicesScore.foodChoiceCalculation(foodChoice)
                + WaterConsumptionScore.waterConsumptionCalculation(dishWasherFrequency, washingMachineFrequency)
                + WasteAndRecyclingScore.wasteAndRecyclingCalculation(recycling, garbageCans)
                + TransportationScore.TransportationCalculation(totalTravel);

        System.out.println(ConsoleColours.YELLOW_BRIGHT + "Are you ready to see your score?");
        try {
            sleep( 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(".");
        try {
            sleep( 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(".");
        try {
            sleep( 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(".");
        try {
            sleep( 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(ConsoleColours.GREEN_UNDERLINED + "\nFINAL SCORE" + ConsoleColours.RESET);
        System.out.println("Based on what you've told us, your carbon footprint is " + totalScore);

        System.out.println(ConsoleColours.GREEN_UNDERLINED + "\nWhat your score means:" + ConsoleColours.RESET);
        System.out.println("A low score is better than a high one as it means lower CO2 emissions.");
        Recommendation.scoreMeaning(totalScore);

        try {
            sleep( 2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Call RecomendationMessage method for tips
        Recommendation.recommendationMessage(FoodChoicesScore.foodChoiceCalculation(foodChoice),
                WaterConsumptionScore.waterConsumptionCalculation(dishWasherFrequency, washingMachineFrequency),
                WasteAndRecyclingScore.wasteAndRecyclingCalculation(recycling, garbageCans),
                TransportationScore.TransportationCalculation(totalTravel));
    }

}
