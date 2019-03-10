package Inner;

import java.io.Serializable;

class BaseClass {
  private static int staticVar1 = 5;
  private int Var1 = 4;

  // ------------- NonStatic member class ----------------
  public class ClassA implements Serializable {
    private int Var2 = 34;
//    private static int staticVar2 = 666;
    private static final int staticFinalVar2 = 555;

//    static void method3() {
//    }

//    interface HelloThere {
//    }

    void method1() {
      System.out.println(Var1);
      System.out.println(BaseClass.this.Var1);

      System.out.println(Var2);
      System.out.println(ClassA.this.Var2);
      System.out.println(ClassA.this.Var2);

      System.out.println(staticVar1);
      System.out.println(BaseClass.staticVar1);

      System.out.println(staticFinalVar2);
      System.out.println(ClassA.staticFinalVar2);
    }
  }
}

public class NoneStaticInnerClass {
  public static void main(String[] args) {
    BaseClass nest = new BaseClass();
    BaseClass.ClassA theA = nest.new ClassA();
    theA.method1();
  }
}
