
import java.util.Scanner;

public class Main {
    static final String exceptionAlert = "Для проведения операции необходимо считать отчеты";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        YearlyReport yearlyReport = new YearlyReport();
        MonthlyReport monthlyReport = new MonthlyReport();
        ReportAssistent reportAssistent = new ReportAssistent();

        while (true) {
            System.out.println("Выберите операцию:");
            printMenu();
            int selectOperation = Integer.parseInt(scanner.nextLine());
            if (selectOperation == 1) {
                monthlyReport.monthlyReportDataHashMap.clear();
                monthlyReport.getMonthlyReport();
                System.out.println("Месячные отчеты считаны." + "\n");

            } else if (selectOperation == 2) {
                yearlyReport.yearlyReportDataHashMap.clear();
                yearlyReport.getEarlyReport();
                System.out.println("Годовой отчет считан." + "\n");

            } else if (selectOperation == 3) {
                if (!monthlyReport.monthlyReportDataHashMap.isEmpty() && !yearlyReport.yearlyReportDataHashMap.isEmpty()) {
                    reportAssistent.doCompare(yearlyReport, monthlyReport);
                } else {
                    System.out.println(exceptionAlert + "\n");
                }
            } else if (selectOperation == 4) {
                if (!monthlyReport.monthlyReportDataHashMap.isEmpty()) {
                    reportAssistent.printMontlhyReportInformation(monthlyReport);
                } else {
                    System.out.println(exceptionAlert + "\n");
                }

            } else if (selectOperation == 5) {
                if (!yearlyReport.yearlyReportDataHashMap.isEmpty()) {
                    reportAssistent.printYearlyReportInformation(yearlyReport);
                } else {
                    System.out.println(exceptionAlert + "\n");
                }
            } else if (selectOperation == 6) {
                break;
            } else {
                System.out.println("Такой операции нет." + "\n");
            }
        }

    }

    static void printMenu() {
        System.out.println("1. Считать все месячные отчёты." + "\n" +
                "2. Считать годовой отчёт." + "\n" +
                "3. Сверить отчёты." + "\n" +
                "4. Вывести информацию о всех месячных отчётах." + "\n" +
                "5. Вывести информацию о годовом отчёте." + "\n" +
                "6. закрыть программу.");
    }
}



