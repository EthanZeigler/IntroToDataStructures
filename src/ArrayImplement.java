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

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ArrayImplement {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        // open input
        BufferedReader input = new BufferedReader(new FileReader(new File(args[0])));
        int numInsert = 0, numDelete = 0, numRetrieve = 0;

        List<Integer> data = new ArrayList<>();

        while (true) {
            String line = input.readLine();
            String lineData[];
            if (line == null) {
                break;
            } else {
                lineData = line.split("[ ]");
            }
            int operation = Integer.parseInt(lineData[0]);
            int num = Integer.parseInt(lineData[1]);
            switch (operation) {
                case 0:
                    // write
                    if (!data.contains(num)) {
                        data.add(num);
                        numInsert++;
                    }
                    break;
                case 1:
                    // delete
                    if (data.remove((Integer) num)) {
                        numDelete++;
                    }
                    break;
                case 2:
                    // retrieve
                    if (data.contains(num)) {
                        numRetrieve++;
                    }
            }
        }

        input.close();

        long millisToComplete = System.currentTimeMillis() - startTime;
        System.out.println("Insertions:\t\t" + numInsert);
        System.out.println("Deletions:\t\t" + numDelete);
        System.out.println("Retrievals:\t\t" + numRetrieve);
        System.out.println("Final data size:\t" + data.size());
        System.out.println("Time:\t\t\t" + millisToComplete / 1000D + " seconds");
    }
}
