public class Attacker {
    static String name;
    int HP;
    static int MAXHP;
    int XP;
    int ability;

    public Attacker(String name, int HP, int MAXHP, int XP) {

        if (HP <= 0){
            HP = 0;
        }

    }

    public int attack(){
        return 0; 
    }

    public void ability(){

    }
}
