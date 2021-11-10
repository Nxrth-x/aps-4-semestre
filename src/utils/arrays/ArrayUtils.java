package utils.arrays;

public class ArrayUtils {
  public static <T> void swap(T[] source, int swapFrom, int swapTo) {
    T aux = source[swapFrom];
    source[swapFrom] = source[swapTo];
    source[swapTo] = aux;
  }

  public static <T> boolean equals(T[] source, T[] target) {
    if (source.length != target.length) {
      return false;
    }

    for (int i = 0; i < source.length; i++) {
      if (!source[i].equals(target[i])) {
        return false;
      }
    }

    return true;
  }
}
