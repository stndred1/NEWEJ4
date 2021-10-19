/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
public abstract class Attacker {
    static String name;
    int HP;
    static int MAXHP;
    int XP;
    int ability;

    public Attacker(String name, int HP, int MAXHP, int XP) {
        //Constructor para la clase abstracta
    }
    //metodo abstracto para atacar
    public abstract int attack();
    //metodo abstracto para la habilidad
    public abstract void ability();
}
