class MyHashMap {
    constructor() {
        this.data = new Array(1000001)
    }
    put(key, val) {
        this.data[key] = val
    }
    get(key) {
        let val = this.data[key]
        return val !== undefined ? val : -1
    }
    remove(key) {
        delete this.data[key]
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */