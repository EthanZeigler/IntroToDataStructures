import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethan Zeigler on 5/6/17.
 */
public class InputGenerator {
    static boolean hasWrittenLine = false;

    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter(args[0]);

        Integer size = Integer.parseInt(args[1]);
        List<Integer> data = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            int operation = (int) (Math.random() * 3);

            switch (operation) {
                case 2:
                    // check for existence
                    if (!data.isEmpty()) {
                        int num2 = data.get((int) (Math.random() * data.size()));
                        writeLine(fileWriter, 2, num2);
                        break;
                    }
                case 1:
                    // delete
                    if (Math.random() < 0.5 && !data.isEmpty()) {
                        int num2 = data.get((int) (Math.random() * data.size()));
                        writeLine(fileWriter, 1, num2);
                        break;
                    }
                case 0:
                    // write
                    int number = (int) (Math.random() * 100000000);
                    data.add(number);
                    writeLine(fileWriter, 0, number);
                    break;
            }
        }

        fileWriter.close();
    }

    public static void writeLine(FileWriter writer, int operation, int data) throws IOException {
        if (hasWrittenLine) {
            writer.write("\n");
        } else {
            hasWrittenLine = true;
        }
        writer.write(operation + " " + data);
    }
}
