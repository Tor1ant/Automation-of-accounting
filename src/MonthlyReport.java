import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;


public class MonthlyReport {
    private final ArrayList<String> monthlyReportInLines = new ArrayList<>();
    ArrayList<MonthData> listOfMonthData = new ArrayList<>();


    void getMonthlyReport(int i) {
        String filename;
//        for (int i = 1; i < 4; i++) {
        filename = "m.20210" + i + ".csv";
        String fileData = readFileContentsOrNull(filename);
        dofileDataArray(fileData);
        getMonthDataObjects(monthlyReportInLines);
        // этот метод вызывается в конце считывания файла
        monthlyReportInLines.clear();
//        }


    }

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of("./resources/" + path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    private void dofileDataArray(String fileData) {
        String[] lines = fileData.split("\n");
        Collections.addAll(monthlyReportInLines, lines);
    }

    private void getMonthDataObjects(ArrayList<String> monthlyReportInLines) {
        for (int i = 1; i < monthlyReportInLines.size(); i++) {
            String[] lines = monthlyReportInLines.get(i).split(",");
            String itemName = lines[0];
            boolean is_expense = Boolean.parseBoolean(lines[1]);
            int quantity = Integer.parseInt(lines[2]);
            int sum_of_one = Integer.parseInt(lines[3]);
            listOfMonthData.add(new MonthData(itemName, is_expense, quantity, sum_of_one));
        }
    }


}
