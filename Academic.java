import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Academic {
    private double lc = 0;
    private ArrayList<String> subjects;
    private HashMap<String, Double> subjectlc;
    private double goal = 0;

    public Academic(){
        this.subjects = new ArrayList<>();
        this.subjectlc = new HashMap();
        String[] subjects = {
            "Philosophy",
            "21st Literature",
            "General Mathematics",
            "Java",
            "HTML",
            "MIL",
            "Oral Comm"
        };
        for(int i = 0; i <= subjects.length - 1; i++){
            subjectlc.put(subjects[i], 0.0);
        }
    }

    public void trackSubjects(Scanner scan, Menu menu, Academic academic){
        menu.clearScreen();
        String[] prompts = {
            "Select Subjects:",
            "[ ] Philosophy",
            "[ ] 21st Literature",
            "[ ] General Mathematics",
            "[ ] Java",
            "[ ] HTML",
            "[ ] MIL",
            "[ ] Oral Communication",
            "(/) to Select and (x) to Ignore",
            "[.] Exit" 
        };
        System.out.println(prompts[0] + "\n");
        for(int i = 1; i <= prompts.length - 2; i++){
            System.out.println(prompts[i]);
        }
        System.out.println("\n" + prompts[9]);
        academic.clearSubjects();
        for(int i = 1; i <= 7; i++){
            menu.moveCursor(i + 2, 2);
            char selection = scan.next().charAt(0);
            switch (selection) {
                case '/' -> academic.addSubject(prompts[i].substring(4));
                case 'x' -> {}
                case '.' -> {
                    return;
                }
                default -> {
                    return;
                }
            }
        }
    }

    public void inputSubjectScores(Scanner scan, Menu menu, Academic academic, int level){
        menu.clearScreen();
        System.out.println("Inputting Scores categorized by Subject");
        for(int i = 0; i < academic.getSubjects().size(); i++){
            System.out.println("[" + (char) ('A' + i) + "] " + subjects.get(i));
        }
        System.out.println("\n[" + (char) ('A' + (academic.getSubjects().size())) + "] Back");
        System.out.print("Select option: ");
        char choice = scan.next().charAt(0);
        switch(choice){
            case 'A' -> {
                checkSize(scan, menu, academic, subjects.get(0), subjects.size(), level);
            }
            case 'B' -> {
                checkSize(scan, menu, academic, subjects.get(1), subjects.size(), level);
            }
            case 'C' -> {
                checkSize(scan, menu, academic, subjects.get(2), subjects.size(), level);
            }
            case 'D' -> {
                checkSize(scan, menu, academic, subjects.get(3), subjects.size(), level);
            }
            case 'E' -> {
                checkSize(scan, menu, academic, subjects.get(4), subjects.size(), level);
            }
            case 'F' -> {
                checkSize(scan, menu, academic, subjects.get(5), subjects.size(), level);
            }
            case 'G' -> {
                checkSize(scan, menu, academic, subjects.get(6), subjects.size(), level);
            }
        }
    }

    public void inputScores(Scanner scan, Menu menu, Academic academic, String subject){
        menu.clearScreen();
        String[] prompts = {
            menu.getTitle() + "\n",
            "How many activities?: ",
            "Input Score:   /"
        };
        System.out.println(prompts[0] + "\n");

        ArrayList<ArrayList<Integer>> scoreData = new ArrayList<>();

        System.out.print(prompts[1]);
        int amount = scan.nextInt();
        for(int i = 0; i < amount; i++){
            menu.clearScreen();
            System.out.println(prompts[0]);
            ArrayList<Integer> scorePair = new ArrayList<>();
            System.out.print(prompts[2]);
            menu.moveCursor(3, prompts[2].length() - 2);
            int score = scan.nextInt();
            menu.moveCursor(3, prompts[2].length() + 1);
            int maxScore = scan.nextInt();

            scorePair.add(score);
            scorePair.add(maxScore);

            scoreData.add(scorePair);
        }

        double totalPercentage = 0.0;

        for (ArrayList<Integer> scorePair : scoreData) {
            int score = scorePair.get(0);
            int maxScore = scorePair.get(1);

            if (maxScore > 0) {
                double percentage = (double) score / maxScore * 100;
                totalPercentage += percentage;
            } else {
                System.out.println("Invalid max score for score: " + score);
            }
        }

        // Calculate the average percentage
        double averagePercentage = totalPercentage / amount;
        subjectlc.put(subject, averagePercentage);
    }

    public void checkSize(Scanner scan, Menu menu, Academic academic, String subject, int amount, int level){
        if(amount > 8){
            level = 5;
        } else {
            inputScores(scan, menu, academic, subject);
        }
    }

    public void setGoal(Scanner scan, Menu menu, Academic academic){
        menu.clearScreen();
        String[] prompts = {
            menu.getTitle() + "\n",
            "Input Goal Percentage: ",
            "\nCurrent Percentage: " + academic.getGoal(),
        };
        for(int i = 0; i <= prompts.length - 1; i++){
            System.out.println(prompts[i]);
        }
        menu.moveCursor(3, prompts[1].length() + 1);
        int percentage = scan.nextInt();

        this.goal = percentage;
    }

    public double getGoal(){
        return goal;
    }

    public ArrayList getSubjects() {
        return subjects;
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public void clearSubjects() {
        subjects.clear();
    }

    public double getSubjectLC(String subject) {
        return subjectlc.get(subject);
    }

    public double getLearningCapacity(Academic academic){
        String[] subjects = {
            "Philosophy",
            "21st Literature",
            "General Mathematics",
            "Java",
            "HTML",
            "MIL",
            "Oral Comm"
        };
        double sum = 0;
        double count = 0;
        for(int i = 0; i <= subjects.length - 1; i++){
            sum += academic.getSubjectLC(subjects[i]);
            if(!(academic.getSubjectLC(subjects[i]) == 0)){
                count += 1;
            }
        }
        double lc = sum / count;

        return lc;
    }
}