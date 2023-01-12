/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3;

/**
 * Una clase que hereda de la clase Pokemon que especifica el tipo de pokemon
 * @author templ
 */
public class tipoHierba extends Pokemon {
    /**
     * Metodo que recibe los mismos atributos que la clase Pokemon (clase padre)
    * @param name Obtener el nombre del pokemon
    * @param health Obtener la vida del pokemon
    * @param attackDamage Obtener el daño que hace el pokemon
    * @param defence Obtener los puntos de defensa que tiene el pokemon
    * @param speed Obtener los puntos de velocidad del pokemon
    * @param state Obtener el estado del pokemon (entre 0 y 1)
    * @param type Obtener el tipo de pokemon
     */
    public tipoHierba(String name, int health, int attackDamage, int defence, int speed, int state, String type) {
        super(name, health, attackDamage, defence, speed, state, type);
    }
    /**
     * Metodo que sobreescribe el metodo de multiplicador elemental, dependiendo del tipo de pokemon para realizar los ataques super efectivos, o no efectivos
     * @param jugador Recibe un jugador solamente para sobreescribir el metodo con el mismo nombre dentro de la clase Pokemon
     * @param enemyType Recibe el tipo de pokemon del jugador atacado
     * @return Retorna un valor, dependiendo si el tipo de pokemon del jugador que ataca es muy fuerte o debil contra el tipo de pokemon del jugador atacado
     */
    @Override
    public float setElementalMultiplier(Player jugador, String enemyType){
        if ("Roca".equals(enemyType) || "Tierra".equals(enemyType) || "Agua".equals(enemyType)){
            System.out.println("¡¡¡Ataque super efectivo!!!");
            return elementalMultiplier = (float) 2.0;
        }
        
        if ("Fuego".equals(enemyType) || "Hierba".equals(enemyType) || "Dragon".equals(enemyType)){
            System.out.println("Ataque no tan efectivo");
            return elementalMultiplier = (float) 0.5;
        }
        
         return elementalMultiplier = 1;
    }
    
}
