public class EvilDragon extends Dragon {
    Lucifero L = new Lucifero("Lucifero", 200, 200, 0);
    public EvilDragon(){
        super(140);
    }
    public void Abilitity1(Lucifero L){
        L.attack();
    }
    public void Ability2(Lucifero L){
        L.Heal();
    }
}
