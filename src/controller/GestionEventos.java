package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_contar;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_compararContenido
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		
		actionListener_contar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				call_contarPalabra();
			}
		};
		view.getBuscar().addActionListener(actionListener_contar);
	}

	private void call_compararContenido() {
		try {
			if (model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText())) {
				view.getTextArea().setText("Los archivos son iguales");
			}else {
				view.getTextArea().setText("Los archivos son diferentes");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			view.showError("No existe el fichero");
		}
	}
	
	private void call_contarPalabra() {
		try {
			String result=model.contarPalabra(view.getFichero1().getText(), view.getPalabra().getText());
			if(result!="-1") {
				
					view.getTextArea().setText("El texto tiene "+result+" PALABRAS" );
				
			}else {
				view.getTextArea().setText("Registro Fallido");
			}
		} catch (IOException e) {
			view.showError("Va mal");
		}
	}

	private void call_buscarPalabra() {
		try {
			int result=model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(),view.getPrimera().isSelected());
			if(result!=-1) {
				if(view.getPrimera().isSelected()) {
					view.getTextArea().setText("La palabra `"+view.getPalabra().getText()+"� aparece por primera vez en la linea "+result );
				}else {
					view.getTextArea().setText("La palabra `"+view.getPalabra().getText()+"� aparece por ultima vez en la linea "+result );
				}
			}else {
				view.getTextArea().setText("No existe la palabra `"+view.getPalabra().getText()+"� en el archivo "+view.getFichero1().getText());
			}
		} catch (IOException e) {
			view.showError("Va mal");
		}
	}

}
