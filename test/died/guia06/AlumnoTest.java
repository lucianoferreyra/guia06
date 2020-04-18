package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	private List<Curso> cursando;
	private List<Curso> prueba;

	@Test
	void testCreditosObtenidos() {
		Alumno a1 = new Alumno();
		Curso c1 = new Curso(1, "C1", 1, 10, 6, 0);
		Curso c2 = new Curso(2, "C2", 1, 10, 10, 0);
		prueba = null;
		prueba.add(c1);
		prueba.add(c2);
		a1.setAprobada(prueba);
		Integer cred = a1.creditosObtenidos();
		assertEquals(16, cred);
	}

	@Test
	void testAprobar() {
		Alumno a1 = new Alumno();
		Curso c1 = new Curso(1, "C1", 1, 10, 6, 0);
		cursando = null;
		cursando.add(c1);
		List<Curso> aprobada = null;
		a1.setCursando(cursando);
		a1.setAprobada(aprobada);
		a1.aprobar(c1);
		assertTrue(a1.getAprobados().contains(c1) && !(a1.getCursando().contains(c1)));
	}

	@Test
	void testInscripcionAceptada() {
		Alumno a1 = new Alumno();
		Curso c1 = new Curso(1, "C1", 1, 10, 6, 0);
		a1.inscripcionAceptada(c1);
		assertTrue(a1.getCursando().contains(c1));
	}
	

}
