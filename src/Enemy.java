public abstract class Enemy extends Attacker{

    static String name;
    static int HP, XP, ability, MAXHP;



    public Enemy(String name, int HP, int MAXHP, int XP) {
        //Constructor para la clase abstracta
        super(name, HP, MAXHP, XP);
    }
    //metodo abstracto para los players
    public abstract int attack();
    //metodo abstracto para la habilidad
    public abstract void ability();
    
}
