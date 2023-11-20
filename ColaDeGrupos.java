import java.util.*;

public class ColaDeGrupos {
    

    public class Cafeteria{
        Queue<Queue<Integer>> cola = null; //Cola de colas

        public void insertar(Integer elem)
        {
            Queue<Queue<Integer>> colaAux = new LinkedList<Queue<Integer>>();
            boolean anadido = false;
            while(!cola.isEmpty()){
                Queue<Integer> c1 = cola.remove();
                if(mismoGrupo(elem, c1.peek())){
                    c1.add(elem);//add = insert
                    anadido = true;
            }
            colaAux.add(c1);
            if(!anadido){
                Queue<Integer> nueva = new LinkedList<>();
                nueva.add(elem);
                colaAux.add(nueva);
            }
            cola = colaAux;
                
            }
            
            
        }


        public int borrar(){
            //pre: no esta vacio ni el primer grupo ni la primera cola
            int i =  cola.peek().remove();
            if(cola.peek().isEmpty()){
                cola.remove();
            }
            return i;
            
            
        }



        public boolean mismoGrupo(int p1, int p2){
            ArrayList<Integer> g1 = new ArrayList<Integer>();
            g1.add(1);g1.add(5);g1.add(7);

            ArrayList<Integer> g2 = new ArrayList<Integer>();
            g2.add(2);g2.add(4);g2.add(6);g2.add(8);

            ArrayList<Integer> g3 = new ArrayList<Integer>();
            g3.add(3);g1.add(6);g1.add(11);

            boolean mismo = false;
            
            if((g1.contains(p1) && g1.contains(p2)
            || (g2.contains(p1) && g2.contains(p2))
            || (g3.contains(p1) && g3.contains(p2)))){
                mismo = true;
            }
            return mismo;
        }
    }

}
