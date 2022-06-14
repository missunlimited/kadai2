package org.kadai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Data {
    /**
     * CSVファイル読み込み
     * @return
     */
    public ArrayList<Student> load() {
        String fileName = "src/main/java/org/data/data.csv";
        File f = new File(fileName);
        String studentData;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Student> studentDetail = new ArrayList<>(); // [生徒の名前, 身長, 出席番号]
        ArrayList<ArrayList<String>> allStudents = new ArrayList<>(); // [[生徒1, 150, 1], [生徒2, 160, 2], ...]


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

                allStudents.add(studentList); // [[生徒1, 150, 1], [生徒2, 160, 2], ...]
            }

            for (int i = 0; i < allStudents.size(); i++) {
                if (i % 2 == 1) {
                    Student odd = new Odd(allStudents.get(i).get(0), Double.parseDouble(allStudents.get(i).get(1)), Integer.parseInt(allStudents.get(i).get(2)));
                    studentDetail.add(odd);
                }else {
                    Student even = new Even(allStudents.get(i).get(0), Double.parseDouble(allStudents.get(i).get(1)), Integer.parseInt(allStudents.get(i).get(2)));
                    studentDetail.add(even);
                }
            }
            System.out.println(allStudents); // [[生徒1, 150, 1], [生徒2, 160, 2], [生徒3, 170, 3], [生徒4, 180, 4], [生徒5, 190, 5]]
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                br.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return studentDetail;
    }
}
