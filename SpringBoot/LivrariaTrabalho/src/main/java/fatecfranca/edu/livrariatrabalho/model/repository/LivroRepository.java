package fatecfranca.edu.livrariatrabalho.model.repository;

import fatecfranca.edu.livrariatrabalho.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}