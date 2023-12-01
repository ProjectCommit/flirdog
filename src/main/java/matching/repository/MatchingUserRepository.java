package matching.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.bean.User;

@Repository
public interface MatchingUserRepository extends JpaRepository<User, Object> {
	

}
