package za.co.cmair.adapter;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import za.co.cmair.core.domain.UserView;

/**
 * Created by marc.marais on 2017/05/10.
 */
public interface UserViewRestAdapter {
    public Resources<Resource<UserView>> getUserViews();
    public Resource<UserView> getUserView(long id);
}
