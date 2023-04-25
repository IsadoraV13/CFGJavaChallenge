import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HomeSizeScore {

    public static String getUserInputNumberOfHouseMembers() {
        String numHouseMembers;
        Scanner input = new Scanner(System.in);
        List<String> allowedUserResponses = Arrays.asList("0", "1", "2", "3", "4", "5", "5+");
        System.out.println(ConsoleColours.GREEN_UNDERLINED + "SECTION 1:" );
        System.out.println(ConsoleColours.GREEN + "First, we are going to ask you about your household." + ConsoleColours.RESET);

        do {
            System.out.println("How many people do you share your house with?");
            System.out.println("Please respond with one of the following options: " +
                    "'0' (i.e. you live alone), '1', '2', '3', '4', '5' or '5+'");
            numHouseMembers = input.nextLine().toLowerCase();
        }
        while (!allowedUserResponses.contains(numHouseMembers));
        return numHouseMembers;
    }

    public static String getUserInputHouseSize() {
        String homeSize;
        Scanner input = new Scanner(System.in);
        List<String> allowedUserResponses = Arrays.asList("large", "medium", "small", "flat");
        System.out.println("How big is your house? (3 bedrooms or more would be considered large and " +
                "2 bedrooms would be medium. A flat is a self-contained unit within a larger property block)");
        System.out.println("Please respond with one of the following options: large, medium, small, flat");
        homeSize = input.nextLine().toLowerCase();
        while (!allowedUserResponses.contains(homeSize)) {
            System.out.println("Remember to only respond with one of the following: large, medium, small, flat");
            homeSize = input.nextLine();
        }
        System.out.println("_____________________________________________________ \n");
        return homeSize;
    }

    public static int homeSizeCalculation(String HomeSize, String numberOfHouseMembers) {
        int score = 0;
        switch(HomeSize) {
            case "large":
                score += 10;
                break;
            case "medium":
                score += 7;
                break;
            case "small":
                score += 4;
                break;
            case "flat":
                score += 2;
                break;
        }

        switch(numberOfHouseMembers) {
            case "0":
                score += 14;
                break;
            case "1":
                score += 12;
                break;
            case "2":
                score += 10;
                break;
            case "3":
                score += 8;
                break;
            case "4":
                score += 6;
                break;
            case "5":
                score += 4;
                break;
            case "5+":
                score += 2;
                break;
        }

        return score;
    }
}
