package died.guia06;

import java.util.Comparator;

public class AlumnoCreditosComparator implements Comparator<Alumno> {

	@Override
	public int compare(Alumno a1, Alumno a2) {
		return (a1.creditosObtenidos().compareTo(a2.creditosObtenidos()));
	}

}
