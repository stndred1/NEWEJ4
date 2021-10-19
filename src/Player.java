public abstract class Player extends Attacker{

    static String name;
    static int HP, XP, ability, MAXHP;



    public Player(String name, int HP, int MAXHP, int XP) {
        //Constructor para la clase abstracta
        super(name, HP, MAXHP, XP);
    }
    //metodo abstracto para los players
    public abstract int attack();
    //metodo abstracto para la habilidad
    public abstract void ability();

}