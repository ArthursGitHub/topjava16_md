package generics;

import java.util.ArrayList;
import java.util.List;

public class gen {
  public static void main(String[] args) {
    List<?> intList = new ArrayList<Integer>();
    intList.add(new Integer(10));
  }
}

