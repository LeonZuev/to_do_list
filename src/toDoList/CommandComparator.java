package toDoList;

import java.util.Comparator;
import java.util.Map;

public class CommandComparator implements Comparator<Map.Entry<Main.Command, String>> {


  @Override
  public int compare(Map.Entry<Main.Command, String> o1, Map.Entry<Main.Command, String> o2) {
    return o1.getValue().compareTo(o2.getValue());
  }
}
