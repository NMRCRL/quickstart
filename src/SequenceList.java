public class SequenceList {

    public static void main(String[] args) {
        String values[] = {"1","2","3","4","5"};
        SeqList<String> LLIS=new SeqList<String>(values);
        SeqList<Integer> list1= new SeqList<Integer>();
        System.out.println(LLIS.toString());
    }

}
class SeqList<T> extends Object
{
    protected Object[] element;
    protected int n;
    public SeqList(int Length)
    {
        this.element=new Object[Length];
        this.n = 0;

    }
    public SeqList()
    {
        this(64);
    }

    public SeqList(T[] values) {
        this(values.length);
        for(int i=0;i<values.length;i++)
            this.element[i]=values[i];
        this.n = element.length;

    }


    public boolean isEmpty() {
        return this.n==0;

    }

    public int size() {
        return this.n;
    }

    public T get(int i) {
        if(i>=0&&i<this.n)
            return(T)this.element[i];
        return null;
    }

    public void set(int i,T x) {
        if(x==null)
            throw new NullPointerException("x==null");
        if(i>=0&&i<this.n)
            this.element[i]=x;
        else throw new java.lang.IndexOutOfBoundsException(i+"");
    }

    public String toString()
    {
        String str=this.getClass().getName()+"(";
        if(this.n>0)
            str+=this.element[0].toString();
        for(int i=1;i<this.n;i++)
            str+=","+this.element[i].toString();
        return str+")";
    }
    public int insert(int i,T x){
       if (x==null);
       throw new NullPointerException("x==null");
       if (i<0)  i = 0;
       if (i>this.n) i=this.n;
       Object[]source =this.element;
       if (this.n==element.length){
           this.element=new
                   Object[source.length*2];
           for (int j=0;j<i;j++)
               this.element[j]=source[j];
       }
       for (int j=this.n-1;j>=i;j--)
           this.element[i]=x;
       this.n++;
       return i;
    }
    public int insert(T x){
        return this.insert(this.n,x );
    }
    public T remove(int i){
        if (this.n>0&&i>=0&&i<this.n){
            T old=(T)this.element[i];
            for (int j=i;j<this.n-1;j++)
                this.element[j]=this.element[j+1];
            this.element[this.n-1]=null;
            this.n--;
            return old;
        }
        return null;
    }
    public void clear(){
        this.n=0;
    }
    public class Josephus {
        public Josephus(int number,int start,int distance) {
            System.out.print("Josephus("+number+","+start+","+distance+"),");

            SeqList<String>list=new SeqList<String>(number);

            for(int i = 0;i<number;i++) {

                list.insert((char)('A'+i)+"");
            }
            System.out.print(list+"\n");

            int j=start;

            while(list.size()>1) {

                j=(j+distance-1)%list.size();

                System.out.print("删除"+list.remove(j)+", ");

                System.out.print(list+"\n");
            }

            System.out.print("被赦免的是"+list.get(0));

        }
    }

}