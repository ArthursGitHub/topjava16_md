package Local;

import java.io.Serializable;

class BaseClass2 {
  private static String staticVar1 = "321";
  private int Var1 = 33;

  static void method1(int i) {
    int Var2 = 33;
    final int finalVar2 = 666;

//    interface HelloThere {
//    }

    // ------------ Inner local class -------------
    class LocalClass2 implements Serializable {
      private int Var3 = 33;
//      private static int staticVar3 = 666;
      private static final int staticFinalVar3 = 666;

//      static void method3() {
//      }

      void method2() {
//        System.out.println(Var1);
//        System.out.println(BaseClass2.this.Var1);

        System.out.println(Var2);
        System.out.println(finalVar2);

        System.out.println(Var3);
        System.out.println(LocalClass2.this.Var3);

        System.out.println(staticVar1);
        System.out.println(BaseClass2.staticVar1);

        System.out.println(staticFinalVar3);
        System.out.println(LocalClass2.staticFinalVar3);
        System.out.println(this.staticFinalVar3);

        System.out.println(i);
        Var3 = 8;
      }
    }

    new LocalClass2().method2();
  }
}

public class LocalClass2 {
  public static void main(String[] args) {
    new BaseClass2().method1(5);
  }
}
