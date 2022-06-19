package org.kadai2;

import java.io.*;
import java.util.ArrayList;

public class LoadStudentData {
    /**
     * CSVファイル読み込み
     * @return studentDetail
     */
    public ArrayList<Student> load() throws IOException {
        String fileName = "src/main/java/org/data/data.csv";
        File f = new File(fileName);
        String studentData;

        ArrayList<Student> studentDetail = new ArrayList<>(); // [生徒の名前, 身長, 出席番号]
        ArrayList<ArrayList<String>> allStudents = new ArrayList<>(); // [[生徒1, 150, 1], [生徒2, 160, 2], ...]

        /**
         * 配列生成
         */

        try(BufferedReader br = new BufferedReader(new FileReader(f))){
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
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return studentDetail;
    }
}
