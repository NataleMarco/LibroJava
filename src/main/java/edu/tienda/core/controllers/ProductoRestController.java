package edu.tienda.core.controllers;


import edu.tienda.core.domain.Producto;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.tienda.core.services.ProductoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/tienda/productos")
public class ProductoRestController{

	@Qualifier("DB")
	@Autowired
	private ProductoService productoService;

	@GetMapping()
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.ok(productoService.getProductos());
	}

	@PostMapping()
	public ResponseEntity<?> saveProducto(@RequestBody Producto producto){
		Integer idProductoGuardado = productoService.saveProducto(producto);
		Producto productoGuardado  = getProductById(idProductoGuardado);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(idProductoGuardado)
			.toUri();
		return ResponseEntity.created(location).body(productoGuardado);
	}
	@GetMapping("/{id}")
	public Producto getProductById(@PathVariable Integer id) {
		Producto producto = productoService.getProductoById(id);
		return producto;
	}
	@DeleteMapping("/all")
	public String deleteAll(){
		return productoService.deleteAll();
	}

}

