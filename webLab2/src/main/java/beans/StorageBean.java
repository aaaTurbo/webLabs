package beans;

import java.util.ArrayList;

public class StorageBean {

    private static ArrayList<String> storage = new ArrayList<>();

    public StorageBean() {

    }

    public static String getStorage() {
        String result = "";
        for (int i = storage.size() - 1; i >= 0; i--) {
            result += storage.get(i);
        }
        return result;
    }

    public static void addItem(String item) {
        storage.add(item);
    }
}
