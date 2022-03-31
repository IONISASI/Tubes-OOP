import java.lang.Exception;

public class StatsbuffException extends Exception {
  private String statsbuffType;
  private int statsbuffNum;

  public StatsbuffException (String someStatsbuffType, int someStatsbuffNum) {
      this.statsbuffType = someStatsbuffType;
      this.statsbuffNum = someStatsbuffNum;
  }

  public String getMessage() {
      return this.statsbuffType+ " " +this.statsbuffNum+ " tidak memenuhi persyaratan MAX/MIN";
  }
}