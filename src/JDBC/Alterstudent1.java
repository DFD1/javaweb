package JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import message.Grade;
//当管理员点击修改时将学生的姓名学号课程成绩显示到jsp页面上
/**
 * Servlet implementation class Alterstudent1
 */
@WebServlet("/Alterstudent1")
public class Alterstudent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alterstudent1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id=String.valueOf(request.getParameter("id"));
		System.out.println(id);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/grade";
		String username="root";//数据库账号
		String password="mly20000425";//数据库密码
		Connection conn=DriverManager.getConnection(url,username,password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from gradetable where studentid="+id);
		Grade grade=new Grade();
		while(rs.next())
		{
			
			grade.setStudentname(rs.getString("studentname"));
			grade.setStudentid(id);
			grade.setCourse(rs.getString("course"));
			grade.setScore(rs.getString("score"));
		}
		request.setAttribute("grade", grade);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		request.getRequestDispatcher("alter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
