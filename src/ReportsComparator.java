import java.util.HashMap;

// вспомогательный класс для проведения операций с отчетами.
public class ReportsComparator {

    int profits;
    int expenses;


    void getProfitsAndExpenses(MonthlyReport monthlyReport) {
        int sumOfProfits = 0;
        for (MonthData monthData : monthlyReport.listOfMonthData) {
            if (!monthData.is_expense) {
                sumOfProfits += monthData.sum_of_one * monthData.quantity;
            }
        }
        this.profits = sumOfProfits;
        getProfitsAndExpenses2(monthlyReport);

    }

    private void getProfitsAndExpenses2(MonthlyReport monthlyReport) {
        int sumofExpenses = 0;
        for (MonthData monthData : monthlyReport.listOfMonthData) {
            if (monthData.is_expense) {
                sumofExpenses += monthData.sum_of_one * monthData.quantity;
            }
        }
        this.expenses = sumofExpenses;

    }

    public void doCompare(int numberOfMonth, int profits, int expenses, HashMap<Integer, YearlyReportMonths> yearlyMonthsData) {

        if (profits == yearlyMonthsData.get(numberOfMonth).income && expenses == yearlyMonthsData.get(numberOfMonth).expenses) {
            if (numberOfMonth == 1) {
                System.out.println("Отчет за Январь успешно сверен с годовым. Несоответствия не обнаружены.");
            } else if (numberOfMonth == 2) {
               System.out.println("Отчет за Февраль успешно сверен с годовым. Несоответствия не обнаружены.");
            } else if (numberOfMonth == 3) {
                System.out.println("Отчет за Март успешно сверен с годовым. Несоответствия не обнаружены.");
            }
        } else {
            if (numberOfMonth == 1) {

                System.out.println("В отчёте за Январь обнаружено несоответствие с годовым отчётом");
            } else if (numberOfMonth == 2) {
                System.out.println("В отчёте за Февраль обнаружено несоответствие с годовым отчётом");
            } else if (numberOfMonth == 3) {
                System.out.println("В отчёте за Март обнаружено несоответствие с годовым отчётом");
            }

        }


    }
}
