package com.neuedu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.bean.ResponseInfo;
import com.neuedu.bean.UserInfo;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DemoServlet() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type");
		if ("list".equals(type)) {//http://localhost:8080/gsonDemo/DemoServlet?type=list

			// 模拟返回一组数据
			List<UserInfo> list = new ArrayList<>();
			list.add(new UserInfo(1, "user1"));
			list.add(new UserInfo(2, "user2"));
			list.add(new UserInfo(3, "user3"));
			list.add(new UserInfo(4, "测试用户"));

			// 把集合转换成响应对象
			ResponseInfo<List<UserInfo>> result = new ResponseInfo<>(true, "查询数据成功");
			result.setData(list);
			// 把响应对象转换成json字符串
			String jsonString = new Gson().toJson(result);

			System.out.println("响应数据： " + jsonString);

			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(jsonString);
			response.getWriter().flush();
			response.getWriter().close();
			
			

		} else {//http://localhost:8080/gsonDemo/DemoServlet
			// 把集合转换成响应对象
			UserInfo userInfo = new UserInfo(100, "测试帐号");
			ResponseInfo<UserInfo> result = new ResponseInfo<>(true, "查询数据成功");
			result.setData(userInfo);
			
			// 把响应对象转换成json字符串
			String jsonString = new Gson().toJson(result);

			System.out.println("响应数据： " + jsonString);

			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(jsonString);
			response.getWriter().flush();
			response.getWriter().close();
		}

	}

}
