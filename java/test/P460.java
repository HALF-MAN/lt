package test;

import java.util.*;

public class P460 {

    class LFUCache {
        Map<Integer, Node> cache;
        Map<Integer, LinkedHashSet<Node>> freqMap;
        int capacity;
        int size;
        int min;
        public LFUCache(int capacity) {
            cache = new HashMap<>(capacity);
            freqMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return  -1;
            }
            freq(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (cache.containsKey(key)) {
                //更新值
                Node node = cache.get(key);
                node.value = value;
                //更新频率
                freq(node);
            } else {
                if (size == capacity) {
                    Node deadNode = removeNode();
                    cache.remove(deadNode.key);
                    size--;
                }
                Node node = new Node(key, value);
                cache.put(key, node);
                addNode(node);
                size++;
            }
        }

        void addNode(Node node) {
            //放入缓存
            node.freq = 1;
            cache.put(node.key, node);
            //更新频率队列
            LinkedHashSet<Node> set = freqMap.get(1);
            if (set == null) {
                set = new LinkedHashSet<>();
                freqMap.put(1, set);
            }
            set.add(node);
            min = 1;
        }

        Node removeNode() {
            LinkedHashSet<Node> set = freqMap.get(min);
            Node deadNode = set.iterator().next();
            set.remove(deadNode);
            return deadNode;
        }

        private void freq(Node node) {
            int freq = node.freq;
            LinkedHashSet<Node> set = freqMap.get(freq);
            set.remove(node);
            if (freq == min && set.size() == 0) {
                min = freq + 1;
            }
            node.freq++;
            LinkedHashSet<Node> setNew = freqMap.get(node.freq);
            if (setNew == null) {
                setNew = new LinkedHashSet<>();
                freqMap.put(node.freq, setNew);
            }
            setNew.add(node);
        }



    }
    class Node {
        int key;
        int value;
        int freq = 1;

        public Node () {

        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
