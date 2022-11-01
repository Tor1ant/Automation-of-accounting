public class MonthData {
    String itemName; //String
    boolean is_expense; // boolean
    int quantity; // double
    int sum_of_one; // int
    int profits;
    int expenses;

    MonthData(String itemName, boolean is_expense, int quantity, int sum_of_one) {
        this.itemName = itemName;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
        if (this.is_expense) {
            expenses = quantity * sum_of_one;
        } else {
            profits = quantity * sum_of_one;
        }
    }
}

