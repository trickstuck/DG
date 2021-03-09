//학번: 2015211322 이름: 노민석

// 프로그램 : Dal.java 달력 프로그램

package dalstudy;

public class DalApp {

	private int dalSize[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getDalSize(int month) {

		return dalSize[month];

	}

	public void setDalSize(int year) {

		if (isYun(year) == 1)

			dalSize[2] = 29;

	}

	public int isYun(int year) {

		if (year % 4 == 0 && year % 100 != 0)

			return 1;

		else if (year % 400 == 0)

			return 1;

		else

			return 0;

	}

	public int sumYun(int year) {

		int sum = 0;

		for (int y = 1; y < year; y++) {

			sum += isYun(y);

		}

		return sum;

	}

	public int sumDalSize(int month) {

		int sum = 0;

		for (int m = 1; m < month; m++) {

			sum += dalSize[m];

		}

		return sum;

	}

	public int getWeekDay(int year, int month) {

		return (365 * (year - 1) + sumYun(year) + sumDalSize(month) + 1) % 7;

	}

	public void printDal(int year, int month) {

		int wd = 0;

		System.out.printf("\n\n    노민석의 " + year + "년 " + +month + "월 달력");

		System.out.println("\n Sun Mon Tue Wed Thr Fri Sat");

		wd = getWeekDay(year, month);

		for (int s = 1; s <= wd; s++) {

			System.out.print("    ");

		}

		for (int day = 1; day <= getDalSize(month); day++) {

			System.out.printf("%4d", day);

			if ((day + wd) % 7 == 0) {

				System.out.println();

			}

		}

	}

	public static void main(String[] args) {

		int month, year = 2021;

		DalApp d = new DalApp();

		/*
		 * 
		 * for (year = 2020; year < 2022; year++) {
		 * 
		 * System.out.println(year + ": " + d.sumYun(year));
		 * 
		 * System.out.println("WeekDay: "+d.getWeekDay(year));
		 * 
		 * }
		 * 
		 */

		d.setDalSize(year);

		for (month = 1; month <= 12; month++) {

			d.printDal(year, month);

		}

	}

}