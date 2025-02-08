package tr.com.api_labianco.spring_security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.com.api_labianco.spring_security.models.ERole;
import tr.com.api_labianco.spring_security.models.Role;

import java.util.Optional;


public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
