package ch.frankel.blog.html5.sse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RandomNumberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {

		resp.setContentType("text/event-stream");
		resp.setCharacterEncoding("UTF-8");
		
		Random random = new Random();
		
		PrintWriter writer = resp.getWriter();

		String next = "data:" + String.valueOf(random.nextInt(100) + 1);
		
		System.out.println(next);
		
		writer.write(next);
		
		writer.flush();
	}
}
