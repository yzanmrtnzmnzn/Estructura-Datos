public class GrupoAlumnos {

    private String nombre;
    private ListaCalificada listaAlumnos;

    public GrupoAlumnos(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new ListaCalificada();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevoAlumno(Alumno alumno) {
    listaAlumnos.insertar(alumno);
    }

    public int getNumAlumnos() {
        int res=0;
        if(!listaAlumnos.vacia()){
            IteradorListaCalificada it=listaAlumnos.getIterador();
            while (it.hasNext()){
                Alumno alumno=it.next();
                res++;
            }
        }
        return res;
    }

    public Alumno getAlumno(int matricula) {
       Alumno alumnoaux=null;
        if(!listaAlumnos.vacia()){
            IteradorListaCalificada it=listaAlumnos.getIterador();
            while (it.hasNext()){
                Alumno alumno=it.next();
                if(alumno.getMatricula()==matricula){
                    alumnoaux=alumno;
                }

            }
        }
        return alumnoaux;
    }

    public double porcentajeAprobados(String nombreAsignatura) {
        boolean aprobado;
        double res=0.0;
        if(!listaAlumnos.vacia()){
            IteradorListaCalificada it=listaAlumnos.getIterador();
            while (it.hasNext()){
                aprobado=it.next().estaAprobado(nombreAsignatura);

                if(aprobado){
                res++;
                }

            }
            res=(res*100)/getNumAlumnos();
        }
        return res;

    }
}
