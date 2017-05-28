package pizza;

import java.io.BufferedReader;

public class Principal  {

	private String pizza;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Novas instancias
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		
		String[] ingrediente = new String[12];
		ingrediente[0] = "mussarela";
		ingrediente[1] = "cebolas";
		ingrediente[2] = "queijo";
		ingrediente[3] = "tomates";
		ingrediente[4] = "ovo";
		ingrediente[5] = "presunto";
		ingrediente[6] = "rucula";
		ingrediente[7] = "frango desfiado";
		ingrediente[8] = "parmessao";
		ingrediente[9] = "bacon";
		ingrediente[10] = "milho";
		ingrediente[11] = "ervilhas";
		
			//Faz as 3 pizzas
		
		    Pizza queijo = new Pizza();
		    queijo.adicionaIngrediente(ingrediente[2], 1);
		    queijo.adicionaIngrediente(ingrediente[3], 1);		    
		    carrinho.adicionar(queijo);
		    System.out.println("O valor total do seu pedido ate o momento é: R$"+queijo.getPreco());	
		
		    Pizza portuguesa = new Pizza();
		    portuguesa.adicionaIngrediente(ingrediente[2], 1);
		    portuguesa.adicionaIngrediente(ingrediente[5], 1);	    
		    portuguesa.adicionaIngrediente(ingrediente[3], 1);	
		    portuguesa.adicionaIngrediente(ingrediente[4], 3);	
		    portuguesa.adicionaIngrediente(ingrediente[7], 3);	
		    portuguesa.adicionaIngrediente(ingrediente[10], 3);	
		    portuguesa.adicionaIngrediente(ingrediente[11], 3);	
		    carrinho.adicionar(portuguesa);
		    System.out.println("O valor total do seu pedido é: R$"+portuguesa.getPreco());
		    
		    
		    Pizza bacon = new Pizza();
		    bacon.adicionaIngrediente(ingrediente[9], 2);
		    bacon.adicionaIngrediente(ingrediente[1], 1);
		    bacon.adicionaIngrediente(ingrediente[5], 1);		  
		    carrinho.adicionar(bacon);
		    System.out.println("O valor total do seu pedido é: R$"+bacon.getPreco()+"\n");
		
		    //Imprime o resultado
		    for(int x= 0; x < ingrediente.length; x++){
		        	if(Pizza.ingredientes.get(ingrediente[x]) != null){
		        		System.out.println("O Ingrediente: "+ingrediente[x]+" foi usado "
		        											+Pizza.ingredientes.get(ingrediente[x])
		        											+" vezes");
		        	}
		     }
		    
		    
			
				
			

	}

}
