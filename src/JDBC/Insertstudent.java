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
//添加学生的信息到数据库中
/**
 * Servlet implementation class Insertstudent
 */
@WebServlet("/Insertstudent")
public class Insertstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/grade";
			String username="root";//数据库账号
			String password="mly20000425";//数据库密码
			Connection conn=DriverManager.getConnection(url,username,password);
			String studentid =request.getParameter("id");//用户输入的学号
			String studentname=request.getParameter("name");//用户输入的姓名
			String course=request.getParameter("course");
			String score=request.getParameter("score");
			String sql="insert into gradetable(studentid,studentname,course,score) values('"+studentid+"','"+studentname+"','"+course+"','"+score+"')";
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			request.getRequestDispatcher("StudentFind").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
