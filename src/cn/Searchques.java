package cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import cn.DBConnection;

public class Searchques extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		//String student_id = request.getParameter("id");
		//System.out.println("id:" + student_id);
		
		try {
			////////////
			// do something
			////////////
			
			//产生随机数
			Random r = new Random();//随机数对象
			int j=0;
			int N=10;//产生介于0-99中的随机数
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {  //产生4个随机数
				int randnumber = r.nextInt(N)+1;//随机的题号
				int flag=1;
				for(int k=0;k<j;k++)
				{
				     if(randnumber==ques[k])
					{ flag=0;
					  break;  }
				}
			        if(flag==1)
				{  ques[j] = randnumber;
				   j++;   }			
			}
			
			ArrayList<Question> que= new ArrayList();
			int i=0;
			while(i<4){
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from questions where tid = '" + ques[i] +"'");
			i++;
			int tid =0;
			String question = "";
			String optA = "";
			String optB = "";
			String optC = "";
			String optD = "";
			String answer = "";
		
		
			while(rs.next()){
				tid=rs.getInt(1);
				question=rs.getString(2);
				optA=rs.getString(3);
				optB=rs.getString(4);
				optC=rs.getString(5);
				optD=rs.getString(6);
				answer=rs.getString(7);
				Question q=new Question(tid,question,optA,optB,optC,optD,answer);
				que.add(q);
			}
			db.close();
			}
			/*Question s = que.get(0);
			System.out.println(s.question);
			System.out.println(s.answer);*/
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			JSONObject obj1 = new JSONObject();
			Question s1 = que.get(0);
			obj1.put("tid", s1.tid);
			obj1.put("question", s1.question);
			obj1.put("optA", s1.optA);
			obj1.put("optB", s1.optB);
			obj1.put("optC", s1.optC);
			obj1.put("optD", s1.optD);
			obj1.put("answer", s1.answer);
			obj.put("question1",obj1);

			JSONObject obj2 = new JSONObject();
			Question s2 = que.get(1);
			obj2.put("tid", s2.tid);
			obj2.put("question", s2.question);
			obj2.put("optA", s2.optA);
			obj2.put("optB", s2.optB);
			obj2.put("optC", s2.optC);
			obj2.put("optD", s2.optD);
			obj2.put("answer", s2.answer);
			obj.put("question2",obj2);
			
			JSONObject obj3 = new JSONObject();
			Question s3 = que.get(2);
			obj3.put("tid", s3.tid);
			obj3.put("question", s3.question);
			obj3.put("optA", s3.optA);
			obj3.put("optB", s3.optB);
			obj3.put("optC", s3.optC);
			obj3.put("optD", s3.optD);
			obj3.put("answer", s3.answer);
			obj.put("question3",obj3);
			
			JSONObject obj4 = new JSONObject();
			Question s4 = que.get(3);
			obj4.put("tid", s4.tid);
			obj4.put("question", s4.question);
			obj4.put("optA", s4.optA);
			obj4.put("optB", s4.optB);
			obj4.put("optC", s4.optC);
			obj4.put("optD", s4.optD);
			obj4.put("answer", s4.answer);
			obj.put("question4",obj4);
			
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
