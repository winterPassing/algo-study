package winter.passing.array;

/**
 * @Author: biancheng
 * @Date: 2019/12/16 17:33
 * @Description:
 */
public class Array {

    /**
     * 定义整型数据data
     */
    public int[] data;

    /**
     * 定义数组长度
     */
    private int n;

    /**
     * 数组容量大小
     */
    private int count;

    /**
     * 构造方法
     * @param capacity
     */
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 根据索引查询元素
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    /**
     * 插入元素
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        //数组中无元素

        //if (index == count && count == 0) {
        //    data[index] = value;
        //    ++count;
        //    return true;
        //}

        // 数组空间已满
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }
        // 如果count还没满，那么就可以插入数据到数组中
        // 位置不合法
        if (index < 0||index > count ) {
            System.out.println("位置不合法");
            return false;
        }
        // 位置合法
        for( int i = count; i > index; --i){
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    /**
     * 根据索引，删除数组中元素
     * @param index
     * @return
     */
    public boolean delete(int index){
        if (index<0 || index >=count) {
            return false;
        }
        //从删除位置开始，将后面的元素向前移动一位
        for (int i=index+1; i<count; ++i){
            data[i-1] = data[i];
        }
        //删除数组末尾元素  这段代码不需要也可以
        /*int[] arr = new int[count-1];
        for (int i=0; i<count-1;i++){
            arr[i] = data[i];
        }
        this.data = arr;*/

        --count;
        return true;
    }

    /**
     * 打印
     */
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i] + " ");
        }
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.insert(4, 11);
        array.printAll();
    }
}
