import java.util.*;
public class Mage extends Attacker {
    int n;
    String name;
    static int HP, XP;
    Scanner s = new Scanner(System.in);
    public Mage(String name, int HP, int MAXHP, int XP){

        super(name, 100, 100, 0);
        this.name = name;
        this.HP = HP;
        this.XP = XP;
        this.MAXHP = 100;
    }
        @Override
        public int attack(){
            return 75 + XP/2;
        }
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
        public void knightBattle(){
            Knight k = new Knight(name, 175, 175, 0);
            System.out.println("Preparate para morir Knight!\n");
            System.out.println("Hoy sera tu ultimo dia Mago!\n");
            do{
                System.out.println(name + ", Cual sera tu porxima accion?\n");
                System.out.println("1. Atacar\n2. Usar un item \n");
                n = s.nextInt(3);
                if (n == 1){
                    k.HP = k.HP - attack();
                    if (k.HP <0){
                        k.HP = 0;
                    }
                    System.out.println("Has hecho " + attack() + " de dano!\n");
                    System.out.println("El Knight tiene " + k.HP + " HP!\n");
                    if (k.HP <= 0){
                        System.out.println("Has derrotado a el Knight!\n");
                        k.HP = 0;
                    }
                    else if (k.HP > 0){
                        System.out.println("Knight, cual sera tu proxima accion?\n");
                        System.out.println("1. Atacar\n2. Usar un item\n");
                        int x = s.nextInt(3);
                            if (x ==1){
                                HP = HP - k.attack();
                            System.out.println("Has hecho " + k.attack() + " de dano!\n");
                            System.out.println("El mago tiene " + HP + " HP!\n");
                                if (HP <= 0){
                                    System.out.println("Has matado al ultimo mago en el mundo!\n");
                                    died();
                                }                               
                            }
                            else if (x == 2){
                                k.ability();
                            }
                        }
                }
                if (n == 2){
                    ability();                 
                }
            }
            while (k.HP > 0);
                XP = XP + 15;
                if (XP >= 20){
                    MAXHP = MAXHP +25;
                }     
                HP = MAXHP;         
        }
        public void died(){
            System.out.println("Te Han matado, \n GAME OVER!!!!!\n");
            System.exit(0);
        }
        public void blackKnight(){
            BlackKnight bk = new BlackKnight(name, 225, 225, 0);
            System.out.println("Tu muerte está asegurada mago...\n");
            System.out.println("Me diras para quien trabajas\n");
            do{
                System.out.println(name + ", Cual sera tu porxima accion?\n");
                System.out.println("1. Atacar\n2. Usar un item \n");
                n = s.nextInt(3);
                if (n == 1){
                    bk.HP = bk.HP - attack();
                    System.out.println("Has hecho " + attack() + " de dano!\n");
                    System.out.println("El Knight tiene " + bk.HP + " HP!\n");
                    if (bk.HP <= 0){
                        System.out.println("Has derrotado a el Black Knight!\n");
                        bk.HP = 0;
                    }
                    else if (bk.HP > 0){
                        System.out.println("Knight, cual sera tu proxima accion?\n");
                        System.out.println("1. Atacar\n2. Usar un item\n");
                        int x = s.nextInt(3);
                            if (x ==1){
                                HP = HP - bk.attack();
                            System.out.println("Has hecho " + bk.attack() + " de dano!\n");
                            System.out.println("El mago tiene " + HP + " HP!\n");
                                if (HP <= 0){
                                    System.out.println("Has matado al ultimo mago en el mundo!\n");
                                    died();
                                }                               
                            }
                            else if (x == 2){
                                bk.ability();
                            }
                        }
                }
                if (n == 2){
                    ability();                 
                }
            }
            while (bk.HP > 0);
                XP = XP + 35;
                if (XP >= 70){
                    MAXHP = MAXHP +55;
                }     
                HP = MAXHP;         
        }
        public void demonBattle(){
            Demon d = new Demon(name, 275, 275, 0);
            System.out.println("Todos ustedes pagarán por la muerte de mi familia y mi comunidad.!\n");
            System.out.println("No he probado el alma de un mago en demasiado tiempo...\n");
            do{
                System.out.println(name + ", Cual sera tu porxima accion?\n");
                System.out.println("1. Atacar\n2. Usar un item \n");
                n = s.nextInt(3);
                if (n == 1){
                    d.HP = d.HP - attack();
                    if (d.HP < 0){
                        d.HP = 0;
                    }
                    System.out.println("Has hecho " + attack() + " de dano!\n");
                    System.out.println("El Knight tiene " + d.HP + " HP!\n");
                    if (d.HP <= 0){
                        System.out.println("Has derrotado a el Knight!\n");
                        d.HP = 0;
                    }
                    else if (d.HP > 0){
                        System.out.println("Samael, cual sera tu proxima accion?\n");
                        System.out.println("1. Atacar\n2. Usar un item\n");
                        int x = s.nextInt(3);
                            if (x ==1){
                                HP = HP - d.attack();
                            System.out.println("Has hecho " + d.attack() + " de dano!\n");
                            System.out.println("El mago tiene " + HP + " HP!\n");
                                if (HP <= 0){
                                    System.out.println("Has matado al ultimo mago en el mundo!\n");
                                    died();
                                }                               
                            }
                            else if (x == 2){
                                d.ability();
                            }
                        }
                }
                if (n == 2){
                    ability();                 
                }
            }
            while (d.HP > 0);
                XP = XP + 30;
                if (XP >= 110){
                    MAXHP = MAXHP + 50;
                }     
                HP = MAXHP;         
        }
        public void finalBattle(){
            Devil D = new Devil(name, 400, 400, 0);
            System.out.println("He matado a tus demonios \ny ahora librare al mundo de tu maldad\n");
            System.out.println("No digas tonterías. \nHe matado a innumerables humanos y he torturado las almas de los condenados. \n");
            System.out.println("Moriras aqui hoy, y te atormentare por la eternidad.\n");
            do{
                System.out.println(name + ", Cual sera tu porxima accion?\n");
                System.out.println("1. Atacar\n2. Usar un item \n");
                n = s.nextInt(3);
                if (n == 1){
                    D.HP = D.HP - attack();
                    if (D.HP < 0){
                        D.HP = 0;
                    }
                    System.out.println("Has hecho " + attack() + " de dano!\n");
                    System.out.println("El Knight tiene " + D.HP + " HP!\n");
                    if (D.HP <= 0){
                        System.out.println("Has derrotado a el Knight!\n");
                        D.HP = 0;
                    }
                    else if (D.HP > 0){
                        System.out.println("Demonio, cual sera tu proxima accion?\n");
                        System.out.println("1. Atacar\n2. Usar un item\n");
                        int x = s.nextInt(3);
                            if (x ==1){
                                HP = HP - D.attack();
                            System.out.println("Has hecho " + D.attack() + " de dano!\n");
                            System.out.println("El mago tiene " + HP + " HP!\n");
                                if (HP <= 0){
                                    System.out.println("Has matado al ultimo mago en el mundo!\n");
                                    died();
                                }                               
                            }
                            else if (x == 2){
                                D.ability();
                            }
                        }
                }
                if (n == 2){
                    ability();                 
                }
            }
            while (D.HP > 0);
        }
}
