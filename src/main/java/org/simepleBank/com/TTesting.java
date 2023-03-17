package org.simepleBank.com;

public class TTesting {
    private static int x;
    private int y;

    public TTesting(int val){
        x = val;
        y = val;
    }

    public void print(){
        System.out.println(x + " " +y);
    }

    public static int getX() {
        return x;
    }

    public static void main(String[] args) {
       TTesting s1 = new TTesting(1);
       int y = TTesting.getX();
        int z = s1.getX();
       //s1.print();

       TTesting s2 = new TTesting(2);
       s1.print();
       s2.print();
    }
}
