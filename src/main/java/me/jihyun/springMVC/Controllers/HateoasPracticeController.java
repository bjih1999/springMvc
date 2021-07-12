package me.jihyun.springMVC.Controllers;

import me.jihyun.springMVC.Models.Hello;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class HateoasPracticeController {

    @GetMapping("/hateoas")
    public EntityModel<Hello> hello() {
        Hello hello = new Hello();
        hello.setPrefix("Hey,");
        hello.setName("Jihyun");

        EntityModel<Hello> helloResource = EntityModel.of(hello);
        helloResource.add(linkTo(methodOn(HateoasPracticeController.class).hello()).withSelfRel());

        return helloResource;
    }
}
