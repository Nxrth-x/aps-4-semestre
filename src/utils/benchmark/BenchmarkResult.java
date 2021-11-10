package utils.benchmark;

import java.util.List;

import utils.tuples.Pair;

public class BenchmarkResult {
  public int listSize;
  public List<Pair<String, Double>> results;

  public BenchmarkResult(int listSize, List<Pair<String, Double>> results) {
    this.listSize = listSize;
    this.results = results;
  }

  public String toJSON() {
    String json = "";

    json += String.format("{\"list_size\":%d,\"times\":{", this.listSize);

    for (var result : this.results) {
      json += String.format("\"%s\": %f,", result.first, result.second);
    }

    json = json.substring(0, json.length() - 1);
    json += "}}";

    return json;
  }
}
