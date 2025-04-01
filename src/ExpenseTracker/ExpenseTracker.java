package ExpenseTracker;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseTracker {

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
                                Expense expense = new Expense(expenseList.size()+1, date, desc, amount);
                                expenseList.add(expense);
                                break;
                            case 2: // UPDATE EXPENSE
                                Scanner input2 = new Scanner(System.in);
                                System.out.println("Which Expense would you like to update?:");
                                displayExpenses();
                                System.out.println("Enter ID:");
                                int updateID = getValidatedInt();
                                if (updateID <= expenseList.size() && updateID > 0) {
                                    System.out.println("What would you like to update?\n1.Date\n2.Description\n3.Amount");
                                    int option2 = getValidatedInt();
                                    switch (option2) {
                                        case 1:
                                            System.out.println("Enter the updated Date:");
                                            expenseList.get(updateID-1).setDate(input2.nextLine());
                                            System.out.println("Date updated.");
                                            break;
                                        case 2:
                                            System.out.println("Enter the updated Description:");
                                            expenseList.get(updateID-1).setDescription(input2.nextLine());
                                            System.out.println("Description updated.");
                                            break;
                                        case 3:
                                            System.out.println("Enter the updated Amount:");
                                            expenseList.get(updateID-1).setAmount(getValidatedInt());
                                            System.out.println("Amount updated.");
                                            break;
                                            default:
                                                break;
                                    }
                                }
                                else {
                                    System.out.println("Could not find expense with ID #" + updateID);
                                }
                                break;
                            case 3: // DELETE EXPENSE
                                System.out.println("Which Expense would you like to delete?:");
                                displayExpenses();
                                System.out.println("Enter ID:");
                                int deleteID = getValidatedInt();
                                if (deleteID <= expenseList.size() && deleteID > 0) {
                                    expenseList.remove(deleteID-1);
                                    System.out.println("Expense deleted.");
                                }
                                else {
                                    System.out.println("Could not find expense with ID #" + deleteID);
                                }
                                break;
                            default:
                                System.out.println("Invalid Option\nPlease Try Again");
                                continue;
                        }
                        break;
                    }
                    break;
                case 2:
                    displayExpenses();
                    break;
                case 3:
                    System.out.println("Summarizing Expenses:");
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
