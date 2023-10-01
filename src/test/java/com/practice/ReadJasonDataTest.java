package com.practice;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class ReadJasonDataTest {

	public static void main(String[] args) throws Throwable {
		FileReader fr=new FileReader(".\\src\\test\\resources\\file.json");
		JSONParser j=new JSONParser();
		Object ob=j.parse(fr);
		JSONObject map=(JSONObject)ob;
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));








	}

}
