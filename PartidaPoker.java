import java.util.*;

public class PartidaPoker {

    public class Juego {
        public int jugar(int nJugadores, int nBilletes, ArrayList<Pago> pagos) {
            Stack<Boolean>[] jugadores = new Stack[nJugadores];
            for (int i = 0; i < jugadores.length; i++) {
                jugadores[i] = new Stack<Boolean>();
                for (int j = 0; j < nBilletes; j++) {
                    if (i == 0) {
                        jugadores[i].push(false);
                    } else {
                        jugadores[i].push(true);
                    }
                }
            }
            for (Pago p : pagos) {
                for (int i = 0; i < p.cantidad; i++) {
                    boolean b = jugadores[p.pagador].pop();
                    jugadores[p.cobrador].push(b);
                }
            }
            int cont = 0;
            while (!jugadores[0].isEmpty()) {
                if (jugadores[0].pop()) {
                    cont++;

                }

            } 

            return cont;
        }

    }

    public class Pago {
        int pagador;
        int cantidad;
        int cobrador;

    }

}