package za.co.cmair.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.cmair.core.domain.UserView;
import za.co.cmair.core.repository.UserViewRepository;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by marc.marais on 2017/05/10.
 */
@Controller
@ExposesResourceFor(UserView.class)
@RequestMapping("/userView")
public class UserViewRestAdapterImpl implements UserViewRestAdapter {
    private final UserViewRepository userViewRepository;
    private EntityLinks entityLinks;

    @Autowired
    public UserViewRestAdapterImpl(UserViewRepository userViewRepository, EntityLinks entityLinks) {
        this.userViewRepository = userViewRepository;
        this.entityLinks = entityLinks;
    }

    @RequestMapping
    public ResponseEntity<List<UserView>> userViews() {
        List<UserView> userViewList = userViewRepository.findAll();
        userViewList.forEach(userView -> userView.add(linkTo(methodOn(UserViewRestAdapter.class).userViews()).withSelfRel()));
        return new ResponseEntity<List<UserView>>(userViewList, HttpStatus.OK);
    }
}