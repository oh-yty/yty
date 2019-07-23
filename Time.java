
//Time  时/分/秒
//功能：1)初始化
//         1.用户传入年月日
//         2.不传，默认给今天
//      2)多少秒之后的时/分/秒
//      3)多少秒之前的时/分/秒
public class Time {
	private int hour;
	private int minute;
	private int second;
	//hour [0,23]
	//minute[0,59]
	//second [0,59]
    public Time(int hour,int minute,int second){
    	if(hour<0||hour>23){
    		System.err.println("小时不对");
    	}
    	if(minute<0||minute>59){
    		System.err.println("分钟不对");
    	}
    	if(second<0||second>59){
    		System.err.println("秒钟不对");
    	}
    	this.hour=hour;
    	this.minute=minute;
    	this.second=second;
    }
    public Time immutableAfter(int seconds){
    	if(seconds<0){
    		System.err.println("输入的秒钟不对");
    	}
    	Time t=new Time(hour,minute,second);
    	second=second+seconds;
    	while(second>59){
    		second=second-60;
    		minute=minute+1;
    		if(minute>59){
    			minute=0;
    			hour=hour+1;
    			if(hour>23){
    				hour=0;
    			}
    		}
    	}
    	return this;
    }
    //a-b 相差多少秒
    public static int diff(Time a,Time b){
    	int s1=a.hour*60*60+a.minute*60+a.second;
    	int s2=b.hour*60*60+b.minute*60+b.second;
      	if(a.hour>=b.hour){
    		return s1-s2;
    	}else{
    		return s2-s1;
    	} 
    }
    public String toString(){
    	return String.format("%02d:%02d:%02d", hour,minute,second);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t1=new Time(15,07,22);
		t1.immutableAfter(80);
		
		System.out.println(t1.toString());
		t1.immutableAfter(60);
		System.out.println(t1.toString());
		
		Time t2=new Time(14,47,22);
		Time t3=new Time(15,47,22);
		System.out.println(t1.diff(t2,t3));
	}
}
