/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
public class Brawler extends Player{
    // Constructor del Brawler
    static int HP, XP, ability;
    int n;
    String name;
    public Brawler(String name, int HP, int MAXHP, int XP){
        super(name, 150, 150, 0);
        this.name = name;
        this.HP = HP;
        this.XP = XP;
        this.MAXHP = 150;
    }
    @Override
    //El ataque del Brawler
    public int attack(){
        return 70 + XP/2;
    }
    @Override
    //La habilidad del brawler
    public void ability(){
        this.ability = 3;
        if (this.ability > 0){
            XP = XP + 50;
            System.out.println("Usaste tu item!\n Tu ataque subio!\n");
            this.ability = this.ability - 1;
        }
        else if (this.ability <= 0){
            System.out.println("No tenes items para usar!\n");
        }
    }
}
