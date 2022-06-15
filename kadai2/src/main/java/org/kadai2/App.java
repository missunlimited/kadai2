package org.kadai2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * mainクラス
 *
 */
public class App 
{

    public static void main( String[] args ) {
        LoadStudentData data = new LoadStudentData();
        ArrayList<Student> studentDetail = data.load(); // 配列に生徒データを格納
        ClassRoom classRoom = new ClassRoom(studentDetail);

        /**
         * 降順ソート実行
         */
        ArrayList<Student> sortStudent = classRoom.descSort();

        for (int i = 0; i < sortStudent.size(); i++) {
            System.out.print(sortStudent.get(i).getNum() + " ");
        }
        System.out.println();
        System.out.println();

        /**
         * 線形探索法実行
         * TODO 探索後、何番目にいる生徒なのかを出力するのではなく、該当する生徒の名前を出力する
         */
        System.out.println("出席番号を入力してください。");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int position = classRoom.linearSearch(target);

        if (position == 0) {
            System.out.println("出席番号が見つかりませんでした。");
        }else {
            System.out.println(target + "は" + position + "番目です。");
        }


        /**
         * 存在するStudentの数をコンソールに出力
         * TODO 生徒の数をclassRoom(インスタンス)で出力できるようにする
         */
        int numberOfStudent = classRoom.countStudent();

        System.out.println("生徒の数は" + numberOfStudent + "人です。");

        ArrayList<Student> allStudent = new ArrayList<>();
        for (int i = 0; i < numberOfStudent; i++) {
            System.out.println(studentDetail.get(i).getNum() + " " + studentDetail.get(i).getName() + " " + studentDetail.get(i).checkEvenOdd());
        }

    }

}
