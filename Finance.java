import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Finance {
    private double budget = 100.0;
    private HashMap<String, Double> distributionPercentage;
    private HashMap<String, Double> distributionMoney;
    private double percentage = 100.0;

    public Finance(){
        this.distributionPercentage = new HashMap();
        this.distributionMoney = new HashMap();
        String[] portions = {
            "Food",
            "Transportation",
            "Savings",
            "Misc"
        };
        for(int i = 0; i <= portions.length - 1; i++){
            distributionPercentage.put(portions[i], 0.0);
            distributionMoney.put(portions[i], 0.0);
        }
    }

    public void allocateBudget(Scanner scan, Menu menu, MenuManager menuManager){
        try {
            menu.clearScreen();
            String[] prompts = {
                menu.getTitle() + "\n",
                "Current Budget -> ₱" + budget,
                "Money to Spend Every Weekday: ₱" + (budget / 5),
                "Input Budget for the Week: ",
                "[-1] Exit"
            };
            for(int i = 0; i <= (prompts.length - 1); i++){
                System.out.println(prompts[i]);
            }
            menu.moveCursor(5, prompts[3].length() + 1);
            double b = scan.nextDouble();
            if(b == -1){} else {
                this.budget = b;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input, Try Again.");
        }
    }

    public double getBudget(){
        return budget;
    }

    public void distributeBudget(Scanner scan, Menu menu, String portion){
        String[] prompts = {
            menu.getTitle() + "\n",
            "[A] Food",
            "[B] Transportation",
            "[C] Savings",
            "[D] Misc",
            "[E] Back",
            "    Distribute Share of " + portion + ": ",
            "    [-1] Close"
        };
        switch(portion){
            case "Food" -> {
                distributePercentage(scan, menu, prompts, portion, 1, 2, 5, 4);
            }
            case "Transportation" -> {
                distributePercentage(scan, menu, prompts, portion, 2, 3, 5, 5);
            }
            case "Savings" -> {
                distributePercentage(scan, menu, prompts, portion, 3, 4, 5, 6);
            }
            case "Misc" -> {
                distributePercentage(scan, menu, prompts, portion, 4, 5, 5, 7);
            }
        }
    }

    public double getPercentage(String portion){
        return distributionPercentage.get(portion);
    }

    public double getMoney(String portion){
        return distributionMoney.get(portion);
    }

    private void distributePercentage(Scanner scan, Menu menu, String[] prompts, String portion, int end0, int start1, int end1, int row){
        menu.clearScreen();
        for(int i = 0; i <= end0; i++){
            System.out.println(prompts[i]);
        }
            System.out.println(prompts[6]);
        System.out.println(prompts[7]);
        for(int i = start1; i <= end1; i++){
            System.out.println(prompts[i]);
        }
        System.out.println("\nAllocate Percentage on " + portion);
        menu.moveCursor(row, prompts[6].length() + 1);
        double percentage = scan.nextDouble();
        if(percentage == -1){} 
        else {
            this.percentage = percentage - this.percentage;
            distributionPercentage.put(portion, percentage);
        }
    }

    public void calculateMoney(Finance finance, String portion){
        double money = (finance.getBudget() / 100) * this.getPercentage(portion);
        distributionMoney.put(portion, money);
    }
}