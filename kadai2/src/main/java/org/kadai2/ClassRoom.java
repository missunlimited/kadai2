package org.kadai2;

import java.util.ArrayList;

public class ClassRoom {
    private final ArrayList<Student> studentList; // フィールド

    public ClassRoom(ArrayList<Student> studentList) { // コンストラクタ
        this.studentList = studentList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    /**
     * 降順　挿入ソート
     * @return sortStudent
     */
    public ArrayList<Student> descSort() {
        ArrayList<Student> sortStudent = new ArrayList<>(); // 降順ソートした生徒データを格納する

        for (int i = 0; i < this.studentList.size(); i++) {
            sortStudent.add(this.studentList.get(i));
        }

        for(int i = 1; i < sortStudent.size(); i++){
            Student indexStudent = sortStudent.get(i);
            int j = i;
            while(j > 0 && indexStudent.getHeight() > sortStudent.get(j - 1).getHeight()){ // 隣同士の生徒を比較
                sortStudent.set(j, sortStudent.get(j - 1)); // j番目にj-1番目の生徒を上書き
                j--; //jをデクリメント
            }
            sortStudent.set(j, indexStudent); // while処理がされなかったときj番目にi番目の生徒を置き換える
        }
        System.out.printf("%n");
        return sortStudent;
    }

    /**
     * 線形探索法
     * @return searchStudent
     */
    public Student linearSearch(int target) {

        for (int i = 0; i< this.studentList.size(); i++) {
            if (this.studentList.get(i).getNum() == target) {
                return this.studentList.get(i);
            }
        }
        return null;
    }

    /**
     * 存在するStudentの数をコンソールに出力
     * @return studentList.size()
     */
    public int printStudent() {
        return studentList.size();
    }
}
