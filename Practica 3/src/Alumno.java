public class Alumno {

    private String nombre;
    private int matricula;
    private ListaOrdinal expediente;

    public Alumno(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new ListaOrdinal();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevaEvaluacion(Evaluacion evaluacion) {
        expediente.insertar(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {
        boolean aprobado = false;
        IteradorListaOrdinal it = expediente.getIterador();
        while (it.hasNext() && !aprobado) {
            Evaluacion evaluacion = it.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public ListaOrdinal asignaturasAprobadas() {
        ListaOrdinal aprobados=new ListaOrdinal();
        IteradorListaOrdinal it= expediente.getIterador();
        if(!expediente.vacia()) {
            while (it.hasNext()) {
                Evaluacion evaluacion = it.next();
                if (evaluacion.getNota()>=5) {
                    aprobados.insertar(evaluacion);
                }
            }


        }
        return aprobados;
    }

    public double mediaAprobadas() {
       double media=0.0;
       double suma=0;
        IteradorListaOrdinal it= asignaturasAprobadas().getIterador();
        while(it.hasNext()) {
            Evaluacion evaluacion = it.next();
            suma=suma+ evaluacion.getNota();


        }
        media = suma/asignaturasAprobadas().getNumElementos();

        return media;
    }

    public int getNumAprobadas() {
        int num=0;
        IteradorListaOrdinal it= asignaturasAprobadas().getIterador();
        while(it.hasNext()) {
            Evaluacion evaluacion = it.next();
            num++;
        }
        return num;

    }

    public void mostrar() {

        IteradorListaOrdinal it= expediente.getIterador();
        System.out.println((nombre + " matricula : " + matricula ));

        while (it.hasNext()){
            it.next().mostrar();
        }
        if(expediente.getNumElementos()!=0) {
            System.out.println(expediente.getNumElementos()+" evaluaciones "+getNumAprobadas() + " asignaturas aprobadas con media " + mediaAprobadas());
        }else{
            System.out.println("NO HA REALIZADO NINGUNA EVALUACION");

        }
    }

}
