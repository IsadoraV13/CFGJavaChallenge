import java.util.Scanner;

public class FoodChoicesScore {
    public static String getUserInputFoodChoices() {
        String meatEater;
        String meatType;
        String meatFrequency;
        String foodChoice;
        String vegOrVegan;
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColours.GREEN_UNDERLINED + "SECTION 2:");
        System.out.println(ConsoleColours.GREEN + "Next we are going to ask you about the foods you eat."
                + ConsoleColours.RESET);
        System.out.println("Do you eat meat? Please answer with 'Y' or 'N'.");
        meatEater = input.nextLine().toLowerCase();
        while (!meatEater.equals("y") && !meatEater.equals("n")) {
            System.out.println("Remember to only respond with 'Y' or 'N'.");
            meatEater = input.nextLine().toLowerCase();
        }

        if (meatEater.equals("y")) {
            do {
                System.out.println("Do you eat meat bought at a supermarket/butcher (i.e. not wild) or only wild meat?");
                System.out.println("Please answer 'wild' if you only eat wild meat " +
                        "and answer 'not wild' if you buy meat from a supermarket/butcher.");
                meatType = input.nextLine().toLowerCase();
            }
            while (!meatType.equals("wild") && !meatType.equals("not wild"));
            if (meatType.equals("not wild")) {
                do {
                    System.out.println("Do you eat meat mostly daily or less frequently (i.e. a few times a week)?");
                    System.out.println("Please answer 'daily' or 'less'.");
                    meatFrequency = input.nextLine().toLowerCase();
                }
                while (!meatFrequency.equals("daily") && !meatFrequency.equals("less"));
                foodChoice = meatFrequency;
            } else foodChoice = meatType;

        } else {// i.e. if (meatEater.equals("n"))
            do {
                System.out.println("Are you vegan or vegetarian? Please answer 'vegan' or 'veg'.");
                vegOrVegan = input.nextLine().toLowerCase();
            }
            while (!vegOrVegan.equals("vegan") && !vegOrVegan.equals("veg"));
            foodChoice = vegOrVegan;
        }
        System.out.println("_____________________________________________________ \n");
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
}
