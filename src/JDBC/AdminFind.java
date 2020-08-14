package JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.Grade;
//当使用管理员账号登录时从数据库获取学生数据显示到jsp页面上
/**
 * Servlet implementation class Findstudent
 */
@WebServlet("/AdminFind")
public class AdminFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFind() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("驱动加载");
			String url="jdbc:mysql://localhost:3306/grade";
			String username="root";//数据库账号
			String password="mly20000425";//数据库密码
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement stmt=conn.createStatement();
			String sql="select * from gradetable ";
			ResultSet rs=stmt.executeQuery(sql);
			List<Grade>list=new ArrayList<Grade>();
			while(rs.next())
			{
				Grade grade=new Grade();
				grade.setStudentid(rs.getString("studentid"));
				grade.setStudentname(rs.getString("studentname"));
				System.out.print(grade.getStudentname());
				grade.setCourse(rs.getString("course"));
				grade.setScore(rs.getString("score"));
				list.add(grade);
			}
			request.setAttribute("list", list);
			rs.close();
			stmt.close();
			conn.close();
			//System.out.println("123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("student_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
