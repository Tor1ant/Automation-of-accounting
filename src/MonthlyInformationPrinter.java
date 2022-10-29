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




    /*При вызове этой функции программа должна выводить следующие данные:
Название месяца;
Самый прибыльный товар, то есть товар для которого is_expense == false, а произведение количества (quantity) на сумму (sum_of_one) максимально. Вывести название товара и сумму;
Самую большую трату. Вывести название товара и сумму.
Эта информация должна выводиться по каждому из месяцев.*/
}
