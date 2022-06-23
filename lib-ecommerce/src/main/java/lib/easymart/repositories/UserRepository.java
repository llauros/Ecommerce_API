package lib.easymart.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findByName(String name);
	
	Optional<UserEntity> findByEmail(String email);
	
	List<UserEntity> findByNameContainingIgnoreCaseOrderByName(String name);
	
	@Query(value = "SELECT * FROM tb_usuario tu "
			+ "WHERE LOWER(TRIM(tu.email)) = LOWER(TRIM(ifnull(:userEmail, tu.email))) "
			+ "AND LOWER(TRIM(tu.nome)) LIKE LOWER(TRIM(ifnull(:userName, tu.nome))) "
			+ "ORDER BY tu.nome",
			countQuery = "SELECT count(*) FROM tb_usuario tu "
					+ "WHERE LOWER(TRIM(tu.email)) = LOWER(TRIM(ifnull(:userEmail, tu.email))) "
					+ "AND LOWER(TRIM(tu.nome)) LIKE LOWER(TRIM(ifnull(:userName, tu.nome))) ",
					nativeQuery = true)
	Page<UserEntity> findUserByEmailAndName(
			@Param("userEmail") String userEmail,
			@Param("userName") String userName,
			Pageable pageable);
}
