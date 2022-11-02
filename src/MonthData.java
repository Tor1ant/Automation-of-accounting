public class MonthData {
    String itemName;
    boolean isExpense;
    int quantity;
    int sumOfOne;
    int profits;
    int expenses;

    MonthData(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
        if (this.isExpense) {
            expenses = quantity * sumOfOne;
        } else {
            profits = quantity * sumOfOne;
        }
    }
}

