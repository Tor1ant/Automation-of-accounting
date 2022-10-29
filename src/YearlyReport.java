import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class YearlyReport {
    int year;
    HashMap<Integer, YearlyReportMonths> yearlyMonthsData = new HashMap<>();

    void doYearlyReport(int year, String path) {
        this.year = year;
        String fileContent = readFileContentsOrNull(path);
        String[] lines = fileContent.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] linesSplit = line.split(",");
            int month = Integer.parseInt(linesSplit[0]);
            int sum = Integer.parseInt(linesSplit[1]);
            boolean isExpense = Boolean.parseBoolean(linesSplit[2]);

            if (!yearlyMonthsData.containsKey(month)) {
                yearlyMonthsData.put(month, new YearlyReportMonths(month));
            }
            YearlyReportMonths oneMonthData = yearlyMonthsData.get(month);
            if (isExpense) {
                oneMonthData.expenses += sum;
            } else {
                oneMonthData.income += sum;
            }
        }
    }

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of("./resources/" + path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public void getAverageExpenses() {

        int allExpenses = 0;
        int countOfExpenses = 0;
        int result;
        for (YearlyReportMonths expensesInMonth : yearlyMonthsData.values()) {
            allExpenses += expensesInMonth.expenses;
            countOfExpenses++;
        }
        result = allExpenses / countOfExpenses;
        System.out.println("Средний расход за все месяцы в году: " + result + "\n");
    }

    public void getAverageProfit() {
        int allProfit = 0;
        int countOfProfit = 0;
        int result;
        for (YearlyReportMonths expensesInMonth : yearlyMonthsData.values()) {
            allProfit += expensesInMonth.income;
            countOfProfit++;
        }
        result = allProfit / countOfProfit;
        System.out.println("Средний доход за все месяцы в году: " + result + "\n");
    }

    public void getProfit(int key) {
        double profit;
        profit = yearlyMonthsData.get(key).income - yearlyMonthsData.get(key).expenses;
        if (key == 1) {
            System.out.println("Прибыль за Январь составила: " + profit);

        } else if (key == 2) {
            System.out.println("Прибыль за Февраль составила: " + profit);

        } else if (key == 3) {
            System.out.println("Прибыль за Март составила: " + profit + "\n");

        }
    }


}
