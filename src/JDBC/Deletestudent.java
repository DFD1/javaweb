package JDBC;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import message.Grade;
//从数据库删除学生的信息
/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/Deletestudent")
public class Deletestudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletestudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=String.valueOf(request.getParameter("id"));
		try {
			
			System.out.println(id);
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/grade";
			String username="root";
			String password="mly20000425";
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql="delete from gradetable where studentid='"+id+"'";
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		response.sendRedirect("StudentFind");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
