import java.util.Scanner;

public class CFPDraft {
    public static void main(String[] args) {
        String homeSize = getUserInputHouseSize();
        String foodChoice = getUserInputFoodChoices();
        int totalScore = homeSizeCalculation(homeSize) + foodChoiceCalculation(foodChoice);
        System.out.println("Your carbon footprint in relation to your house and food choices is "
                + totalScore);
        recommendation(foodChoiceCalculation(foodChoice), 6, 7);

    }

    public static String getUserInputHouseSize() {
        String homeSize;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How big would you say your house is? (as a guide, 3 bedrooms or more would be considered large and " +
                    "2 bedrooms would be medium)");
            System.out.println("Please choose amongst the following options: large, medium, small, apartment");
            homeSize = scanner.nextLine().toLowerCase();
        }
        while (!homeSize.equals("large") && !homeSize.equals("medium") && !homeSize.equals("small") &&
                !homeSize.equals("apartment"));
        return homeSize;
    }

    public static int homeSizeCalculation(String userHomeSize) {
        int score = 0;
        switch(userHomeSize) {
            case "large":
                score += 10;
                break;
            case "medium":
                score += 7;
                break;
            case "small":
                score += 4;
                break;
            case "apartment":
                score += 2;
                break;
        }
        return score;
    }

    public static String getUserInputFoodChoices() {
        String meatEater;
        String meatType;
        String meatFrequency;
        String vegOrVegan;
        String foodChoice = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you eat meat? Please answer Y or N");
            meatEater = scanner.nextLine().toLowerCase();
        }
        while (!meatEater.equals("y") && !meatEater.equals("n"));
        if (meatEater.equals("y")) {
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Do you meat bought at a supermarket/butcher (i.e. not wild) or only wild meat?");
                System.out.println("Please answer 'wild' if you only eat wild meat " +
                        "and answer 'not wild' if you buy meat from a supermarket/butcher");
                meatType = scanner.nextLine().toLowerCase();
            }
            while (!meatType.equals("wild") && !meatType.equals("not wild"));
            if (meatType.equals("not wild")) {
                do {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Do you eat meat mostly daily or less frequently (i.e. a few times a week)?");
                    System.out.println("Please answer 'daily' or 'less'");
                    meatFrequency = scanner.nextLine().toLowerCase();
                }
                while (!meatFrequency.equals("daily") && !meatFrequency.equals("less"));
                foodChoice = meatFrequency;
            } else foodChoice = meatType;

        } else {// i.e. if (meatEater.equals("n"))
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Are you vegan or vegetarian?");
                System.out.println("Please answer 'vegan' or 'veg'");
                vegOrVegan = scanner.nextLine().toLowerCase();
            }
            while (!vegOrVegan.equals("vegan") && !vegOrVegan.equals("veg"));
            foodChoice = vegOrVegan;
        }
        System.out.println("Food choice is " + foodChoice);
        return foodChoice;
    }

    public static int foodChoiceCalculation(String userFoodChoices) {
        int score = 0;
        switch(userFoodChoices) {
            case "daily":
                score += 10;
                break;
            case "less":
                score += 8;
                break;
            case "veg":
                score += 4;
                break;
            case "vegan", "wild":
                score += 2;
                break;
            default:
                System.out.println("invalid answer");
        }
        return score;
    }

    public static void recommendation(int userFoodChoice, int userWaterConsumption, int userSomethingElse) {
        int highestPossibleFoodChoiceScore = 10;
        int highestPossibleWaterConsumptionScore = 6;
        int highestPossibleSomethingElse = 7;

        String reduceFoodEmissionMessage = "";
        String reduceWaterConsumptionEmissionMessage = "";
        String reduceSomethingElseEmissionMessage = "";

        boolean reduceFoodEmission = userFoodChoice == highestPossibleFoodChoiceScore ? true : false;
        boolean reduceWaterConsumptionEmission = userWaterConsumption == highestPossibleWaterConsumptionScore ? true : false;
        boolean reduceSomethingElseEmission = userSomethingElse == highestPossibleSomethingElse ? true : false;

        
            if (reduceFoodEmission == true) {
                reduceFoodEmissionMessage = "\n- start varying your diet to include more wild meat";
            }
            if (reduceWaterConsumptionEmission == true) {
                reduceWaterConsumptionEmissionMessage = "\n- be mindful of how frequently you run the dishwasher" +
                        " and/or washing machine";
            }
            if (reduceSomethingElseEmission == true) {
                reduceSomethingElseEmissionMessage = "\n- something else";
            }


        System.out.println("A first step to reducing your CO2 emission would be to:" + reduceFoodEmissionMessage
                + reduceWaterConsumptionEmissionMessage + reduceSomethingElseEmissionMessage);
    }
}
