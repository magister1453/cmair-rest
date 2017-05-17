package za.co.cmair.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@ExposesResourceFor(UserView.class)
@RequestMapping("/userView")
public class UserViewRestAdapterImpl implements UserViewRestAdapter {
    private final UserViewRepository userViewRepository;

    @Autowired
    public UserViewRestAdapterImpl(UserViewRepository userViewRepository) {
        this.userViewRepository = userViewRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public Resources<Resource<UserView>> getUserViews() {
        List<UserView> userViewList = userViewRepository.findAll();
        Link selfLink = linkTo(methodOn(UserViewRestAdapter.class).userViews()).withSelfRel();
        List<Resource<UserView>> resourceList = userViewList.stream().map(userView -> customerToResource(customer)).collect(Collectors.toList());
        return new ResponseEntity<List<UserView>>(userViewList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Resource<UserView> getUserView(@PathVariable int id) {

        return customerToResource(userViewRepository.getCustomer(id));

    }

    private Resource<UserView> userViewToResource(UserView userView) {
        Link selfLink = linkTo(methodOn(UserViewRestAdapterImpl.class).getCustomer(customer.getId())).withSelfRel();

        return new Resource&lt;&gt;(customer, selfLink, invoiceLink, allInvoiceLink);

    }
}