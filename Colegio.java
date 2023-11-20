import java.util.LinkedList;
import java.util.Queue;



public class Colegio {

    Queue<Queue<String>> alumnos = new LinkedList<>();


    public void repartirRegalos(Queue<String> regalos)
    {
            
        while (!regalos.isEmpty()) {
            String r = regalos.remove();
            Queue<String> cola = alumnos.remove();
            while (cola.peek() != r) //VEMOS QUE YA HEMOS REPARTIDO A TODOS LOS ALUMNOS 
            {
                String alumno = cola.remove();
                System.out.println(alumno + r);
            }

            alumnos.add(cola);

        }
        
    }
}