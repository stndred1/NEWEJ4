/**
 * @author Edgar Mendez 211133
 * section 40
 * @Version Tears of the Damned Project
 */
//Imports para la clase
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class Menu {
    Random r = new Random();
    int n;
    Scanner s = new Scanner(System.in);
    Story Story = new Story();
    static String Name;
    static Mage m;
    static Brawler b;
    static BeastTamer c;
    static Lucifero L;
    int place = 0, act = 1;
    boolean inProgress;
    public Menu(){
        n = 0;
    }
    //Nombre del juego y mi nombre
    public void menu(){
        System.out.println("Bienvenido a Tierra de Magia");
        System.out.println("Director: Edgar 211133 \n");
        PAC();
        adventure();
    }
    public void mainMenu(){
        System.out.println("Que juego deseas jugar?\n");
        System.out.println("1. Story Mode\n");
        System.out.println("2. Raid Battle\n");
        int g = s.nextInt(3);
            if (g == 1){
                adventure();
            }
            else if (g == 2){
                raidBattle();
            }
    }
    public void PAC(){
        //Hace que el usuario presione un boton para continuar
        System.out.println("Presione cualquier boton para continuar\n");
        s.next();
        empty();
    }
    public void adventure(){
        //La creación del aventurero 
        boolean pName = false;
        System.out.println("Te gustaria ser: \n 1. un mago \n 2. un batallador?");
        int w = s.nextInt(3);
        try{
        //Excepción para asegurar que el usuario escoja un numero correcto
        if (w == 1){
            do{
                //Nombre del Usuario
                System.out.println("Como queres que te llamemos, valiente aventurero? \n");
                Name = s.next();
                System.out.println("Tu nombre es " + Name + "?\n");
                System.out.println("1. Si\n");
                System.out.println("2. No\n");
                int N = s.nextInt(3);
                if (N == 1)
                    pName = true;   
            }
                while(!pName);
                //Asegurar que el usuario tenga el nombre correcto
                //Empieza la historia del mago
                    mageStory();            
        }
        else if (w == 2){
            do{
                //try catch para asegurar que el usuario escoja el numero correcto
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
                //Asegurar que el usuario escoja el nombre que desea
                //Empieza la historia del Brawler
                    brawlerStory();
        }
        }
        catch(InputMismatchException e){
            System.out.println("Por favor elige una opcion correcta!\n");
            menu();
        }
    }
    //Quita todo de la pantalla
    public void empty(){
        for (int i = 0; i < 75; i ++){
            System.out.println("");
        }
    }
    public static void pInfo(){
        //La información del mago
        System.out.println(m.name + "\t HP " + m.HP + "\t XP " + m.XP + "\n");
    }
    public static void pInfoB(){
        //La información del Brawler
        System.out.println(b.name + "\t HP " + b.HP + "\t XP " + b.XP + "\n");
    }
    public static void printMenu(){
        //El menu despues de todas las batallas para poder ver donde estan
        System.out.println("Que deseas hacer: \n");
        System.out.println("1. Continuar tu aventura\n");
        System.out.println("2. Ver las caracteristicas de tu aventurero\n");
        System.out.println("3. Salir del juego\n");
    }
    public void mageStory(){
        //La historia del mago completa
                    empty();
                    //El intro de la historia  
                    Story.introM();
					PAC();
                    //Creación de un nuevo mago
                    m = new Mage(Name, 100, 100, 0);  
                    inProgress = true;
                    while(inProgress = true){
                        empty();
                        printMenu();
                        try{
                            //el mismo try catch
                            int n = s.nextInt(4);
                            if (n == 1){
                                if (place == 0){
                                    //La historia del nuevo mago con la primera batalla
                                    Story.firstBattle();
                                    knightBattleM();
                                        if(m.XP >= 10 && act ==1){
                                            act = 2;
                                            place = 1;
                                            //La historia del castillo
                                            Story.blackKnightsStronghold();
                                        }                                    
                                }
                                //Asegurar que el usuario tenga la fuerza suficiente para combatir con el Black Knight!!! 
                                else if (place == 1){
                                    if (m.XP < 50){
                                        System.out.println("Has encontrado otro Knight!!\n");
                                        knightBattleM();         
                                    }
                                    //Cambio de lugar y la ultima batalla con un knight
                                    if (m.XP >= 50 && act == 2){
                                        act = 3;
                                        place = 2;
                                        System.out.println("Hay un ultimo Knight frente a la puerta que lleva al Black Knight...\n");
                                        knightBattleM();
                                        //Historia para la pelea del jefe
                                        Story.castleBossBattle();
                                    }
                                }
                                else if (place == 2){
                                    //La batalla con el Black Knight
                                        bossBattleCM();
                                        if (m.XP >= 80 && act == 3){
                                            act = 4;
                                            place = 3;
                                            //El viaje el infierno
                                            Story.roadtoHell();
                                        }
                                }
                                else if (place == 3){
                                    //Batallas con los demonios
                                    Story.Hell();
                                    PAC();
                                    System.out.println("Un demonio se interpone en tu camino, babeando, con las garras preparadas...\n");
                                    demonBattleM();
                                    //Asegurar que el usuario podría vencer al Diablo de Negro
                                    if (m.XP >= 250 && act == 4){
                                        act = 5;
                                        place = 4;
                                    }
                                    else if (place == 3){
                                        //Batalla con los demonios
                                        demonBattleM();
                                    }
                                }
                                if (place == 4){
                                    System.out.println("Solo sobrevive un demonio.\n Matalo para vencer al diablo\n");
                                    PAC();
                                    empty();
                                    //ultima batalla con los demonios
                                    demonBattleM();
                                    //La introducción del Diablo
                                    Story.deviloftheTreeStars();
                                    PAC();
                                    empty();
                                    //La batalla con el diablo
                                    devilBattleM();
                                }
                                    if (m.XP >= 85 && act == 5){
                                        act = 5;
                                        place = 4;
                                        //La historia termina con un nuevo diablo
                                        Story.theEnd();
                                        PAC();
                                        empty();
                                        System.out.println("Ha vengado a su familia y a sus amigos. \nPero ahora eres el diablo en la historia de otros\n");
                                        //Jugar de nuevo o salir del programa
                                        System.out.println("Deseas jugar de nuevo?\n");
                                        System.out.println("1. Si");
                                        System.out.println("2. No\n");
                                        int z = s.nextInt(2);
                                            if (z == 1){
                                                menu();
                                            }
                                            else if (z == 2){
                                                n = 3;
                                            }
                                    }                                   
                            }     
                            else if (n == 2){
                                pInfo();
                                //Información del mago
                                PAC();
                            }       
                            else if (n == 3){
                                //Cerrar el Programa
                                System.out.println("Hasta la proxima aventurero\n");
                                System.exit(0);
                            }
                        }
                        catch (InputMismatchException o){
                            System.out.println("Elige un numero entre 1 y 2\n");
                            printMenu();
                        }
                    }
    }
    public void brawlerStory(){
        //Historia complete del Brawler
                    empty();
                    //Introducción del Brawler  
                    Story.introB();
					PAC();
                    //creación de un nuevo Brawler
                    b = new Brawler(Name, 150, 150, 0);  
                    inProgress = true;
                    while(inProgress = true){
                        empty();
                        printMenu();
                            int n = s.nextInt(4);
                            if (n == 1){
                                if (place == 0){
                                    Story.firstBattle();
                                    knightBattleB();
                                        if(b.XP >= 10 && act ==1){
                                            act = 2;
                                            place = 1;
                                            Story.blackKnightsStronghold();
                                            PAC();                                    
                                            empty();
                                        }                                    
                                }
                                else if (place == 1){
                                    if (b.XP < 50){
                                        System.out.println("Has encontrado otro Knight!!\n");
                                        knightBattleB();         
                                    }
                                    if (b.XP >= 50 && act == 2){
                                        act = 3;
                                        place = 2;
                                        System.out.println("Hay un ultimo caballero frente a la puerta que lleva al Black Knight...\n");
                                        knightBattleB();
                                        Story.castleBossBattle();
                                        PAC();
                                        empty();
                                    }
                                }
                                else if (place == 2){
                                        bkBattleB();
                                        if (b.XP >= 80 && act == 3){
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
                                    demonBattleB();
                                    if (b.XP >= 150 && act == 4){
                                        act = 5;
                                        place = 4;
                                    }
                                }
                                else if (place == 4){
                                    System.out.println("Solo sobrevive un demonio.\n Matalo para vencer al diablo\n");
                                    PAC();
                                    empty();
                                    demonBattleB();
                                    PAC();
                                    empty();
                                    Story.deviloftheTreeStars();
                                    PAC();
                                    empty();
                                    devilBattleB();
                                }
                                    PAC();
                                    empty();
                                    if (b.XP >= 85 && act == 5){
                                        act = 5;
                                        place = 4;
                                        Story.theEnd();
                                        PAC();
                                        empty();
                                        System.out.println("Ha vengado a su familia y a sus amigos. \nPero ahora eres el diablo en la historia de otros\n");
                                        System.out.println("Deseas jugar de nuevo?\n");
                                        System.out.println("1. Si");
                                        System.out.println("2. No\n");
                                        int z = s.nextInt(2);
                                            if (z == 1){
                                                menu();
                                            }
                                            else if (z == 2){
                                                n = 3;
                                            }
                                    }
                                    
                            }     
                            else if (n == 2){
                                pInfoB();
                                PAC();
                            }       
                            else if (n == 3){
                                System.out.println("Hasta la proxima aventurero\n");
                                System.exit(0);
                            }
                        }
                    }
            public void knightBattleM(){
            try{
            Knight k = new Knight("Knight", 175, 175, 0);
            System.out.println("Preparate para morir Knight!\n");
            System.out.println("Hoy sera tu ultimo dia Mago!\n");
            do{
                System.out.println(m.name + ", Cual sera tu porxima accion?\n");
                System.out.println("1. Atacar\n2. Usar un item \n");
                int y = s.nextInt(3);
                    if (y == 1){
                    k.HP = k.HP - m.attack();
                    if (k.HP <= 0){
                        k.HP = 0;
                    }
                        System.out.println("Has hecho " + m.attack() + " de dano!\n");
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
                                m.HP = m.HP - k.attack();
                                    if (m.HP < 0){
                                    m.HP = 0;
                                }
                                    System.out.println("Has hecho " + k.attack() + " de dano!\n");
                                    System.out.println("El mago tiene " + m.HP + " HP!\n");
                                        if (m.HP <= 0){
                                            System.out.println("Has matado al ultimo mago en el mundo!\n");
                                            died();
                                        }                               
                             }
                                        else if (x == 2){
                                                        k.ability();
                                        }
                    }
                                        }
                                        if (y == 2){
                                            m.ability();
                                            if (k.HP > 0){
                                                System.out.println("Knight, cual sera tu proxima accion?\n");
                                                System.out.println("1. Atacar\n2. Usar un item\n");
                                                int x = s.nextInt(3);
                                                    if (x ==1){
                                                        m.HP = m.HP - k.attack();
                                                        if (m.HP < 0){
                                                            m.HP = 0;
                                                        }
                                                    System.out.println("Has hecho " + k.attack() + " de dano!\n");
                                                    System.out.println("El mago tiene " + m.HP + " HP!\n");
                                                        if (m.HP <= 0){
                                                            System.out.println("Has matado al ultimo mago en el mundo!\n");
                                                            died();
                                                        }                                 
                                                    }
                                                    else if (x == 2){
                                                        k.ability();
                                                    }
                                             }
                                        }
            }
                                      while (k.HP > 0);
                                        m.XP = m.XP + 15;
                                        if (m.XP >= 20){
                                            m.MAXHP = m.MAXHP +25;
                                        }     
                                        m.HP = m.MAXHP;
            }
                catch(InputMismatchException d){
                System.out.println("Por favor elige un numero entre 1 y 2\n");
                }      
    }
    public void bossBattleCM(){
        try{
        BlackKnight bk = new BlackKnight(m.name, 225, 225, 0);
        System.out.println("Tu muerte esta asegurada mago...\n");
        System.out.println("Me diras para quien trabajas\n");
            do{
            System.out.println(m.name + ", Cual sera tu porxima accion?\n");
            System.out.println("1. Atacar\n2. Usar un item \n");
            int y = s.nextInt(3);
                if (y == 1){
                    bk.HP = bk.HP - m.attack();
                    if (bk.HP <= 0){
                        bk.HP = 0;
                    }
                        System.out.println("Has hecho " + m.attack() + " de dano!\n");
                        System.out.println("El Black Knight tiene " + bk.HP + " HP!\n");
                            if (bk.HP <= 0){
                                System.out.println("Has derrotado al Black Knight!\n");
                                bk.HP = 0;
                            }
                            else if (bk.HP > 0){
                                System.out.println("Black Knight, cual sera tu proxima accion?\n");
                                System.out.println("1. Atacar\n2. Usar un item\n");
                                int x = s.nextInt(3);
                                    if (x ==1){
                                        m.HP = m.HP - bk.attack();
                                            if (m.HP < 0){
                                                m.HP = 0;
                                            }
                                                System.out.println("Has hecho " + bk.attack() + " de dano!\n");
                                                System.out.println("El mago tiene " + m.HP + " HP!\n");
                                                    if (m.HP <= 0){
                                                        System.out.println("Nunca tuviste una oportunidad!\n");
                                                        died();
                                                    }                               
                                                    }
                                                    else if (x == 2){
                                                        bk.ability();
                                                    }
                                                }
                                        }
                                        if (y == 2){
                                            m.ability();
                                            if (bk.HP > 0){
                                                System.out.println("Black Knight, cual sera tu proxima accion?\n");
                                                System.out.println("1. Atacar\n2. Usar un item\n");
                                                int x = s.nextInt(3);
                                                    if (x ==1){
                                                        m.HP = m.HP - bk.attack();
                                                        System.out.println("Has hecho " + bk.attack() + " de dano!\n");
                                                        System.out.println("El mago tiene " + m.HP + " HP!\n");
                                                        if (m.HP <= 0){
                                                            System.out.println("Nunca tuviste una oportunidad!\n");
                                                            died();
                                                        }                               
                                                    }
                                                    else if (x == 2){
                                                        bk.ability();
                                                    }
                                                }                
                                        }
                                    }
                                    while (bk.HP > 0);
                                        m.XP =m.XP + 35;
                                        if (m.XP >= 70){
                                            m.MAXHP = m.MAXHP +55;
                                        }     
                                        m.HP = m.MAXHP;
        }  
        catch(InputMismatchException f){
            System.out.println("Por favor elige un numero entre 1 y 2\n");
        }
    }
    public void demonBattleM(){
        try{
        Demon d = new Demon("Demonio", 275, 275, 0);
        System.out.println("Todos ustedes pagarán por la muerte de mi familia y mi comunidad.!\n");
        System.out.println("No he probado el alma de un mago en demasiado tiempo...\n");
        do{
            System.out.println(m.name + ", Cual sera tu porxima accion?\n");
            System.out.println("1. Atacar\n2. Usar un item \n");
            int y = s.nextInt(3);
            if (y == 1){
                d.HP = d.HP - m.attack();
                if (d.HP < 0){
                    d.HP = 0;
                }
                System.out.println("Has hecho " + m.attack() + " de dano!\n");
                System.out.println("El demonio tiene " + d.HP + " HP!\n");
                if (d.HP <= 0){
                    System.out.println("Has derrotado al Demonio!\n");
                    d.HP = 0;
                }
                else if (d.HP > 0){
                    System.out.println("demonio, cual sera tu proxima accion?\n");
                    System.out.println("1. Atacar\n2. Usar un item\n");
                    int x = s.nextInt(3);
                        if (x ==1){
                            m.HP = m.HP - d.attack();
                            if (m.HP < 0){
                                m.HP = 0;
                            }
                            System.out.println("Has hecho " + d.attack() + " de dano!\n");
                            System.out.println("El mago tiene " + m.HP + " HP!\n");
                            if (m.HP <= 0){
                                System.out.println("Me voy a comer tu alma!\n");
                                died();
                            }                               
                        }
                        else if (x == 2){
                            d.ability();
                        }
                    }
            }
            if (y == 2){
                m.ability();
                if (d.HP > 0){
                    System.out.println("demonio, cual sera tu proxima accion?\n");
                    System.out.println("1. Atacar\n2. Usar un item\n");
                    int x = s.nextInt(3);
                        if (x ==1){
                            m.HP = m.HP - d.attack();
                            if (m.HP < 0){
                                m.HP = 0;
                            }
                            System.out.println("Has hecho " + d.attack() + " de dano!\n");
                            System.out.println("El mago tiene " + m.HP + " HP!\n");
                            if (m.HP <= 0){
                                System.out.println("Me voy a comer tu alma!\n");
                                died();
                            }                               
                        }
                        else if (y == 2){
                            d.ability();
                        }
                    }                 
            }
        }
        while (d.HP > 0);
            m.XP = m.XP + 30;
            if (m.XP >= 110){
                m.MAXHP = m.MAXHP + 50;
            }     
            m.HP = m.MAXHP; 
        if (m.XP >= 150 && act == 4){
            act = 5;
            place = 4;
        }
    }
    catch (InputMismatchException s){
        System.out.println("Por favor elige un numero entre 1 y 2\n");
    }
    }
    public void devilBattleM(){
        try{
        Devil D = new Devil(m.name, 400, 400, 0);
        System.out.println("He matado a tus demonios \ny ahora librare al mundo de tu maldad\n");
        System.out.println("No digas tonterías. \nHe matado a innumerables humanos y he torturado las almas de los condenados. \n");
        System.out.println("Moriras aqui hoy, y te atormentare por la eternidad.\n");
            do{
                System.out.println(m.name + ", Cual sera tu porxima accion?\n");
                System.out.println("1. Atacar\n2. Usar un item \n");
                int y = s.nextInt(3);
                    if (y == 1){
                        D.HP = D.HP - m.attack();
                            if (D.HP < 0){
                                D.HP = 0;
                            }
                            System.out.println("Has hecho " + m.attack() + " de dano!\n");
                            System.out.println("Samael tiene " + D.HP + " HP!\n");
                                if (D.HP <= 0){
                                    System.out.println("Has derrotado al Diablo!\n");
                                     D.HP = 0;
                                }
                                else if (D.HP > 0){
                                    System.out.println("Samael, cual sera tu proxima accion?\n");
                                    System.out.println("1. Atacar\n2. Usar un item\n");
                                    int x = s.nextInt(3);
                                        if (x ==1){
                                            m.HP =m. HP - D.attack();
                                                if (m.HP < 0){
                                                    m.HP = 0;
                                                }
                                                    System.out.println("Has hecho " + D.attack() + " de dano!\n");
                                                    System.out.println("El mago tiene " + m.HP + " HP!\n");
                                                if (m.HP <= 0){
                                                    System.out.println("Has matado al ultimo mago en el mundo!\n");
                                                    died();
                                                }                               
                                        }
                                        else if (x == 2){
                                                        D.ability();
                                        }
                                }
                    }
                                        if (y == 2){
                                            m.ability();
                                                if (D.HP > 0){
                                                    System.out.println("Samael, cual sera tu proxima accion?\n");
                                                    System.out.println("1. Atacar\n2. Usar un item\n");
                                                    int x = s.nextInt(3);
                                                        if (x ==1){
                                                            m.HP =m. HP - D.attack();
                                                            if (m.HP < 0){
                                                                m.HP = 0;
                                                            }
                                                            System.out.println("Has hecho " + D.attack() + " de dano!\n");
                                                            System.out.println("El mago tiene " + m.HP + " HP!\n");
                                                            if (m.HP <= 0){
                                                                System.out.println("Has matado al ultimo mago en el mundo!\n");
                                                                died();
                                                            }                               
                                                        }
                                                        else if (x == 2){
                                                            D.ability();
                                                        }
                                                    }                 
                                        }
                                    }
                                    while (D.HP > 0);
        }
        catch(InputMismatchException a){
            System.out.println("Por favor elige un numero entre 1 y 2\n");
        }
    }
    public void knightBattleB(){
        Knight k = new Knight("Knight", 175, 175, 0);
        System.out.println("Preparate para morir Knight!\n");
        System.out.println("Terminare con tu miserable existencia!\n");
        do{
        System.out.println(b.name + ", Cual sera tu porxima accion?\n");
        System.out.println("1. Atacar\n2. Usar un item \n");
        int y = s.nextInt(3);
            if (y == 1){
                k.HP = k.HP - b.attack();
                    if (k.HP <= 0){
                        k.HP = 0;
                    }
                        System.out.println("Has hecho " + b.attack() + " de dano!\n");
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
                                        b.HP = b.HP - k.attackB();
                                            if (b.HP < 0){
                                                b.HP = 0;
                                            }
                                                System.out.println("Has hecho " + k.attackB() + " de dano!\n");
                                                System.out.println("El brawler tiene " + b.HP + " HP!\n");
                                                    if (b.HP <= 0){
                                                    System.out.println("Has matado al hombre mas fuerte del mundo!\n");
                                                        died();
                                                    }                               
                                     }
                                            else if (x == 2){
                                                k.ability();
                                                System.out.println(b.HP);
                                            }
                                                }
                                        }
            if (y == 2){
                b.ability();
                    if (k.HP > 0){
                        System.out.println("Knight, cual sera tu proxima accion?\n");
                        System.out.println("1. Atacar\n2. Usar un item\n");
                        int x = s.nextInt(3);
                            if (x ==1){
                                b.HP = b.HP - k.attackB();
                                if (b.HP < 0){
                                    b.HP = 0;
                                }
                                    System.out.println("Has hecho " + k.attackB() + " de dano!\n");
                                    System.out.println("El brawler tiene " + b.HP + " HP!\n");
                                    if (b.HP <= 0){
                                        System.out.println("Has matado al Brawler mas poderoso del mundo!\n");
                                        died();
                                    }                                 
                            }
                            else if (x == 2){
                                k.ability();
                            }
                    }
            }
        }
            while (k.HP > 0);
            b.XP = b.XP + 15;
                if (b.XP >= 20){
                    b.MAXHP = b.MAXHP +25;
                }     
                    b.HP = b.MAXHP;      
    }
    public void bkBattleB(){
        BlackKnight bk = new BlackKnight(b.name, 225, 225, 0);
        System.out.println("Tu muerte esta asegurada bruto exagerado...\n");
        System.out.println("Me diras para quien trabajas\n");
        do{
            System.out.println(b.name + ", Cual sera tu porxima accion?\n");
            System.out.println("1. Atacar\n2. Usar un item \n");
            int y = s.nextInt(3);
            if (y == 1){
                bk.HP = bk.HP - b.attack();
                if (bk.HP <= 0){
                    bk.HP = 0;
                }
                    System.out.println("Has hecho " + b.attack() + " de dano!\n");
                    System.out.println("El Black Knight tiene " + bk.HP + " HP!\n");
                if (bk.HP <= 0){
                    System.out.println("Has derrotado al Black Knight!\n");
                    bk.HP = 0;
                }
                else if (bk.HP > 0){
                    System.out.println("Black Knight, cual sera tu proxima accion?\n");
                    System.out.println("1. Atacar\n2. Usar un item\n");
                    int x = s.nextInt(3);
                        if (x ==1){
                            b.HP = b.HP - bk.attackB();
                            if (b.HP < 0){
                                b.HP = 0;
                            }
                            System.out.println("Has hecho " + bk.attackB() + " de dano!\n");
                            System.out.println("El brawler tiene " + b.HP + " HP!\n");
                            if (b.HP <= 0){
                                System.out.println("Nunca tuviste una oportunidad!\n");
                                died();
                            }                               
                        }
                        else if (x == 2){
                            bk.ability();
                        }
                    }
            }
            if (y == 2){
                b.ability();
                if (bk.HP > 0){
                    System.out.println("Black Knight, cual sera tu proxima accion?\n");
                    System.out.println("1. Atacar\n2. Usar un item\n");
                    int x = s.nextInt(3);
                        if (x ==1){
                            b.HP = b.HP - bk.attackB();
                            System.out.println("Has hecho " + bk.attackB() + " de dano!\n");
                            System.out.println("El brawler tiene " + b.HP + " HP!\n");
                            if (b.HP <= 0){
                                System.out.println("Nunca tuviste una oportunidad!\n");
                                died();
                            }                               
                        }
                        else if (x == 2){
                            bk.ability();
                        }
                    }                
            }
        }
        while (bk.HP > 0);
            b.XP =b.XP + 35;
            if (b.XP >= 70){
                b.MAXHP = b.MAXHP +55;
            }     
            b.HP = b.MAXHP;         
    }
    public void demonBattleB(){
        Demon d = new Demon("Demonio", 275, 275, 0);
        System.out.println("Todos ustedes pagarán por la muerte de mi familia y mi comunidad.!\n");
        System.out.println("Las almas de tus seres queridos eran deliciosas\n");
        do{
            System.out.println(b.name + ", Cual sera tu porxima accion?\n");
            System.out.println("1. Atacar\n2. Usar un item \n");
            int y = s.nextInt(3);
            if (y == 1){
                d.HP = d.HP - b.attack();
                if (d.HP < 0){
                    d.HP = 0;
                }
                System.out.println("Has hecho " + b.attack() + " de dano!\n");
                System.out.println("El demonio tiene " + d.HP + " HP!\n");
                if (d.HP <= 0){
                    System.out.println("Has derrotado al Demonio!\n");
                    d.HP = 0;
                }
                else if (d.HP > 0){
                    System.out.println("demonio, cual sera tu proxima accion?\n");
                    System.out.println("1. Atacar\n2. Usar un item\n");
                    int x = s.nextInt(3);
                        if (x ==1){
                            b.HP = b.HP - d.attackB();
                            if (b.HP < 0){
                                b.HP = 0;
                            }
                            System.out.println("Has hecho " + d.attackB() + " de dano!\n");
                            System.out.println("El brawler tiene " + b.HP + " HP!\n");
                            if (b.HP <= 0){
                                System.out.println("Me voy a comer tu alma!\n");
                                died();
                            }                               
                        }
                        else if (x == 2){
                            d.ability();
                        }
                    }
            }
            if (y == 2){
                b.ability();
                if (d.HP > 0){
                    System.out.println("demonio, cual sera tu proxima accion?\n");
                    System.out.println("1. Atacar\n2. Usar un item\n");
                    int x = s.nextInt(3);
                        if (x ==1){
                            b.HP = b.HP - d.attackB();
                            if (b.HP < 0){
                                b.HP = 0;
                            }
                            System.out.println("Has hecho " + d.attackB() + " de dano!\n");
                            System.out.println("El brawler tiene " + b.HP + " HP!\n");
                            if (b.HP <= 0){
                                System.out.println("Me voy a comer tu alma!\n");
                                died();
                            }                               
                        }
                        else if (y == 2){
                            d.ability();
                        }
                    }                 
            }
        }
        while (d.HP > 0);
            b.XP = b.XP + 30;
            if (b.XP >= 110){
                b.MAXHP = b.MAXHP + 50;
            }     
            b.HP = b.MAXHP; 
    }
    public void devilBattleB(){
        Devil D = new Devil(b.name, 400, 400, 0);
            System.out.println("He matado a tus demonios \ny ahora librare al mundo de tu maldad\n");
            System.out.println("No digas tonterías. \nHe matado a innumerables humanos y he torturado las almas de los condenados. \n");
            System.out.println("Moriras aqui hoy, y te atormentare por la eternidad.\n");
            do{
                System.out.println(b.name + ", Cual sera tu porxima accion?\n");
                System.out.println("1. Atacar\n2. Usar un item \n");
                int y = s.nextInt(3);
                    if (y == 1){
                        D.HP = D.HP - b.attack();
                        if (D.HP < 0){
                        D.HP = 0;
                        }
                            System.out.println("Has hecho " + b.attack() + " de dano!\n");
                            System.out.println("Samael tiene " + D.HP + " HP!\n");
                                if (D.HP <= 0){
                                    System.out.println("Has derrotado al Diablo!\n");
                                     D.HP = 0;
                                }
                                else if (D.HP > 0){
                                    System.out.println("Samael, cual sera tu proxima accion?\n");
                                    System.out.println("1. Atacar\n2. Usar un item\n");
                                    int x = s.nextInt(3);
                                        if (x ==1){
                                            b.HP =b. HP - D.attackB();
                                            if (b.HP < 0){
                                                b.HP = 0;
                                            }
                                                System.out.println("Has hecho " + D.attackB() + " de dano!\n");
                                                System.out.println("El mago tiene " + b.HP + " HP!\n");
                                                    if (b.HP <= 0){
                                                        System.out.println("Deberias haberte suicidado, habria sido menos doloroso!\n");
                                                        died();
                                                    }                               
                                                    }
                                        else if (x == 2){
                                            D.ability();
                                        }
                                }
                                        }
                    if (y == 2){
                        b.ability();
                            if (D.HP > 0){
                                System.out.println("Samael, cual sera tu proxima accion?\n");
                                System.out.println("1. Atacar\n2. Usar un item\n");
                                int x = s.nextInt(3);
                                    if (x ==1){
                                        b.HP =b. HP - D.attackB();
                                            if (b.HP < 0){
                                                b.HP = 0;
                                            }
                                                System.out.println("Has hecho " + D.attackB() + " de dano!\n");
                                                System.out.println("El mago tiene " + b.HP + " HP!\n");
                                                    if (b.HP <= 0){
                                                        System.out.println("Deberias haberte suicidado, habria sido menos doloroso!\n");
                                                        died();
                                                    }                              
                                     }
                                            else if (x == 2){
                                                D.ability();
                                            }
                            }                 
                    }
            }
            while (D.HP > 0);
    }
    public void died(){
        System.out.println("Te Han matado, \nGAME OVER!!!!!\n");
        System.exit(0);
    }
    public void raidBattle(){
        try{
        System.out.println("Cuantos jugadores habra en tu grupo, maximo 4\n");
        int p = s.nextInt(5);
            if (p == 1){
               System.out.println("Elije su atacador\n");
               System.out.println("1. Mago\n");
               System.out.println("2. Brawler\n");
               System.out.println("3. Cazador\n");
               int f = s.nextInt();
               if (f == 1){
                   Mage a = new Mage("Wizard King", 225, 225, 75);
               }
               else if (f == 2){
                    Brawler a = new Brawler("Rey de los Brawlers", 275, 275, 75);
                    
               }
               else if ( f == 3){
                   BeastTamer a = new BeastTamer("Rey de los Animales", 200, 200, 75);
               }
               rB1P();
            }
            else if (p == 2){
                System.out.println("Primer jugador elije to atacador\n");
                System.out.println("1. Mago\n");
                System.out.println("2. Brawler\n");
                System.out.println("3. Cazador\n");
                int d = s.nextInt(4);
                    
            }
            else if (p == 3){

            }
            else if (p == 4){

            }
    }
    catch (InputMismatchException w){
        System.out.println("Por favor elige un numero entre 1 y 4");
    }
    }
    public void rB1P(){
        int demons = r.nextInt(21);
        if (demons > 12){
            Demon a = new Demon("Demonio", 75, 75, 0);
            Demon d = new Demon("Demonio", 75, 75, 0);
            Lucifero L = new Lucifero("Lucifero", 100, 100, 0);
            System.out.println("Has encontrado al Raid boss y tiene 2 demonios!\n");
            PAC();
            do{
            System.out.println("Como quieres vencer al tus enemigos?\n");
            System.out.println("1. Atacar\n ");
            System.out.println("2. Item\n");
            int i = s.nextInt(4);
                if (i == 1){
                    System.out.println("1. Atacar el Raid Boss\n");
                    System.out.println("2. Atacar al demonio 1\n");
                    System.out.println("3. Atacar al demonio 2\n");
                    int o = s.nextInt(4);
                        if (o == 1){
                        L.HP = L.HP - a.attack();
                                if (L.HP < 0){
                                    L.HP = 0;
                                }
                                    System.out.println("Has hecho " + a.attack() + " de dano!\n");
                                    System.out.println("Lucifero tiene " + L.HP + " HP!\n");
                                        if (L.HP <= 0){
                                            System.out.println("Has derrotado a Lucifero y sus demonios!\n");
                                            L.HP = 0;
                                        }
                                        else if (L.HP > 0){
                                            System.out.println("Lucifero, cual sera tu proxima accion?\n");
                                            System.out.println("1. Atacar\n2. Usar un item\n3.Recuperar\n");
                                            int x = s.nextInt(4);
                                                if (x ==1){
                                                    a.HP =a. HP - L.attackB();
                                                    if (a.HP < 0){
                                                        a.HP = 0;
                                                    }
                                                        System.out.println("Has hecho " + L.attackB() + " de dano!\n");
                                                        System.out.println("El heroe tiene " + a.HP + " HP!\n");
                                                            if (a.HP <= 0){
                                                                System.out.println("Apenas venciste a Samael, y pensaste que podrias vencerme....\n");
                                                                died();
                                                            }                               
                                                            }
                                                else if (x == 2){
                                                    L.ability();
                                                }
                                                else if (x == 3){
                                                    L.Heal();
                                                }
                                        }
                                                }
                            if (o == 2){
                                a.ability();
                                    if (L.HP > 0){
                                        System.out.println("Samael, cual sera tu proxima accion?\n");
                                        System.out.println("1. Atacar\n2. Usar un item\n");
                                        int x = s.nextInt(3);
                                            if (x ==1){
                                                a.HP =a. HP - L.attackB();
                                                    if (a.HP < 0){
                                                        a.HP = 0;
                                                    }
                                                        System.out.println("Has hecho " + L.attackB() + " de dano!\n");
                                                        System.out.println("El mago tiene " + a.HP + " HP!\n");
                                                            if (a.HP <= 0){
                                                                System.out.println("Deberias haberte suicidado, habria sido menos doloroso!\n");
                                                                died();
                                                            }                              
                                             }
                                                    else if (x == 2){
                                                     L.ability();
                                                    }
                                    }                 
                            }
                    }
                }
                while (L.HP > 0);
                
        }
        else if (demons < 6){
            Demon z = new Demon("Demon", 175, 175, 0);
            System.out.println("Has encontrado al Raid boss ty solo tiene un demonio!\n");
        }
        else if (demons <= 12 && demons >= 6){}
        System.out.println("Has encontrado al Raid boss y esta solo!\n");
    }
}