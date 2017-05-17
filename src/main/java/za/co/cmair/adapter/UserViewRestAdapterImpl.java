package za.co.cmair.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.cmair.core.domain.UserView;
import za.co.cmair.core.repository.UserViewRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by marc.marais on 2017/05/10.
 */
@RestController
@RequestMapping(value = "/api/uservew", produces = "application/hal+json")
public class UserViewRestAdapterImpl implements UserViewRestAdapter {
    private final UserViewRepository userViewRepository;

    @Autowired
    public UserViewRestAdapterImpl(UserViewRepository userViewRepository) {
        this.userViewRepository = userViewRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public Resources<Resource<UserView>> getUserViews() {
        return userViewToResource(userViewRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Resource<UserView> getUserView(@PathVariable long id) {
        return userViewToResource(userViewRepository.findOne(id));
    }

    private Resources<Resource<UserView>> userViewToResource(List<UserView> userViews) {
        Link selfLink = linkTo(methodOn(UserViewRestAdapterImpl.class).getUserViews()).withSelfRel();
        List<Resource<UserView>> customerViewResources = userViews.stream().map(this::userViewToResource).collect(Collectors.toList());
        return new Resources<>(customerViewResources, selfLink);

    }

    private Resource<UserView> userViewToResource(UserView userView) {
        Link selfLink = linkTo(methodOn(UserViewRestAdapterImpl.class).getUserView(userView.getUserViewid())).withSelfRel();
        return new Resource<>(userView, selfLink);

    }
}