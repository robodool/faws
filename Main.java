import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        Finance student = new Finance();

        MenuManager menuManager = new MenuManager(student);
        Menu mainMenu = menuManager.getMenu("faws");

        Menu financeMenu = menuManager.getMenu("finance");
        Menu budgetMenu = menuManager.getMenu("budget");


        boolean running = true;

        int level = 0;

        loop:while(running){
            switch(level){
                case 0 -> {
                    char choice = mainMenu.display(scan);
                    switch(choice){
                        case 'A' -> level = 1;
                        case 'B' -> level = 0;
                        case 'C' -> running = false;
                        default -> System.out.println("Invalid choice, Try Again.");
                    }
                }
                case 1 -> {
                    char choice = financeMenu.display(scan);
                    switch(choice){
                        case 'A' -> level = 2;
                        case 'B' -> level = 3;
                        case 'C' -> level = 0;
                        default -> System.out.println("Invalid choice, Try Again.");
                    }
                }
                case 2 -> {
                    char choice = budgetMenu.display(scan);
                    switch(choice){
                        case 'A' -> student.allocateBudget(scan, mainMenu);
                        case 'B' -> level = 1;
                    }
                }
            }
        }
    }
}