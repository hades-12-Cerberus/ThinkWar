import java.util.Scanner; //Importamos la libreria para poder usar el escaner//

public class ThinkWar { //Creamos la clase publica//
    public static void main(String[] args) { //Creamos el main que es donde vamos a ejecutar el juego y vamos a llamar a las demas clases//
        Scanner scn = new Scanner(System.in);//Creamos la variable del escaner para que el usuario pueda introducir por consola las opciones elegidas//

        int menu = 0; //Creamos la variable del menu y le damos valor 0 porque sino no funciona//

        while (menu != 3) { //Creamos el bucle while y si menu es diferente a 3 el bucle sigue//
            System.out.println("=======================================");
            System.out.println("Bienvenido vas a jugar a ThinkWar");
            System.out.println("=======================================");
            System.out.println("1. Jugar"); //Imprimimos por pantalla la opcion de jugar//
            System.out.println("2. Creditos"); //Imprimimos por pantalla la opcion de los creditos//
            System.out.println("3. Salir"); //Imprimimos por pantalla la opcion de salir del juego//
            System.out.println("Elige una opcion: "); //Imprimimos por pantalla para que el jugador eliga una opcion//

            menu = scn.nextInt(); //Le decimos a la variable de menu que el valor lo va a leer del usuario//

            switch (menu) { //Creamos un switch con la variable de menu para decir que pasa segun la opcion que eliga el jugador//
                case 1: //Creamos el caso 1//
                    iniciarJuego(scn); //Llamamos a la clase publica iniciarJuego//
                    break; //Salimos del bucle//
                case 2: //Creamos el caso 2//
                    System.out.println("ThinkWar ha sido creado por Iván Martín Carretero como proyecto final de la asignatura Fundamentos de Progamación. Gracias por jugarlo.");
                    break; //Salimos del bucle//
                case 3: //Creamos el caso 3//
                    System.out.println("Has salido del juego. Una lastima, no sabes disfrutar");
                    break; //Salimos del bucle//
                default: //Creamos un caso por defecto en el que si el jugador elige una opcion incorrecta se mostrara por pantalla lo de abajo//
                    System.out.println("Opción incorrecta. Vuelve a elegir una opción correcta");
            }
        }
        scn.close(); //Cerramos el escaner//
    }
    public static void iniciarJuego(Scanner scn){ //Creamos la clase publica iniciarJuego que contendra la variable de escaner para poder seguir utilizandola dentro del juego//

            Personaje[] personajesDisponibles = { //Creamos un array para poder almacenar los personajes dentro//
                    new Personaje("Papa Noel", 70, 10), //Creamos el personaje con su nombre, vida y ataque//
                    new Personaje("Melchor", 60, 12),
                    new Personaje("Duende", 50, 15)
            };
            Personaje[] enemigosDisponibles = { //Creamos un array para poder almacenar los personajes enemigos dentro//
                    new Personaje("Grinch", 50, 6), //Creamos los enemigos con su nombre. vida y daño//
                    new Personaje("Krampus", 60, 14),
                    new Personaje("Jack Frost", 60, 10)
            };

            System.out.println("Prepárate, Elige tu personaje:");
            for (int i = 0; i < personajesDisponibles.length; i++) { //Creamos un bucle para mostrar los personajes almacenados en el array, empezando en la posicion 0 y seguimos mientras que i sea menor que el array y le incrementamos 1//
                System.out.println((i + 1) + ". " + personajesDisponibles[i].name + " (Vida: " + personajesDisponibles[i].health + ", Ataque: " + personajesDisponibles[i].attack + ")"); //Imprimimos por pantalla los personajes para que el jugador eliga y usamos i+1 para que la opcion empieze en 1 y no en 0//
            }

            int eleccion = scn.nextInt() - 1; //Creamos la variable para que el jugador eliga al personaje, le restamos 1 porque el array empieza en 0,1,2 pero nosotros queremos mostrar la opcion 1,2,3//
            Personaje Player = personajesDisponibles[eleccion]; //Creamos el objeto del personaje que se le asignara el personaje de eleccion del array//
            System.out.println("El personaje elegido es " + Player.name); //Imprimimos el personaje que el jugador ha elegido//

            Personaje Enemy = enemigosDisponibles[(int) (Math.random() * enemigosDisponibles.length)]; //Para elegir el enemigo de manera aleatoria usamos la funcion Math.random que genera un numero y lo multiplicamos por el numero de enemigos disponibles y con int lo convertimos en numero entero//
            System.out.println("Mala suerte. Tu enemigo es: " + Enemy.name); //Imprimimos por pantalla el enemigo al que se enfrenta el jugador//

            int healingPotion = 3; //Creamos la variable de las pociones que va a tener el jugador//

            System.out.println("Prepárate, la batalla ha comenzado!"); //Imprimimos por pantalla//

            while (Player.estaVivo() && Enemy.estaVivo()) { //Creamos el bucle donde mientras el jugador y el enemigo esten vivos hacemos lo de abajo//
                System.out.println("======================================"); //Diferenciamos el turno del jugador//
                System.out.println("Tienes " + Player.health + " puntos de vida"); //Imprimimos por pantalla la cantidad de vida que tiene el jugador//
                System.out.println("El enemigo tiene " + Enemy.health + " puntos de vida"); //Imprimimos por pantalla la cantidad de vida tiene el enemigo//
                System.out.println("1. Atacar"); //Imprimimos por pantalla la opcion de atacar//
                System.out.println("2. Usar pociones. Te quedan " + healingPotion); //Imprimimos por pantalla la opcion de usar pociones y la cantidad que tiene el jugador//
                System.out.println("3. Defender"); //Imprimimos por pantalla la opcion de defenderse//

                int option = scn.nextInt(); //Creamos la variable de opcion para poder guardar la opcion que introduzca el jugador por pantalla//

                switch (option) { //Creamos un switch para decir que pasa segun la opcion que haya elegido el jugador//
                    case 1: //Creamos el primer caso//
                        Player.attack(Enemy); //El jugador ataca al enemigo//
                        break; //Cuando elige la opcion se para el bucle//
                    case 2: //Creamos el segundo caso//
                        if (healingPotion > 0) { //Comprobamos si le quedan pociones, tiene mas de 0//
                            Player.health += 15; //Si tiene pociones y la usa, el jugador se cura 15 puntos de vida//
                            healingPotion--; //Si usa la pocion, se le resta de las que le queden//
                            System.out.println("Has usado una poción curativa y has recuperado 15 puntos de salud"); //Imprimimos por pantalla que ha usado una pocion y cuantos puntos de vida se ha curado//
                        } else { //Si comprueba y no tiene pociones, imprimimos por pantalla lo de abajo//
                            System.out.println("No tienes mas pociones");
                        }
                        break; //Salimos del bucle//
                    case 3: //Creamos el tercer caso//
                        System.out.println("Te estas defendiendo"); //Imprimimos por pantalla que el jugador se esta defendiendo//
                        break; //Salimos del bucle//
                    default: //Creamos un caso por defecto en el que si el jugador introduce una opcion incorrecta, imprimimos por pantalla lo de abajo//
                        System.out.println("Opcion incorrecta. Elige una opcion correcta");
                        continue; //En caso de que el jugador introduzca una opcion incorrecta, el bucle se vuelve a ejecutar dandole el turno otra vez al jugador//
                }

                if (!Enemy.estaVivo()) { //Comprobamos si el enemigo sigue vivo o no y si no sigue vivo imprimimos por pantalla lo de abajo//
                    System.out.println("Has derrotado al enemigo");
                    break; //Salimos del bucle//
                }

                System.out.println("===================================="); //Diferenciamos el turno del enemigo//
                System.out.println("Es el turno del enemigo"); //Imprimimos por pantalla que es el turno del enemigo//
                if (option == 3) { //Comprobamos si la opcion elegida por el jugador es el caso 3, en ese caso hacemos lo de abajo//
                    System.out.println("Bloqueas parte del daño"); //Imprimimos por pantalla que el jugador bloquea parte del daño//
                    Player.health -= Math.max(Enemy.attack - 4, 0); //Le restamos 4 de vida al jugador y con el 0 nos aseguramos de que el valor no pase a negativo//
                } else { //Si la opcion elegida por el jugador es diferente al caso 3, el enemigo ataca normal al jugador//
                    Enemy.attack(Player);

                }

            }

            if (!Player.estaVivo()) { //Comprobamos si el jugador sigue vivo o no y si no sigue vivo imprimimos por pantalla lo de abajo//
                System.out.println("Que pena, has sido derrato y la Navidad ha muerto junto a tí");
            }

        System.out.println("Volviendo al menu principal"); //Imprimimos por pantalla que vamos a volver al menu principal//
        }
    }

