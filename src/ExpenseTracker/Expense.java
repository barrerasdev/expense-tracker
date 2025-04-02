package ExpenseTracker;

public class Expense {
    private final int id;
    private String date;
    private String description;
    private int amount;

    public Expense(int id, String date, String description, int amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public int getMonth(){
        return Integer.parseInt(date.split("/")[0]);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "   "+id+"     "+date+"    "+description+"         $"+amount;
    }
}
