package fatecfranca.edu.livrariatrabalho.model.repository;

import fatecfranca.edu.livrariatrabalho.model.entity.Livraria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrariaRepository extends JpaRepository<Livraria, Long> {
}