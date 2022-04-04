public class Effectivity {
    private ElementType source;
    private ElementType target;
    private static double effectivity;

    public Effectivity(ElementType source, ElementType target, double effectivity){
        this.source = source;
        this.target = target;
    }

    public ElementType getSource(){
        return this.source;
    }

    public ElementType getTarget(){
        return this.target;
    }

    public static double getEffectivity(){
        return effectivity;
    }
}
