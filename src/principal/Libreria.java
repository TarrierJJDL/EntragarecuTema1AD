package principal;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Libreria {
	
	public void Libreria() {
		
	}

	public void guardar(Libro l, String f) {
		ObjectOutputStream out=null;
		
			try {
				out = new ObjectOutputStream(new FileOutputStream (f));
				out.writeObject(l);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				intentarCerrar(out);
			}
			
		
	}
	
	public void intentarCerrar(Closeable aCerrar) {
		try {
			if (aCerrar!=null) {
				aCerrar.close();
			}
		}catch( IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
	
	public Libro recuperar(String f) {
		Libro l=null;
		ObjectInputStream in=null;
		try {
			in= new ObjectInputStream(new FileInputStream (f));
			l= (Libro) in.readObject();
		}catch(ClassNotFoundException ex) {
			System.err.println("Error de fichero");
		}catch (IOException ex) {
			System.err.println("Error IO");
		}finally {
			intentarCerrar(in);
		}
		return l;
	}
}
