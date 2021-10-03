public class Devil extends Demon{

    public Devil(String name, int HP, int MAXHP, int XP){
        super(name, 400, 400, 0);
        this.name = name;
        this.HP = HP;
    }
    @Override
        public int attack(){
            return 250;
        }
        @Override
        public void ability(){
            this.ability = 2;
            if(this.ability > 0){
                Mage.XP = Mage.XP - 75;
                Brawler.XP = Brawler.XP - 75;
                System.out.println("Has debilitado al heroe!\n");
                this.ability = this.ability --;
            }
            else if (this.ability <= 0){
                System.out.println("No tenes mana!\n");
            }
        }
}
