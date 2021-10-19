/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
public class Knight extends Enemy {
    //Constructor del Knight
    static int HP, XP, ability;
    static String name;
    public Knight(String name, int HP, int MAXHP, int XP) {
        super("Knight", 175, 175, 0);
        this.HP = HP;
        this.XP = XP;
    }
    @Override
    //Override del ataque del mago
    public int attack(){
        return 30 + Mage.HP/5;
    }
    //El ataque para el Brawler
    public int attackB(){
        return 30 + Player.HP/4;
    }
    //Override para la habilidad del Knight
    @Override
    public void ability(){
        this.ability = 2;
        if(this.ability > 0){
            Mage.HP = Mage.HP - 20;
            Brawler.HP = Brawler.HP - 20;
            System.out.println("Has disparado una flecha a tu oponente!\n Has hecho 20 en dano\n");
            this.ability = this.ability --;
        }
        else if (this.ability <= 0){
            System.out.println("No te quedan flechas!\n");
        }
    }
}
