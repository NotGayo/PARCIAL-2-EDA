import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Impresoras {

    public void procesarTrabajos(ArrayList<Peticion> lista) {

        Queue<Integer>[] impt = new Queue[6];

        for (int i = 0; i < 6; i++) {
            impt[i] = new LinkedList<Integer>();
        }
        boolean apagon = false;

        for (Peticion e : lista) {
            if (e.evento == 'P') {
                if (apagon) {
                    impt[0].add(e.trabajo);
                } else {
                    impt[e.impresora].add(e.trabajo);
                }
            }

            else if (e.evento == 'F') {
                impt[e.impresora].remove();
            }

            else if (e.evento == 'A') {
                for (int i = 0; i < impt.length; i++) {
                    while (!impt[i].isEmpty()) {
                        int t = impt[i].remove();
                        impt[0].add(t);
                    }

                }
                apagon = true;
            } else {
                apagon = false;
            }
            // ESCRIBIRLAS
        }
    }

    public class Peticion {
        Character evento;
        Integer impresora;
        Integer trabajo;
    }
}
