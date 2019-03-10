package Local;

import java.io.Serializable;

class BaseClass {
  private static String staticVar1 = "321";
  private int Var1 = 33;

  void method1(int i) {
    int Var2 = 33;
    final int finalVar2 = 666;

//    interface HelloThere {
//    }

    // ------------ Inner local class -------------
    class LocalClass implements Serializable {
      private int Var3 = 33;
//      private static int staticVar3 = 666;
      private static final int staticFinalVar3 = 666;

//      static void method3() {
//      }

      void method2() {
        System.out.println(Var1);
        System.out.println(BaseClass.this.Var1);

        System.out.println(Var2);
        System.out.println(finalVar2);

        System.out.println(Var3);
        System.out.println(LocalClass.this.Var3);

        System.out.println(staticVar1);
        System.out.println(BaseClass.staticVar1);

        System.out.println(staticFinalVar3);
        System.out.println(LocalClass.staticFinalVar3);
        System.out.println(this.staticFinalVar3);

        System.out.println(i);
        Var3 = 8;
      }
    }

    new LocalClass().method2();
  }
}

public class LocalClass {
  public static void main(String[] args) {
    new BaseClass().method1(5);
  }
}
