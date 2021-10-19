/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
public class Demon extends Enemy{ 
    //Constructor del demonio
        static int HP, XP, ability;
        static String name;
        public Demon(String name, int HP, int MAXHP, int XP) {
            super("Demon", 275, 275, 0);
            this.HP = HP;
            this.XP = XP;
        }
        @Override
        //Override el ataque del mago
        public int attack(){
            return 75 + Player.HP/5;
        }

        //Override para la habilidad del demonio
        @Override
        public void ability(){
            this.ability = 2;
            if(this.ability > 0){
                Player.XP = Player.XP -50;
                System.out.println("Has debilitado al heroe\n");
                this.ability = this.ability --;
            }
            else if (this.ability <= 0){
                System.out.println("No tenes mana!\n");
            }
        }
}
