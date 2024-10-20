import modals.Sheet;
import services.SheetService;

import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static SheetService sheetService;
    public static void main(String[] args) {
        boolean running = true;
        scanner = new Scanner(System.in);
        sheetService = new SheetService();
        sheetService.createSheet();
        System.out.println("---Sheet---");
        System.out.println("Creating Sheet...");
        while(running) {
            displayOption();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addValue();
                    break;
                case 2:
                    fetchValue();
                    break;
                case 3:
                    sheetService.displayExcel();
                    break;
                case 4:
                    doOperation();
                    break;
                case 5:
                    doFormatting();
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    private static void doFormatting() {
        System.out.println("Enter the start address, end address, formatting type");
        String fetchInput = scanner.nextLine();
        String[] inputs = fetchInput.trim().split(" ");
        sheetService.doFormatting(inputs[0], inputs[1], inputs[2]);
    }

    public static void displayOption() {
        System.out.println("Creating Sheet...");
        System.out.println("Please choose an option to proceed.");
        System.out.println("1. Add Value In Cell");
        System.out.println("2. Fetch Cell Value");
        System.out.println("3. Display Excel");
        System.out.println("4. Operation on Excel");
        System.out.println("5. Formatting");
        System.out.println("6. Quit");
    }

    public static void fetchValue() {
        System.out.println("Enter address of cell to fetch value.");
        String fetchInput = scanner.nextLine();
        String value = sheetService.fetchValue(fetchInput.trim());
        System.out.println("Value at: " + fetchInput.trim() + " is: " + value);
    }

    public static void addValue() {
        System.out.println("Enter address of cell & value.");
        String addInput = scanner.nextLine();
        String[] inputArr = addInput.trim().split(" ");
        sheetService.addValue(inputArr[0], inputArr[1]);
    }

    public static void doOperation() {
        System.out.println("Enter start address, end address and operation");
        String fetchInput = scanner.nextLine();
        String[] inputs = fetchInput.trim().split(" ");
        System.out.println("Result of the operation is: " + sheetService.operation(inputs[0], inputs[1], inputs[2]));
    }

}