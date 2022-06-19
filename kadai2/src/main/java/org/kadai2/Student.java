package org.kadai2;

public abstract class Student {
    /**
     * メンバ変数として、名前、身長、出席番号をもつ
     */

    private String name;
    private double height;
    private int num;

    public Student(String name, double height, int num) {
        this.name = name;
        this.height = height;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getNum() {
        return num;
    }

    public abstract Object checkEvenOdd();

}
