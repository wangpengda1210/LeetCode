import java.util.HashMap;
import java.util.List;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, String> groups = new HashMap<>();
        HashMap<String, Double> weights = new HashMap<>();
        HashMap<String, Integer> sizes = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double factor = values[i];
            union(dividend, divisor, factor, groups, weights, sizes);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!groups.containsKey(dividend) || !groups.containsKey(divisor)) {
                results[i] = -1.0;
            } else {
                String dividendParent = find(dividend, groups, weights);
                String divisorParent = find(divisor, groups, weights);

                if (!dividendParent.equals(divisorParent)) {
                    results[i] = -1.0;
                } else {
                    results[i] = weights.get(dividend) / weights.get(divisor);
                }
            }
        }

        return results;
    }

    private void union(String dividend, String divisor, double factor, HashMap<String, String> groups,
                       HashMap<String, Double> weights, HashMap<String, Integer> sizes) {
        if (!groups.containsKey(dividend)) {
            groups.put(dividend, dividend);
            weights.put(dividend, 1.0);
            sizes.put(dividend, 1);
        }

        if (!groups.containsKey(divisor)) {
            groups.put(divisor, divisor);
            weights.put(divisor, 1.0);
            sizes.put(divisor, 1);
        }

        String dividendParent = find(dividend, groups, weights);
        String divisorParent = find(divisor, groups, weights);

        if (!dividendParent.equals(divisorParent)) {
            if (sizes.get(dividendParent) > sizes.get(divisorParent)) {
                String temp = dividendParent;
                dividendParent = divisorParent;
                divisorParent = temp;
                factor = 1.0 / factor;
            }

            groups.put(dividendParent, divisorParent);
            weights.put(dividendParent, weights.get(divisor) * factor / weights.get(dividend));
            sizes.put(dividendParent, sizes.get(dividendParent) + sizes.get(divisorParent));
        }
    }

    private String find(String item, HashMap<String, String> groups, HashMap<String, Double> weights) {
        String parent = item;
        double weight = 1.0;

        while (!groups.get(parent).equals(parent)) {
            weight *= weights.get(parent);
            parent = groups.get(parent);
        }

        groups.put(item, parent);
        weights.put(item, weight);

        return parent;
    }
}
