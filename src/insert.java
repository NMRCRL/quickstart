public class insert {
}
public int insert(int i,T x){
 if(x==null)
     throw new NullPointerException("x==null");
    if(i<0)      i=0;
    if(i>this.n) i=this.n;
    Object[]  source=this.n;
    if (this.n==element.length){
        this.element=new Object[source.length*2];
        for (int j=0;j<i;j++)
            this.element[j]=source[j];
    }
    for (int j=this.n-1;j>=i;j--)
        this.element[j+1]=source[j];
    this.element[j+1]=x;
    this.n++;
    return i;
}
public int insert(T x){
    return  this.insert(this.n,x);
}