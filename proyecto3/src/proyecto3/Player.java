/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * En esta clase creamos el objeto Jugador, donde tendrá algunos metodos y atributos como la lista de Pokemon y la lista de Pociones
 * 
 */

public class Player {
    /**
     * Guarda el nombre del jugador
     */
    public String name;
    ArrayList<Pokemon> pokedex;
    List<String> pociones = new ArrayList<String>();

    /**
     * Metodo constructor para crear los atributos de los objetos jugador
     * @param name Guarda el nombre escrito por el jugador 
     */
    public Player(String name) {
        this.pokedex = new ArrayList<Pokemon>();
        this.pociones = new ArrayList<String>();        
        this.name = name;
    }
/**
 * Metodo constructor vacio para generar objetos de tipo jugador sin atributos
 */
    public Player() {
    }
/**
 * Metodo para agregar pokemon a la pokedex del jugador
 * @param pokemon Recibimos el pokemon a agregar
 */
    public void addPokemon(Pokemon pokemon){
        pokedex.add(pokemon);
    }
    
/**
 * Metodo para imprimir la lista de pokemon (pokedex) del jugador
 */
    public void seePokemon(){
        System.out.println("||||||||| POKEDEX ||||||||");
        System.out.println("Pokemon en combate: "+pokedex.get(0).toString());
        
        for (int i = 0; i < pokedex.size()-1; i++) {
            System.out.println(i+1+".- "+pokedex.get(i+1).toString());
        }
        System.out.println("||||||||||||||||||||||||||");
    }
    /**
     * Metodo para cambiar de posicion dentro de la lista de pokemon (pokedex) por uno requerido
     * @param cambio Recibimos el indice del pokemon a cambiar
     * @return Si regresa un numero 1, quiere decir que el pokemon seleccionado no existe dentro de la pokedex, por lo tanto, mandamos a repetir la instriccion en un ciclo while
     */
    public int changePokemon(int cambio){ //Solicitamos el numero del indice del pokemon a cambiar
        try{
            Pokemon temp = pokedex.get(0); //Guardamos el pokemon actual (el del indice 0) en una variable temporal

            if (pokedex.get(cambio).getState() == 0){ //Si el pokemon a elegir, ya tiene el estado derrotado, no se puede elegir
                System.out.println("POKEMON NO DISPONIBLE ELIGE OTRO");
                return 1;
            } else {
            //Realizamos un intercambio de posiciones, el pokemon a elegir pasa al indice 0 y el actual pasa al indice del pokemon elegido
                pokedex.set(0, pokedex.get(cambio));
                pokedex.set(cambio, temp);
            }
        }catch(Exception IndexOutOfBounds){
            System.out.println("POKEMON NO EXISTENTE, DEBES ELEGIR OTRO"); //Si escoge una opcion fuera de la lista de pokemon
            return 1;
        }
        return 0;
        
    }
    /**
     * Metodo que nos ayuda a validar el estado de todos los pokemon dentro de la pokedex
     * @return Si todos los pokemon estan derrotados, regresamos un cero que significa que es un jugador derrotado y termina el ciclo While
     */
    public int status(){ //Validamos que los pokemones sigan con vida
        int derrotados = 0; 
        for (int i = 0; i<pokedex.size(); i++){ //Vamos recorriendo la pokedex de los jugadores
            if(pokedex.get(i).getState() == 0){ 
                derrotados ++; //Si algun pokemon es derrotado, vamos sumando uno
            }
        }
        if (derrotados == pokedex.size()){ //Si los derrotados equivalen al tamaño de la pokedex, regresamos un cero
            return 0;
        }
        return 1;
    }
    /**
     * Metodo que nos ayuda a colocar el estado a todos los pokemon en cero, significa que no estan disponibles y estan derrotados
     */
    public void setStatus() { //Pone el estado en 0 a todos los pokemon
        for (int i = 0; i < pokedex.size(); i++) {
            pokedex.get(i).setState(0);
        }
    }
    /**
     * Metodo que asigna las pociones respectivas (dos de cada una) a la lista de pociones de cada jugador
     * @param jugador Recibe un objeto jugador para poder agregar las pociones a su lista de pociones
     */
    public void asignarPocion(Player jugador){
        jugador.pociones.add("Vida");
        jugador.pociones.add("Vida");
        jugador.pociones.add("Defensa");
        jugador.pociones.add("Defensa");
        jugador.pociones.add("Danio");
        jugador.pociones.add("Danio");
    }
    /**
     * Metodo que muestra la lista de pociones del jugador
     * @param jugador Recibe un jugador para poder usar la lista de pociones
     * @param nombre Recibe el nombre de la pocion a usar
     * @return Regresa un contador que indica el numero total de pociones disponibles de cada tipo (2 maximo, 0 minimo)
     */
    public int mostrarPoc(Player jugador, String nombre){
        int contador=0;
        for (String element : jugador.pociones){
            if (element.equals(nombre)){
                contador ++;
            }
        }
        return contador;
    }
    /**
     * Metodo que comprueba si dentro de la lista de pociones se ha agotado algun tipo de pocion
     * @param jugador Usamos la lista de pociones del jugador
     * @param nombre Recibimos el nombre del tipo de pocion la cual queremos validar si aun existe dentro de la lista de pociones del jugador
     * @return Regresamos un true si es que aun quedan pociones, en caso contrario retornamos un false
     */
    public boolean comprobarPocion(Player jugador, String nombre){ //Creamos una funcion que compruebe si aun existe dentro de la lista las pociones solicitadas
        for(String element : jugador.pociones){
            if(element.equals(nombre)){
                return true;
            }
        }
        return false;
    }
    /**
     * Metodo que borra las pociones de la lista cuando son usadas
     * @param jugador Leemos la lista de pociones del jugador
     * @param nombre Obtenemos el nombre del tipo de pocion a eliminar
     */
    public void borrarPocion(Player jugador, String nombre){
        jugador.pociones.remove(nombre);
    }
    
}
