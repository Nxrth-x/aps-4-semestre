package tests;

import java.util.ArrayList;
import utils.sorting.algoritms.ISortableAlgorithm;

public class TestImplementation {
  public static void test(ISortableAlgorithm algorithm) throws Exception {
    var range = 30;
    var answerList = new ArrayList<Integer>();
    var testList = new ArrayList<Integer>();

    for (int i = 0; i < range; i++)
      answerList.add(i);

    for (int i = range - 1; i >= 0; i--)
      testList.add(i);

    var responseList = algorithm.sort(testList);

    if (responseList.equals(answerList)) {
      System.out.println("[INFO]: Test passed!\nYour answer was correct.");
    } else {
      System.out.println("[ERROR] Test failed!");
      System.out.println("Answer was: " + answerList.toString());
      System.out.println("Your algorithm was: " + responseList.toString());

      throw new Exception("Failed sorting algorithm");
    }

  }
}
