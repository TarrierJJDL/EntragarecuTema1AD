package principal;

import java.util.ArrayList;
import java.util.Iterator;



public class Libreria_Libro {

	public static void main(String[] args) {
		
		Libro l1=new Libro (1,"Hola","Jorge",2008,"Juan Baldes",205);
		
		l1.print();
		
		Libreria libreria= new Libreria();
		
		libreria.guardar(l1, "prueba");
		
		libreria.recuperar("prueba");
		
		ArrayList<Libro> recuperar_todos=new ArrayList<Libro>();
				
		recuperar_todos.add(l1);
		recuperar_todos.add(new Libro (1,"Hola","Jorge",2008,"Juan Baldes",205));
			
		Iterator it=recuperar_todos.iterator();
		while(it.hasNext()) {
			Libro l11 = (Libro) it.next();
			l11.print();
		}
	}

}
