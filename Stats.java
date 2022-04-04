  public class Stats{
    private static double HP;
    private static double att;
    private static double def;
    private static double spatt;
    private static double spdef;
    private static double speed;

    public Stats (double someHP, double someAtt, double someDef, double someSpatt, double someSpdef, double someSpeed) {
        this.HP = someHP;
        this.att = someAtt;
        this.def = someDef;
        this.spatt = someSpatt;
        this.spdef = someSpdef;
        this.speed = someSpeed;
    }
    
    public static double getHP(){
        double d;
        d = (Double) java.lang.Math.floor(HP);
        return d;
    }
    public static double getAtt() {
        double d;
        d = (Double) java.lang.Math.floor(att);
        return d;
    }
    public static double getDef() {
        double d;
        d = (Double) java.lang.Math.floor(def);
        return d;
    }
    public static double getspatt(){
        double d;
        d = (Double) java.lang.Math.floor(spatt);
        return d;
    }
    public static double getspdef(){
        double d;
        d = (Double) java.lang.Math.floor(spdef);
        return d;
    }
    public static  double getspeed(){
        double d;
        d = (Double) java.lang.Math.floor(speed);
        return d;
    }
    public static void cetak(){
        System.out.println("STATS");
        System.out.println("HP: "+ getHP());
        System.out.println("Attack: "+getAtt());
        System.out.println("Defense: "+getDef());
        System.out.println("Sp.Atk: "+getspatt());
        System.out.println("Sp.Def: "+getspdef());
        System.out.println("Speed: "+getspeed());
    }
}