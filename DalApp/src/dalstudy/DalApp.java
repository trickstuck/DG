package dalstudy;
import java.util.*;

public class DalApp {
	int isYun(int oyear) {
		int Yun = 0;
		if((oyear%4 & oyear%100)!=0) Yun=1;
		else if(oyear%400==0) Yun=2;
		return Yun;
	}

	public static void main(String[] args) {
		int wd=0, oyear=2012;
		DalApp dal = new DalApp();
		System.out.println("Yun = " + dal.isYun(oyear));
	}

}
