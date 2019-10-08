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
    %>
  </head>
  <%
  	String tipoForm=(String)request.getAttribute("tipoForm");
  
  	Categoria cat=null;
  	
  	if(tipoForm.equals("actualizar")){
  		
  		cat=(Categoria)request.getAttribute("categoria");
  		
  	}
  	
  %>
  <body>
<!--   	ENCABEZADO -->
	<jsp:include page="..\layouts\header.jsp"></jsp:include>
  	
    <div class="page-content">
    	<div class="row">
		<!--   	SIDEBAR -->
		<jsp:include page="..\layouts\Sidebar.jsp"></jsp:include>
		 
	   <div class="col-md-10">
	   		<div class="content-box-large">
	   			<div class="panel-heading">
	   				<div class="panel-tittle">Crear Categoria</div>
	   			</div>
	   			<div class="panel-body">
<!-- 	   Formulario con bootstrap -->
				<div class="row">
					<div class="col-md-6">
						<form class="form-hotizontal" role="form" action="categorias" method="post">
							<div class="form-group">
								<input type="hidden" name="accion" value="<%=tipoForm%>">
							<div class="col-sm-12">
								<input type="number" class="form-control" name="idCat" placeholder="Clave Categoria"
									value="<% if (tipoForm.equals("actualizar")){out.print(cat.getCategoriaId());} %>" >
							</div>	
							</div>
							<div class="form-group">
	<!-- 							<input type="hidden" name="accion" value="crear"> -->
							<div class="col-sm-12">
								<input type="text" class="form-control" name="nombreCat" placeholder="nombre categoria"
								 value="<% if (tipoForm.equals("actualizar")){out.print(cat.getNombreCat());} %>">
							</div>	
							</div>
							<div class="form-group">
								<div class="col-sm-10">
									<button type=submmit class="btn btn-primary"><%=tipoForm %></button>
								</div>
							</div>
						
						</form>
					
					</div>
				</div>
	
				</div> 
				<!-- panel body end -->
<!-- 			fin del formulario -->
			</div> <!--  fin del box -->
	   </div>

		</div>
    </div>

<!--   	FOOTER -->
  <jsp:include page="..\layouts\Footer.jsp"></jsp:include>
  </body>
</html>