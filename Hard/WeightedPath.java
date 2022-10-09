public static String WeightedPath(String[] strArr) {
    int n = Integer.parseInt(strArr[0]);
    String[] nodes = new String[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = strArr[i + 1];
    }
    Map<String, Map<String, Integer>> graph = new HashMap<>();
    for (int i = n + 1; i < strArr.length; i++) {
      String[] edge = strArr[i].split("\\|");
      String from = edge[0];
      String to = edge[1];
      int weight = Integer.parseInt(edge[2]);
      graph.putIfAbsent(from, new HashMap<>());
      graph.putIfAbsent(to, new HashMap<>());
      graph.get(from).put(to, weight);
      graph.get(to).put(from, weight);
    }
    Map<String, Integer> dist = new HashMap<>();
    Map<String, String> prev = new HashMap<>();
    for (String node : nodes) {
      dist.put(node, Integer.MAX_VALUE);
      prev.put(node, null);
    }
    dist.put(nodes[0], 0);
    PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
    pq.add(nodes[0]);
    while (!pq.isEmpty()) {
      String node = pq.poll();
      if (node.equals(nodes[n - 1])) {
        break;
      }
      try{
        for (Map.Entry<String, Integer> entry : graph.get(node).entrySet()) {
        String neighbor = entry.getKey();
        int weight = entry.getValue();
        int newDist = dist.get(node) + weight;
        if (newDist < dist.get(neighbor)) {
          dist.put(neighbor, newDist);
          prev.put(neighbor, node);
          pq.add(neighbor);
        }
      }

      }catch (NullPointerException e){
        return "-1";
      }
      
    }
    if (dist.get(nodes[n - 1]) == Integer.MAX_VALUE) {
      return "-1";
    }
    StringBuilder sb = new StringBuilder();
    String node = nodes[n - 1];
    while (node != null) {
      sb.insert(0, node);
      node = prev.get(node);
      if (node != null) {
        sb.insert(0, "-");
      }
    }
    return sb.toString();
  }
