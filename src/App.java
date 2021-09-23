import java.util.ArrayList;
import utils.benchmark.Benchmarker;
import utils.benchmark.IBenchmarkable;
import utils.sorting.algoritms.BubbleSort;
import utils.sorting.algoritms.QuickSort;

public class App {
  public static void main(String[] args) {
    var benchmarks = new ArrayList<IBenchmarkable>();

    var bubbleSort = Benchmarker.getBenchmark(new BubbleSort());
    var quickSort = Benchmarker.getBenchmark(new QuickSort());

    benchmarks.add(bubbleSort);
    benchmarks.add(quickSort);

    Benchmarker.execute(benchmarks, 10000);
  }
}
