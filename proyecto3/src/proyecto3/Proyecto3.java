/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package proyecto3;
import java.util.Scanner;
import java.util.Random;

/**
 * Esta es la clase donde se encuentra el main
 * @author templ
 */
public class Proyecto3 {
/**
 * El punto de entrada del programa
 * @param args Los argumentos que se pueden pasar atraves de la terminal al programa (ninguno en este caso)
 */
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----El combate inicia-----");

        System.out.println("Por favor, ingresa el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        Player jugador1 = new Player(nombre1);
        
        System.out.println("Por favor, ingresa el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();
        Player jugador2 = new Player(nombre2);        
        
        System.out.println("Jugador |"+nombre1+"|, agrega tus pokemon");
        agregarPokemon(jugador1);
        jugador1.asignarPocion(jugador1);
        
        System.out.println("Jugador |"+nombre2+"|, agrega tu pokemon");
        agregarPokemon(jugador2);
        jugador2.asignarPocion(jugador2);
        /*
        tipoFuego pokemon1 = (tipoFuego) pokedex1[0]; //Casteamos de clase Pokemon a clase tipoFuego
        tipoAgua pokemon2 = (tipoAgua) pokedex2[0]; //Casteamos de clase Pokemon a clase tipoAgua
        //Casteamos para hacer uso de los métodos dentro de la clase de cada tipo
        */
        Player actualJugador = jugador1;
        while(jugador1.status()==1&&jugador2.status()==1){
        int val = 1; 
            if (actualJugador == jugador1){
                
                int op, op3, op6 = 1, op1 = 1;
                while (op1 == 1){
                    op3 = validateState(jugador1); //Validamos el estado del POKEMON del jugador 1 (es por si busca cambiar su pokemon actual por uno sin vida) 
                    if (op3 == 1){
                        System.out.println("Jugador |"+nombre1+"|, escoge una opcion:");
                        System.out.println("\n"+jugador1.pokedex.get(0).getName() +" - HP: " +jugador1.pokedex.get(0).getHealth());
                        System.out.println("\n---------------------\n");
                        System.out.println(jugador2.pokedex.get(0).getName() +" - HP: " +jugador2.pokedex.get(0).getHealth()+"\n");
                        System.out.println("1.- Atacar                         2.- Mochila");
                        System.out.println("3.- Cambiar pokemon               4.- Rendirse");
                        op = scanner.nextInt();
                    } else { //En caso de que quiera cambiar el pokemon actual por uno sin vida, lo mandaremos directamente a escoger un pokemon
                        val = 0; // Ciclamos en el turno del jugador 
                        op = 3; //Entramos al caso 3 (cambiar pokemon)
                        op6 = 0; //Asignamos el valor, entramos en esta condicion por que el pokemon fue derrotado y cancelar que cambie al turno del otro jugador
                    }
                    switch (op){
                        case 1:
                        {
                            int op5 = 1;
                            while (op5 == 1){
                                System.out.println("==== Atacar ====");
                                System.out.println("Escoge un movimiento");
                                System.out.println("1.- Ataque 1 ("+jugador1.pokedex.get(0).getType()+")      2.- Ataque 2 ");
                                System.out.println("0.- SALIR ");
                                
                                int op2 = scanner.nextInt();
                                if ( op2 == 0){
                                      op5 = 0;
                                      op1 = 1;
                                } else {
                                    switch (op2){
                                        case 1:
                                        {
                                            ataque1(jugador1, jugador2);
                                            op5 = 0;
                                            break;
                                        }
                                        case 2:
                                        {
                                            ataque2(jugador1, jugador2);
                                            op5 = 0;
                                            break;
                                        }
                                        default:
                                        {
                                            System.out.println("OPCION NO VALIDA");
                                            op5 = 1;
                                            break;
                                        }
                                    } 
                                    op1 = 0;
                                }
                            }
                            
                            break;
                            }
                        case 2:
                        {
                            int op7 = 1; //Para mantenernos en loop en caso de escoger una opcion no valida
                            while (op7 == 1){
                                int maxHP = jugador1.pokedex.get(0).getMaxHealth(); //Conseguimos la maxima salud del pokemon luchando

                                System.out.println("==== Mochila ====");
                                System.out.println("Elige la pocion que quieras usar en tu pokemon actual: ");
                                System.out.print("1.- Pocion de Vida: ");
                                System.out.println(jugador1.mostrarPoc(jugador1, "Vida"));
                                System.out.print("2.- Pocion de Defensa: ");
                                System.out.println(jugador1.mostrarPoc(jugador1, "Defensa"));
                                System.out.print("3.- Pocion de Danio: ");
                                System.out.println(jugador1.mostrarPoc(jugador1, "Danio"));
                                System.out.println("0.- SALIR");

                                int op5 = scanner.nextInt();
                                if (op5 == 0){
                                    op7 = 0;
                                    op1 = 1;
                                } else {
                                    switch (op5){
                                        case 1: //Caso conseguir salud
                                        {
                                            op7 = sumarVida(jugador1, maxHP);
                                            break;
                                        }
                                        case 2: //Caso conseguir defensa
                                        {
                                            op7 =sumarDefensa(jugador1);
                                            break;
                                        }
                                        case 3:
                                        {
                                            op7 = sumarDanio(jugador1);
                                            break;
                                        }
                                        default:
                                        {
                                            System.out.println("OPCION NO VALIDA");
                                            op7 = 1;
                                            break;
                                        }
                                    }
                                    op1 = 0;
                                 }   
                            }
                            break;
                        }
                        case 3:
                            {
                                int op4 = 1;
                                while (op4 == 1){
                                    System.out.println("==== Cambiar Pokemon ====");
                                    jugador1.seePokemon();
                                    System.out.println("0.- CANCELAR");
                                    int op2 = scanner.nextInt();
                                    if (op2 == 0){ //Si desea cancelar este menu, lo mandamos a escoger de nuevo
                                        val = 0;
                                        if (op6 == 0){ //Condicion que valida cuando entra el ciclo de "pokemon derrotado" y se usa la opcion de cancelar
                                            val = 0; //Volvemos a estar ciclando en el turno del jugador 1 hasta que eliga una opcion que corte el ciclo
                                        }
                                        break;
                                    }
                                    op4 = jugador1.changePokemon(op2);
                                }
                                op1 = 0;
                                break;
                            }
                        case 4:
                            {
                                System.out.println("==== Rendirse ====");
                                System.out.println("¿Estas seguro de que te quieres rendir?");
                                System.out.println("1.- Si      2.- No");
                                int op2 = scanner.nextInt();
                                switch (op2) {
                                    case 1:
                                    {
                                        jugador1.setStatus();
                                        op1 = 0;
                                        break;
                                    }
                                    case 2:
                                    {
                                        op1 = 1;
                                        break;
                                    }
                                    default:
                                    {
                                        System.out.println("OPCION NO VALIDA");
                                        op1 = 1;
                                        break;
                                    }
                                }
                                break;
                            }
                        default:
                            System.out.println("OPCION NO VALIDA");
                            op1 = 1;
                            break;
                    }
                }
                if (val == 1){ //Val, valida si es correcto cambiar de turno o no, si es asi, cambiamos de turno
                    
                    System.out.println("====== TURNO FINALIZADO ======");
                    System.out.println("#### TURNO JUGADOR 2 ####");
                    actualJugador = jugador2;
                } else {
                   
                    actualJugador = jugador1; //Si alguna accion (como la de cancelar la eleccion de pokemon) regresamos al mismo turno del jugador
                }
      
            } else { // ---- INICIA JUGADOR 2 ----
                int op, op3, op6 = 1, op1=1;
                while (op1 == 1){
                    op3 = validateState(jugador2);
                    if (op3 == 1){
                        System.out.println("Jugador |"+nombre2+"|, escoge una opcion:");
                        System.out.println("\n"+jugador2.pokedex.get(0).getName() +" - HP: " +jugador2.pokedex.get(0).getHealth());
                        System.out.println("\n---------------------\n");
                        System.out.println(jugador1.pokedex.get(0).getName() +" - HP: " +jugador1.pokedex.get(0).getHealth()+"\n");
                        System.out.println("1.- Atacar                         2.- Mochila");
                        System.out.println("3.- Cambiar pokemon               4.- Rendirse");
                        op = scanner.nextInt();
                    } else {
                        val = 0;
                        op = 3;
                        op6 = 0;
                    }
                     switch (op){
                        case 1:
                        {
                            int op5 = 1;
                            while (op5 == 1){
                                System.out.println("==== Atacar ====");
                                System.out.println("Escoge un movimiento");
                                System.out.println("1.- Ataque 1 ("+jugador2.pokedex.get(0).getType()+")      2.- Ataque 2 ");
                                System.out.println("0.- SALIR");
                                int op2 = scanner.nextInt();
                                if (op2 == 0){
                                    op5 = 0;
                                    op1 = 1;
                                } else {
                                        switch (op2){  
                                        case 1:
                                        {
                                            ataque1(jugador2, jugador1);

                                            op5 = 0;
                                            break;
                                        }
                                        case 2:
                                        {
                                            ataque2(jugador2, jugador1);
                                            op5 = 0;
                                            break;
                                        }
                                        default:
                                        {
                                            System.out.println("OPCION NO VALIDA");
                                            op5 = 1;
                                            break;
                                        }
                                    }
                                        op1 = 0;
                                }
                            }
                                break;
                            }
                        case 2:
                        {
                            int op7 = 1; //Para mantenernos en loop en caso de escoger una opcion no valida
                            while (op7 == 1){
                                int maxHP = jugador2.pokedex.get(0).getMaxHealth(); //Conseguimos la maxima salud del pokemon luchando

                                System.out.println("==== Mochila ====");
                                System.out.println("Elige la pocion que quieras usar en tu pokemon actual: ");
                                System.out.print("1.- Pocion de Vida: ");
                                System.out.println(jugador2.mostrarPoc(jugador2, "Vida"));
                                System.out.print("2.- Pocion de Defensa: ");
                                System.out.println(jugador2.mostrarPoc(jugador2, "Defensa"));
                                System.out.print("3.- Pocion de Danio: ");
                                System.out.println(jugador2.mostrarPoc(jugador2, "Danio"));
                                System.out.println("0.- SALIR");

                                int op5 = scanner.nextInt();
                                if (op5 == 0){
                                    op7 = 0;
                                    op1 = 1;
                                } else {
                                    switch (op5){
                                        case 1: //Caso conseguir salud
                                        {
                                            op7 = sumarVida(jugador2, maxHP);
                                            break;
                                        }
                                        case 2: //Caso conseguir defensa
                                        {
                                            op7 = sumarDefensa(jugador2);
                                            break;
                                        }
                                        case 3:
                                        {
                                            op7 = sumarDanio(jugador2);
                                            break;
                                        }
                                        default:
                                        {
                                            System.out.println("OPCION NO VALIDA");
                                            op7 = 1;
                                            break;
                                        }
                                    }
                                    op1 = 0;
                                 }   
                            }
                            break;
                        }
                        case 3:
                            {
                                int op4 = 1;
                                while (op4 == 1){
                                    System.out.println("==== Cambiar Pokemon ====");
                                    jugador2.seePokemon();
                                    System.out.println("0.- CANCELAR");
                                    int op2 = scanner.nextInt();
                                    if (op2 == 0){ //Si desea cancelar este menu, lo mandamos a escoger de nuevo
                                        val = 0;
                                        if (op6 == 0){ //Condicion que valida cuando entra el ciclo de "pokemon derrotado" y se usa la opcion de cancelar
                                            val = 0; //Volvemos a estar ciclando en el turno del jugador 1 hasta que eliga una opcion que corte el ciclo
                                        }
                                        break;
                                    }
                                    op4 = jugador2.changePokemon(op2);
                                    
                                }
                                op1 = 0;
                                break;
                            }
                        case 4:
                            {
                                System.out.println("==== Rendirse ====");
                                System.out.println("¿Estas seguro de que te quieres rendir?");
                                System.out.println("1.- Si      2.- No");
                                int op2 = scanner.nextInt();
                                switch (op2) {
                                    case 1:
                                    {
                                        jugador2.setStatus();
                                        op1 = 0;
                                        break;
                                    }
                                    case 2:
                                    {
                                        op1 = 1;
                                        break;    
                                    }
                                    default:
                                    {
                                        System.out.println("OPCION INVALIDA");
                                        op1 = 1;
                                        break;
                                    }
                                }
                                break;
                            }
                        default:
                        {
                            System.out.println("OPCION NO VALIDA");
                            op1 = 1;
                            break;
                        }
                    }
                }//AQUI TERMINA WHILE
                if (val == 1){
                    System.out.println("====== TURNO FINALIZADO ======");
                    System.out.println("#### TURNO JUGADOR 1 ####");
                    actualJugador = jugador1;
                } else {
                    actualJugador = jugador2;
                }
                
            }
            
         }
        System.out.println("FIN DEL JUEGO");
        if (jugador1.status()==0){
            System.out.println("===[[[[[JUGADOR 2 VICTORIOSO]]]]]===");
        } else if (jugador2.status()==0){
            System.out.println("===[[[[[JUGADOR 1 VICTORIOSO]]]]]===");
        }
    }
    
    /**
     * Metodo usado para agregar una lista de pokemon a la lista de pokemon del jugador (a la pokedex)
     * @param jugador Recibe el jugador para usar su lista de pokemon (pokedex)
     */
    public static void agregarPokemon(Player jugador){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Ingresa que lista de pokemon deseas tener ----");
        System.out.println("        LISTA 1                      LISTA 2                        LISTA 3");
        System.out.println(" CHARIZARD: TIPOFUEGO           BLASTOISE: TIPOAGUA          VENUSAUR: TIPOHIERBA ");
        System.out.println(" BLASTOISE: TIPOAGUA            RAICHU: TIPOELECTRICO        INFERNAPE: TIPOFUEGO ");
        System.out.println(" ELECTIVIRE: TIPOELECTRICO      GROTLE: TIPOHIERBA           GYARADOS: TIPOAGUA ");
        int op2 = 1;
        while (op2 == 1){
            System.out.print("Lista: ");
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    {
                        System.out.println("### CHARIZARD - BLASTOISE - ELECTIVIRE ###");
                        int numeroAleatorio = aleatorio();
                        tipoFuego pokemon = new tipoFuego("Charizard", 18+(numeroAleatorio), 10+(numeroAleatorio), 8+(numeroAleatorio), 14+(numeroAleatorio), 1, "Fuego");
                        jugador.addPokemon(pokemon);
                        System.out.println("Agregado con exito a tu pokedex");

                        tipoAgua pokemon2 = new tipoAgua("Blastoise", 19+(numeroAleatorio), 11+(numeroAleatorio), 10+(numeroAleatorio), 11+(numeroAleatorio), 1, "Agua");
                        jugador.addPokemon(pokemon2);

                        tipoElectrico pokemon3 = new tipoElectrico("Electivire", 18+(numeroAleatorio), 10+(numeroAleatorio), 9+(numeroAleatorio), 13+(numeroAleatorio), 1, "Electrico");
                        jugador.addPokemon(pokemon3);
                        op2 = 0;
                        break;
                    }
                case 2:
                    {
                        System.out.println("### BLASTOISE - RAICHU - GROTLE ###");
                        int numeroAleatorio = aleatorio();
                        tipoAgua pokemon = new tipoAgua("Blastoise", 19+(numeroAleatorio), 11+(numeroAleatorio), 10+(numeroAleatorio), 11+(numeroAleatorio), 1, "Agua");
                        jugador.addPokemon(pokemon);
                        System.out.println("Agregado con exito a tu pokedex");
                        //Agregando otro pokemon a la Pokedex del jugador
                        tipoElectrico pokemon2 = new tipoElectrico("Raichu", 19+(numeroAleatorio), 11+(numeroAleatorio), 10+(numeroAleatorio), 11+(numeroAleatorio), 1, "Electrico");
                        jugador.addPokemon(pokemon2);
                        tipoHierba pokemon3 = new tipoHierba("Grotle", 18+(numeroAleatorio), 12+(numeroAleatorio), 11+(numeroAleatorio), 10+(numeroAleatorio), 1, "Hierba");
                        jugador.addPokemon(pokemon3);
                        op2 = 0;
                        break;
                    }
                case 3:
                {
                        System.out.println("### VENUSAUR - INFERNAPE - GYARADOS ###");
                        int numeroAleatorio = aleatorio();
                        tipoHierba pokemon = new tipoHierba("Venusaur", 19+(numeroAleatorio), 11+(numeroAleatorio), 10+(numeroAleatorio), 11+(numeroAleatorio), 1, "Hierba");
                        jugador.addPokemon(pokemon);
                        System.out.println("Agregado con exito a tu pokedex");
                        //Agregando otro pokemon a la Pokedex del jugador (temporal)
                        tipoFuego pokemon2 = new tipoFuego("Infernape", 18+(numeroAleatorio), 10+(numeroAleatorio), 9+(numeroAleatorio), 13+(numeroAleatorio), 1, "Fuego");
                        jugador.addPokemon(pokemon2);
                        tipoAgua pokemon3 = new tipoAgua("Gyarados", 19+(numeroAleatorio), 11+(numeroAleatorio), 10+(numeroAleatorio), 11+(numeroAleatorio), 1, "Agua");
                        jugador.addPokemon(pokemon3);
                        op2 = 0;
                        break;
                }
                default:
                {
                    System.out.println("OPCION NO VALIDA");
                    op2 = 1;
                    break;
                }
            }
        }
    }
    /**
     * Metodo usado para generar un numero aleatorio entre -2 y 2, con motivos de balance del juego y dar diversidad a los valores de los atributos del pokemon
     * @return Retorna el numero aleatorio obtenido
     */
    public static int aleatorio(){
        Random rng = new Random();
        int randomNumber = rng.nextInt(5)-2; //Genera numero aleatorio entre -2 y 2
        return randomNumber;
    }
    /**
     * Metodo que genera el resultado del ataque 1 del jugador
     * @param jugador1 Recibe el jugador atacante
     * @param jugador2 Recibe el jugador atacado
     */
    public static void ataque1(Player jugador1, Player jugador2){ //El jugador 1 es el atacante, el jugador 2 es el atacado
        int dmg, dfc;
        float result;
        dmg = jugador1.pokedex.get(0).getAttackDamage(); //Obtenemos el daño del pokemon del jugador atacante
        dfc = jugador2.pokedex.get(0).getDefence(); //Obtenemos la defensa del pokemon del jugador atacado
        String tmp = jugador2.pokedex.get(0).getType(); //Obtenemos el tipo del pokemon del jugador a atacar
        //Imprimimos el nombre del pokemon que ataca
        System.out.println(jugador1.pokedex.get(0).getName()+" ataca");
        //Asignamos el valor del Multiplicador elemental del pokemon atacante con el tipo del pokemon atacado
        float EM = jugador1.pokedex.get(0).setElementalMultiplier(jugador1, tmp); //Funcion para calcular el multiplicador elemental
        
        //Calculamos el resultado del enfrentamiento 
        result = (dmg - dfc) * EM;
        
        //En esta funcion, calculamos la salud correspondida al pokemon atacado
        jugador2.pokedex.get(0).combateA1(jugador2, EM, result); //Pasamos el jugador atacado, el MultiplicadorElemental y el resultado de la batalla

    }
    /**
     * Metodo que genera el resultado del ataque 2 del jugador
     * @param jugadorAtacante Recibe el jugador atacante
     * @param jugadorAtacado Recibe el jugador atacado
     */
    public static void ataque2 (Player jugadorAtacante, Player jugadorAtacado){ //Funcion para que se realice el ataque 2
        int dmg, dfc;
        float result;
        dmg = jugadorAtacante.pokedex.get(0).getAttackDamage(); //Obtenemos el daño del pokemon del jugador atacante
        dfc = jugadorAtacado.pokedex.get(0).getDefence(); //Obtenemos la defensa del pokemon del jugador atacado
        result = (dmg - dfc);
        System.out.println(jugadorAtacante.pokedex.get(0).getName()+" ataca");
        if (result <= 0){
            System.out.println("LA DEFENSA ES EXCELENTE, NO RECIBE DANIO");
        } else {
            int health = jugadorAtacado.pokedex.get(0).getHealth();
            result = health - result;
            jugadorAtacado.pokedex.get(0).setHealth((int) result);
        }
    }
    /**
     * Metodo para validar el estado de los pokemon dentro de la lista de pokemon de un jugador
     * @param jugador Recibe el jugador para evaluar sus pokemon de su lista de pokemon
     * @return Regresa un valor, si es un cero significa que el pokemon se encuentra derrotado y no se puede usar
     */
    public static int validateState(Player jugador){
        int op = jugador.pokedex.get(0).getState();
        if (op == 1){ //Estado 1: Disponible
            return 1;
        }
        System.out.println("POKEMON DERROTADO, ESCOGE OTRO POKEMON");
        return 0; //Estado 0: No disponible
    }
    /**
     * Metodo que sirve para sumar vida en caso de haber usado una pocion de vida en un pokemon
     * @param jugador Recibe el jugador para obtener el pokemon al cual se le va a aplicar el aumento de vida
     * @param maxHP Recibe la vida maxima del pokemon
     * @return Retorna un uno en caso de que se hayan agotado las pociones
     */
    public static int sumarVida(Player jugador, int maxHP){ //Funcion para aumentar la vida del pokemon

        boolean booleano = jugador.comprobarPocion(jugador, "Vida");
        if (booleano){ //Si aun quedan pociones, restaremos una pocion y aumentaremos la vida
            float result;
            result = (float) ((maxHP*0.2) + jugador.pokedex.get(0).getHealth()); // Calculo de la vida a aumentar
            jugador.pokedex.get(0).setHealth((int) result); //Colocamos el resultado del calculo anterior a la nueva vida del pokemon
            jugador.borrarPocion(jugador, "Vida"); //Quitamos una pocion de vida en este caso
            System.out.println("Se ha sumado un 20% a la vida"); //Imprimimos si ha sido correcto
            return 0; //Regresamos un cero para evaluarlo en la opcion de "Mochila"
        } else{
            System.out.println("NO QUEDAN MAS POCIONES"); //Si la funcion comprobarPocion retorna un valor falso, significa que se han acabado las pociones de vida y no se puede seguir sumando vida al pokemon
            return 1;
        }
  
    }
    /**
     * Metodo que sirve para aumentar los puntos de la defensa del pokemon
     * @param jugador Recibe el jugador para obtener el pokemon al cual aplicarle el aumento de defensa
     * @return Retorna un uno en caso de que se hayan agotado las pociones
     */
    public static int sumarDefensa(Player jugador){ //Funcion para aumentar la defensa del pokemon

        boolean booleano = jugador.comprobarPocion(jugador, "Defensa");
        if (booleano){ //Si aun quedan pociones, restaremos una pocion y aumentaremos la defensa
            float result;
            int dfc = jugador.pokedex.get(0).getDefence();
            result = (float) ((dfc*0.1) + dfc); // Calculo de la defensa a aumentar (10% de la denfesa original)
            jugador.pokedex.get(0).setDefence((int) result); //Colocamos el resultado del calculo anterior a la nueva defensa del pokemon
            jugador.borrarPocion(jugador, "Defensa"); //Quitamos una pocion de defensa en este caso
            System.out.println("Se ha sumado un 10% a la defensa"); //Imprimimos si ha sido correcto
            return 0; //Regresamos un cero para evaluarlo en la opcion de "Mochila"
        } else{
            System.out.println("NO QUEDAN MAS POCIONES"); //Si la funcion comprobarPocion retorna un valor falso, significa que se han acabado las pociones de defensa y no se puede seguir sumando defensa al pokemon
            return 1;
        }
  
    }
    /**
     * Metodo que sirve para aumentar los puntos de la defensa del pokemon
     * @param jugador Recibe el jugador para obtener el pokemon al cual aplicarle el aumento de defensa
     * @return Retorna un uno en caso de que se hayan agotado las pociones
     */
    public static int sumarDanio(Player jugador){ //Funcion para aumentar el danio del pokemon

        boolean booleano = jugador.comprobarPocion(jugador, "Danio");
        if (booleano){ //Si aun quedan pociones, restaremos una pocion y aumentaremos el danio
            float result;
            int dmg = jugador.pokedex.get(0).getAttackDamage();
            result = (float) ((dmg*0.1) + dmg); // Calculo del danio a aumentar (10% de la danio original)
            jugador.pokedex.get(0).setAttackDamage((int) result); //Colocamos el resultado del calculo anterior al nuevo danio del pokemon
            jugador.borrarPocion(jugador, "Danio"); //Quitamos una pocion
            System.out.println("Se ha sumado un 10% al danio"); //Imprimimos si ha sido correcto
            return 0; //Regresamos un cero para evaluarlo en la opcion de "Mochila"
        } else{
            System.out.println("NO QUEDAN MAS POCIONES"); //Si la funcion comprobarPocion retorna un valor falso, significa que se han acabado las pociones de defensa y no se puede seguir sumando defensa al pokemon
            return 1;
        }
  
    }
    
}
