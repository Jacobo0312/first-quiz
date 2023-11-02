package org.velezreyes.quiz.question6;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

  private static VendingMachine instance;
  private int quarters = 0;
  private static final List<Drink> drinks = initializeDrinks();

  private static List<Drink> initializeDrinks() {
    List<Drink> drinkList = new ArrayList<>();
    drinkList.add(new DrinkImpl("ScottCola", true, 3));
    drinkList.add(new DrinkImpl("KarenTea", false, 4));
    return drinkList;
  }

  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

  @Override
  public void insertQuarter() {
    this.quarters++;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {

    Drink drink = getDrink(name);

    if (this.quarters < drink.getPrice()) {
      throw new NotEnoughMoneyException();
    }

    this.quarters -= drink.getPrice();
    return drink;
  }

  private Drink getDrink(String name) throws UnknownDrinkException {
    return drinks.stream()
        .filter(drink -> drink.getName().equals(name))
        .findFirst()
        .orElseThrow(UnknownDrinkException::new);
  }
}
