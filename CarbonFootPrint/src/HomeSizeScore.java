import java.util.Scanner;

public class HouseSizeScore {
    public static String getUserInputHouseSize() {
        String homeSize;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColours.GREEN_UNDERLINED + "SECTION 1:" );
        System.out.println(ConsoleColours.GREEN + "First, we are going to ask you about your household." + ConsoleColours.RESET);
        System.out.println("How big is your house? (as a guide, 3 bedrooms or more would be considered large and " +
                "2 bedrooms would be medium)");
        System.out.println("Please type one of the following options: large, medium, small, apartment");
        homeSize = scanner.nextLine().toLowerCase();
        while (!homeSize.equals("large") && !homeSize.equals("medium") && !homeSize.equals("small") &&
                !homeSize.equals("apartment")) {
            System.out.println("Remember to only respond with one of the following: large, medium, small, apartment");
            homeSize = scanner.nextLine();
        }
        System.out.println("_________________________________________ \n");
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
}
