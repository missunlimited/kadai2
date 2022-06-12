package org.kadai2;

public class Odd extends Student {
    public Odd(String name, double height, int num) {
        super(name, height, num);
    }

    @Override
    public String checkEvenOdd() {
        if ((this.getNum() % 2) == 1) {
            try {
                return "odd";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
