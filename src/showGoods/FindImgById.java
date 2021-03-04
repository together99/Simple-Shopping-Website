package showGoods;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;

/**
 * Servlet implementation class FindImgById
 */
@WebServlet("/FindImgById")
public class FindImgById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindImgById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		byte img[]=null;
		//String strid=request.getParameter("id");
		//System.out.println(strid);
		int id=Integer.parseInt(request.getParameter("id"));
		//int id=1;
		img=GoodsDao.findGoodsById(id).getImages();
		
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(img);
		outputStream.flush();//排出流中所有数据
		outputStream.close();//关闭流
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
