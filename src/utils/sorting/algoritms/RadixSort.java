package utils.sorting.algoritms;

import java.util.ArrayList;
import java.lang.Math;

public class RadixSort implements ISortableAlgorithm {
  public ArrayList<Integer> sort(ArrayList<Integer> list) {
    return this.sortList(list);
  }

  private int getNumberOfDigits(int digit) {
    return Integer.toString(digit).length();
  }

  private int getMaximumNumber(ArrayList<Integer> list) {
    var maximum = list.get(0);

    for (int item : list) {
      if (item > maximum) {
        maximum = item;
      }
    }

    return maximum;
  }

  private ArrayList<Integer> sortList(ArrayList<Integer> list) {
    var maximum = this.getMaximumNumber(list);
    var digits = this.getNumberOfDigits(maximum);

    for (var digit = 0; digit < digits; digit++) {
      var bucket = this.generateBuckets();

      for (var item : list) {
        var index = (int) Math.floor(item / Math.pow(10, digit) % 10);
        bucket.get(index).add(item);
      }

      list = this.flat(bucket);
    }

    return list;
  }

  private ArrayList<Integer> flat(ArrayList<ArrayList<Integer>> lists) {
    var flatted = new ArrayList<Integer>();

    for (var list : lists) {
      for (var number : list) {
        flatted.add(number);
      }
    }

    return flatted;
  }

  private ArrayList<ArrayList<Integer>> generateBuckets() {
    var bucket = new ArrayList<ArrayList<Integer>>();

    for (var i = 0; i < 10; i++)
      bucket.add(new ArrayList<Integer>());

    return bucket;
  }
}