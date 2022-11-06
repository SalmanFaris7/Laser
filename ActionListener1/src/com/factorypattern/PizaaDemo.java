package com.factorypattern;

public class PizaaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasePizzaFactory pizzaFactory = new PizzaFactory();
		Pizza cheesePizza = pizzaFactory.createPizza("cheese");
		Pizza veggiePizza = pizzaFactory.createPizza("veggie");
	}

}
