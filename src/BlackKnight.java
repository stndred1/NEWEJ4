/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
public class BlackKnight extends Enemy{
    //Constructor del Black Knight
    static int XP, HP, ability;
    public BlackKnight(String name, int HP, int MAXHP, int XP){
        super(name, 200, 200, 0);
        this.name = name;
        this.HP = HP;
    }
    //Override para el ataque del mago
    @Override
    public int attack(){
        return 50 + Player.HP/5;
    }
    @Override
    //Override para la habilidad del Black Knight
    public void ability(){
        this.ability = 2;
        if(this.ability > 0){
            Player.HP = Player.HP - 50;
            System.out.println("Has disparado una flecha a tu oponente!\n Has hecho 50 en dano\n");
            this.ability = this.ability --;
        }
        else if (this.ability <= 0){
            System.out.println("No te quedan flechas!\n");
        }
    }
}
