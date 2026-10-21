public class Vehiculo extends Thread {
    private String nombre;
    private Pistas pistas;

    public Vehiculo(String nombre, Pistas pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
    }

    @Override
    public void run() {
        try {
            System.out.println(nombre + " espera pista...");
            int pista = pistas.ocuparPista();
            System.out.println(nombre + " entra a la pista " + (pista + 1));

            long inicio = System.currentTimeMillis();
            Thread.sleep(2000 + (long) (Math.random() * 3000));
            long fin = System.currentTimeMillis();
            System.out.println(nombre + " sale de la pista " + (pista + 1) + " tras " + (fin - inicio) + " ms");

            pistas.liberarPista(pista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
