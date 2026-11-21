class FreqStack {
    class Element {
        int value;
        int insertionTime;
        int freq;

        Element(int val, int ist, int f) {
            value = val;
            insertionTime = ist;
            freq = f;
        }
    }

    int time = 0;
    Map<Integer, Integer> mp = new HashMap<>();
    Comparator<Element> cmp = (Element a, Element b) -> {
        if (a.freq == b.freq)
            return b.insertionTime - a.insertionTime;
        return b.freq - a.freq;
    };
    PriorityQueue<Element> pq = new PriorityQueue<>(cmp);

    public FreqStack() {

    }

    public void push(int val) {
        if (mp.containsKey(val)) {
            int prevFreq = mp.get(val);
            mp.put(val, prevFreq + 1);
            pq.offer(new Element(val, time++, prevFreq + 1));
        } else {
            pq.offer(new Element(val, time++, 1));
            mp.put(val, 1);
        }
    }

    public int pop() {
        Element top = pq.poll();
        int prevFreq = mp.get(top.value);
        mp.put(top.value, prevFreq - 1);
        return top.value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */