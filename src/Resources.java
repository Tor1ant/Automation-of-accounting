import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Resources {
    static final String relativePath = "./resources/";

    static List<String> readFileContentsOrNull(String fileName) {
        try {
            return Files.readAllLines(Path.of(relativePath + fileName));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной" +
                    " директории.");
            return null;
        }
    }

    static List<String> getFileNames() {
        File dir = new File("./resources/");
        List<String> lst = new ArrayList<>();
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isFile())
                lst.add(file.getName());
        }
        return lst;
    }
}