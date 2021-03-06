package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, Integer creditos, Integer creditosRequeridos) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.cicloLectivo = cicloLectivo;
			this.cupo = cupo;
			this.creditos = creditos;
			this.creditosRequeridos = creditosRequeridos;
			this.inscriptos = new ArrayList<Alumno>();
			this.log = new Registro();
		}

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
	
		int contCiclo = 0; 
		for(Curso c : a.getCursando()) {         // Obtener la cantidad de materias del mismo ciclo lectivo del curso.
			if(c.cicloLectivo.equals(this.cicloLectivo)) {
				contCiclo++;
			}
		}
		
		// Evaluar las condiciones necesarias para la inscripcion al curso.
		if((a.creditosObtenidos() >= this.creditosRequeridos) && (this.cupo > this.inscriptos.size()) &&  (contCiclo < 3)) {	
				try {
				log.registrar(this, "inscribir ",a.toString());
				inscriptos.add(a);
				a.inscripcionAceptada(this);
				System.out.println("El alumno "+ a.getNombre() + " ha sido inscripto con  exito.");
			} catch(IOException e) {
				System.out.println("Error al inscribir al alumno: " + e.getMessage());
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptosPorLibreta() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			//System.out.println();
			
			Collections.sort(this.getInscriptos(), new AlumnoLibretaComparator());
			System.out.println(this.getInscriptos());

		} catch(IOException e) {
			System.out.println("Error en el archivo: " + e.getMessage());
		}
	}
	
	public void imprimirInscriptosPorCreditos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			//System.out.println();
			
			Collections.sort(this.getInscriptos(), new AlumnoCreditosComparator());
			System.out.println(this.getInscriptos());

		} catch(IOException e) {
			System.out.println("Error en el archivo: " + e.getMessage());
		}
	}
	
	public void imprimirInscriptosPorNombre() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			//System.out.println();
			
			Collections.sort(this.getInscriptos(), new AlumnoNombreComparator());
			System.out.println(this.getInscriptos());

		} catch(IOException e) {
			System.out.println("Error en el archivo: " + e.getMessage());
		}
	}
	
	
	public void inscribirAlumno(Alumno a) throws Exception {
		
		int contCiclo = 0; 
		for(Curso c : a.getCursando()) {         // Obtener la cantidad de materias del mismo ciclo lectivo del curso.
			if(c.cicloLectivo.equals(this.cicloLectivo)) {
				contCiclo++;
			}
		} 
		
		if(a.creditosObtenidos() < this.creditosRequeridos) {
			throw new InscribirAlumnoException("El alumno no posee los creditos requeridos por el curso.");
		}
		if(this.cupo <= this.inscriptos.size()) {
			throw new InscribirAlumnoException("El cupo del curso ya se ha completado.");
		}
		if(contCiclo >= 3) {
			throw new InscribirAlumnoException("El alumno ya esta cursando tres materias del mismo ciclo  lectivo.");
		}
		
		try {
			log.registrar(this, "inscribir ",a.toString());
			inscriptos.add(a);
			System.out.println("El alumno "+ a.getNombre() + " ha sido inscripto con  exito.");
			a.inscripcionAceptada(this);
		}
		catch(IOException e) {
			throw new RegistroAuditoriaException("Ha ocurrido un error en el archivo de registro.");
		}
	}
	
	
	
	public int getCreditos() {
		return (this.creditos);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public List<Alumno> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	
	
	
}
