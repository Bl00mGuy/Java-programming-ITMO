import java.util.ArrayList;
import java.util.HashMap;

class ItemCatalog {
    private final HashMap<Integer, GenericItem> catalog = new HashMap<>();
    private final ArrayList<GenericItem> ALCatalog = new ArrayList<>();

    public void addItem(GenericItem item) {
        catalog.put(item.ID, item);
        ALCatalog.add(item);
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) {
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.ID == id) return i;
        }
        return null;
    }
}