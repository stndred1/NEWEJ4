public class Demon extends Attacker{
    
        static int HP;
        static String name;
        public Demon(String name, int HP, int MAXHP, int XP) {
            super("Demon", 275, 275, 0);
            this.HP = HP;
            this.XP = XP;
        }
        @Override
        public int attack(){
            return 150;
        }
        @Override
        public void ability(){
            this.ability = 2;
            if(this.ability > 0){
                Mage.XP = Mage.XP - 50;
                Brawler.XP = Brawler.XP - 50;
                System.out.println("Has debilitado al heroe\n");
                this.ability = this.ability --;
            }
            else if (this.ability <= 0){
                System.out.println("No tenes mana!\n");
            }
        }
}
