public class Statsbuff {
  private static int MAX = 4;
  private static int MIN = -4;
  private int att;
  private int def;
  private int spatt;
  private int spdef;
  private int speed;

  public Statsbuff(int someAtt, int someDef, int someSpatt, int someSpdef, int someSpeed) throws StatsbuffException {
    if (someAtt > MAX || someAtt < MIN) {
      throw new StatsbuffException("Attack", someAtt);
    } else {
      this.att=someAtt;
    }
    if (someDef > MAX || someDef < MIN) {
      throw new StatsbuffException("Deffense", someDef);
    } else {
      this.def=someDef;
    }
    if (someSpatt > MAX || someSpatt < MIN) {
      throw new StatsbuffException("Special Attack", someSpatt);
    } else {
      this.spatt=someSpatt;
    }
    if (someSpdef > MAX || someSpdef < MIN) {
      throw new StatsbuffException("Special Deffense", someSpdef);
    } else {
      this.spdef=someSpdef;
    }
    if (someSpeed > MAX || someSpeed < MIN) {
      throw new StatsbuffException("Speed", someSpeed);
    } else {
      this.speed=someSpeed;
    }
  }
  
  public int getAtt() {
    return att;
  }
  public int getDef() {
    return def;
  }
  public int getSpatt(){
    return spatt;
  }
  public int getSpdef(){
    return spdef;
  }
  public int getSpeed(){
    return speed;
  }

  public void setAtt(int someAtt) throws StatsbuffException {
    if (someAtt > MAX || someAtt < MIN) {
      throw new StatsbuffException("Attack", someAtt);
    } else {
      this.att=someAtt;
    }
  }
  public void setDef(int someDef) throws StatsbuffException {
    if (someDef > MAX || someDef < MIN) {
      throw new StatsbuffException("Deffense", someDef);
    } else {
      this.def=someDef;
    }
  }
  public void setSpatt(int someSpatt) throws StatsbuffException {
    if (someSpatt > MAX || someSpatt < MIN) {
      throw new StatsbuffException("Special Attack", someSpatt);
    } else {
      this.spatt=someSpatt;
    }
  }
  public void setSpdef(int someSpdef) throws StatsbuffException {
    if (someSpdef > MAX || someSpdef < MIN) {
      throw new StatsbuffException("Special Deffense", someSpdef);
    } else {
      this.spdef=someSpdef;
    }
  }
  public void setSpeed(int someSpeed) throws StatsbuffException {
    if (someSpeed > MAX || someSpeed < MIN) {
      throw new StatsbuffException("Speed", someSpeed);
    } else {
      this.speed=someSpeed;
    }
  }
}