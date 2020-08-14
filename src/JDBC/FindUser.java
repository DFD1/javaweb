package JDBC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
//从数据库中寻找当前账号密码是在普通用户表中还是管理员表中
/**
 * Servlet implementation class FindUser
 */
@WebServlet("/FindUser")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String []who=request.getParameterValues("check");
		//System.out.print(who[0]);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("驱动加载");
			String url="jdbc:mysql://localhost:3306/users";
			String username="root";//数据库账号
			String password="mly20000425";//数据库密码
			Connection conn=DriverManager.getConnection(url,username,password);
			String userName=request.getParameter("username");//用户输入的用户名
			String Password=request.getParameter("password");//用户输入的密码
			if(who[0].equals("管理员"))
			{
			String sql="select adminid from admintable where adminid='"+userName+"'";
			String sql1="select adminpassword from admintable where adminpassword='"+Password+"'";
			Statement stmt1=conn.createStatement();
			Statement stmt2=conn.createStatement();
			ResultSet rs=stmt1.executeQuery(sql);
			ResultSet rs1=stmt2.executeQuery(sql1);
			if(rs.next()&&rs1.next()) {
				request.getRequestDispatcher("shouye.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("adminfail.jsp").forward(request, response);
			}
			}
			else {
				String sql="select Username from userstable where Username='"+userName+"'";
				String sql1="select Password from userstable where Password='"+Password+"'";
				Statement stmt1=conn.createStatement();
				Statement stmt2=conn.createStatement();
				ResultSet rs=stmt1.executeQuery(sql);
				ResultSet rs1=stmt2.executeQuery(sql1);
				if(rs.next()&&rs1.next()) {
					request.getRequestDispatcher("shouye1.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("fail.jsp").forward(request, response);
				}
			}
			//System.out.println("123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
