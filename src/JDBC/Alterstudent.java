package JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//修改学生成绩
/**
 * Servlet implementation class Alterstudent
 */
@WebServlet("/Alterstudent")
public class Alterstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alterstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/grade";
		String username="root";//数据库账号
		String password="mly20000425";//数据库密码
		Connection conn=DriverManager.getConnection(url,username,password);
		String studentid=request.getParameter("id");
		String course=request.getParameter("course");
		String score=request.getParameter("score");
		String sql="update gradetable set score='"+score+"' where studentid='"+studentid+"'";
		Statement stmt=conn.createStatement();
		stmt.executeUpdate(sql);
		response.sendRedirect("StudentFind");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
