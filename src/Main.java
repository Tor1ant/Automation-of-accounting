
import java.util.Scanner;


public class Main {
    static final String exceptionAlert = "Для проведения операции необходимо считать отчеты";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isoperation1Selected = false;
        boolean isoperation2Selected = false;
        YearlyReport yearlyReport = new YearlyReport();
        MonthlyReport monthlyReport = new MonthlyReport();
        ReportAssistent reportAssistent = new ReportAssistent();
        while (true) {
            System.out.println("Выберите операцию:");
            printMenu();
            int selectOperation = Integer.parseInt(scanner.nextLine());
            if (selectOperation == 1) {
                monthlyReport.getMonthlyReport();
                isoperation1Selected = true;
                System.out.println("Месячные отчеты считаны."+"\n");
            } else if (selectOperation == 2) {
                yearlyReport.getEarlyReport();
                isoperation2Selected = true;
                System.out.println("Годовой отчет считан."+"\n");
            } else if (selectOperation == 3) {
                if (isoperation1Selected && isoperation2Selected) {
                    reportAssistent.getAllProfitsAndExpensesByMonths(monthlyReport);
                    reportAssistent.doCompare(yearlyReport);
                } else {
                    System.out.println(exceptionAlert + "\n");
                }
            } else if (selectOperation == 4) {
                if (isoperation1Selected) {
                    reportAssistent.printMontlhyReportInformation(monthlyReport);
                } else {
                    System.out.println(exceptionAlert + "\n");
                }

            } else if (selectOperation == 5) {
                if (isoperation2Selected) {
                    reportAssistent.printYearlyReportInformation(yearlyReport);
                } else {
                    System.out.println(exceptionAlert + "\n");
                }
            } else if (selectOperation == 6) {
                break;
            } else {
                System.out.println("Такой операции нет."+"\n");
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



