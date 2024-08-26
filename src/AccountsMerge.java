import java.util.*;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts.
 * Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name,
 * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 */

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parents = new int[accounts.size()];
        int[] sizes = new int[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            parents[i] = i;
            sizes[i] = 1;
        }

        HashMap<String, Integer> emails = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> person = accounts.get(i);
            for (int j = 1; j < person.size(); j++) {
                String email = person.get(j);
                if (!emails.containsKey(email)) {
                    emails.put(email, i);
                } else {
                    union(parents, sizes, i, emails.get(email));
                }
            }
        }

        HashMap<Integer, HashSet<String>> resultMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int parent = find(parents, i);
            resultMap.computeIfAbsent(parent, e -> new HashSet<>()).addAll(accounts.get(i));
            resultMap.get(parent).remove(accounts.get(i).get(0));
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, HashSet<String>> person : resultMap.entrySet()) {
            List<String> one = new ArrayList<>(person.getValue().stream().sorted().toList());
            one.add(0, accounts.get(person.getKey()).get(0));
            result.add(one);
        }

        return result;
    }

    private int find(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = find(parents, parents[i]);
            i = parents[i];
        }

        return i;
    }

    private void union(int[] parents, int[] sizes, int x, int y) {
        int parentX = find(parents, x);
        int parentY = find(parents, y);

        if (parentX == parentY) {
            return;
        }

        if (sizes[parentX] > sizes[parentY]) {
            parents[parentY] = parentX;
            sizes[parentX] += sizes[parentY];
        } else {
            parents[parentX] = parentY;
            sizes[parentY] += sizes[parentX];
        }
    }
}
