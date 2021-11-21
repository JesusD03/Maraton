package model;

import exceptions.ProgramadorRepetidoException;

public class Maraton {
	
	private int numProgramadores;
	private Programador programadorRaiz;
	
	public Maraton() {
		numProgramadores = 0;
	}
	
	public void agregarProgramador(String n, String t, String d, String em) throws ProgramadorRepetidoException {
		
		Programador p = new Programador(n, t, d, em);
		
		if(programadorRaiz == null) {
			programadorRaiz = p;
		}else {
			agregarProgramador(p, programadorRaiz);
		}
		
	}
	
	private void agregarProgramador(Programador n, Programador r) throws ProgramadorRepetidoException {
		
		boolean added = false;
		
		while(!added) {
			if(n.compareTo(r) == 0) {
				throw new ProgramadorRepetidoException();
			}else if(n.compareTo(r)<0) {
				if(r.getIzq() == null) {
					r.setIzq(n);
					numProgramadores++;
					added = true;
				}else {
					r = r.getIzq();
				}
			}else {
				if(r.getDer() == null) {
					r.setDer(n);
					numProgramadores++;
					added = true;
				}else {
					r = r.getDer();
				}
			}
		}
		
	}
	// este metodo no se usa
	public void eliminarProgramador(String name) {
		
	}
	// este metodo no se usa
	public Programador buscarProgramador(String name) {
		return null;
	}
	
	public String[] darListaProgramadores() {
		String list[] = new String[2];
		if(programadorRaiz != null) {
			list [0] = inorden(programadorRaiz);
			list [1] = String.valueOf(programadorRaiz.darAltura());
		}else {
			list [0] = "Actualmente no hay programadores registrados\n";
			list [1] = "No se puede calcular la altura porque no hay programadores\n";
		}
		return list;
	}
	
	public String inorden(Programador p) {
		String list = "";
		if( p != null) {
			if(p.getIzq() != null) {
				list += inorden(p.getIzq());
			}
			list += p.toString();
			if(p.getDer() != null) {
				list += inorden(p.getDer());
			}
		}
		return list;
	}

	public int getNumProgramadores() {
		return numProgramadores;
	}
	
	
	
}
