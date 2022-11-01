
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonthlyReport {

    final String path = "./resources/";
    HashMap<Integer, ArrayList<MonthData>> monthlyReportDataHashMap = new HashMap<>();
    int[] monthsNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    List<String> fileNames;

    MonthlyReport() {
        fileNames = Resources.getFileNames();
    }

    void getMonthlyReport() {


        for (String name :
                fileNames) {
            if (name.startsWith("m.")) {

                for (int monthsNumber : monthsNumbers) {
                    if (Integer.parseInt(name.substring(6, 8)) == monthsNumber) {
                        List<String> content = Resources.readFileContentsOrNull(name);
                        if (content != null) {
                            for (int j = 1; j < content.size(); j++) {
                                String[] lines = content.get(j).split(",");
                                String itemName = lines[0];
                                boolean is_expense = Boolean.parseBoolean(lines[1]);
                                int quantity = Integer.parseInt(lines[2]);
                                int sum_of_one = Integer.parseInt(lines[3]);
                                monthlyReportDataHashMap.computeIfAbsent(monthsNumber, k -> new ArrayList<>()).add(new MonthData(itemName, is_expense, quantity, sum_of_one));
                            }

                        }
                    }
                }

            }
        }

    }
}
