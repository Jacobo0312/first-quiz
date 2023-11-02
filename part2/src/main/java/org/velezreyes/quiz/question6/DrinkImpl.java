package org.velezreyes.quiz.question6;

public class DrinkImpl implements Drink{

    private String name;
    private boolean isFizzy;
    private int price;


    public DrinkImpl(String name, boolean isFizzy,int price) {
        this.name = name;
        this.isFizzy = isFizzy;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isFizzy() {
        return this.isFizzy;
    }

    @Override
    public int getPrice(){
        return this.price;
    }
    
}
