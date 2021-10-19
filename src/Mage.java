/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
public class Mage extends Player {
    //Constructor del Mago
    String name;
    static int HP, XP, ability;
    public Mage(String name, int HP, int MAXHP, int XP){

        super(name, 100, 100, 0);
        this.name = name;
        this.HP = HP;
        this.XP = XP;
        this.MAXHP = 100;
    }
    //el Override para el ataque del mago
        @Override
        public int attack(){
            return 
            75 + XP/2;
        }
        //El override para la habilidad del mago
        @Override
        public void ability(){
            this.ability = 3;
            if (this.ability > 0){
                HP = HP + HP/2;
                System.out.println("Usaste tu item!\nTe has curado a ti mismo\nTenes " + HP + " HP\n");
                this.ability = this.ability --;
            }
            else if (this.ability <= 0){
                System.out.println("No tenes items para usar!\n");
            }
        }
}
