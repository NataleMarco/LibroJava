package edu.tienda.core.persistance.respositories;

import edu.tienda.core.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRespository extends JpaRepository<ProductoEntity, Integer> {
}
