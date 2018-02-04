import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ListMaster {

/*
    switch (integral expression){
        case (expression):
            set of statements;
            break;
        case (expression):
            set of statements;
            break;
        default:
            set of statements;
    }
 */
    public static void main(String[] args) {
        List  <String> todoitems = new ArrayList();
	// write your code here
        //TestPrintGradeRange();
        //RunPrintGradeRange();
        System.out.println("Select 1 for Add \nSelect 2 For Show \nSelect 3 for Clear \nSelect 4 for Delete");

        Scanner selection = new Scanner(System.in);
        while (selection.hasNextLine()) {
            int option = -1;
            try {
                option = Integer.parseInt(selection.nextLine());
            }catch (NumberFormatException nfe){}
            ManageTodoList(option, todoitems);
            System.out.println("Select 1 for Add \nSelect 2 For Show \nSelect 3 for Clear \nSelect 4 for Delete");
        }


    }
/*
    This method will manage a todo list.
    When users select options the method
    updates or displays the todo list.
    1 - add to list
    2 - show list
    3 - clear list
 */
    public static void ManageTodoList (int option, List <String> todoItems){
        switch (option){
            case (1):
                addtolist(todoItems);
                break;
            case (2):
                showlist(todoItems);
                break;
            case (3):
                clearlist(todoItems);
                break;
            case (4):
                deleteitem(todoItems);
                break;
            default:
                System.out.println ("Error");
        }
    }
    public static void addtolist (List <String> todoItems) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your shit. enter '.' when you're done");
        while(sc.hasNextLine()){
            String userInput = sc.nextLine();
            if (userInput.equals(".")){
                break;
            }
            else {
                todoItems.add(userInput);
            }
        }


    }

    public static void showlist (List <String> todoItems) {
        int listNumber = 1;
        for(String item:todoItems) {
            System.out.println(listNumber + ": " + item);
            listNumber++;
        }
    }

    public static void clearlist (List <String> todoItems) {
        todoItems.clear();
    }

    public static  void deleteitem (List <String> todoItems){
        showlist(todoItems);
        System.out.println("What item do you want to delete:");
        Scanner sc = new Scanner(System.in);
        int option = -1;
        try {
            option = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException nfe){

        }
        if (option > 0 && option <= todoItems.size()) {
            todoItems.remove(option - 1);
        }
        else{
            System.out.println("Error: Invalid index");
        }
    }

    private static void RunPrintGradeRange() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a letter grade:");
        while(sc.hasNextLine()){
            String userInput = sc.nextLine(); //get input from the commandline
            //validate input
            if (userInput.length()>1){
                System.out.println ("So you got a " + userInput + " For a grade?");
            }
            else {
                char letter = userInput.toUpperCase().charAt(0); //get the first character of the string
                PrintGradeRange(letter);
            }
        }
    }

    private static void TestPrintGradeRange() {
        PrintGradeRange('A');
        PrintGradeRange('B');
        PrintGradeRange('C');
        PrintGradeRange('D');
        PrintGradeRange('F');
        PrintGradeRange('L');
        PrintGradeRange('1');
    }

    /*
        This method prints a grade range when
        a letter {A,B,C,D,F} is passed in. For
        all other input the method prints
        "Invalid Letter Grade"
     */

    public static void PrintGradeRange (char letter){
        switch (letter){
            case ('A'):
                System.out.println ("90-100");
                break;
            case ('B'):
                System.out.println ("80-89");
                break;
            case ('C'):
                System.out.println ("70-79");
                break;
            case ('D'):
                System.out.println ("60-69");
                break;
            case ('F'):
                System.out.println ("0-59");
                break;
            default:
                System.out.println ("So you got a " +letter + " For a grade?");
                break;
        }
    }
}
