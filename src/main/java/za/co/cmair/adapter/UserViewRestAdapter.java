package za.co.cmair.adapter;

import org.springframework.http.ResponseEntity;
import za.co.cmair.core.domain.UserView;

import java.util.List;

/**
 * Created by marc.marais on 2017/05/10.
 */
public interface UserViewRestAdapter {
    public ResponseEntity<List<UserView>> userViews();
}
