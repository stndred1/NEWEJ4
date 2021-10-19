public class BeastTamer extends Player {

    String name;
    static int HP, XP, ability;

    public BeastTamer(String name, int HP, int MAXHP, int XP){
        super(name, 125, 125, 0);
        this.name = name;
        this.XP = XP;
        this.HP = HP;
        this.MAXHP = MAXHP;
    }
    @Override
        public int attack(){
            if (ability > 0){
                return 135 + XP/2;
            }
            else if (ability <= 0){
                return 100 + XP/2;
            }
            return attack();
        }
    @Override
        public void ability(){
           ability = 1;
           if (ability == 1){
               Dragon Dr = new Dragon(150);
               System.out.println("Tu monstruo ha entrado a la pelea!");
               this.ability = 0;
               if (Dr.HP <= 0){
                   this.ability = 1;
               }
               if (this.HP <= 0){
                   Dr.HP = 0;
               } 
           }
           else if (ability <= 0){
               System.out.println("Tu monstruo todavia esta en la pelea");
           }
        }    
}
