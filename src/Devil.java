/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
public class Devil extends Demon{
    //Constructor de diablo
    static int XP, HP;
    public Devil(String name, int HP, int MAXHP, int XP){
        super(name, 400, 400, 0);
        this.name = name;
        this.HP = HP;
    }
    //El override del ataque para el mago
    @Override
        public int attack(){
            return 150 + Mage.HP/5;
        }
        //Ataque para el Brawler
        public int attackB(){
            return 150 + Brawler.HP/4;
        }
        //Override para la habilidad del Diablo
        @Override
        public void ability(){
            this.ability = 2;
            if(this.ability > 0){
                Mage.XP = Mage.XP - 75;
                Brawler.XP = Brawler.XP - 75;
                System.out.println("Has debilitado al heroe!\n");
                this.ability = this.ability - 1;
            }
            else if (this.ability <= 0){
                System.out.println("No tenes mana!\n");
            }
        }
}
