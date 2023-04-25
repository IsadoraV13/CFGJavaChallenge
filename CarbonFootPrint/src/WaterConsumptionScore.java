import java.util.Scanner;

public class WaterConsumptionScore {
    public static int getUserInputDishWasherWaterConsumption() {
        Scanner input = new Scanner(System.in);
        String hasDishwasher;
        int dishwasherFrequency = 0;

        System.out.println(ConsoleColours.GREEN_UNDERLINED + "SECTION 3:");
        System.out.println(ConsoleColours.GREEN + "This section is about your water consumption."
                + ConsoleColours.RESET);
        do {
            System.out.print("Do you have a dishwasher? Please answer with 'Y' or 'N': ");
            hasDishwasher = input.nextLine().toLowerCase();
        }
        while (!hasDishwasher.equals("y") && !hasDishwasher.equals("n"));

        if (hasDishwasher.equals("y")) {
            System.out.print("How many times do you run your dishwasher per week? ");
            while (!input.hasNextInt()) {
                System.out.println("Please input a whole number (without decimals or commas)");
                input.next();
            }
            dishwasherFrequency = input.nextInt();
        }
        return dishwasherFrequency;
    }

    public static int getUserInputWashingMachineWaterConsumption() {
        Scanner input = new Scanner(System.in);
        String hasWashingMachine;
        int washingMachineFrequency = 0;

        do {
            System.out.print("Do you have a washing machine? Please answer with 'Y' or 'N': ");
            hasWashingMachine = input.nextLine().toLowerCase();
        }
        while (!hasWashingMachine.equals("y") && !hasWashingMachine.equals("n"));

        if (hasWashingMachine.equals("y")) {
            System.out.print("How many times do you run your washing machine per week? ");
            while (!input.hasNextInt()) {
                System.out.println("Please input a whole number (without decimals or commas)");
                input.next();
            }
            washingMachineFrequency = input.nextInt();
        }
        System.out.println("_____________________________________________________ \n");
        return washingMachineFrequency;
    }

    public static int waterConsumptionCalculation(int dishwasherFrequency, int washingMachineFrequency) {

        int score = 0;
        if (dishwasherFrequency > 9) {
            score += 3;
        } else if (dishwasherFrequency >= 4) {
            score += 2;
        } else if (dishwasherFrequency > 0) {
            score += 1;
        }

        if (washingMachineFrequency > 9) {
            score += 3;
        } else if (washingMachineFrequency >= 4) {
            score += 2;
        } else if (washingMachineFrequency > 0) {
            score += 1;
        }
        return score;
    }
}
