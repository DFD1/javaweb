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
//�����ݿ���Ѱ�ҵ�ǰ�˺�����������ͨ�û����л��ǹ���Ա����
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
			//System.out.println("��������");
			String url="jdbc:mysql://localhost:3306/users";
			String username="root";//���ݿ��˺�
			String password="mly20000425";//���ݿ�����
			Connection conn=DriverManager.getConnection(url,username,password);
			String userName=request.getParameter("username");//�û�������û���
			String Password=request.getParameter("password");//�û����������
			if(who[0].equals("����Ա"))
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
