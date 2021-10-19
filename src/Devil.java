/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
public class Devil extends Enemy{
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
            return 150 + Player.HP/5;
        }
        //Override para la habilidad del Diablo
        @Override
        public void ability(){
            this.ability = 2;
            if(this.ability > 0){
                Player.XP = Player.XP - 75;
                System.out.println("Has debilitado al heroe!\n");
                this.ability = this.ability - 1;
            }
            else if (this.ability <= 0){
                System.out.println("No tenes mana!\n");
            }
        }
}
