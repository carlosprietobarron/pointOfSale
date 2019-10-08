package mx.com.candas.comercializadora.dao;
import java.util.List;

import mx.com.candas.comercializadora.modelos.*;

public interface iCategoriaDAO {
	public List<Categoria> listAll();
	public String insert(Categoria cat);
	public Categoria findById(long catId);
	public String update(Categoria cat);
	
}
