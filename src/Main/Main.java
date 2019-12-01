
package Main;

import LinkedList.Chain.*;
import Queue.*;
import Stack.*;

public class Main {
    public static void main(String[] args) {
        Queue cola = new ArrayQueue<>();
        cola.put(1);
        cola.put(2);
        cola.put(3);
        cola.put(4);
        cola.put(5);
        cola.put(6);
        System.out.println("La cola es "+cola.getFrontElement());
    }
    
     /**
 * Busca un valor numerico dentro de un arreglo numerico...
 * previamente ordenado usando el metodo de busqueda binaria 
 * 
 * @param arreglo con los elementos; dato a buscar
 * @return posicion del elemento buscado, en caso de no existir retorna -1
    */
 public static int busquedaBinaria(int  vector[], int dato){
  int n = vector.length;
  int centro,inf=0,sup=n-1;
   while(inf<=sup){
     centro=(sup+inf)/2;
     if(vector[centro]==dato) return centro;
     else if(dato < vector [centro] ){
        sup=centro-1;
     }
     else {
       inf=centro+1;
     }
   }
   return -1;
 }
    
    
    
}



