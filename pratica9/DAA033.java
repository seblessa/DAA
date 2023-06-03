import java.util.*;


public class DAA033 {
    static class Edge {
        String destination;
        double cost;

        Edge(String destination, double cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    static Map<String, List<Edge>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        in.nextLine();  // Discard rest of the line

        String[] locations = in.nextLine().split(" ");
        String start = locations[0], end = locations[1];

        for (int i = 0; i < e; i++) {
            String[] edge = in.nextLine().split(" ");
            String source = edge[0], destination = edge[1];
            double cost = Double.parseDouble(edge[2]);

            graph.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, cost));
            graph.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge(source, cost));  // Since it's bidirectional
        }

        double distance = dijkstra(start, end);
        System.out.printf("%.1f\n", distance);
    }

    static double dijkstra(String start, String end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingDouble(e -> e.cost));
        Map<String, Double> dist = new HashMap<>();
        dist.put(start, 0.0);

        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            if (dist.get(current.destination) < current.cost) continue;  // If i find in dist that i have a key with
            // with a cost less than the cost in the edge continue


            for (Edge edge : graph.getOrDefault(current.destination, Collections.emptyList())) {  // edge is going to take the values of each of
                // the List<Edge> in the graph for the key = current.to
                double newDist = current.cost + edge.cost;

                if (!dist.containsKey(edge.destination) || newDist < dist.get(edge.destination)) {
                    dist.put(edge.destination, newDist);
                    queue.add(new Edge(edge.destination, newDist));
                }
            }
        }
        return dist.get(end);
    }
}