import java.util.HashMap;

public class MenuManager {
    private HashMap<String, Menu> menus;
    private Finance finance;
    private Finance percentage;

    public MenuManager(Finance finance){
        this.menus = new HashMap();
        this.finance = finance;

        menus.put("faws", new Menu("The Financial and Academic Wellfare System:", "Select an option", new String[]{
            "[A] Financial Manager",
            "[B] Academic Learning Capacity System",
            "[C] Exit"
        }));

        menus.put("finance", new Menu("Financial Management System:", "Select an option", new String[]{
            "[A] Budget",
            "[B] Distribution",
            "[C] Back to Main Menu"
        }));

        menus.put("budget", new Menu("Budgeting Weekly Allowance:", "Select an option", new String[]{
            "Budget -> ₱" + finance.getBudget(),
            "[A] Allocate Budget",
            "[B] Back"
        }));

        menus.put("distribute", new Menu("Distributing Budget to Different Portions:", "Select Portion", new String[]{
            "[A] Food",
            "[B] Transportation",
            "[C] Savings",
            "[D] Misc",
            "Percentage left to dsitribute: " + finance.getPercentage() + "%"
        }));
    }

    public Menu getMenu(String key){
        return menus.get(key);
    }

    public double getBudgetFromMenu(Finance finance){
        return finance.getBudget();
    }
    
    public double getPercentageFromMenu(Finance finance){
        return finance.getPercentage();
    }
}