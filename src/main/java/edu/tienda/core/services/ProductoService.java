package edu.tienda.core.services;

import java.util.List;
import edu.tienda.core.domain.Producto;


public interface ProductoService {
	public List<Producto> getProductos();
	public Integer saveProducto(Producto producto);
	public Producto getProductoById(Integer id);
	public String deleteAll();
}
