package mx.com.candas.comercializadora.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.candas.comercializadora.dao.CategoriaJDBCDAO;
import mx.com.candas.comercializadora.modelos.Categoria;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoriasController
 */
@WebServlet("/categorias")
public class CategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	if (request.getParameter("accion")!=null){
    	
    		switch (request.getParameter("accion")) {
			case "nuevo":
				formnuevo(request,response);
				break;
			case "editar":
				formEditar(request,response);
				break;
//			default:
//				break;
			}
    		
    	}else{
    	
         CategoriaJDBCDAO daoCategoria = new CategoriaJDBCDAO();
        
         List<Categoria> listaCategorias = daoCategoria.listAll();
        
         request.setAttribute("categorias", listaCategorias);
        
        request.getRequestDispatcher("/WEB-INF/categorias/index.jsp").
                forward(request, response);
    	}
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("accion")!=null){
	    	
    		switch (request.getParameter("accion")) {
			case "crear":
				insertarCategoria(request,response);
				break;
			case "borrar":
				
				break;
			case "actualizar":
				actualizarCategoria(request, response);
				break;
//			default:
//				break;
			}
    		
    	}else{
		doGet(request, response);
		}
	}
	
	

	private void actualizarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long 	claveCat=Long.parseLong(request.getParameter("idCat"));
		String nombreCat=request.getParameter("nombreCat");
		Categoria cat=new Categoria();
		cat.setCategoriaId(claveCat);
		cat.setNombreCat(nombreCat);
		CategoriaJDBCDAO catDao=new CategoriaJDBCDAO();
		String msj = catDao.update(cat);
		
		request.getSession().setAttribute("opCategoria", msj);
		System.out.println(msj);
		response.sendRedirect("/sistema-comercializadora/categorias");

		
	}

	private void formnuevo(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("tipoForm", "crear");
		request.getRequestDispatcher("/WEB-INF/categorias/form.jsp").forward(request, response);
		
	}
	
	private void formEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("idCat"));
		Long idCat= Long.parseLong(request.getParameter("idCat"));
		
		CategoriaJDBCDAO  catDao=new CategoriaJDBCDAO();
		
		Categoria cat= catDao.findById(idCat);
		
		if(cat!=null){
			request.setAttribute("tipoForm", "actualizar");
			request.setAttribute("categoria", cat);
			request.getRequestDispatcher("/WEB-INF/categorias/form.jsp").forward(request, response);
		}
	}

	private void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long 	claveCat=Long.parseLong(request.getParameter("idCat"));
		String nombreCat=request.getParameter("nombreCat");
		Categoria cat=new Categoria();
		cat.setCategoriaId(claveCat);
		cat.setNombreCat(nombreCat);
		CategoriaJDBCDAO catDao=new CategoriaJDBCDAO();
		String msj = catDao.insert(cat);
		
		request.getSession().setAttribute("opCategoria", msj);
		System.out.println(msj);
		response.sendRedirect("/sistema-comercializadora/categorias");
	}
}
