public class FactorialTimeExample {
    private static int minPathCost = Integer.MAX_VALUE;

    public static void findShortestPath(int[][] distances, boolean[] visited, int pos, int count, int cost) {
        int n = distances.length;

        // If we've visited all cities, check if this path is the shortest
        if (count == n && distances[pos][0] > 0) {
            minPathCost = Math.min(minPathCost, cost + distances[pos][0]);
            return;
        }

        // Try to visit all other cities from the current city
        for (int city = 0; city < n; city++) {
            if (!visited[city] && distances[pos][city] > 0) {
                visited[city] = true;
                findShortestPath(distances, visited, city, count + 1, cost + distances[pos][city]);
                visited[city] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] distances = {
                { 0, 20, 42, 35 },
                { 20, 0, 30, 34 },
                { 42, 30, 0, 12 },
                { 35, 34, 12, 0 }
        };

        boolean[] visited = new boolean[distances.length];
        visited[0] = true;

        findShortestPath(distances, visited, 0, 1, 0);
        System.out.println("Minimum path cost: " + minPathCost);
    }
}

// Brute-force Solution for TravelingSalesman
// tries every possible combination
// try guessing 3 digit pin how many trials you need?