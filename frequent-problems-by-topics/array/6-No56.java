class Solution {//O(nlog⁡n) O(1) ||O(n) 
  public int[][] merge(int[][] intervals) {
    Collections.sort(Arrays.asList(intervals), (i1,i2)->{
        return i1[0]<i2[0]?-1:i1[0]==i2[0]?0:1;
    });

    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      }
      // otherwise, there is overlap, so we merge the current and previous
      // intervals.
      else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }
}



/*
class Solution {
  private Map<int[], List<int[]>> graph;
  private Map<Integer, List<int[]>> nodesInComp;
  private Set<int[]> visited;

  // return whether two intervals overlap (inclusive)
  private boolean overlap(int[] a, int[] b) {
    return a[0] <= b[1] && b[0] <= a[1];
  }

  // build a graph where an undirected edge between intervals u and v exists
  // iff u and v overlap.
  private void buildGraph(int[][] intervals) {
    graph = new HashMap<>();
    for (int[] interval : intervals) {
      graph.put(interval, new LinkedList<>());
    }

    for (int[] interval1 : intervals) {
      for (int[] interval2 : intervals) {
        if (overlap(interval1, interval2)) {
          graph.get(interval1).add(interval2);
          graph.get(interval2).add(interval1);
        }
      }
    }
  }

  // merges all of the nodes in this connected component into one interval.
  private int[] mergeNodes(List<int[]> nodes) {
    int minStart = nodes.get(0)[0];
    for (int[] node : nodes) {
      minStart = Math.min(minStart, node[0]);
    }

    int maxEnd = nodes.get(0)[1];
    for (int[] node : nodes) {
      maxEnd = Math.max(maxEnd, node[1]);
    }

    return new int[] {minStart, maxEnd};
  }

  // use depth-first search to mark all nodes in the same connected component
  // with the same integer.
  private void markComponentDFS(int[] start, int compNumber) {
    Stack<int[]> stack = new Stack<>();
    stack.add(start);

    while (!stack.isEmpty()) {
      int[] node = stack.pop();
      if (!visited.contains(node)) {
        visited.add(node);

        if (nodesInComp.get(compNumber) == null) {
          nodesInComp.put(compNumber, new LinkedList<>());
        }
        nodesInComp.get(compNumber).add(node);

        for (int[] child : graph.get(node)) {
          stack.add(child);
        }
      }
    }
  }

  // gets the connected components of the interval overlap graph.
  private void buildComponents(int[][] intervals) {
    nodesInComp = new HashMap<>();
    visited = new HashSet<>();
    int compNumber = 0;

    for (int[] interval : intervals) {
      if (!visited.contains(interval)) {
        markComponentDFS(interval, compNumber);
        compNumber++;
      }
    }
  }

  public int[][] merge(int[][] intervals) {
    buildGraph(intervals);
    buildComponents(intervals);

    // for each component, merge all intervals into one interval.
    List<int[]> merged = new LinkedList<>();
    for (int comp = 0; comp < nodesInComp.size(); comp++) {
      merged.add(mergeNodes(nodesInComp.get(comp)));
    }

    return merged.toArray(new int[merged.size()][]);
  }
}*/
