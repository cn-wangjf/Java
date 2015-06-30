package cn.wangjf.java.number;

import java.util.Scanner;

public class InviteCode {

	private static final String codeChars = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int num = 0;
			while( (num = in.nextInt()) >= 0) {
				String code = format(convert(num));
				System.out.println("code: " + code);
				System.out.println("num: " + parse(code));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}
	
	public static String convert(int num) {
		if(num == 0) {
			return "";
		}
		int codeLength = codeChars.length();
		return convert(num / codeLength) + codeChars.charAt(num % codeLength);
	}
	
	public static String format(String code) {
		while(code.length() < 6) {
			code = codeChars.charAt(0) + code;
		}
		return code;
	}
	
	public static int parse(String code) {
		int codeLength = codeChars.length();
		int num = 0;
		for(int i = code.length() - 1; i >= 0 ; i-- ) {
			num += codeChars.indexOf(code.charAt(i)) * Math.pow(codeLength, code.length() - i - 1 );
		}
		return num;
	}
	
}
