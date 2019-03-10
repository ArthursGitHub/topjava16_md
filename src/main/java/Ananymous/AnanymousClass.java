package Ananymous;

class BaseClass {
  private static String staticVar1 = "321";
  private int Var1 = 33;

  static void method1(int i) {
    int Var2 = 33;
    final int finalVar2 = 55;

//    interface HelloThere {
//    }

    // ----------------- Ananymous class -------------------
    new Object() {
      private int Var3 = 33;
//      private static int staticVar3 = 33;
      private static final int staticFinalVar3 = 666;

//      static void method3() {
//      }

      void method2() {
//        System.out.println(Var1);
//        System.out.println(BaseClass.this.Var1);

        System.out.println(Var2);
        System.out.println(finalVar2);

        System.out.println(Var3);
        System.out.println(this.Var3);

        System.out.println(staticVar1);
        System.out.println(BaseClass.staticVar1);

        System.out.println(staticFinalVar3);
        System.out.println(this.staticFinalVar3);

        System.out.println(i);
        Var3 = 8;
      }

    }.method2();
  }
}

public class AnanymousClass {
  public static void main(String[] args) {
    new BaseClass().method1(5);
  }
}
