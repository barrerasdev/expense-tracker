package ExpenseTracker;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseTracker {

    static int expenses = 0;
    static ArrayList<Expense> expenseList = new ArrayList<Expense>();

    public static void main(String[] args){
        while (true){
            System.out.println("\n\nExpense Tracker\n1. Manage Expenses\n2. View all  \n3. Summarize \n4. Monthly View\n5. Quit");
            int choice = getValidatedInt();
            switch(choice){
                case 1:
                    while(true) {
                        System.out.println("\n\nExpense Manager");
                        System.out.println("1. Add Expense");
                        System.out.println("2. Update Expense");
                        System.out.println("3. Delete Expense");

                        int option = getValidatedInt();

                        switch (option) {
                            case 1: // ADD EXPENSE
                                Scanner input = new Scanner(System.in);
                                System.out.println("Enter the Date (MM/DD/YYYY) of the Expense:");
                                String date = input.nextLine();
                                System.out.println("Describe Expense:");
                                String desc = input.nextLine();
                                System.out.println("Enter the amount rounded in dollars");
                                int amount = getValidatedInt();
                                Expense expense = new Expense(expenses+1, date, desc, amount);
                                expenseList.add(expense);
                                break;
                            case 2:
                                System.out.println("Which Expense would you like to update?:");
                                displayExpenses();
                                System.out.println("Enter ID:");
                                int id = getValidatedInt()-1;
                                System.out.println("Enter Description:");

                                break;
                            case 3:
                                //choose to delete
                                System.out.println("Deleted");
                                break;
                            default:
                                System.out.println("Invalid Option\nPlease Try Again");
                                continue;
                        }
                        break;
                    }
                    break;
                case 2:
                    //display all
                    break;
                case 3:
                    //summarize by category
                    break;
                case 4:
                    //monthly view
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option\nPlease Try Again");
            }
        }
    }

    public static int getValidatedInt(){
        Scanner input = new Scanner(System.in);
        while(true){
            try{
                return input.nextInt();
            }catch (InputMismatchException notInteger){
                System.out.println("Please enter an integer:");
                input.nextLine();
            }
        }
    }

    public static void displayExpenses(){
        System.out.println("# ID     Date          Description    Amount");
        for (Expense expense : expenseList) {
            System.out.println(expense.toString());
        }
    }

}
