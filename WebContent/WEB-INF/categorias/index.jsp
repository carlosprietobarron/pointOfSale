<%@page import="java.util.List"%>
<%@page import="mx.com.candas.comercializadora.modelos.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap Admin Theme v3</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<%= request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="<%= request.getContextPath() %>/css/styles.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <%
    	List<Categoria> listCategorias=(List<Categoria>)request.getAttribute("categorias");
    	String resultado="";
    	
    	if(request.getSession().getAttribute("opCategoria")!=null){
    		resultado=(String)request.getSession().getAttribute("opCategoria");
    		
    	}
    %>
  </head>
  <body>
<!--   	ENCABEZADO -->
	<jsp:include page="..\layouts\header.jsp"></jsp:include>
  	
    <div class="page-content">
    	<div class="row">
		<!--   	SIDEBAR -->
		<jsp:include page="..\layouts\Sidebar.jsp"></jsp:include>
		 
	   <div class="col-md-10">
	   		<%
	   			if(!resultado.isEmpty()){%>
	   				<div class="alert alert-success alert-dismissible fade-in" >
	   					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times</a>
	   				    <%=resultado %>
	   				</div>
	   			    <%request.getSession().removeAttribute("opCategoria"); %>
	   			
	   		<%		
	   			}
	   		%>
	   
	   		<div class="row">
	   			<div class="col-md-12">
	   				<div class="content-box-large">
		  				<div class="panel-heading">
							<div class="panel-title">CATEGORIAS</div>
							
							<div class="panel-options">
								<a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
								<a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
							</div>
						</div>
		  				<div class="panel-body">
		  					<table class="table">
				              <thead>
				                <tr>
				                  <th>ID Categoria</th>
				                  <th>Nombre Categoria</th>
				                  
				                </tr>
				              </thead>
				              <tbody>
				              <%
				                for(Categoria cat : listCategorias){
				              %>
				              		<tr>
				              			<td><%=cat.getCategoriaId() %></td>
				              			<td><%=cat.getNombreCat() %></td>
				              			<td>
				              				<%System.out.println(cat.getCategoriaId()); %>
				              				<a href="categorias?accion=editar&idCat=<%=cat.getCategoriaId()%>"class="btn btn-primary btn-xs">Editar</a>
				              			</td>
				              		</tr>
 				              <%} %> <%--cierra el for --%>
							  </tbody>
				            </table>
				            <a  href="categorias?accion=nuevo" class="btn btn-primary">Nueva Categoria</a>
		  				</div>
		  			</div>
	   			</div>
	   		</div>
	   </div>

		</div>
    </div>

<!--   	FOOTER -->
  <jsp:include page="..\layouts\Footer.jsp"></jsp:include>
  </body>
</html>