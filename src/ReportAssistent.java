
import java.util.*;

public class ReportAssistent {

    HashMap<Integer, String> months;


    ReportAssistent() {
        months = new HashMap<>();
        months.put(1, "Январь");
        months.put(2, "Февраль");
        months.put(3, "Март");
        months.put(4, "Апрель");
        months.put(5, "Май");
        months.put(6, "Июнь");
        months.put(7, "Июль");
        months.put(8, "Август");
        months.put(9, "Сентябрь");
        months.put(10, "Октябрь");
        months.put(11, "Ноябрь");
        months.put(12, "Декабрь");
    }

    public void doCompare(YearlyReport yearlyReport, MonthlyReport monthlyReport) {
        // get all profits and expenses by months
        HashMap<Integer, Integer> profitsByMonths = new HashMap<>();
        HashMap<Integer, Integer> expensesByMonths = new HashMap<>();

        for (Integer numberOfMonths : monthlyReport.monthlyReportDataHashMap.keySet()) {
            int sumOfprofits = 0;
            int sumOfExpenses = 0;
            for (MonthData monthData : monthlyReport.monthlyReportDataHashMap.get(numberOfMonths)) {
                sumOfprofits += monthData.profits;
                sumOfExpenses += monthData.expenses;
            }
            profitsByMonths.put(numberOfMonths, sumOfprofits);
            expensesByMonths.put(numberOfMonths, sumOfExpenses);
        }

        // do compare monthly reports and yearly report
        boolean flag = false;
        for (int i = 1; i <= 12; i++) {
            if (!yearlyReport.yearlyReportDataHashMap.containsKey(i)) {
                continue;
            }

            if (yearlyReport.yearlyReportDataHashMap.get(i).income == (profitsByMonths.get(i)) &&
                    yearlyReport.yearlyReportDataHashMap.get(i).expenses == (expensesByMonths.get(i))) {
            } else {

                String monthName = months.get(i);
                System.out.println("Несоответствие обнаружено в месяце " + monthName);
                flag = true;
            }
        }
        if (flag) {
            return;
        }
        System.out.println("Операция выполнена успешно. Несоответствий не обнаружено" + "\n");
    }

    public void printMontlhyReportInformation(MonthlyReport monthlyReport) {

        String monthName = "";
        String maxProfitProduct = "", maxExpensesProduct = "";
        int maxProfit = Integer.MIN_VALUE;
        int maxExpenses = Integer.MIN_VALUE;
        for (int i = 1; i <= monthlyReport.monthlyReportDataHashMap.size(); i++) {
            for (MonthData monthData : monthlyReport.monthlyReportDataHashMap.get(i)) {
                monthName = months.get(i);
                if (!monthData.isExpense) {
                    if (monthData.profits > maxProfit) {
                        maxProfit = monthData.profits;
                        maxProfitProduct = monthData.itemName;
                    }
                } else if (monthData.expenses > maxExpenses) {
                    maxExpenses = monthData.expenses;
                    maxExpensesProduct = monthData.itemName;
                }
            }
            System.out.println("Отчет за " + monthName + ":" + "\n");
            System.out.println("Самый прибыльный товар: " + maxProfitProduct + ". Доход от него составил: " +
                    maxProfit);
            System.out.println("Самый не прибыльный товар: " + maxExpensesProduct + ". Расходы составили: " +
                    maxExpenses + "\n");
            maxProfit = Integer.MIN_VALUE;
            maxExpenses = Integer.MIN_VALUE;
        }
    }


    public void printYearlyReportInformation(YearlyReport yearlyReport) {
        System.out.println(yearlyReport.year);
        int allProfit;
        for (Integer month : yearlyReport.yearlyReportDataHashMap.keySet()) {
            allProfit = (int) (yearlyReport.yearlyReportDataHashMap.get(month).income - yearlyReport.
                    yearlyReportDataHashMap.get(month).expenses);
            System.out.println("Прибыль за " + months.get(month) + " составила: " + allProfit);
        }
        getAverageProfitAndExpenses(yearlyReport);

    }

    public void getAverageProfitAndExpenses(YearlyReport yearlyReport) {
        int allProfit = 0;
        int averageProfit;
        int allExpenses = 0;
        int averageExpenses;
        for (YearlyReportData yearlyReportData : yearlyReport.yearlyReportDataHashMap.values()) {
            allProfit += yearlyReportData.income;
            allExpenses += yearlyReportData.expenses;
        }
        averageProfit = allProfit / 12;
        averageExpenses = allExpenses / 12;
        System.out.println("Средний доход за все месяцы в году: " + averageProfit);
        System.out.println("Средние расходы за все месяцы в году: " + averageExpenses + "\n");
    }
}