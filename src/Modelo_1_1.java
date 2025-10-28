import java.util.ArrayList;
import java.util.List;

public class Modelo_1_1 {


public void calcular() {
    double resultado = 1;
    for (double i = 1; i < 9991999.0; i++) {
        resultado *= i;
        resultado += (resultado / 2);
        resultado *= 77;
        resultado %= 1000000;
        resultado += 0.3;
    }
}

public void rodar(int threads){
    long tempoInicial = System.nanoTime();

    List<Thread> lista = new ArrayList<>();
    for (int i = 1; i <= threads; i++ ){

        final int ThreadId = i;
        Thread thread = new Thread(() -> {
            for (int j = 0; j < 5; j++){
                System.out.println("Thread "+ ThreadId + " executando passo " + j );
                calcular();
            }
        });
        lista.add(thread);
        thread.start();

        }
    for (Thread t : lista ) {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        long tempoFinal = System.nanoTime();
        long tempoTotal = tempoFinal - tempoInicial;
        System.out.println("Tempo de processamento: " + tempoTotal / 1_000_000 + " ms.");

}





}
