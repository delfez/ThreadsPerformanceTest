public class Modelo_N_1 {

    public void calcular() {

        int resultado = 1;
        for (double i = 1; i < 999999.0; i++) {
            resultado *= i;
            resultado += (resultado / 2);
            resultado *= 77;
            resultado %= 1000000;

        }
    }

    public void rodar(int threads) {
        long tempoInicial = System.nanoTime();
        for (int i = 1; i <= threads; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Thread "+i+ " executando passo " + j);
                calcular();
            }

        }
        long tempoFinal = System.nanoTime();
        long tempoTotal = tempoFinal - tempoInicial;
        System.out.println("Tempo de processamento: "+tempoTotal/1_000_000+" ms.");
    }


}





