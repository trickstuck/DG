package dalstudy;
import java.util.*;

public class DalApp {
	int isYun(int oyear) {
		int Yun = 0;
		if((oyear%4 & oyear%100)!=0) Yun=1;
		else if(oyear%400==0) Yun=2;
		return Yun;
	}
	
	 int getWkday(int oyear) {
		int wday=0, yuncount=0, totdays=0;
		for(int y=1; y<oyear; y++) {
			if(isYun(y)!=0) ++yuncount;
		}
		totdays=(oyear-1)*365 + yuncount;
		wday = totdays%7; // 12월 31일의 요일
		wday = ++wday%7; // 1월 1일의 요일
		return wday;
	}
	
	 
	public static void main(String[] args) {
		int wd=0, oyear=2012;
		DalApp dal = new DalApp();
		System.out.println("Yun = " + dal.isYun(oyear));
		
	}
	
}
