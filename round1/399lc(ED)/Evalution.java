import java.util.*;

public class Evalution {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);

        // Read equations
        System.out.print("Enter number of equations: ");
        int m = obj.nextInt();
        List<List<String>> equations = new ArrayList<>();
        System.out.println("Enter each equation as two strings (e.g., a b):");
        for (int i = 0; i < m; i++) {
            List<String> eq = new ArrayList<>();
            eq.add(obj.next());
            eq.add(obj.next());
            equations.add(eq);
        }

        // Read values
        double[] values = new double[m];
        System.out.println("Enter the values for each equation:");
        for (int i = 0; i < m; i++) {
            values[i] = obj.nextDouble();
        }

        // Read queries
        System.out.print("Enter number of queries: ");
        int q = obj.nextInt();
        List<List<String>> queries = new ArrayList<>();
        System.out.println("Enter each query as two strings (e.g., a b):");
        for (int i = 0; i < q; i++) {
            List<String> query = new ArrayList<>();
            query.add(obj.next());
            query.add(obj.next());
            queries.add(query);
        }

        double[] a = new Evalution().calcEquation(equations, values, queries);
        System.out.println("Results:");
        for (double v : a) {
            System.out.println(v);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> a = build(equations, values);
        double fin[] = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String divisor = queries.get(i).get(0);
            String diviend = queries.get(i).get(1);
            if (!a.containsKey(divisor) || !a.containsKey(diviend)) {
                fin[i] = -1.0;
                continue;
            }
            double ans[] = { -1.0 };
            double temp = 1.0;
            HashSet<String> vis = new HashSet<>();
            dfs(divisor, diviend, a, ans, temp, vis);
            fin[i] = ans[0];
        }
        return fin;
    }

    public static HashMap<String, HashMap<String, Double>> build(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String divisor = equations.get(i).get(0);
            String diviend = equations.get(i).get(1);
            double value = values[i];
            gr.putIfAbsent(divisor, new HashMap<>());
            gr.putIfAbsent(diviend, new HashMap<>());
            gr.get(divisor).put(diviend, value);
            gr.get(diviend).put(divisor, 1.0 / value);
        }
        return gr;
    }

    public void dfs(String a, String b, HashMap<String, HashMap<String, Double>> gr, double[] ans, double temp,
            HashSet<String> vis) {
        if (vis.contains(a)) {
            return;
        }
        vis.add(a);
        if (a.equals(b)) {
            ans[0] = temp;
            return;
        }
        for (Map.Entry<String, Double> r : gr.get(a).entrySet()) {
            String x = r.getKey();
            double y = r.getValue();
            dfs(x, b, gr, ans, temp * y, vis);
        }
    }
}
// }
// Enter number of equations: 2
// Enter each equation as two strings (e.g., a b):
// a b
// b c
// Enter the values for each equation:
// 2.0
// 3.0
// Enter number of queries: 4
// Enter each query as two strings (e.g., a b):
// a c
// b a
// a e
// a a
// Results:
// 6.0
// 0.5
// -1.0
// 1.0
// PS C:\Users\Acer\Desktop\FSD\stripe-interview\round1\399lc(ED)> 