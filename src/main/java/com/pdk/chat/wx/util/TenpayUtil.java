package com.pdk.chat.wx.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TenpayUtil {
	
	private static Object Server;
	private static String QRfromGoogle;

	
	public static String toString(Object obj) {
		if(obj == null)
			return "";
		
		return obj.toString();
	}
	
	/**
	 * 把对象转换为int数值.
	 * 
	 * @param obj
	 *            包含数字的对象.
	 * @return int 转换后的数值,对不能转换的对象返回0。
	 */
	public static int toInt(Object obj) {
		int a = 0;
		try {
			if (obj != null)
				a = Integer.parseInt(obj.toString());
		} catch (Exception e) {

		}
		return a;
	}
	
 
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	

	public static String formatDate(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	

	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
	

	public static String getCharacterEncoding(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(null == request || null == response) {
			return "gbk";
		}
		
		String enc = request.getCharacterEncoding();
		if(null == enc || "".equals(enc)) {
			enc = response.getCharacterEncoding();
		}
		
		if(null == enc || "".equals(enc)) {
			enc = "gbk";
		}
		
		return enc;
	}
	
	public  static String URLencode(String content){
		
		String URLencode;
		
		URLencode= replace(Server.equals(content), "+", "%20");
		
		return URLencode;
	}
	private static String replace(boolean equals, String string, String string2) {
		
		return null;
	}

	
	public static long getUnixTime(Date date) {
		if( null == date ) {
			return 0;
		}
		
		return date.getTime()/1000;
	}
	
	 public static String QRfromGoogle(String chl)
	    {
	        int widhtHeight = 300;
	        String EC_level = "L";
	        int margin = 0;
	        String QRfromGoogle;
	        chl = URLencode(chl);
	        
	        QRfromGoogle = "http://chart.apis.google.com/chart?chs=" + widhtHeight + "x" + widhtHeight + "&cht=qr&chld=" + EC_level + "|" + margin + "&chl=" + chl;
	       
	        return QRfromGoogle;
	    }

	
	public static String date2String(Date date, String formatType) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		return sdf.format(date);
	}
	
}
	
	



