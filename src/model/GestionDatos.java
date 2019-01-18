package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import view.LaunchView;


public class GestionDatos {
	
	public GestionDatos() {

	}

	//TODO: Implementa una función para abrir ficheros
	
	//TODO: Implementa una función para cerrar ficheros
	
	public void FileReader () {
		
	}
	
	
	public boolean compararContenido (String fichero1, String fichero2) throws IOException{
		
		FileReader fr1 = new FileReader(fichero1);
		FileReader fr2 = new FileReader(fichero2);
		 
		BufferedReader bf1 = new BufferedReader(fr1);
		BufferedReader bf2 = new BufferedReader(fr2);
		
		boolean igu = true;
		String sCadena1 = bf1.readLine();
		 String sCadena2 = bf2.readLine();
		  
		while ((sCadena1!=null) || (sCadena2!=null) && igu) {

			if (sCadena1 == null || sCadena2== null || !sCadena1.equals(sCadena2)) {
				igu = false;
			}
				
			
			sCadena1 = bf1.readLine();
			sCadena2 = bf2.readLine();
		} 
		fr1.close();
		fr2.close();
		bf1.close();
		bf2.close();
		 
		return igu;
		  	
		
	}
	
	public String contarPalabra (String fichero1, String cant) throws IOException{
		//TODO: Implementa la función
		FileReader fr1=new FileReader(fichero1);
		BufferedReader bf1=new BufferedReader(fr1);

		String Cadena1 = bf1.readLine();
		
		int cont=0; String result;		
		int num = Integer.parseInt(cant);
		if(num==0) {
			result="-1";
		}
		else {
			while (cont<num) {
				cont++;
				Cadena1=bf1.readLine();
			}
			if(cont>num) {
				result="-1";
			}else {
				result=""+cont;
			}
						
		}

		fr1.close();
		bf1.close();



		return result;
	}	
	
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera) throws IOException{
		//TODO: Implementa la función
		FileReader fr1=new FileReader(fichero1);
		BufferedReader bf1=new BufferedReader(fr1);

		String Cadena1 = bf1.readLine();
		boolean encontrada = false;
		int cont=0; int linea=0; int result;		
		if(primera) {
			while ((Cadena1!=null) && encontrada==false) {
				cont++;
				if(Cadena1.compareTo(palabra)==0) {
					encontrada=true;
					linea=cont;
				}
				Cadena1=bf1.readLine();
			}
			if(linea==0) {
				result=-1;
			}else {
				result=linea;
			}

		}
		else {
			while ((Cadena1!=null)) {
				cont++;
				if(Cadena1.compareTo(palabra)==0) {
					linea=cont;
				}
				Cadena1=bf1.readLine();
			}
			if(linea==0) {
				result=-1;
			}else {
				result=linea;
			}

		}

		fr1.close();
		bf1.close();



		return result;
	}	
		

}
