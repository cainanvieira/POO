package fatecfranca.edu.produtodb.model.repository;

import fatecfranca.edu.produtodb.model.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {


}