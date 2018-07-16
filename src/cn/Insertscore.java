package cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import cn.DBConnection;

public class Insertscore extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		
		int score =Integer.parseInt(request.getParameter("score")) ;
		String time = request.getParameter("time");
		System.out.println("score:" + score);
		System.out.println("time:" + time);
		
		try {
			
			DBConnection db = new DBConnection();
			db.execute("INSERT INTO scores (score, time) VALUES ('"+score+"', '"+time+"')");
			db.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
