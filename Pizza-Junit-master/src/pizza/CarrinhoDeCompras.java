package pizza;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras  {
	private List<Pizza> pizzas = new ArrayList<>() ; 
	private static double valorPizza;


	public String adicionar(Pizza pizza){  
    	//Confere a quantidade de pizzas e se há ingredientes
        if (pizza.possuiIngredientes() == true) {  
            pizzas.add(pizza);
            System.out.println("\n");
            System.out.println("Total de pizzas no carrinho ate o momento: "+pizzas.size());
            return String.valueOf(pizzas.size());
        }else{
        	System.out.println("Pizza sem ingredientes");
        	return "Pizza sem ingredientes";
        } 
    }
    
   
}

