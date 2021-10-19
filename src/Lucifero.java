public class Lucifero extends Devil {
    static int XP, HP;
    Dragon Dr = new Dragon(140);
    static Dragon q = new Dragon(140);
    public Lucifero(String name, int HP, int MAXHP, int XP){
        super(name, HP, MAXHP, XP);
        this.name = name;
        this.HP = HP;
        this.MAXHP = MAXHP;
        this.XP = XP;
    }
   //El override del ataque para los jugadores
   @Override
   public int attack(){
       return 55 + Player.HP/5;
   }
    public void Heal(){
        if (q != null){ 
            System.out.println("No tenes la energia para poder recuperarte.\n");
        }
        else if (q == null){
            this.HP = this.HP + 50;
        }
    }
   //Override para la habilidad del Lucifero
   @Override
   public void ability(){
        if (q == null){
            this.ability = 2;
            if(this.ability > 0){
            Mage.XP = Mage.XP - 100;
            Brawler.XP = Brawler.XP - 100;
            BeastTamer.XP = BeastTamer.XP - 100;
            System.out.println("Has debilitado al heroe!\n");
            this.ability = this.ability - 1;
            }
            else if (this.ability <= 0){
            System.out.println("No tenes mana!\n");
            }
            }
        else if (q != null){
            System.out.println("No tenes mana!\n");
        }
   }
    public void cloneDragon(){
        if (Dr == null){
            System.out.println("No hay mascotas en la batalla");
        }
        else if (Dr != null){
            Dragon q = new Dragon(140);
        }        
    }
    public void Vary(){
        System.out.println("Que habilidad deseas dar a tu clone?\n");
        System.out.println("1. Atacar\n");
        System.out.println("2. Recuperar\n");

   }
    public void liberate(){
        q = null;
   }    
}
