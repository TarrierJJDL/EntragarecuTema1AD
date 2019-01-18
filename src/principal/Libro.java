package principal;

import java.io.Serializable;

public class Libro implements Serializable{

	private	int iden;
	private String tit;
	private String autor;
	private int publi;
	private String ed;
	private int pag;
	
	public Libro() {
		
	}
	
	public Libro(int iden, String tit, String autor, int publi, String ed, int pag) {
		iden=0;
		tit="";
		autor="";
		publi=0;
		ed="";
		pag=0;
	}

	public int getIden() {
		return iden;
	}

	public void setIden(int iden) {
		this.iden = iden;
	}

	public String getTit() {
		return tit;
	}

	public void setTit(String tit) {
		this.tit = tit;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPubli() {
		return publi;
	}

	public void setPubli(int publi) {
		this.publi = publi;
	}

	public String getEd() {
		return ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}

	public int getPag() {
		return pag;
	}

	public void setPag(int pag) {
		this.pag = pag;
	}
	
	public void print() {
		System.out.println("Identificador: "+iden+", titulo: "+tit+", autor: "+autor+", año de publicacion: "+publi+", editor: "+ed+" y numero de paginas: "+pag+".");
	}
}
