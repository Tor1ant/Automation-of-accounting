
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonthlyReport {
    HashMap<Integer, ArrayList<MonthData>> monthlyReportDataHashMap = new HashMap<>();

    void getMonthlyReport() {
        List<String> fileNames = Resources.getFileNames();
        for (String name :
                fileNames) {
            if (!name.startsWith("m.")) {
                continue;
            }
            for (int i = 1; i <= 12; i++) {
                if (Integer.parseInt(name.substring(6, 8)) == i) {
                    List<String> content = Resources.readFileContentsOrNull(name);
                    if (content != null) {
                        for (int j = 1; j < content.size(); j++) {
                            String[] lines = content.get(j).split(",");
                            String itemName = lines[0];
                            boolean isExpense = Boolean.parseBoolean(lines[1]);
                            int quantity = Integer.parseInt(lines[2]);
                            int sumOfOne = Integer.parseInt(lines[3]);
                            final var monthData = new MonthData(itemName, isExpense, quantity, sumOfOne);
                            final List<MonthData> data = monthlyReportDataHashMap.computeIfAbsent(i, k ->
                                    new ArrayList<>());
                            data.add(monthData);
                        }
                    }
                }
            }
        }
    }
}
