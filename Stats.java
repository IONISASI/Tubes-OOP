public class Stats{
    private double someHP;
    private double someAtt;
    private double someDef;
    private double someSpatt;
    private double someSpdef;
    private double someSpeed;

    public Stats (double someHP, double someAtt, double someDef, double someSpatt, double someSpdef, double someSpeed) {
        this.someHP = someHP;
        this.someAtt = someAtt;
        this.someDef = someDef;
        this.someSpatt = someSpatt;
        this.someSpdef = someSpdef;
        this.someSpeed = someSpeed;
    }
    
    public double getHP(){
        double d;
        d = (Double) java.lang.Math.floor(someHP);
        return d;
    }
    public void setHP(double hp){
        this.someHP = hp;
    }
    public double getAtt() {
        double d;
        d = (Double) java.lang.Math.floor(someAtt);
        return d;
    }
    public void setAtt(double att){
        this.someAtt = att;
    }
    public double getDef() {
        double d;
        d = (Double) java.lang.Math.floor(someDef);
        return d;
    }
    public void setDef(double def){
        this.someDef = def;
    }
    public double getspatt(){
        double d;
        d = (Double) java.lang.Math.floor(someSpatt);
        return d;
    }
    public void setspatt(double spatt){
        this.someSpatt = spatt;
    }
    public double getspdef(){
        double d;
        d = (Double) java.lang.Math.floor(someSpdef);
        return d;
    }
    public void setspdef(double spdef){
        this.someSpdef = spdef;
    }
    public double getspeed(){
        double d;
        d = (Double) java.lang.Math.floor(someSpeed);
        return d;
    }
    public void setspeed(double speed){
        this.someSpeed = speed;
    }
    public void cetak(){
        System.out.println("STATS");
        System.out.println("HP: "+ getHP());
        System.out.println("Attack: "+getAtt());
        System.out.println("Defense: "+getDef());
        System.out.println("Sp.Atk: "+getspatt());
        System.out.println("Sp.Def: "+getspdef());
        System.out.println("Speed: "+getspeed());
    }
}