import java.util.HashMap;

public class MenuManager {
    private final HashMap<String, Menu> menus;

    private Finance finance;
    private Finance percentage;

    private Academic academic;

    public MenuManager(Finance finance, Academic academic){
        this.menus = new HashMap();
        this.finance = finance;
        this.academic = academic;

        menus.put("faws", new Menu("The Financial and Academic Welfare System:", "Select an option", new String[]{
            "[A] Financial Management System",
            "[B] Academic Learning Capacity System",
            "[C] Exit"
        }));

        menus.put("finance", new Menu("Financial Management System:", "Select an option", new String[]{
            "[A] Budget",
            "[B] Distribution",
            "[C] See Plan",
            "[D] Back to Main Menu"
        }));

        menus.put("plan", new Menu("Budgeting Plan:", "Select an option", new String[]{
            "Current Budget: " + finance.getBudget(),
            "Money to Spend Every Weekday: " + finance.getBudget() / 5,
            "\nDistribution:",
            "Food -> " + Math.round(finance.getPercentage("Food")) + "%: ₱" + finance.getMoney("Food"),
            "Transportation -> " + Math.round(finance.getPercentage("Transportation")) + "%: ₱" + finance.getMoney("Transportation"),
            "Savings -> " + Math.round(finance.getPercentage("Savings")) + "%: ₱" + finance.getMoney("Savings"),
            "Misc -> " + Math.round(finance.getPercentage("Misc")) + "%: ₱" + finance.getMoney("Misc"),
            "\n[A] Back"
        }));

        menus.put("budget", new Menu("Budgeting Weekly Allowance:", "Select an option", new String[]{
            "Budget: " + finance.getBudget(),
            "[A] Allocate Budget",
            "[B] Back"
        }));

        menus.put("distribute", new Menu("Distributing Budget to Different Portions:", "Select Portion", new String[]{
            "[A] Food",
            "[B] Transportation",
            "[C] Savings",
            "[D] Misc",
            "[E] Back",
        }));

        menus.put("academic", new Menu("Academic Learning Capacity System:", "Select an option", new String[]{
            "[A] Subjects",
            "[B] Scores",
            "[C] Goal",
            "[D] Assessment",
            "[E] Back to Main Menu"
        }));

        menus.put("subjects", new Menu("Tracking Subjects for Input:", "Select an option", new String[]{
            "Tracked Subjects -> " + (academic.getSubjects().isEmpty() ? "None" : academic.getSubjects()),
            "[A] Track Subjects",
            "[B] Back"
        }));

        menus.put("scores", new Menu("Inputting Scores for Assessment:", "Select an option", new String[]{
            "[A] Subjects",
            "[B] Back"
        }));

        menus.put("goal", new Menu("Accomplishing a Goal Learning Capacity:", "Select an option", new String[]{
            "[A] Set Goal Percentage",
            "[B] Back"
        }));

        menus.put("assessment", new Menu("Assessing Students Learning Capacity:", "Select an option", new String[]{
            "Subjects -> " + (academic.getSubjects().isEmpty() ? "None\n" : academic.getSubjects()),
            "Subject Capacity: \n",
            "Philosophy: " + Math.round(academic.getSubjectLC("Philosophy")),
            "21st Literature: " + Math.round(academic.getSubjectLC("21st Literature")),
            "General Mathematics: " + Math.round(academic.getSubjectLC("General Mathematics")),
            "Java: " + Math.round(academic.getSubjectLC("Java")),
            "HTML: " + Math.round(academic.getSubjectLC("HTML")),
            "MIL: " + Math.round(academic.getSubjectLC("MIL")),
            "Oral Comm: " + Math.round(academic.getSubjectLC("Oral Comm")),
            "\nOverall Learning Capacity: " + (academic.getLearningCapacity(academic) > 0 ? academic.getLearningCapacity(academic) : 0),
            "\nGoal Percentage: " + (academic.getGoal() > 0 ? Math.round(academic.getGoal()) : 0),
            "Goal Reached?: " + (academic.getGoal() < academic.getLearningCapacity(academic) ? "Yes" : "No"),
            "\n[A] Back" 
        }));
    }

    public Menu getMenu(String key){
        return menus.get(key);
    }
}