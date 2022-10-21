package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("1_01");
        strings.add("11_02");
        strings.add("111_03");
        strings.add("1111111_04");
        strings.add("111_05");
        strings.add("111111111111_06");
        strings.add("111111_07");
        strings.add("11111111111111_08");
        strings.add("11111111_09");
        strings.add("11111_10");
        strings.add("111111111111_11");

        System.out.println();
        System.out.print("Введіть кількість колонок - ");
        Scanner scanner = new Scanner(System.in);
        int choiceColumn = scanner.nextInt();
        //int choiceRow = (strings.size() / choiceColumn) + 1;
        //int choiceRow = (int) Math.round(1.0 * strings.size() / choiceColumn);
        int choiceRow = (int) Math.ceil(1.0 * strings.size() / choiceColumn);
        System.out.println("choiceRow = " + choiceRow);

        //strings.forEach(System.out::println); // виведення первинного масиву

        int mass = 0;
        int countLines = 1;
        List<List<String>> listLines = new ArrayList<>();
        for (String string : strings) {
            //System.out.println("mas = " + mass + "; countLines = " + countLines);
            if (countLines == 1) {
                List<String> newRow = new ArrayList<>();
                listLines.add(newRow);
            }
            listLines.get(mass).add(string);
            //if(countLines != 0 && countLines % choice == 0){
            //System.out.println("countLines % choiceRow = " + countLines % choiceRow);
            if (countLines % choiceRow == 0) {
                mass++;
                countLines = 1;
            } else {
                countLines++;
            }
            //System.out.println("mas = " + mass + "; countLines = " + countLines);
        }

        System.out.println("------------------------------------------------------------------");

        int column = 0;
        int sizeLine = 0;
        for (int i = 0; i < choiceRow; i++) {
            //column = 0;
            for (List<String> listLine : listLines) {
                if (listLine.size() > column) {
                    sizeLine = maxLine(listLine) - listLine.get(column).length();
                    System.out.print(listLine.get(column));
                    printSpace(sizeLine);
                    //System.out.print("sizeLine = " + sizeLine + " ");
                }
            }
            System.out.println();
            column++;
        }
    }

    public static void printSpace(int sizeLine){
        for (int i = 0; i <= sizeLine; i++) {
            System.out.print(" ");
        }
    }
    public static int maxLine(List<String> strings) {
        int size = 0;
        for (String string : strings) {
            int sizeString = string.length();
            if (sizeString > size) {
                size = sizeString;
            }
        }
        return size;
    }

}
