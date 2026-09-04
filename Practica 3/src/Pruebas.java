public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** EVALUACIONES EN LA LISTA **********");
        Evaluacion evaluacion1 = new Evaluacion("ED", "Junio 19", 4.5);
        Evaluacion evaluacion2 = new Evaluacion("ED", "Julio 19", -1);
        Evaluacion evaluacion3 = new Evaluacion("ED", "Julio 20", 7.4);
        Evaluacion evaluacion4 = new Evaluacion("Algebra", "Junio 18", 6.4);

        ListaOrdinal lista = new ListaOrdinal();
        lista.insertar(evaluacion1);
        lista.insertar(evaluacion2);
        lista.insertar(evaluacion3);
        lista.insertar(evaluacion4);

        IteradorListaOrdinal it = lista.getIterador();

        while (it.hasNext()) {
            it.next().mostrar();
        }
        System.out.println("Convocatorias en ED: " + lista.numConvocatorias("ED"));
        System.out.println("Convocatorias en Algebra: " + lista.numConvocatorias("Algebra"));
        System.out.println("Convocatorias en Fundamentos de Programación: " + lista.numConvocatorias("FP"));

        Alumno alumno1 = new Alumno("Felipe García Lopez", 1253);
        Alumno alumno2 = new Alumno("Alicia Blázquez Martín", 5622);
        alumno1.nuevaEvaluacion(evaluacion1);
        alumno1.nuevaEvaluacion(evaluacion2);
        alumno1.nuevaEvaluacion(evaluacion3);
        alumno1.nuevaEvaluacion(evaluacion4);
        alumno1.asignaturasAprobadas();
        System.out.println("----------- Asignaturas aprobadas por Felipe Garcia Lopez: ");
        it = alumno1.asignaturasAprobadas().getIterador();
        while (it.hasNext()) {
            it.next().mostrar();
        }
        alumno2.asignaturasAprobadas();
        System.out.println("----------- Asignaturas aprobadas por Alicia Blázquez Martín: ");
        it = alumno2.asignaturasAprobadas().getIterador();
        while (it.hasNext()) {
            it.next().mostrar();
        }
        System.out.println("----------- MOSTRAR LOS ALUMNOS ------------");
        alumno1.mostrar();
        System.out.println("---------------------------------");
        alumno2.mostrar();
        System.out.println("----------- MOSTRAR LOS ALUMNOS BIBLIOTECA ------------");
        AlumnoBib alumno3 = new AlumnoBib("Eduardo Parra Martin", 8765);
        AlumnoBib alumno4 = new AlumnoBib("Sonia Torres Pardo", 2345);
        alumno3.nuevaEvaluacion(evaluacion1);
        alumno3.nuevaEvaluacion(evaluacion2);
        alumno3.nuevaEvaluacion(evaluacion3);
        alumno3.nuevaEvaluacion(evaluacion4);
        alumno3.mostrar();
        System.out.println("---------------------------------");
        alumno4.mostrar();
        System.out.println("---------------------------------");
        Alumno alumno5 = new Alumno("Pedro Jiménez del Pozo ", 8510);
        Evaluacion evaluacion5 = new Evaluacion("Fundamentos de Programacion", "Enero 19", 8.8);

        alumno5.nuevaEvaluacion(evaluacion5);
        ListaCalificada list = new ListaCalificada();
        list.insertar(alumno5);
        list.insertar(alumno1);
        list.insertar(alumno2);
        IteradorListaCalificada iter = list.getIterador();
        while (iter.hasNext()) {
            iter.next().mostrar();
        }
        System.out.println("----------------Borramos claves menores a 6000-----------------");
        list.borrarMenores(6000);
        iter = list.getIterador();
        while (iter.hasNext()) {
            iter.next().mostrar();
        }
        System.out.println("--------------Borramos claves menores a 9000-------------------");
        list.borrarMenores(9000);
        iter = list.getIterador();
        while (iter.hasNext()) {
            iter.next().mostrar();
        }
        list.insertar(alumno5);
        list.insertar(alumno1);
        list.insertar(alumno2);
        System.out.println("--------------Metemos todos los alumnos y borramos claves menores a 9000-------------------");
        list.borrarMayores(7000);
        iter = list.getIterador();
        while (iter.hasNext()) {
            iter.next().mostrar();
        }
        System.out.println("--------------Borramos claves mayores a 1000-------------------");
        list.borrarMayores(1000);
        iter = list.getIterador();
        while (iter.hasNext()) {
            iter.next().mostrar();
        }
        GrupoAlumnos grupo1=new GrupoAlumnos("GX11");
        grupo1.nuevoAlumno(alumno1);
        grupo1.nuevoAlumno(alumno2);
        grupo1.nuevoAlumno(alumno5);
        System.out.println("------------ CREADO EL GRUPO GX11------------");
        System.out.println("El grupo tiene "+grupo1.getNumAlumnos()+" alumnos");
        System.out.println("------------ Grupo GX11. Alumno con matrícula 8510 ------------ ");
        grupo1.getAlumno(8510).mostrar();
        System.out.println("---------------------------------");
        System.out.println("porcentaje de aprobados en ED el grupo GX11: "+grupo1.porcentajeAprobados("ED"));
    }
}
