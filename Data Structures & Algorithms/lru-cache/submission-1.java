

class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    ArrayList<Pair> list;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>();
    }

    public int get(int key) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).key == key) {

                Pair pair = list.get(i);

                // Recently used -> end
                list.remove(i);
                list.add(pair);

                return pair.value;
            }
        }

        return -1;
    }

    public void put(int key, int value) {

        // Check if key already exists
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).key == key) {

                Pair pair = list.get(i);

                // Update value
                pair.value = value;

                // Recently used -> end
                list.remove(i);
                list.add(pair);

                return;
            }
        }

        // New key and cache is full
        if (list.size() == capacity) {
            list.remove(0);   // Remove LRU
        }

        // New key becomes MRU
        list.add(new Pair(key, value));
    }
}