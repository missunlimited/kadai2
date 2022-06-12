package org.kadai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Data {
    /**
     * CSV読み込み
     * @throws FileNotFoundException
     */
    public void load() throws FileNotFoundException {
        String fileName = "src/main/java/org/data/data.csv";
        File f = new File(fileName);
        String studentData;
        BufferedReader br = new BufferedReader(new FileReader(f));

        ArrayList<ArrayList<String>> twoDStudentList = new ArrayList<>();

        /**
         * 配列生成
         */
        try {

            while ((studentData = br.readLine()) != null) {

                ArrayList<String> studentList = new ArrayList<>();
                String[] studentDataSplit = studentData.split(",");

                for (String splitedStudentData : studentDataSplit) {
                    studentList.add(splitedStudentData);
                }

                twoDStudentList.add(studentList);
            }
//            System.out.println(twoDStudentList); // [[あ, 150, 1], [い, 160, 2], [う, 170, 3], [え, 180, 4], [お, 190, 5]]

//            for (ArrayList<String> twoDStudentListElements : twoDStudentList) {
//                System.out.println(twoDStudentListElements.get(2)); // 1, 2, 3, 4, 5
//            }

            /**
             * even.checkEvenOdd()出力
             */
            for (ArrayList<String> twoDStudent : twoDStudentList) {
                int studentHeight = Integer.parseInt(twoDStudent.get(1));
                int studentNum = Integer.parseInt(twoDStudent.get(2));
                Even even = new Even(twoDStudent.get(0), studentHeight, studentNum);
                System.out.println(even.checkEvenOdd());
            }

            System.out.println();

            /**
             * odd.checkEvenOdd()出力
             */
            for (ArrayList<String> twoDStudent : twoDStudentList) {
                int studentHeight = Integer.parseInt(twoDStudent.get(1));
                int studentNum = Integer.parseInt(twoDStudent.get(2));
                Odd odd = new Odd(twoDStudent.get(0), studentHeight, studentNum);
                System.out.println(odd.checkEvenOdd());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
