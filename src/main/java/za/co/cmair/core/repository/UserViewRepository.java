package za.co.cmair.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cmair.core.domain.UserView;

/**
 * Created by marc.marais on 2017/05/10.
 */
public interface UserViewRepository extends JpaRepository<UserView, Long> {
}
