import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Colores {
    Queue<Integer>[] jugadores;

    Stack<Integer> mesa;

     public int juego(int n, ArrayList<Tirada> tiradas) 
     {
        int winner = 0;
        for(int i = 0; i < tiradas.size()-1; i++)
        {
            if( i == 0 && tiradas.get(i).dado1 == 6){
                return 0;
            }
            else if ( i != 0 && tiradas.get(i).dado1 % 2 == 0){
                int ficha = jugadores[tiradas.get(i).dado2-1].remove();
                mesa.add(ficha);
            }
            else if ( i != 0 && tiradas.get(i).dado1 % 2 != 0){
                int ficha = mesa.pop();
                jugadores[tiradas.get(i).dado2].add(ficha);
            }
        }
        
        for (int i = 1; i < jugadores.length-1; i++)
        {
            int maxcount = 0;
            int count = 0;
            while (!jugadores[i].isEmpty()) 
            {
                int ficha = jugadores[i].remove();
                if (ficha == 0){
                    count++;
                }
                
            }
         
            if(count > maxcount){
                winner = i;
            }
            
        }
        return winner;
     }



    
    
    public class Tirada
    {
        int dado1;
        int dado2;
    }
}
