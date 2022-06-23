package lib.easymart.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.SubCategoryEntity;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long>{

	@Query("SELECT u FROM SubCategoryEntity u WHERE u.id IN :subCategoryList" )
	Set<SubCategoryEntity> findSubCategoryById(@Param("subCategoryList") List<Long> list);
	
}