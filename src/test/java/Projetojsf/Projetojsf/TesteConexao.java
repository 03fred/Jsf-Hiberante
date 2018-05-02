package Projetojsf.Projetojsf;


import javax.persistence.Persistence;


public class TesteConexao {
	 
	public static void main(String[] args)
	  {
			
	    Persistence.createEntityManagerFactory("Projetojsf");

	  }
}
