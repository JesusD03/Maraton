package model;

public class Programador {
	
	private String nombre;
	private String telefono;
	private String direccion;
	private String eMail;
	
	private Programador izq;
	private Programador der;
	
	public Programador(String n, String t, String d, String em) {
		nombre = n;
		telefono = t;
		direccion = d;
		eMail = em;
	}
	
	public int compareTo(Programador p) {
		return nombre.compareTo(p.darNombre());
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public String darTelefono() {
		return telefono;
	}
	
	public String darDireccion() {
		return direccion;
	}
	
	public String darEmail() {
		return eMail;
	}
	
	public boolean esHoja() {
		
		if(izq == null && der == null) {
			return true;
		}else {
			return false;
		}
		
	}
	// este metodo no se usa
	public Programador darMenor() {
		return null;
	}
	// este metodo no se usa
	public Programador darMayor() {
		return null;
	}

	public int darAltura() {
		if(esHoja()) {
			return 1;
		}else {
			if(izq !=null && der !=null) {
				int left = izq.darAltura();
				int right = der.darAltura();
				return 1 + Math.max(left, right);
			}else if(der != null) {
				return 1+der.darAltura();
			}else {
				return 1+izq.darAltura();
			}
		}
	}
	// este metodo no se usa
	public int darPeso() {
		return 0;
	}
	// este metodo no se usa
	public void insertar(Programador p) {
		
	}
	// este metodo no se usa
	public Programador buscar(String name) {
		return null;
	}
	// este metodo no se usa
	public Programador eliminar(String name) {
		return null;
	}

	public Programador getIzq() {
		return izq;
	}

	public void setIzq(Programador izq) {
		this.izq = izq;
	}

	public Programador getDer() {
		return der;
	}

	public void setDer(Programador der) {
		this.der = der;
	}
	
	public String toString() {
		return "Nombre: "+nombre+"\n";
	}
	//cambie este metodo a tipo String, ya que si lo ponia void como aparece en el enunciado no habia forma de imprimir la lista
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
	
}
