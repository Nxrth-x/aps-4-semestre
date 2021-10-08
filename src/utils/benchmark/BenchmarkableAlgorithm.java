package utils.benchmark;

public class BenchmarkableAlgorithm {
  public String label;
  public IBenchmarkable algorithm;

  public BenchmarkableAlgorithm(String label, IBenchmarkable algorithm) {
    this.label = label;
    this.algorithm = algorithm;
  }
}
