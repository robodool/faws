import java.util.Scanner;

public class Menu {
    private String title;
    private String prompt;
    private String[] options;

    public Menu(String title, String prompt, String[] options){
        this.title = title;
        this.prompt = prompt;
        this.options = options;
    }

    public String getTitle(){
        return title;
    }

    public char display(Scanner scan){
        this.clearScreen();
        System.out.println(title + "\n");
        for(int i = 0; i < options.length; i++){
            System.out.println(options[i] + ".");
        }
        System.out.print("\n" + prompt + ": ");
        char choice = scan.next().charAt(0);

        return choice;
    }

    public String[] getOptions(){
        return options;
    }

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen.");
        }
    }
}