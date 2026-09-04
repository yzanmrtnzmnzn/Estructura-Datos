import java.util.Iterator;
import java.util.LinkedList;
public class AlumnoBib {

    private String nombre;
    private int matricula;
    private LinkedList<Evaluacion> expediente;

    public AlumnoBib(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new LinkedList<Evaluacion>();
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
        expediente.add(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {
        boolean aprobado = false;
        Iterator<Evaluacion> it = expediente.iterator();
        while (it.hasNext() && !aprobado) {
            Evaluacion evaluacion = it.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public LinkedList<Evaluacion> asignaturasAprobadas() {
        LinkedList<Evaluacion> aprobados=new LinkedList<Evaluacion>();
        Iterator<Evaluacion> it= expediente.iterator();
        if(!expediente.isEmpty()) {
            while (it.hasNext()) {
                Evaluacion evaluacion = it.next();
                if (evaluacion.getNota()>=5) {
                    aprobados.add(evaluacion);
                }
            }


        }
        return aprobados;
    }

    public double mediaAprobadas() {
       double media=0.0;
       double suma=0;
        Iterator<Evaluacion> it= asignaturasAprobadas().iterator();
        while(it.hasNext()) {
            Evaluacion evaluacion = it.next();
            suma=suma+ evaluacion.getNota();


        }
        media = suma/asignaturasAprobadas().size();

        return media;
    }

    public int getNumAprobadas() {
        int num=0;
        Iterator<Evaluacion> it= asignaturasAprobadas().iterator();
        while(it.hasNext()) {
            Evaluacion evaluacion = it.next();
            num++;
        }
        return num;

    }

    public void mostrar() {

        Iterator<Evaluacion> it= expediente.iterator();
        System.out.println((nombre + " matricula : " + matricula ));

        while (it.hasNext()){
            it.next().mostrar();
        }
        if(expediente.size()!=0) {
            System.out.println(expediente.size()+" evaluaciones "+getNumAprobadas() + " asignaturas aprobadas con media " + mediaAprobadas());
        }else{
            System.out.println("NO HA REALIZADO NINGUNA EVALUACION");

        }
    }

}
