public class Brawler extends Attacker {
    static int HP, XP;
    public Brawler(String name, int HP, int MAXHP, int XP){
        super(name, 150, 150, 0);
    }
    @Override
    public int attack(){
        return 50 + XP/2;
    }
    @Override
    public void ability(){
        this.ability = 3;
        if (this.ability > 0){
            XP = XP + 50;
            System.out.println("Usaste tu item!\n Tu ataque subio!\n");
            this.ability = this.ability --;
        }
        else if (this.ability <= 0){
            System.out.println("No tenes items para usar!\n");
        }
    }

}
