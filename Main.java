import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        Finance finance = new Finance();
        Academic academic = new Academic();

        boolean running = true;

        int level = 0;
        loop:while(running){
            MenuManager menuManager = new MenuManager(finance, academic);

            Menu mainMenu = menuManager.getMenu("faws");

            Menu financeMenu = menuManager.getMenu("finance");

            Menu academicMenu = menuManager.getMenu("academic");
            Menu scoresMenu = menuManager.getMenu("scores");
            Menu goalMenu = menuManager.getMenu("goal");
            Menu assessmentMenu = menuManager.getMenu("assessment");

            switch (level) {
                case 0 -> {
                    char choice = mainMenu.display(scan);
                    switch (choice) {
                        case 'A' ->
                            level = 1;
                        case 'B' ->
                            level = 5;
                        case 'C' ->
                            running = false;
                        default ->
                            System.out.println("Invalid choice, Try Again.");
                    }
                }
                case 1 -> {
                    char choice = financeMenu.display(scan);
                    switch (choice) {
                        case 'A' ->
                            level = 2;
                        case 'B' ->
                            level = 3;
                        case 'C' ->
                            level = 4;
                        case 'D' ->
                            level = 0;
                        default ->
                            System.out.println("Invalid choice, Try Again.");
                    }
                }
                case 2 -> {
                    Menu budgetMenu = menuManager.getMenu("budget");
                    char choice = budgetMenu.display(scan);
                    switch (choice) {
                        case 'A' ->
                            finance.allocateBudget(scan, mainMenu, menuManager);
                        case 'B' ->
                            level = 1;
                    }
                }
                case 3 -> {
                    Menu distibruteMenu = menuManager.getMenu("distribute");
                    char choice = distibruteMenu.display(scan);
                    switch (choice) {
                        case 'A' -> {
                            finance.distributeBudget(scan, mainMenu, "Food");
                            finance.calculateMoney(finance, "Food");
                        }
                        case 'B' -> {
                            finance.distributeBudget(scan, mainMenu, "Transportation");
                            finance.calculateMoney(finance, "Transportation");
                        }
                        case 'C' -> {
                            finance.distributeBudget(scan, mainMenu, "Savings");
                            finance.calculateMoney(finance, "Savings");
                        }
                        case 'D' -> {
                            finance.distributeBudget(scan, mainMenu, "Misc");
                            finance.calculateMoney(finance, "Misc");
                        }
                        case 'E' -> level = 1;
                    }
                }
                case 4 -> {
                    Menu planMenu = menuManager.getMenu("plan");
                    char choice = planMenu.display(scan);
                    switch (choice) {
                        case 'A' -> {
                            level = 1;
                        }
                    }
                }
                case 5 -> {
                    char choice = academicMenu.display(scan);
                    switch (choice) {
                        case 'A' -> level = 6;
                        case 'B' -> level = 7;
                        case 'C' -> level = 8;
                        case 'D' -> level = 9;
                        case 'E' -> level = 0;
                    }
                }
                case 6 -> {
                    Menu subjectsMenu = menuManager.getMenu("subjects");
                    char choice = subjectsMenu.display(scan);
                    switch (choice) {
                        case 'A' -> academic.trackSubjects(scan, subjectsMenu, academic);
                        case 'B' -> level = 5;
                    }
                }
                case 7 -> {
                    char choice = scoresMenu.display(scan);
                    switch (choice) {
                        case 'A' -> academic.inputSubjectScores(scan, scoresMenu, academic, level);
                        case 'B' -> level = 5;
                    }
                }
                case 8 -> {
                    char choice = goalMenu.display(scan);
                    switch (choice) {
                        case 'A' -> academic.setGoal(scan, goalMenu, academic);
                        case 'B' -> level = 5;
                    }
                }
                case 9 -> {
                    char choice = assessmentMenu.display(scan);
                    switch (choice) {
                        case 'A' -> level = 5;
                    }
                }
            }
        }
    }
}