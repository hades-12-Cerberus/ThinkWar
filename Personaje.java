public class Personaje { //Creamos la clase del personaje como publica para luego poder llamarla//
    String name; //Creamos la variable donde vamos a guadar el valor del nombre del personaje y el enemigo//
    int health; //Creamos la variable donde vamos a guardar el valor de la vida del personaje y el enemigo//
    int attack; //Creamos la variable donde vamos a guardar el valor del ataque del personaje y el enemigo//

    public Personaje(String name, int health, int attack) { //Creamos el constructor del personaje para luego poder llamarlo//
        this.name = name; //Creamos los atributos de la clase que sera el valor que luego se le pase al constructor//
        this.health = health;
        this.attack = attack;
    }

    public void attack(Personaje objetivo) { //Creamos el metodo para el ataque que apunta a otro metodo que es el objetivo, a quien vamos a atacar//
        objetivo.health -= this.attack; //Aqui le estamos restando los puntos de vida al objetivo por el ataque recibido//
        System.out.println(this.name + " ataca y causa " + this.attack + " de daño"); //Imprimimos por pantalla el nombre del personaje que ha atacado y cuanto daño ha causado//
    }

    public boolean estaVivo() {
        return health > 0;
    } //Creamos el metodo booleano para poder comprobar si el personaje sigue vivo o no//

}
