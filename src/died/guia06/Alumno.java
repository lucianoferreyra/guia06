package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno() {
		super();
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}

	public int creditosObtenidos() {
		int creditos = 0;
		
		for(Curso c : aprobados) {
			creditos += c.getCreditos();
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		this.aprobados.add(c);
		this.cursando.remove(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}

	public boolean equals(Alumno a) {
		if(this.nroLibreta.equals(a.nroLibreta)) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Alumno a) {
		return(a.nombre.compareTo(this.nombre));
	}
	
	public void setAprobada(List<Curso> c) {
		this.aprobados = c;
	}
	
	public void setCursando(List<Curso> c) {
		this.cursando = c;
	}
	
	public List<Curso> getAprobados() {
		return this.aprobados;
	}
	
	public List<Curso> getCursando() {
		return this.cursando;
	}

}
