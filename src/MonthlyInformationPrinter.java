import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyInformationPrinter {
    String monthName;

    MonthlyInformationPrinter(HashMap<String, ArrayList<MonthData>> monthDataByMonths, String key) {
        this.monthName = key;
        printMaxProfitProduct(monthDataByMonths);
        printMaxExpenseProduct(monthDataByMonths);
    }

    private void printMaxProfitProduct(HashMap<String, ArrayList<MonthData>> monthDataByMonths) {

        String productName = "";
        int maxProfit = Integer.MIN_VALUE;
        for (MonthData monthData : monthDataByMonths.get(monthName)) {
            if (!monthData.is_expense) {
                int profit = monthData.quantity * monthData.sum_of_one;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    productName = monthData.itemName;
                }
            }
        }
        System.out.println(this.monthName + "\n");
        System.out.println("Самый прибыльный товар - " + productName + ". Доход: " + maxProfit);
    }

    private void printMaxExpenseProduct(HashMap<String, ArrayList<MonthData>> monthDataByMonths) {
        String productName = "";
        int maxExpense = Integer.MIN_VALUE;
        for (MonthData monthData : monthDataByMonths.get(monthName)) {
            if (monthData.is_expense) {
                int expense = monthData.quantity * monthData.sum_of_one;
                if (expense > maxExpense) {
                    maxExpense = expense;
                    productName = monthData.itemName;
                }
            }
        }
        System.out.println("Самая большая трата - " + productName + ". Расходы: " + maxExpense + "\n");
    }

}
