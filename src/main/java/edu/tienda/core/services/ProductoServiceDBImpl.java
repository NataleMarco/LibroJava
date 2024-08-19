package edu.tienda.core.services;

import edu.tienda.core.domain.Producto;
import edu.tienda.core.exceptions.ResourceNotFoundException;
import edu.tienda.core.persistance.entities.ProductoEntity;
import edu.tienda.core.persistance.respositories.ProductosRespository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service("DB")
@Data
@NoArgsConstructor
@ConditionalOnProperty(
	value = "productos.estrategia",
	havingValue = "EN_DB")
public class ProductoServiceDBImpl implements ProductoService {

	@Autowired
	private ProductosRespository productosRespository;

	@Override
	public List<Producto> getProductos(){
		List<ProductoEntity> productosEntities = productosRespository.findAll();
		List<Producto> productos = new ArrayList<Producto>();
		for(ProductoEntity productoEntity : productosEntities){
			Producto producto = new Producto();
			producto.setId(productoEntity.getId());
			producto.setNombre(productoEntity.getNombre());
			producto.setPrecio(productoEntity.getPrecio());
			producto.setStock(productoEntity.getStock());
			productos.add(producto);
		}
		return productos;
	}
	@Override
	public Integer saveProducto(Producto producto) {
		ProductoEntity productoEntity = new ProductoEntity();
		productoEntity.setNombre(producto.getNombre());
		productoEntity.setPrecio(producto.getPrecio());
		productoEntity.setStock(producto.getStock());

		productoEntity = productosRespository.save(productoEntity);
		log.info("ID de producto entity " + productoEntity.getId());
		return productoEntity.getId();
	}

	@Override
	public Producto getProductoById(Integer id){
		List<Producto> productos = getProductos();
		return productos.stream()
		.filter(producto -> producto.getId()
			.equals(id))
		.findFirst()
		.orElseThrow(() -> new ResourceNotFoundException("Product with ID: " + id + " Not found")) ;
	}
	@Override
	public String deleteAll(){
		productosRespository.deleteAll();
		return "Un exito uwu";
	}
}
