import java.util.List;

public class CFPDraft {
    public static void main(String[] args) {
        System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT + "Welcome to our Carbon Footprint Calculator!\n" + ConsoleColours.RESET);

        // Call methods for user input and pass to relevant variables
        String numberOfHouseMembers = HomeSizeScore.getUserInputNumberOfHouseMembers();
        String homeSize = HomeSizeScore.getUserInputHouseSize();
        String foodChoice = FoodChoicesScore.getUserInputFoodChoices();
        String garbageCans = WasteAndRecyclingScore.getUserInputWasteProduction();
        List<String> recycling = WasteAndRecyclingScore.getUserInputRecycling();
        int dishWasherFrequency = WaterConsumptionScore.getUserInputDishWasherWaterConsumption();
        int washingMachineFrequency = WaterConsumptionScore.getUserInputWashingMachineWaterConsumption();

        System.out.println("\n________Checks_________________________________ ");
        System.out.println("Home size score " + HomeSizeScore.homeSizeCalculation(homeSize, numberOfHouseMembers));
        System.out.println("Food choice score " + FoodChoicesScore.foodChoiceCalculation(foodChoice));
        System.out.println("Water score " + WaterConsumptionScore.waterConsumptionCalculation(dishWasherFrequency,
                washingMachineFrequency));
        System.out.println("Waste & R score " + WasteAndRecyclingScore.wasteAndRecyclingCalculation(recycling, garbageCans));
        System.out.println("________Checks_________________________________ \n");

        // Calculate user's total score
        int totalScore = HomeSizeScore.homeSizeCalculation(homeSize, numberOfHouseMembers) +
                FoodChoicesScore.foodChoiceCalculation(foodChoice)
                + WaterConsumptionScore.waterConsumptionCalculation(dishWasherFrequency, washingMachineFrequency)
                + WasteAndRecyclingScore.wasteAndRecyclingCalculation(recycling, garbageCans);
        System.out.println(ConsoleColours.GREEN_UNDERLINED + "FINAL SCORE" + ConsoleColours.RESET);
        System.out.println("Based on what you've told us, your carbon footprint is " + totalScore);

        System.out.println(ConsoleColours.GREEN_UNDERLINED + "\nWhat your score means:" + ConsoleColours.RESET);
        Recommendation.scoreMeaning(totalScore);


//      call RecomendationMessage method to get tips
        Recommendation.recommendationMessage(FoodChoicesScore.foodChoiceCalculation(foodChoice),
                WaterConsumptionScore.waterConsumptionCalculation(dishWasherFrequency, washingMachineFrequency),
                WasteAndRecyclingScore.wasteAndRecyclingCalculation(recycling, garbageCans), 7);
    }

}
