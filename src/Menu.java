import java.util.Scanner;

public class Menu {
    int n;
    Scanner s = new Scanner(System.in);
    Story Story = new Story();
    String Name;
    static Mage m;
    int place = 0, act = 1;
    boolean inProgress;
    public Menu(){
        n = 0;
    }
    public void menu(){
        System.out.println("Bienvenido a Tierra de Magia");
        System.out.println("Director: Edgar 211133 \n");
        PAC();
        adventure();
    }
    public void PAC(){
        System.out.println("Presione cualquier boton para continuar\n");
        s.next();
        empty();
    }
    public void adventure(){
        boolean pName = false;
        System.out.println("Te gustaria ser: \n 1. un mago \n 2. un batallador?");
        n = s.nextInt(3);
        if (n ==1){
            do{
                System.out.println("Cual es tu nombre, valiente aventurero? \n");
                Name = s.next();
                System.out.println("Tu nombre es " + Name + "?\n");
                System.out.println("1. Si\n");
                System.out.println("2. No\n");
                int N = s.nextInt(3);
                if (N == 1)
                    pName = true;   
            }
                while(!pName);
                    empty();  
                    Story.introM();
					PAC();
                    m = new Mage(Name, 100, 100, 0);  
                    inProgress = true;
                    while(inProgress = true){
                        empty();
                        printMenu();
                            int n = s.nextInt(4);
                            if (n == 1){
                                if (place == 0){
                                    Story.firstBattle();
                                    PAC();
                                    empty();
                                    m.knightBattle();
                                    PAC();
                                    empty();
                                    if(m.XP >= 10 && act ==1){
                                        act = 2;
                                        place = 1;
                                        Story.blackKnightsStronghold();                                    
                                        PAC();
                                        empty();
                                    }                                    
                                }
                                else if (place == 1){
                                    if (m.XP < 50){
                                        System.out.println("Has encontrado otro Knight!!\n");
                                        PAC();
                                        empty();
                                        m.knightBattle();
                                        PAC();
                                        empty();
                                    }
                                    if (m.XP >= 50 && act == 2){
                                        act = 3;
                                        place = 2;
                                        System.out.println("Hay un ultimo caballero frente a la puerta que lleva al Black Knight...\n");
                                        PAC();
                                        empty();
                                        m.knightBattle();
                                        PAC();
                                        empty();
                                        Story.castleBossBattle();
                                        PAC();
                                        empty();
                                    }
                                }
                                else if (place == 2){
                                    m.blackKnight();
                                    PAC();
                                    empty();
                                        if (m.XP >= 80 && act == 3){
                                            act = 4;
                                            place = 3;
                                            Story.roadtoHell();
                                            PAC();
                                            empty();
                                        }
                                }
                                else if (place == 3){
                                    Story.Hell();
                                    PAC();
                                    empty();
                                    System.out.println("Un demonio se interpone en tu camino, babeando, con las garras preparadas...\n");
                                    PAC();
                                    empty();
                                    m.demonBattle();
                                    PAC();
                                    empty();
                                    if (m.XP >= 150 && act == 4){
                                        act = 5;
                                        place = 4;
                                    }
                                }
                                else if (place == 4){
                                    System.out.println("Solo sobrevive un demonio.\n Matalo para vencer al diablo\n");
                                    PAC();
                                    empty();
                                    m.demonBattle();
                                    PAC();
                                    empty();
                                    Story.deviloftheTreeStars();
                                    PAC();
                                    empty();
                                    m.finalBattle();
                                    PAC();
                                    empty();
                                    if (m.XP >= 85 && act == 4){
                                        act = 5;
                                        place = 4;
                                        Story.theEnd();
                                        PAC();
                                        empty();
                                        System.out.println("Ha vengado a su familia y a sus amigos. \nPero ahora eres el diablo en la historia de otros\n");
                                        System.out.println("Deseas jugar de nuevo?\n");
                                        System.out.println("1. Si");
                                        System.out.println("2. No\n");
                                        int y = s.nextInt(2);
                                            if (y == 1){
                                                menu();
                                            }
                                            else if (y == 2){
                                                n = 3;
                                            }
                                    }
                                }    
                            }     
                            else if (n == 2){
                                pInfo();
                                PAC();
                            }       
                            else if (n == 3){
                                System.out.println("Hasta la proxima aventurero\n");
                                System.exit(0);
                            }
                    }     
        }
    }
    public void empty(){
        for (int i = 0; i < 100; i ++){
            System.out.println("");
        }
    }
    public static void pInfo(){
        System.out.println(m.name + "\t HP " + m.HP + "\t XP " + m.XP + "\n");
    }
    public static void printMenu(){
        System.out.println("Que deseas hacer: \n");
        System.out.println("1. Continuar tu aventura\n");
        System.out.println("2. Ver las caracteristicas de tu mago\n");
        System.out.println("3. Salir del juego\n");
    }
}