package org.kadai2;

import java.util.ArrayList;

public class ClassRoom {
    private ArrayList<Student> studentList;

    /**
     * 降順ソート
     * 引数なしで
     */
    public void descSort() {
        for(int i = 0; i < studentList.size(); i++){
            double indexStudent = studentList.get(i).getHeight();
            int j = i;
            while(j > 0 && indexStudent > studentList.get(i).getHeight()[j - 1]){
                student[j] = student[j - 1];
                j--;
            }
            student[j] = indexStudent;
        }

        for (int i = 0; i < studentList.size(); i++){
            System.out.print(studentList.get(i) + " ");

        }
    }
}
