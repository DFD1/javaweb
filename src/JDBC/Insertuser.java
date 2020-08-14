package JDBC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
//将普通用户的数据添加到数据库中
/**
 * Servlet implementation class Insertuser
 */
@WebServlet("/Insertuser")
public class Insertuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/users";
			String username="root";//数据库账号
			String password="mly20000425";//数据库密码
			Connection conn=DriverManager.getConnection(url,username,password);
			String userName=request.getParameter("username1");//用户输入的用户名
			String Password=request.getParameter("password1");//用户输入的密码
			String sql="insert into userstable(Username,Password) values('"+userName+"','"+Password+"')";
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			request.getRequestDispatcher("zhucesuc.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
