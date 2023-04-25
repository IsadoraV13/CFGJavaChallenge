import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WasteAndRecyclingScore {
    public static String getUserInputWasteProduction() {
        Scanner input = new Scanner(System.in);
        String numCans;
        List<String> allowedUserResponses = Arrays.asList("less than 1", "1", "2", "3", "4+");
        System.out.println(ConsoleColours.GREEN_UNDERLINED + "SECTION 4:");
        System.out.println(ConsoleColours.GREEN + "This section looks at your waste production and recycling habits."
                + ConsoleColours.RESET);

        do {
            System.out.print("How many medium bin bags do you fill each week? ");
            System.out.println("Please respond with one of the following: 'less than 1', '1', '2', '3', '4+'");
            numCans = input.nextLine().toLowerCase();
        } while (!allowedUserResponses.contains(numCans));

        return numCans;
    }

    public static List<String> getUserInputRecycling() {
        Scanner input = new Scanner(System.in);
        String recycles;
        List<String> allowedUserResponses = Arrays.asList("glass", "paper", "plastic", "metal", "compost");
        String item = "";
        List<String> itemList = null;
        String recycledMaterial = "";

        do {
            System.out.print("Do you recycle? Please answer with 'Y' or 'N': ");
            recycles = input.nextLine().toLowerCase();
        } while (!recycles.equals("y") && !recycles.equals("n"));

        if (recycles.equals("y")) {
            System.out.println("What items do you recycle?");
            System.out.println("Please respond with a comma-separated list, only with items from this list: " +
                    "Glass, Plastic, Paper, Metal, Compost ");
            item = input.nextLine().toLowerCase();
            itemList = new ArrayList<String>(Arrays.asList(item.split(", ")));
            do {
                for (String response : itemList) {
                    recycledMaterial = response;
                    if (!allowedUserResponses.contains(response)) {
                        System.out.println("Please only list items that you recycle from this list: " +
                                "Glass, Plastic, Paper, Metal, Compost. Separate each item with a comma");
                        item = input.nextLine().toLowerCase();
                        itemList = new ArrayList<String>(Arrays.asList(item.split(", ")));
                        break;
                    }
                }
            } while (!allowedUserResponses.contains(recycledMaterial));
        }
        System.out.println("_________________________________________ \n");
        return itemList;
    }


    public static int wasteAndRecyclingCalculation(List<String> userRecycledItems, String numCans) {
        int score = 0;

        // calculate recycling score
        if (userRecycledItems != null) {
            int numRecycledItems = userRecycledItems.size();
            score += (20 - (4 * numRecycledItems));
        } else {
            score +=24;
        }

        // calculate waste production score
        switch(numCans) {
            case "less than 1":
                score += 5;
                break;
            case "1":
                score += 20;
                break;
            case "2":
                score += 30;
                break;
            case "3":
                score += 40;
                break;
            case "4+":
                score += 50;
                break;
        }
        return score;
    }

}
