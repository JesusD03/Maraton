package ui;

import exceptions.ProgramadorRepetidoException;
import model.Maraton;

public class Main {
	
	private static Maraton maraton;
	
	public static void main(String[] args) {
		
		maraton = new Maraton();
		
		try {
			maraton.agregarProgramador("Jesus David", "312157485", "carrera 1", "jdcorreo@gmail.com");
			maraton.agregarProgramador("Andres ", "311258746", "carrera 2", "afcorreo@gmail.com");
			maraton.agregarProgramador("Pablo", "300264952", "carrera 3", "pcorreo@gmail.com");
			String[] list = maraton.darListaProgramadores();
			System.out.println("Los programadores registrados son: \n"+list[0]+"\n"+"La altura del arborl es: "+list[1]);
		} catch (ProgramadorRepetidoException e) {
			System.out.println("No pueden haber dos programadores con el mismo nombre");
		}
		
	}
	
}
