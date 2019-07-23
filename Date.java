package Day;

//Date 存储 年-月-日 信息
//原则：一切从用户角度出发
//功能：1)初始化
//            1.用户传入年月日
//            2.不传，默认给今天
//        2)多少天之后的年/月/日
//        3)多少天之前的年/月/日
public class Date {
	private int year;
	private int month;
	private int day;
	
	//构造方法
	//年支持的范围[1840,2020]
	//月支持的范围[1,12]
	//日支持的范围 int[] day_of_month
    private static final int[] day_of_month={31,28,31,30,31,30,31,31,30,31,30,31};
	public Date(int year,int month,int day){
	
		if(year<1840||year>2020){
			System.out.println("年支持的范围[1840,2020]");
			return;
		}
		if(month<1||month>12){
			System.out.println("月支持的范围[1,12]");
			return;
		}
		if(day<0||day>CalcDaysOfMonth(month)){
			System.out.println("超出认知的日期");
			return;
		}
		//上述判断完成后再进行初始化
		this.year=year;
		this.month=month;
		this.day=day;
	}
	public int CalcDaysOfMonth(int month){
		if(month!=2){
			return  day_of_month[month-1];    //[month-1]是因为day_of_month是数组，下标是从0开始的
		}
		if(isLeapYear(year)){                 //有闰年的情况
			return 29;
		}else{
			return 28;
		}	
	}
	public boolean isLeapYear(int year){      //判断是否为闰年
		if(year % 4==0 && year % 100!=0){
			return true;
		}
		if(year % 400==0){
			return true;
		}else{
			return false;
		}
	}
	public Date after(int days){             
		day=day+days;                           //day= 构造方法传进来的day+after传进来的days
		while(day>CalcDaysOfMonth(month)){      //调用CalcDaysOfMonth(month)方法，如果day 大于当月总天数，
			day=day-CalcDaysOfMonth(month);     //此时 day=day-当月总天数
			month=month+1;                      //月份加1
			if(month>12){                       // 在这里判断传进来的days 有没有可能使年份往后推一年，比如当days=300
				month=1;
				year=year+1;
			}
		}
		return this;                            //如果上面day=day+days<CalcDaysOfMonth(month),直接return ，
		                                        //如果大于，则在执行完while（）之后return this;
	}
	public Date before(int days){
		day=day-days;                          //（2017，7，20）假设days=80，20-80=-60
		while(day<0){
			month=month-1;                     //day=-60<0,7月的20天已经减掉了，所以month=month-1=6
			if(month<1){                       //在这里判断传进来的days 有没有可能使年份往前推一年，比如当days=300
				month=12;
				year=year-1;
			}
			day=day+CalcDaysOfMonth(month);    //day=-60+CalcDaysOfMonth(6)=-60+30=-30
			
		}
		return  this;
	}
	//d1-d2
	
	public String toString(){
		return String.format("%04d-%02d-%02d",year,month,day);
	}

	public static void main(String[] args) {
		Date d=new Date(2019,7,22);
//		Date da1=d.after(20);
//		System.out.println("20天后日期为："+da1.toString());
//		Date da2=d.after(300);  //Date 返回的this指的是当前对象，也就是d，所以r和d指向的都是（2019，7，20）
//		System.out.println("300天后日期为："+da2.toString());
		
		System.out.println("当前日期为"+d);
		Date db1=d.before(8287);
		System.out.println("8285天前日期为："+db1.toString());
//		Date db2=d.before(300);
//		System.out.println("300天前日期为："+db2.toString());


	}

}
