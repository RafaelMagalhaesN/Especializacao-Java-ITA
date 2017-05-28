package models;

public class Produto {
	 String nome;
	 int preco, codigo;
	 
	public Produto(String nome, int codigo, int preco) {		
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}
	
	
	@Override
	public int hashCode(){
		int hash = 31 + this.codigo;
		return hash;		
	}
	
	@Override 
	public boolean equals(Object o){
		if(!(o instanceof Produto)){
			return false;
		}
		Produto p = (Produto) o;				
		if (this.hashCode() == p.hashCode()){
			return true;
		}			
		return false;	
	}


	public String getNome() {
		return nome;
	}


	public int getPreco() {
		return preco;
	}


	public int getCodigo() {
		return codigo;
	}
	
	 
	 
}
