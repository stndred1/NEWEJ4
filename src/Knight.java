public class Knight extends Attacker {
    static int HP;
    static String name;
    public Knight(String name, int HP, int MAXHP, int XP) {
        super("Knight", 175, 175, 0);
        this.HP = HP;
        this.XP = XP;
    }
    @Override
    public int attack(){
        return 50;
    }
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
