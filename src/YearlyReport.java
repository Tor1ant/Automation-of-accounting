import java.util.HashMap;
import java.util.List;

public class YearlyReport {
    int year;
    HashMap<Integer, YearlyReportData> yearlyReportDataHashMap = new HashMap<>();

    void getEarlyReport() {
        List<String> fileNames = Resources.getFileNames();
        for (String name :
                fileNames) {
            if (name.startsWith("y.")) {
                year = Integer.parseInt(name.substring(2, 6));
                List<String> content = Resources.readFileContentsOrNull(name);
                if (content != null) {
                    for (int i = 1; i < content.size(); i++) {
                        String[] lines = content.get(i).split(",");
                        int month = Integer.parseInt(lines[0]);
                        int sum = Integer.parseInt(lines[1]);
                        boolean isExpense = Boolean.parseBoolean(lines[2]);
                        final var yearlyReportData = new YearlyReportData(month);
                        yearlyReportDataHashMap.putIfAbsent(month, yearlyReportData);
                        YearlyReportData oneMonthData = yearlyReportDataHashMap.get(month);
                        if (isExpense) {
                            oneMonthData.expenses += sum;
                        } else {
                            oneMonthData.income += sum;
                        }
                    }
                }
            }
        }
    }
}
