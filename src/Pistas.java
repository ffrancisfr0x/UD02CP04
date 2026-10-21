public class Pistas {
    private final boolean[] disponibles = {true, true};

    public synchronized int ocuparPista() throws InterruptedException {
        int pista = buscarLibre();
        while (pista == -1) {
            wait();
            pista = buscarLibre();
        }
        disponibles[pista] = false;
        return pista;
    }

    public synchronized void liberarPista(int pista) {
        disponibles[pista] = true;
        notifyAll();
    }

    private int buscarLibre() {
        for (int i = 0; i < disponibles.length; i++) {
            if (disponibles[i]) {
                return i;
            }
        }
        return -1;
    }
}