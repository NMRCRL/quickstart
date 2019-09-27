public class SeqTest {

    public static void main(String[] args) {
        String values[] = { "A", "B", "C", "D", "E" };
        SeqList<String> lista = new SeqList<String>(values); // lista引用顺序表实例，元素是String
        new SeqList<String>().Josephus(5, 0, 2);

    }
}

class SeqList<T> extends Object {

    protected Object[] element; // 对象数组存储顺序表的数据元素，保护成员
    protected int n; // 顺序表元素个数（长度）

    public SeqList(int length) { // 构造容量为length的空表
        this.element = new Object[length]; // 申请数组的存储空间，元素为null
        this.n = 0;
    }

    public SeqList() { // 创建默认容量的空表，构造方法重载
        this(64); // 调用本类已声明的指定参数列表的构造方法
    }

    public SeqList(T[] values) { // 构造顺序表，由values数组提供元素
        this(values.length); // 创建容量为values.length的空表
        for (int i = 0; i < values.length; i++) { // 复制数组元素，O(n)
            this.element[i] = values[i]; // 对象引用赋值
            this.n = values.length;
        }
    }

    public boolean isEmpty() { // 判断顺序表是否为空，若为空则返回true
        return this.n == 0;
    }

    public int size() { // 返回顺序表元素个数
        return this.n;
    }

    @SuppressWarnings("unchecked")
    public T get(int i) { // 返回低i个元素，0 <= i < n。若i越界，则返回null
        if (i >= 0 && i < this.n) {
            return (T) this.element[i]; // 返回数组元素引用的对象，传递对象引用
        }
        return null;
    }

    // 设置第i个元素为x， 0 <= i < n。若i越界，则抛出序号越界异常；若x==null，则抛出空对象异常
    public void set(int i, T x) {
        if (x == null) {
            throw new NullPointerException("x == null"); // 抛出空对象异常
        }
    }

    // 直接在顺序表末尾添加元素
    public int insert(T key) {
        Object[] source = this.element;
        if (this.n == element.length) {
            this.element = new Object[source.length * 2];
            for (int i = 0; i < source.length; i++) {
                element[i] = source[i];
            }
        }
        element[this.n] = key;
        this.n++;
        return 0;
    }

    public T remove(int i) { // 删除第i个元素，0 <= i < n ，返回被删除元素。若i越界，则返回null
        if (this.n > 0 && i >= 0 && i < this.n) {

            T old = (T) this.element[i];
            // old里存储被删除元素
            for (int j = i; j < this.n - 1; j++) {
                this.element[j] = this.element[j + 1];
                // 元素前移一个位置
            }
            this.element[this.n - 1] = null;
            // 设置数组元素对象为空，释放原引用实例
            this.n--;
            return old;
        }
        return null;
    }

    public T remove(T key) { // 删除首次出现的与key相等元素，返回被删除元素
        boolean flag = false;
        // 作为顺序表中是否含有指定元素key的依据
        int index = 0;
        // 获取此key的索引
        for (int i = 0; i < this.n; i++) {
            // 循环遍历element判断是否含有指定元素
            if (element[i].equals(key)) {
                flag = true;
                index = i;
                break;
            }
        }
// 如果含有指定元素key，则进行删除操作
        if (flag) {

            T old = (T) element[index]; // 记录被删除的元素的值
            for (; index < this.n - 1; index++) {
                element[index] = element[index + 1];
            }
            this.n--; // 顺序表中元素个数减一
            return old;
        } else { // 不含有指定元素key则返回空
            return null;
        }
    }

    public String toString() {
        String str = this.getClass().getName() + "(";// 获得这个类的名字
        if (this.n > 0) {
            str += this.element[0].toString();
        }
        for (int i = 1; i < this.n; i++) {
            str += "," + this.element[i].toString();
        }
        return str + ")";
    }

    // 创建Josephus环并求解，参数指定环长度、起始位置、计数
    public void Josephus(int number, int start, int distance) {
        System.out.print("Josephus(" + number + "," + start + "," + distance + "),");
// 创建顺序表实例，元素类型为字符串
        SeqList<String> list = new SeqList<String>(number);
        for (int i = 0; i < number; i++) {
            list.insert((char) ('A' + i) + " "); // 在该list顺序表的末尾直接添加数据元素
        }
        System.out.println(list.toString());
        int i = start; // 计数起始位置
        while (list.size() > 1) { // 多于一个元素时循环
            i = (i + distance - 1) % list.size(); // 按循环方式对顺序表进行遍历
            System.out.print("被杀死的是" + list.remove(i) + ",   "); // 删除i位置对象
            System.out.println(list.toString());
        }
        System.out.println("被赦免者是" + list.get(0).toString());
    }
}
