package org.kadai2;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassRoom {
    private ArrayList<Student> studentList; // フィールド

    public ClassRoom(ArrayList<Student> studentList) { // コンストラクタ
        this.studentList = studentList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * 降順　挿入ソート
     * @return
     */
    public ArrayList<Student> descSort() {
        ArrayList<Student> sortStudent = new ArrayList<>(); // 降順ソートした生徒データを格納する

        for(int i = 1; i < this.studentList.size(); i++){
            Student indexStudent = this.studentList.get(i);
            int j = i;
            while(j > 0 && indexStudent.getHeight() > this.studentList.get(j - 1).getHeight()){ // 隣同士の生徒を比較
                this.studentList.set(j, this.studentList.get(j - 1)); // j番目にj-1番目の生徒を置き換える
                j--; //jをデクリメント
            }
            this.studentList.set(j, indexStudent); // while処理がされなかったときj番目にi番目の生徒を置き換える
        }
        for (Student sorted : studentList) {
            sortStudent.add(sorted);
        }
        System.out.println();
        return sortStudent;
    }

    /**
     * 線形探索法
     * @return
     */
    public int linearSearch(int target) {
//        ArrayList<Student> searchStudent = new ArrayList<>();
        int position = 0;

        for (int i = 0; i< this.studentList.size(); i++) {
            if (this.studentList.get(i).getNum() == target) {
                position = i + 1;
                break;
            }
        }

//        for (Student searched : this.studentList) {
//            searchStudent.add(searched);
//        }

        System.out.println();
        return position;
    }

    /**
     * 存在するStudentの数をコンソールに出力
     * @return
     */
    public int countStudent() {

        return studentList.size();
    }

//    public void checkEvenOdd() {
//        for (int i = 0; i < studentList.size(); i++) {
//            if (studentList.get(i).getNum() % 2 == 0) {
//                Even even = new Even(studentList.get(i).getName(), studentList.get(i).getHeight(), studentList.get(i).getNum());
//            }else {
//                Odd odd = new Odd(studentList.get(i).getName(), studentList.get(i).getHeight(), studentList.get(i).getNum());
//            }
//        }
//
//    }


}
