public class AlgoritmosPila {

    public Pila crearPila() {
        Pila pila = new Pila();
        for(int i=0; i<5;i++)
            pila.apilar(i);
        pila.apilar(19);
        pila.apilar(24);
        pila.apilar(48);
        return pila;
    }

    public Pila copiaPilaRecursivo(Pila pilaOrigen) {
        Pila copia1= new Pila();
        if(!pilaOrigen.vacia()) {
        int aux = pilaOrigen.desapilar();
        copia1 = copiaPilaRecursivo(pilaOrigen);
        pilaOrigen.apilar(aux);
        copia1.apilar(aux);
        }
        return copia1;
    }

    private void sumar(Pila pila,int suma){
        if(!pila.vacia()){
            int aux = pila.desapilar();
            suma = suma + aux;
            sumar(pila,suma);
            pila.apilar(aux);
        }
        else{
            pila.apilar(suma);
        }
    }

    public void sumaEnFondoPila(Pila pila) {
        int suma = 0;
        sumar(pila,suma);
    }

    private void eliminarFondo(Pila pila,int elementos){
        if(!pila.vacia()){
            int aux = pila.desapilar();
            elementos--;
            eliminarFondo(pila,elementos);
            if(elementos==0){
                pila.apilar(aux);
                pila.desapilar();
                elementos++;
            }
            else{
                pila.apilar(aux);
            }
        }
    }

    public void segunNumQuitar(Pila pilaOrigen) {
        int elementos = pilaOrigen.getNumElementos();
        if(!pilaOrigen.vacia()){
            if(elementos%2==0){
                eliminarFondo(pilaOrigen,elementos);
            }
                else if(elementos%2!=0){
                    pilaOrigen.desapilar();
                }
            }
        }



    public void pruebaCopiaPilaRecursivo(Pila pila1) {
        System.out.println("\n---------------------Pruebas sobre copiaRPila---------------");
        Pila pilaCopia;
        System.out.println("Antes de copiar:");
        pila1.mostrar();
        pilaCopia = copiaPilaRecursivo(pila1);
        pilaCopia.apilar(2);
        System.out.println("Pila original:");
        pila1.mostrar();
        System.out.println("Pila copia:");
        pilaCopia.mostrar();
    }

    public void pruebaSumaEnFondo(Pila pila1) {
        System.out.println("\n---------------------Pruebas sobre sumaEnFondoPila---------------");
        pila1.mostrar();
        System.out.println("Al sumar primera vez sumaEnFondopila ");
        sumaEnFondoPila(pila1);
        System.out.println("Resultado obtenido:");
        pila1.mostrar();
        System.out.println("Al sumar segunda vez sumaEnFondopila ");
        sumaEnFondoPila(pila1);
        System.out.println("Resultado obtenido:");
        pila1.mostrar();
    }

    public void pruebaSegunNumQuitar (Pila pila1) {
        System.out.println("\n---------------------Pruebas sobre segunNumQuitar---------------");
        pila1.mostrar();
        System.out.println("Al lanzar primera vez segunNumQuitar ");
        segunNumQuitar(pila1);
        System.out.println("Pila original:");
        pila1.mostrar();
        System.out.println("Al lanzar segunda vez segunNumQuitar ");
        segunNumQuitar(pila1);
        System.out.println("Pila original:");
        pila1.mostrar();
    }
}

