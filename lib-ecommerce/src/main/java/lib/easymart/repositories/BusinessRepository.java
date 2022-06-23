package lib.easymart.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.BusinessEntity;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessEntity, Long> {

	@Query("SELECT b FROM BusinessEntity b WHERE b.ownerUser.id = :idUser")
	Optional<BusinessEntity> findBusinessByOwnerUser(@Param("idUser") Long idUser);
}
