public class AlgoritmosCola {
    public Cola crearCola() {
        Cola cola = new Cola();
        for(int i=0;i<5;i++)
        cola.encolar(i);
        cola.encolar(19);
        cola.encolar(24);
        cola.encolar(48);
        return cola;
    }

    public Cola copiaCola(Cola cola) {
        Cola copia1 = new Cola();
        int aux;
        for(int i=0;i<cola.getNumElementos();i++){
            aux = cola.desencolar();
            copia1.encolar(aux);
            cola.encolar(aux);

        }
        return copia1;
    }

    public void mediaEnPrimeroCola(Cola cola) {
        int media = 0,aux;
        if(!cola.vacia()){
            for(int i=0;i<cola.getNumElementos();i++){
                aux = cola.desencolar();
                media = media + aux;
                cola.encolar(aux);
            }

            media = media/cola.getNumElementos();
            cola.encolar(media);

            for(int i=0;i<cola.getNumElementos()-1;i++){
                aux = cola.desencolar();
                cola.encolar(aux);
            }
        }
    }

    public int numParesImpares(Cola cola, int valor) {
        int aux, pares = 0, impar = 0, retorno = 0;
        if (!cola.vacia()) {
            if (valor == 1) {
                for (int i = 0; i < cola.getNumElementos(); i++) {
                    aux = cola.desencolar();
                    if (aux % 2 != 0) {
                        impar++;
                    }
                    cola.encolar(aux);
                }
                retorno = impar;
            } else if (valor == 2) {
                for (int i = 0; i < cola.getNumElementos(); i++) {
                    aux = cola.desencolar();
                    if (aux % 2 == 0 && aux != 0) {
                        pares++;
                    }
                    cola.encolar(aux);
                }
                retorno = pares;
            }
        }
        return retorno;
    }

    public void pruebaCopiaCola(Cola cola1) {
        System.out.println("\n---------------------Pruebas sobre copiaCola---------------");
        System.out.println("Antes de copiar:");
        cola1.mostrar();
        Cola colaCopia = copiaCola(cola1);
        colaCopia.encolar(2);
        System.out.println("Cola original:");
        cola1.mostrar();
        System.out.println("Cola copia:");
        colaCopia.mostrar();
    }

    public void pruebaMediaEnPrimeroCola(Cola cola1) {
        System.out.println("\n---------------------Pruebas sobre mediaEnPrimeroCola---------------");
        cola1.mostrar();
        mediaEnPrimeroCola(cola1);
        System.out.println("Después de ejecutar mediaEnPrimeroCola:");
        cola1.mostrar();
        System.out.println("La media de los elementos de la cola: " + cola1.desencolar());
        cola1.mostrar();
        Cola colaVacia = new Cola();
        mediaEnPrimeroCola(colaVacia);
        System.out.println("Al ejecutar mediaEnPrimeroCola de una cola vacía:");
        colaVacia.mostrar();
    }

    public void pruebaNumParesImpares(Cola cola1) {
        System.out.println("\n---------------------Pruebas sobre numeroElementosPI---------------");
        cola1.mostrar();
        System.out.println("Numeros impares en cola: " + numParesImpares(cola1, 1));
        System.out.println("Después de ejecutar Numeros impares en cola:");
        cola1.mostrar();
        System.out.println("Numeros pares en cola: " + numParesImpares(cola1, 2));
        System.out.println("Después de ejecutar Numeros pares en cola:");
        cola1.mostrar();
        System.out.println("Valor fuera de 1 y 2 de Numeros  en cola: " + numParesImpares(cola1, 4));
        System.out.println("Después de ejecutar Numeros pares en cola:");
        cola1.mostrar();
        Cola colaVacia = new Cola ();
        System.out.println("Numeros impares  en cola vacia: "+ numParesImpares(colaVacia,1));;
        System.out.println("Después de ejecutar Numeros impares  en cola vacia:");
        colaVacia.mostrar();
    }
}
