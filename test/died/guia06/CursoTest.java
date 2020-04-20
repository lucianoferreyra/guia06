package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	
	Alumno a1, a2;
	
	@BeforeEach
	public void init() {
		a1 = new Alumno("Juan", 123);
		a2 = new Alumno("Pedro", 567);
	}
	
	@Test
	void testInscribirCorrecto() {
		
		Curso c1 = new Curso(2, "C1", 1, 10, 10, 0);
		
		c1.inscribir(a1);
		c1.inscribir(a2);
		
		List<Alumno> aux = new ArrayList<Alumno>();
		aux.add(a1);
		aux.add(a2);
		
		assertEquals(c1.getInscriptos(),aux);
	}
	
	void testInscribirCreditos() {
		Alumno a1 = new Alumno("Juan", 123);
		Alumno a2 = new Alumno("Pedro", 567);
		Curso c1 = new Curso(2, "C1", 1, 10, 10, 5);
		Curso c2 = new Curso(2, "C1", 1, 10, 6, 0);
		
		List<Curso> aux = new ArrayList<Curso>();
		aux.add(c2);
		
		a2.setAprobada(aux);
		List<Alumno> aux2 = new ArrayList<Alumno>();
		aux2.add(a2);
		
		c1.inscribir(a1);
		c1.inscribir(a2);
		
		assertEquals(c1.getInscriptos(),aux2);
	}
	
	void testInscribirCupo() {
		Alumno a1 = new Alumno("Juan", 123);
		Alumno a2 = new Alumno("Pedro", 567);
		Curso c1 = new Curso(2, "C1", 1, 1, 10, 0);
		
		c1.inscribir(a1);
		c1.inscribir(a2);
		
		List<Alumno> aux = new ArrayList<Alumno>();
		aux.add(a1);
		
		assertEquals(c1.getInscriptos(),aux);
	}
	
	void testInscribirCicloLectivo() {
		Alumno a1 = new Alumno("Juan", 123);
		Alumno a2 = new Alumno("Pedro", 567);
		Curso c1 = new Curso(2, "C1", 1, 1, 10, 0);
		Curso c2 = new Curso(2, "C1", 1, 1, 10, 0);
		Curso c3 = new Curso(2, "C1", 1, 1, 10, 0);
		Curso c4 = new Curso(2, "C1", 1, 1, 10, 0);
		
		c1.inscribir(a1);
		c2.inscribir(a1);
		c3.inscribir(a1);
		c4.inscribir(a1);
		c4.inscribir(a2);
		
		List<Alumno> aux = new ArrayList<Alumno>();
		aux.add(a2);
		
		assertEquals(c4.getInscriptos(),aux);
		
		
	}

}
