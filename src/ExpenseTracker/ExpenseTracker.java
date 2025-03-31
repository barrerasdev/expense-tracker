package ExpenseTracker;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseTracker {

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
                            case 1:
                                //begin add
                                break;
                            case 2:
                                //select index to update etc date, id
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

}
