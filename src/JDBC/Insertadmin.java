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
//������Ա���˺ź�������ӵ����ݿ���
/**
 * Servlet implementation class Insertadmin
 */
@WebServlet("/Insertadmin")
public class Insertadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertadmin() {
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
			String url="jdbc:mysql://localhost:3306/users";
			String username="root";//���ݿ��˺�
			String password="mly20000425";//���ݿ�����
			Connection conn=DriverManager.getConnection(url,username,password);
			String Adminid=request.getParameter("adminid");//�û�������û���
			String Password=request.getParameter("password1");//�û����������
			String sql="insert into admintable(adminid,adminpassword) values('"+Adminid+"','"+Password+"')";
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			request.getRequestDispatcher("zhucesuc.jsp").forward(request, response);
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
