//학번: 2015211322 이름: 노민석

// 프로그램 : Dal.java 달력 프로그램

package dalstudy;

public class DalApp {

	int dal2d[][] = new int[6][7]; // 6주 , 7일이므로 6 row x 7 column

	int dal3d[][][] = new int[13][6][7]; // 12달 * 6x7 의 3차원 배열 - 1~12까지만 사용

	private int dalSize[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// get, set으로 데이터를 설정하고 얻어온다. ㅡ 객체지향적 방식(정보은닉)

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

	public void printTitle(int year, int month) {

		System.out.printf("\n     노민석의 " + year + "년 " + +month + "월 달력");

		System.out.println("\n Sun Mon Tue Wed Thr Fri Sat");

	}

	public void printDal(int year, int month) {

		int wd = 0;

		printTitle(year, month);

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

	// 2차원 배열을 이용한 달력 출력 메소드

	// 선언된 2차원 배열을 초기화해준다.

	public void clearDal2d() {

		for (int r = 0; r < 6; r++) {

			for (int c = 0; c < 7; c++) {

				dal2d[r][c] = 0;

			}

		}

	}

	public void fillDal2d(int year, int month) {

		int day = 1, wd = 5;

		wd = getWeekDay(year, month);

		for (int r = 0; r < 6; r++) {

			for (int c = wd; c < 7; c++) { // 첫 주는 시작요일 0~6

				dal2d[r][c] = day++; // 후위연산자, 값 할당 후 증가.

				// if dalSize[m]<day dalSize[m]과 day 비교하는것 작성

			}

			wd = 0; // 2번째 반복 부터 = 2~5주는 0으로 시작.

		}

	}

	public void printDal2d(int year, int month) {

		int r, c, cc = 0;

		printTitle(year, month);

		for (r = 0; r < 6; r++) {

			for (c = 0; c < 7; c++) {

				cc = c;

				if (dal2d[r][c] == 0)

					System.out.printf("    ");

				else

					System.out.printf("%4d", dal2d[r][c]);

				if (dal2d[r][c] == dalSize[month])

					break;

			}

			System.out.println();

			if (dal2d[r][cc] == dalSize[month])

				break;

		}

	}


	// 3차원을 이용한 달력 출력 메소드

	public void clearDal3d() {

		for (int d = 1; d <= 12; d++)

			for (int r = 0; r < 6; r++)

				for (int c = 0; c < 7; c++)

					dal3d[d][r][c] = 0;

	}

	public void fillDal3d(int year) {

		int day = 1, wd = 0, month = 1;

		for (month = 1; month <= 12; month++) {

			day = 1;

			wd = getWeekDay(year, month);

			for (int r = 0; r < 6; r++) {

				for (int c = wd; c < 7; c++) { // 첫 주는 시작요일 0~6

					dal3d[month][r][c] = day++; // 후위연산자, 값 할당 후 증가.

				}

				wd = 0; // 2번째 반복 부터 = 2~5주는 0으로 시작.

			}

		}

	}

	public void printDal3d(int year) {

		int r, c, cc = 0, month = 1;

		for (month = 1; month <= 12; month++) {

			printTitle(year, month);

			for (r = 0; r < 6; r++) {

				// 이 자리에 for문 하나 들어가야함

				for (c = 0; c < 7; c++) {

					cc = c;

					if (dal3d[month][r][c] == 0)

						System.out.printf("    ");

					else

						System.out.printf("%4d", dal3d[month][r][c]);

					if (dal3d[month][r][c] == dalSize[month])

						break;

				}

				System.out.println();

				if (dal3d[month][r][cc] == dalSize[month])

					break;

			}

		}

	}

	// 복수의 달을 가로로 나란히 출력

	public void printMultiDal3d(int year) {

		int r, c, cc = 0, month = 1, mm = 0, m = 0;
		

		for (month = 1; month <= 12; month+=2) {
			printTitle(year, month);
			
			for (r = 0; r < 6; r++) {
				for (m = month; m <month+2; m++) {
					for (c = 0; c < 7; c++) {

						cc = c;

						mm = m;

						if (dal3d[m][r][c] == 0)

							System.out.printf("    ");

						else

							System.out.printf("%4d", dal3d[m][r][c]);

						if (dal3d[m][r][c] == dalSize[m])

							break;

					}

					System.out.printf("    ");

				}

				System.out.println();

				if (dal3d[mm][r][cc] == dalSize[mm])

					break;

			}

		}

	}

	public static void main(String[] args) {

		int year = 2021;

		DalApp d = new DalApp();

		/*
		 * 
		 * for (year = 2020; year < 2022; year++) { System.out.println(year + ": " +
		 * 
		 * d.sumYun(year)); System.out.println("WeekDay: "+d.getWeekDay(year)); }
		 * 
		 */

		d.setDalSize(year);

		/*
		 * 
		 * for (month = 1; month <= 12; month++) { d.clearDal2d(); d.fillDal2d(year,
		 * 
		 * month); d.printDal2d(year, month); }
		 * 
		 */

		d.clearDal3d();

		d.fillDal3d(year);

		d.printMultiDal3d(year);

	}

}
