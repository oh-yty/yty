import java.util.Arrays;

public class ArraysTest{
	public static int indexOf(int[] a ,int v){
		
		for(int i=0;i<a.length;i++){
		    if(a[i]==v)     //注意，v是方法传回的值
				return 1;
		}
		return -1;
	}
	
	public static int[] copyOf(int[]  original,int newlength){
		    //重新定义一个数组
		 int [] dest=new int[newlength]; 
		int length =original.length<=newlength ? original.length : newlength;   //三目运算符
		for(int i=0;i<newlength;i++){
			dest[i]=original[i];
//			if(original.length<=newlength){
//				newlength=original.length;  //else 不用写，因为数组的默认值是0
//			}
		}	
		  //toString数组打印的方法
	    return dest;
	}
	public static void main (String [] args){
		int[] a={1,2,3,4,5};
		indexOf(a,0);
		copyOf(a,10);   
		System.out.println(Arrays.toString(Arrays.copyOf(a,10 )));
		//System.out.println(copyOf(a,3));      //打印出来的是一串地址  [I@c3c749
		
	
	}
}
