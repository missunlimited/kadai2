package org.kadai2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * mainクラス
 *
 */
public class App 
{

    public static void main( String[] args ) {
        Data data = new Data();
        ArrayList<Student> studentDetail = data.load(); // 配列に生徒データを格納
        System.out.println();

        /**
         * 降順ソート実行
         */
        ClassRoom classRoomDescSort = new ClassRoom(studentDetail);
        ArrayList<Student> sortStudent = classRoomDescSort.descSort(); // 降順ソートした生徒データを格納

        for (int i = 0; i < sortStudent.size(); i++) {
            System.out.println(sortStudent.get(i).getNum());
        }
        System.out.println();

        /**
         * TODO 線形探索法実行
         */
        Scanner scanner = new Scanner(System.in);
        ClassRoom classRoomLinerSearch = new ClassRoom(studentDetail);

        System.out.println("出席番号を入力してください。");
        int inputNum = scanner.nextInt();
        int position = 0;

        ArrayList<Student> searchStudent = classRoomLinerSearch.linearSearch();

        try {
            if (position == 0) {
                System.out.println("出席番号が見つかりませんでした。");
            }else {
                System.out.println(inputNum + "は" + position + "番目です。");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(searchStudent);
    }
}
