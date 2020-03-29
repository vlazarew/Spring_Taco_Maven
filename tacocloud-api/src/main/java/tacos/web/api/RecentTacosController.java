package tacos.web.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tacos.Taco;
import tacos.data.TacoRepository;

import org.springframework.hateoas.Resources;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RepositoryRestController
public class RecentTacosController {

    private TacoRepository tacoRepository;

    public RecentTacosController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
    public ResponseEntity<Resources<TacoResource>> recentsTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepository.findAll(page).getContent();

        List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);

        Resources<TacoResource> recentResources = new Resources<TacoResource>(tacoResources);

        recentResources.add(linkTo(methodOn(RecentTacosController.class).recentsTacos()).withRel("recents"));

        return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }
}
