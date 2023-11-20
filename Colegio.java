import java.util.LinkedList;
import java.util.Queue;



public class Colegio {

    Queue<Queue<String>> alumnos = new LinkedList<>();


    public void repartirRegalos(Queue<String> regalos)
    {
            
        while (!regalos.isEmpty()) {
            String r = regalos.remove();
            Queue<String> cola = alumnos.remove();
            String primero = cola.peek();
             //VEMOS QUE YA HEMOS REPARTIDO A TODOS LOS ALUMNOS 
            do
            {
                String alumno = cola.remove();
                System.out.println(alumno + r);
                cola.add(alumno);
            }
            while (cola.peek() != primero);

            alumnos.add(cola);

        }
        
    }
}