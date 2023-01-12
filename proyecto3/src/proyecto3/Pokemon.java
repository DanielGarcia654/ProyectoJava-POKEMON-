/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3;
/**
 * En esta clase se crea el objeto de tipo Pokemon donde encontraremos los metodos y atributos correspondientes para el flujo del juego.
 * @author templ
 */
public class Pokemon {
  private String name;
  private final int maxHP; //Guardaremos aqui la maxima salud gracias al campo "final"
  private int health;
  int attackDamage;
  private int defence;
  private int speed;
  private int state;
  String type;
  float elementalMultiplier;

/**
 * Constructor para obtener todos los atributos correspondientes al objeto pokemon
 * @param name Obtener el nombre del pokemon
 * @param maxHP Obtener el maximo de vida del pokemon
 * @param attackDamage Obtener el daño que hace el pokemon
 * @param defence Obtener los puntos de defensa que tiene el pokemon
 * @param speed Obtener los puntos de velocidad del pokemon
 * @param state Obtener el estado del pokemon (entre 0 y 1)
 * @param type Obtener el tipo de pokemon
 */
    public Pokemon(String name, int maxHP, int attackDamage, int defence, int speed, int state, String type) {
        this.name = name;
        this.maxHP = maxHP; //Construimos naturalmente los atributos (al ser inicial, solo se puede cambiar en el contructor)
        this.health = maxHP; //La variable health nos ayudara a ir modificando el atributo, pero no asignandolo directamente al atributo del objeto como tal
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.speed = speed;
        this.state = state;
        this.type = type;
        
    }
/**
 * Obtener el nombre del pokemon
 * @return Retorna el nombre del pokemon
 */
    public String getName() {
        return name;
    }
/**
 * Colocar el nombre del pokemon
 * @param name Recibe el nombre a colocar en el atributo "nombre" del pokemon
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * Obtener la vida del pokemon
 * @return Retorna la vida del pokemon
 */
    public int getHealth() {
        return health;
    }
/**
 * Obtener la vida maxima del pokemon
 * @return Retorna el los puntos maximos de vida del pokemon
 */
    public int getMaxHealth(){ //Retenemos el valor original, incluso si el setter de Health asigna un nuevo valor
        return maxHP;
    }
/**
 * Colocar la salud actual del pokemon
 * @param healthDyn Recibe el nuevo valor de la vida del pokemon y en caso de ser cero, el estado cambia a cero
 */
    public void setHealth(int healthDyn) {
        if (healthDyn <= 0){
            healthDyn = 0;
            setState(0);
        }
        this.health = healthDyn;
    }
/**
 * Obtener los puntos de daño del pokemon
 * @return Retorna los puntos de daño del pokemon actualmente
 */
    public int getAttackDamage() {
        return attackDamage;
    }
/**
 * Colocar los puntos de daño del pokemon 
 * @param attackDamage Recibe el nuevo valor de puntos de daño del pokemon
 */
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
/**
 * Obtener los puntos de defensa del pokemon
 * @return Retorna los puntos de defensa del pokemon
 */
    public int getDefence() {
        return defence;
    }
/**
 * Colocar los puntos de defensa del pokemon
 * @param defence Recibe el nuevo valor de puntos de defensa del pokemon
 */
    public void setDefence(int defence) {
        this.defence = defence;
    }
/**
 * Obtener los puntos de velocidad del pokemon
 * @return Retorna los puntos de velocidad del pokemon
 */
    public int getSpeed() {
        return speed;
    }
/**
 * Colocar los puntos de velocidad del pokemon
 * @param speed Recibe el nuevo valor de puntos de velocidad del pokemon
 */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
/**
 * Obtener el estado del pokemon
 * @return Retorna el estado del pokemon (entre 0 y 1)
 */
    public int getState() {
        return state;
    }
/**
 * Colocar el estado del pokemon
 * @param state Recibe el estado del pokemon
 */
    public void setState(int state) {
        this.state = state;
    }
  /**
   * Obtener el tipo de pokemon
   * @return Retorna el tipo de pokemon
   */
    public String getType() {
        return type;
    }
/**
 * Colocar el tipo de pokemon
 * @param type Recibe el nombre del tipo de pokemon
 */
    public void setType(String type) {
        this.type = type;
    }

/**
 * Metodo que genera el multiplicador elemental
 * @param jugador Recibe un jugador para usar su lista de pokemon
 * @param enemyType Recibe el tipo de pokemon del jugador enemigo o jugador que esta siendo atacado
 * @return Retorna el valor del multiplicador elemental
 */    
    public float setElementalMultiplier(Player jugador, String enemyType){
        //Obtenemos el primer pokemon (el que esta atacando) y le pasamos su respectiva asignacion de multiplicador elemental con el tipo de pokemon del otro jugador
        /**
         * Metodo que nos ayudara a obtener el valor del multiplicador elemental, dependiendo del tipo de pokemon del jugador atacante
         */
        elementalMultiplier =  jugador.pokedex.get(0).setElementalMultiplier(jugador, enemyType);
        return elementalMultiplier; //Lo retornamos
    }
/**
 * Metodo que calcula el ataque 1 de cada jugador
 * @param jugadorEnemy Recibe el jugador atacado para usar su pokemon actual
 * @param EM Recibe el multiplicador elemental para multiplicar el poder del ataque
 * @param result Recibe un numero basado en el resultado de un calculo para realizar una condicion
 */
    public void combateA1(Player jugadorEnemy, float EM, float result){
        int healthDyn = health;
        if (result <= 0) { //Si el resultado es 0, el pokemon atacado no recibe daño
            System.out.println("LA DEFENSA ES EXCELENTE, NO RECIBE DANIO");
        } else { //Si el resultado es positivo, calculamos el daño que haremos (lo que restamos a la salud)
            // Este calculo es propio, la verdad no encontré como calcular el daño y este fue el mejor balance que encontré
            healthDyn = (int) ((health + (defence/2))-((jugadorEnemy.pokedex.get(0).getAttackDamage() * EM))); // A la salud le sumamos la defensa dividida entre dos, luego obtenemos el daño del pokemon enemigo y lo multiplicamos por el multiplicador elemental, al final se restan ambos valores y se asigna a la nueva vida
        }
        setHealth(healthDyn);
    }
    
/**
 * Se imprimen todos los valores de los atributos del pokemon
 * @return 
 */
    @Override
    public String toString() {
        return name + " --- HP=" + health + ", Ataque=" + attackDamage + ", Defensa=" + defence + ", Velocidad=" + speed + ", Estado=" + state + ", Tipo=" + type;
    }

    
    
}
