package test;

import sorting.algorithms.ISortableAlgorithm;
import utils.arrays.ArrayUtils;

public class TestImplementation {
  public static void test(ISortableAlgorithm algorithm) throws Exception {
    var range = 30;
    var answerList = new Integer[range];
    var testList = new Integer[range];

    for (int i = 0; i < range; i++)
      answerList[i] = i;

    for (int i = range - 1; i >= 0; i--)
      testList[i] = i;

    var responseList = algorithm.sort(testList);

    if (ArrayUtils.equals(answerList, responseList)) {
      System.out.println("[INFO]: Test passed!");
    } else {
      System.out.println("[ERROR] Test failed!");
      System.out.println("Answer was: " + answerList.toString());
      System.out.println("Your algorithm was: " + responseList.toString());

      throw new Exception("Failed sorting algorithm");
    }

  }
}
