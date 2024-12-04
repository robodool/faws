import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Finance {
    private double budget = 0.0;
    private HashMap<String, Double> distribution;
    private int percentage = 100;

    public void allocateBudget(Scanner scan, Menu menu){
        try {
            menu.clearScreen();
            System.out.println(menu.getTitle() + "\n");
            System.out.println("Current Budget -> " + budget);
            System.out.println("Money to Spend Every Weekday: " + (budget / 5));
            System.out.print("Input Budget for the Week: ");
            double b = scan.nextDouble();
            this.budget = b;
        } catch (InputMismatchException e) {
            this.budget = 0;
        }
    }



    public double getBudget(){
        return budget;
    }

    public void distributeBudget(Scanner scan, Menu menu){
        

        menu.clearScreen();
    }

    public int getPercentage(){
        return percentage;
    }

    public void setPercentage(int p){
        this.percentage = p;
    }
}