package cart;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodsDao;
import po.Cart;
import po.Goods;


/**
 * Servlet implementation class CartSer
 */
@WebServlet("/CartSer")
public class CartSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String action;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out=response.getWriter();
		this.action=request.getParameter("action");
		
		if(action != null) {
			if(action.equals("add")) {
				//request.getRequestDispatcher("/success.jsp").forward(request, response);
				if(addToCart(request, response)) {
					//request.getRequestDispatcher("http:www.baidu.com").forward(request, response);
					request.getRequestDispatcher("success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			if(action.equals("show")) {
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			if(action.equals("delete")) {
				String sid=request.getParameter("id");
				System.out.println("ss  s  :"+sid);
				int id= Integer.parseInt(sid);
				request.getRequestDispatcher("/delete.jsp?&id="+id).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String num=request.getParameter("num");
		
		Goods item =GoodsDao.findGoodsById(Integer.parseInt(id));
		System.out.println(item);
		HttpSession session=request.getSession();
		if(session.getAttribute("cart") == null) {
			Cart cart=new Cart();
			session.setAttribute("cart", cart);
		}
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart.addGoods(item, Integer.parseInt(num))) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
