import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DesignInMemoryFileSystem {


    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
        List<String> param_1 = obj.ls("/");
        System.out.println(param_1);
        obj.mkdir("/a/b/c");
        obj.addContentToFile("/a/b/c/d", "hello");
        List<String> param_2 = obj.ls("/");
        System.out.println(param_2);
        String param_4 = obj.readContentFromFile("/a/b/c/d");
        System.out.println(param_4);
    }
}

class FileSystem {
    class Dir {
        String content;
        boolean isFile;
        HashMap<String, Dir> sub;

        public Dir(String content, boolean isFile) {
            this.content = content;
            this.isFile = isFile;
            this.sub = new HashMap<>();
        }

        public Dir() {
            this("", false);
        }
    }

    Dir root;
    public FileSystem() {
        root = new Dir();
    }

    public List<String> ls(String path) {
        String[] folders = path.split("/");
        Dir curr = findDir(folders, false);

        if (curr == null) {
            return null;
        }

        List<String> ans = new ArrayList<>();
        if (curr.isFile) {
            ans.add(folders[folders.length - 1]);
        } else {
            ans.addAll(curr.sub.keySet());
            Collections.sort(ans);
        }

        return ans;
    }

    public void mkdir(String path) {
        String[] folders = path.split("/");
        findDir(folders, true);
    }

    public void addContentToFile(String filePath, String content) {
        String[] folders = filePath.split("/");
        Dir file = findDir(folders, true);
        if (file != null) {
            file.isFile = true;
            file.content += content;
        }
    }

    public String readContentFromFile(String filePath) {
        String[] folders = filePath.split("/");
        Dir file = findDir(folders, false);
        if (file != null) {
            return file.content;
        }

        return "";
    }

    private Dir findDir(String[] folders, boolean create) {
        Dir curr = root;
        for (int i = 1; i < folders.length; i++) {
            String dirName = folders[i];
            if (!curr.sub.containsKey(dirName)) {
                if (create) {
                    curr.sub.put(dirName, new Dir());
                } else {
                    return null;
                }
            }
            curr = curr.sub.get(dirName);
        }

        return curr;
    }
}
