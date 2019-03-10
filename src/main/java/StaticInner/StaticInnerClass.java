package StaticInner;

import java.io.Serializable;

class BaseClass {
  public int Var1 = 33;
  public static int staticVar1 = 321;

  // --------------- Static member class -----------------
  public static class StaticClassA implements Serializable {
    private int Var2 = 44;
    private static int staticVar2 = 123;

    interface HelloThere {
    }

    public void method1() {
//      System.out.println(BaseClass.this.Var1);

      System.out.println(StaticClassA.this.Var2);
      System.out.println(Var2);

      System.out.println(staticVar1);
      System.out.println(BaseClass.staticVar1);

      System.out.println(staticVar2);
      System.out.println(BaseClass.StaticClassA.staticVar2);
    }

    public static void method2() {
//      System.out.println(Var1);
//      System.out.println(Var2);

      System.out.println(staticVar1);
      System.out.println(BaseClass.staticVar1);

      System.out.println(staticVar2);
      System.out.println(BaseClass.StaticClassA.staticVar2);
    }
  }
}

public class StaticInnerClass {
  public static void main(String[] args) {
    BaseClass.StaticClassA theA = new BaseClass.StaticClassA();
    theA.method1();
    theA.method2();
  }
}
