package com.eZer;

public class Main {

    public static void main(String[] args) {

        String text="10 + 6 - 3";
        String data[] =text.split(" ");

        Expression e = new Number(Integer.parseInt(data[0]));

        for (int i=0;i<data.length;i++){
            if(!data[i].matches("[0-9]*")){
                if(data[i].equals("+")){
                    int next = Integer.parseInt(data[i+1]);
                    e = new Plus(e,new Number(next));
                }else{
                    int next = Integer.parseInt(data[i+1]);
                    e = new Minus(e,new Number(next));
                }
            }
        }

        System.out.println(e.interprer());
    }
}

interface Expression{
    int interprer();
}

class Plus implements Expression{

    Expression ex1;
    Expression ex2;

    public Plus(Expression ex1, Expression ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    @Override
    public int interprer() {
        return ex1.interprer()+ex2.interprer();
    }
}

class Minus implements Expression{

    Expression ex1;
    Expression ex2;

    public Minus(Expression ex1, Expression ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    @Override
    public int interprer() {
        return ex1.interprer() - ex2.interprer();
    }
}

class Number implements Expression{
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interprer() {
        return this.number;
    }
}
