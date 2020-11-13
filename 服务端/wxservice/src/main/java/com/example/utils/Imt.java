package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Imt {

	public static String getDateTime(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static Date getCustomDateTime(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date getCustomDateM(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date getCustomDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String fomartDateTime(Date date){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	public static boolean strIsNull(String str){
		if(str!=null&&str!=""){
			return true;
		}
		return false;
	}
	
	public static String addArraychild(String arystr,String child){
		String res=child;
		if(arystr!=null){
			if(arystr.length()>0){
				res = arystr+","+child;
			}
		}
		return res;
	}
	
	public static String removeArraychild(String arystr,String child){
		String res=arystr;
		if(arystr!=null){
			if(arystr.length()>0){
				if(arystr.indexOf(",")>-1){
					String[] ary = arystr.split(",");
					List<String> list=Arrays.asList(ary);
				    if(list.contains(child)){
				        List<String> arrayList=new ArrayList<String>(list);
				        arrayList.remove(child);
				        res="";
				        for(String str1:arrayList ){
				            res+=str1+",";
				        }
				        res=res.substring(0, res.length()-1);
				    }
				}else{
					if(arystr.equals(child)){
						res="";
					}
				}
			}
		}
		return res;
	}
}
