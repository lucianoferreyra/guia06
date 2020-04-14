package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

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
	
	

}
