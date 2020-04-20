package died.guia06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {	
		
		Alumno a1 = new Alumno("Juan", 123);
		Alumno a2 = new Alumno("Pedro", 567);
		
		Curso c1 = new Curso(1, "C1", 1, 10, 10, 0);
		Curso c2 = new Curso(2, "C2", 1, 10, 6, 5);
		
		c1.inscribir(a1);
		
		c1.inscribir(a2);
		
		c1.imprimirInscriptosPorNombre();
		
		a2.aprobar(c1);
		
		System.out.println("Creditos obtenidos por Juan: "+a1.creditosObtenidos());
		System.out.println("Creditos obtenidos por Pedro: "+a2.creditosObtenidos());
		
		c2.inscribir(a1);
		
		c2.inscribir(a2);
		
		c2.imprimirInscriptosPorLibreta();
	
	}
}
