import java.util.EmptyStackException;
import java.util.Stack;

public class Bloques {
    public class Bloque {   
        int puntos;   
        int salto;
        String direccion;

        public int getNewPos(){
            int salta = 0;
            if(direccion == "d"){
                salta = salto;
            }
            if(direccion == "i"){
                salta = -1*salto;
            }
            return salta;
        }
    }

    public class Juego{
        Stack<Bloque> [] tablero;
        int numColumnas = 7;


        public Juego(){
            tablero = (Stack<Bloque>[]) new Stack[numColumnas];
            for (int i = 0; i <= numColumnas - 1; i++){
                tablero[i] = new Stack<Bloque>();
            }
        }


        public int jugar() {
            int playerPoints = tablero[4].peek().puntos;
            int pos = tablero[4].pop().getNewPos();
            boolean fin = false;

            try{

                while(!fin){
                    playerPoints += tablero[pos].peek().puntos;
                    pos = tablero[pos].pop().getNewPos();
                }



            }catch(ArrayIndexOutOfBoundsException AIOOB){
                fin = true;
                playerPoints = -1;
            }catch(EmptyStackException ESE){
                fin = true;
            }
            return playerPoints;
        }
    }



}
