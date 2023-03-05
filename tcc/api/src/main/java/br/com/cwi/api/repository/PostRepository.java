package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Post;
import br.com.cwi.api.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.id in (select post1.id from Post post1 join Usuario u on u.id = post1.usuario where u.id = :id) or p.id in (select post2.id from Post post2 where post2.usuario in (:listaAmigos)) order by dataPostagem desc")
    List<Post> findByPost(@Param("id") Long id, @Param("listaAmigos") List<Usuario> listaAmigos);

}
