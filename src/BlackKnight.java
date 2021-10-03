public class BlackKnight extends Attacker{

    public BlackKnight(String name, int HP, int MAXHP, int XP){
        super(name, 200, 200, 0);
        this.name = name;
        this.HP = HP;
    }
    @Override
    public int attack(){
        return 85;
    }
    @Override
    public void ability(){
        this.ability = 2;
        if(this.ability > 0){
            Mage.HP = Mage.HP - 50;
            Brawler.HP = Brawler.HP - 50;
            System.out.println("Has disparado una flecha a tu oponente!\n Has hecho 20 en dano\n");
            this.ability = this.ability --;
        }
        else if (this.ability <= 0){
            System.out.println("No te quedan flechas!\n");
        }
    }
}
