package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.TodoDTO;
import service.TodoListService;
import service.TodoListServiceImpl;

/**
 * Servlet implementation class TodoListServlet
 */
@WebServlet("/todolist/*")
public class TodoListServlet extends HttpServlet {
	private TodoListService service = new TodoListServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		resp.getWriter().print("pathInfo = " + pathInfo);
		switch (pathInfo) {
		case "/": // 顯示 Todo List 首頁
			List<TodoDTO> todos = service.findAllTodos();
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/todolist.jsp");
			req.setAttribute("todos", todos);
			rd.forward(req, resp);
			return;

		case "/update": // 修改 Todo 紀錄
			String id = req.getParameter("id");
			String completed = req.getParameter("checked");
			String text = req.getParameter("text");

			if (completed != null) {
				// 修改 Todo 完成狀態

			} else if (text != null) {
				// 修改 Todo 內容

			}

			break;
		case "/delete": // 刪除某一項 Todo 紀錄

			break;
		default: // 錯誤路徑
			resp.getWriter().print("path error");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if (!pathInfo.equals("/add")) {
			// 錯誤路徑
			resp.getWriter().print("path error");
			return;
		}
		// 進行新增程序

	}
}
