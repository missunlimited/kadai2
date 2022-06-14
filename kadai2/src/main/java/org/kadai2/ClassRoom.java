package org.kadai2;

import java.util.ArrayList;

public class ClassRoom {
    private ArrayList<Student> studentList;

    public ClassRoom(ArrayList<Student> studentList) {
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
        for(int i = 1; i < studentList.size(); i++){
            Student indexStudent = studentList.get(i);
            int j = i;
            while(j > 0 && indexStudent.getHeight() > studentList.get(j - 1).getHeight()){ // 隣同士の生徒を比較
                studentList.set(j, studentList.get(j - 1)); // j番目にj-1番目の生徒を置き換える
                j--; //jをデクリメント
            }
            studentList.set(j, indexStudent); // j番目にi番目の生徒を置き換える
        }
        return studentList;
    }

    /**
     * TODO 線形探索法
     * @return
     */
    public ArrayList<Student> linearSearch() {
        for (int i = 0; i< studentList.size(); i++) {
            if (studentList.get(i).getNum() == i) {
                int position = i;
                break;
            }
        }
        return studentList;
    }

    /**
     * TODO 存在するStudentの数をコンソールに出力
     * @return
     */
    public ArrayList<Student> countStudent() {
        System.out.println("生徒の数は" + studentList.size() + "人です。");
        return studentList;
    }
}
