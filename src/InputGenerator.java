/*
 * Copyright (c) 2017 Ethan Zeigler, Eric Giovannini
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
