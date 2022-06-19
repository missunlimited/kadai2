package org.kadai2;

import java.io.IOException;
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
        ArrayList<Student> studentDetail = null; // 配列に生徒データを格納
        try {
            System.out.printf("%n");
            studentDetail = data.load();
            System.out.printf("%n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClassRoom classRoom = new ClassRoom(studentDetail);


        /**
         * 降順ソート実行
         */
        System.out.println("-------------降順ソート-------------");
        ArrayList<Student> sortStudent = classRoom.descSort();

        for (int i = 0; i < sortStudent.size(); i++) {
            System.out.print(sortStudent.get(i).getNum() + "  ");
        }
        System.out.printf("%n%n");

        /**
         * 線形探索法実行
         */
        System.out.println("-------------線形探索法-------------");
        System.out.println("出席番号を入力してください。");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        Student searchStudent = classRoom.linearSearch(target);

        if (searchStudent == null) {
            System.out.println("該当する出席番号が見つかりませんでした。");
        }else {
            System.out.println("出席番号" + target + "番は" + searchStudent.getName() + "です。");
        }
        System.out.printf("%n%n");

        /**
         * 存在するStudentの数をコンソールに出力
         */
        System.out.println("----------コンソールに出力----------");
        int numberOfStudent = classRoom.printStudent();

        System.out.println("生徒の数は" + numberOfStudent + "人です。");

        for (int i = 0; i < numberOfStudent; i++) {
            Student tempStudent = classRoom.getStudentList().get(i);
            System.out.println(tempStudent.getNum() + " " + tempStudent.getName() + " " + tempStudent.checkEvenOdd());
        }
    }
}
