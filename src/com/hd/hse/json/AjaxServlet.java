package com.hd.hse.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


public class AjaxServlet extends HttpServlet {
	private static JSONGateway gateway = null;
	private String dataSource = "";
	@Override
	public void init(ServletConfig config){
       dataSource = config.getInitParameter("dataSource");
       System.out.println("datasource : " + dataSource);
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding( "UTF-8" );
		res.setCharacterEncoding( "UTF-8" );
		if( gateway == null ){
			gateway = new JSONGateway();
			gateway.init();
		}
		req.setAttribute("dataSource", dataSource);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				req.getInputStream() , "utf-8"));
		StringBuffer buffer = new StringBuffer();
		String json = "";
		if (br != null) {
			if ((json = br.readLine()) != null) {
				buffer.append(json);
			}
		}
		String strBuffer = buffer.toString();
		if( strBuffer.length() > 0 ){
			boolean bencoding= false;
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject( strBuffer );
				String jsonEncodeData = bencoding ? gateway.encode( jsonObject ) : jsonObject.toString();
				System.out.println( jsonEncodeData );
				String jsonEncodeResponse = gateway.proc(null, jsonEncodeData , req , res );
				if( jsonEncodeResponse != null ){
					//jsonObject = new JSONObject( bencoding ? gateway.decode(jsonEncodeResponse) : jsonEncodeResponse.toString() );
					res.setContentType("text/json");
					PrintWriter pw = res.getWriter();
					pw.write(jsonEncodeResponse);
				}else{
					System.err.println("invalid message : " + buffer.toString() + " - " + req.getAttribute("error"));
					res.setContentType("text/json");
					PrintWriter pw = res.getWriter();
					JSONObject obj = new JSONObject();
					obj.put("error", "400 bad request" + " - " + req.getAttribute("error"));
					obj.put("request", jsonObject);
					pw.write( obj.toString() );
				}
			} catch (JSONException e) {
				e.printStackTrace();
				
				res.setContentType("text/json");
				PrintWriter pw = res.getWriter();
				pw.write( e.getMessage() );
			}
		}else{
			res.setContentType("text/json");
			PrintWriter pw = res.getWriter();
			pw.write("Request Message is empty");
		}
    }
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding( "UTF-8" );
		res.setCharacterEncoding( "UTF-8" );
		
		res.setContentType("text/json");
		PrintWriter pw = res.getWriter();
		pw.write("not supported 'GET' Method");
	}
}
