package mx.com.candas.comercializadora.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.com.candas.comercializadora.dataaccess.*;
import mx.com.candas.comercializadora.modelos.Categoria;

/**
 *
 * @author Javier Vázquez
 */
public class CategoriaJDBCDAO implements iCategoriaDAO{

    @Override
    public List<Categoria> listAll() {
        
        Categoria cat;
        List<Categoria> listaCategorias = new ArrayList<>();
        try {
            DBMySql base = new DBMySql();
            String sql = "select * from categorias";
            PreparedStatement ps = base.getConn().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            //cambio para probar git
            System.out.println("otro cambio para probar git")
            while(rs.next()){
                cat = new Categoria();
                cat.setCategoriaId(rs.getInt("categoriaid"));
                cat.setNombreCat(rs.getString("nombrecat"));
                listaCategorias.add(cat);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en listAll de categorias: " + 
                    ex.getMessage());
        }
        
        return listaCategorias;
    }

	@Override
	public String insert(Categoria cat)  {
		// TODO Auto-generated method stub
		 String mensaje="";
		 try {
			DBMySql base = new DBMySql();
			 String sql = "INSERT INTO categorias (categoriaid, nombrecat ) "
			 		+ "           VALUES (?,?)";
			 System.out.println(sql);
			 PreparedStatement ps = base.getConn().prepareCall(sql);
			 ps.setLong(1, cat.getCategoriaId());
			 ps.setString(2,cat.getNombreCat());
			 
			 ps.executeUpdate();
			 base.desconectarDB();
			 mensaje="La categoria se creo correctamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensaje="Fallo en la creacion de categoria"+ e.getMessage();
		} 
                
		return mensaje;
	}

	@Override
	public Categoria findById(long catId) {
		// TODO Auto-generated method stub
		Categoria cat=null;
		try {
            DBMySql base = new DBMySql();
            String sql = "select * from categorias WHERE categoriaid = ? LIMIT 1";
            PreparedStatement ps = base.getConn().prepareCall(sql);
            ps.setLong(1, catId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                cat = new Categoria();
                cat.setCategoriaId(rs.getInt("categoriaid"));
                cat.setNombreCat(rs.getString("nombrecat"));
                //listaCategorias.add(cat);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en listAll de categorias: " + 
                    ex.getMessage());
        }
        
        return cat;
	}

	@Override
	public String update(Categoria cat) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 String mensaje="";
		 try {
			DBMySql base = new DBMySql();
			 String sql = "UPDATE categorias "
			 		+ "      SET NOMBRECAT = ? WHERE CATEGORIAID=?";
			 System.out.println(sql);
			 PreparedStatement ps = base.getConn().prepareCall(sql);
			 
			 ps.setString(1,cat.getNombreCat());
			 ps.setLong(2, cat.getCategoriaId());
			 
			 ps.executeUpdate();
			 base.desconectarDB();
			 mensaje="La categoria se ACTUALIZO correctamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensaje="Fallo en la ACTUALIZACION de categoria"+ e.getMessage();
		} 
               
		return mensaje;

	}
    
}
