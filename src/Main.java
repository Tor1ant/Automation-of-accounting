

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static final String exceptionAlert = "Для проведения операции необходимо считать месячные и годовой отчеты";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isoperation1Selected = false;
        boolean isoperation2Selected = false;
        MonthlyReport monthlyReport1 = new MonthlyReport();
        MonthlyReport monthlyReport2 = new MonthlyReport();
        MonthlyReport monthlyReport3 = new MonthlyReport();
        HashMap<String, ArrayList<MonthData>> monthDataByMonths = new HashMap<>();
        YearlyReport yearlyReport = new YearlyReport();
        ReportsComparator reportsComparator;
        ReportsComparator reportsComparator2;
        ReportsComparator reportsComparator3;

        while (true) {
            System.out.println("Выберите операцию:");
            printMenu();
            int selectOperation = Integer.parseInt(scanner.nextLine());
            if (selectOperation == 1) {
                monthlyReport1.getMonthlyReport(1);
                monthlyReport2.getMonthlyReport(2);
                monthlyReport3.getMonthlyReport(3);
                monthDataByMonths.put("Январь", monthlyReport1.listOfMonthData);
                monthDataByMonths.put("Февраль", monthlyReport2.listOfMonthData);
                monthDataByMonths.put("Март", monthlyReport3.listOfMonthData);
                isoperation1Selected = true;
                System.out.println("Месячные отчеты считаны.");
            } else if (selectOperation == 2) {
                yearlyReport.doYearlyReport(2021, "y.2021.csv");
                isoperation2Selected = true;
                System.out.println("Готовой отчет считан.");
            } else if (selectOperation == 3) {
                if (isoperation1Selected && isoperation2Selected) {
                    reportsComparator = new ReportsComparator();
                    reportsComparator2 = new ReportsComparator();
                    reportsComparator3 = new ReportsComparator();
                    reportsComparator.getProfitsAndExpenses(monthlyReport1);
                    reportsComparator2.getProfitsAndExpenses(monthlyReport2);
                    reportsComparator3.getProfitsAndExpenses(monthlyReport3);
                    reportsComparator.doCompare(1, reportsComparator.profits, reportsComparator.expenses, yearlyReport.yearlyMonthsData);
                    reportsComparator2.doCompare(2, reportsComparator2.profits, reportsComparator2.expenses, yearlyReport.yearlyMonthsData);
                    reportsComparator3.doCompare(3, reportsComparator2.profits, reportsComparator2.expenses, yearlyReport.yearlyMonthsData);
                    System.out.println("Отчеты сверены");
                } else {
                    System.out.println(exceptionAlert + "\n");
                }
            } else if (selectOperation == 4) {
                if (isoperation1Selected && isoperation2Selected) {
                    MonthlyInformationPrinter informationPrinter1 = new MonthlyInformationPrinter(monthDataByMonths, "Январь");
                    MonthlyInformationPrinter informationPrinter2 = new MonthlyInformationPrinter(monthDataByMonths, "Февраль");
                    MonthlyInformationPrinter informationPrinter3 = new MonthlyInformationPrinter(monthDataByMonths, "Март");
                } else {
                    System.out.println(exceptionAlert + "\n");
                }

            } else if (selectOperation == 5) {
                if (isoperation1Selected && isoperation2Selected) {
                    System.out.println(yearlyReport.year + "\n");
                    yearlyReport.getProfit(1);
                    yearlyReport.getProfit(2);
                    yearlyReport.getProfit(3);
                    yearlyReport.getAverageExpenses();
                    yearlyReport.getAverageProfit();
                } else {
                    System.out.println(exceptionAlert + "\n");
                }
            } else if (selectOperation == 6) {
                break;
            } else {
                System.out.println("Такой операции нет.");
            }
        }

    }

    static void printMenu() {
        System.out.println("1. Считать все месячные отчёты." + "\n" +
                "2. Считать годовой отчёт." + "\n" +
                "3. Сверить отчёты." + "\n" +
                "4 Вывести информацию о всех месячных отчётах." + "\n" +
                "5 Вывести информацию о годовом отчёте." + "\n" +
                "6. закрыть программу.");
    }
}



