package org.kadai2;

public class Even extends Student {
    public Even(String name, double height, int num) {
        super(name, height, num);
    }

    @Override
    public String checkEvenOdd() {
        if ((this.getNum() % 2) == 0) {
            try {
                return "even";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return "odd";
    }
}
