import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Modelo_N_M {

    public void calcular() {
        double resultado = 1;
        for (int i = 1; i < 1_000_00; i++) {
            resultado *= 1.0000001;
            resultado %= 1_000_000;

        }
        double[] vetor = new double[1_000_00];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Math.random();
        }
        List<Double> lista = new ArrayList<>();
        for (int i = 0; i < 1_000_00; i++) {
            lista.add(Math.random());
        }
        Collections.sort(lista);

    }


    public void rodar(int N) {
        int M = Runtime.getRuntime().availableProcessors();
        long tempoInicial = System.nanoTime();

        ExecutorService executor = Executors.newFixedThreadPool(M);


        for (int i = 1; i <= N; i++) {
            int taskId = i;
            executor.submit(()-> {
                for (int j = 0; j < 3; j++) {
                    calcular();
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long tempoFinal = System.nanoTime();
        long tempoTotal = tempoFinal - tempoInicial;
        System.out.println("Tempo de processamento: "+tempoTotal/1_000_000+" ms.");
    }


}





