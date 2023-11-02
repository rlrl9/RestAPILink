package springrest.exam.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.domain.ComicActorModel;
import springrest.exam.entity.ComicActor;

import java.util.Collection;

@RestController
public class HateoasRestController {
    @GetMapping("/all")
    public CollectionModel<ComicActorModel> allActor(){
        ComicActorModel Dooly = new ComicActorModel();
        Dooly.setName("둘리");
        ComicActorModel Ddochi = new ComicActorModel();
        Ddochi.setName("또치");
        ComicActorModel Dauner = new ComicActorModel();
        Dauner.setName("도우너");
        Dooly.add(Link.of("http://localhost:8088/dooly").withRel("detail"));
        Ddochi.add(Link.of("http://localhost:8088/ddochi").withRel("detail"));
        Dauner.add(Link.of("http://localhost:8088/dauner").withRel("detail"));
        Collection<ComicActorModel> comicM = new java.util.ArrayList<>();
        comicM.add(Dooly);
        comicM.add(Ddochi);
        comicM.add(Dauner);
        CollectionModel<ComicActorModel> model = CollectionModel.of(comicM);
        return model;
    }
    @GetMapping("/dooly")
    public ResponseEntity<ComicActor> getDooly() {
        ComicActor ca= new ComicActor();
        ca.setName("둘리");
        ca.setAddr("쌍문동");
        ca.setImage("dooly.jpg");
        return ResponseEntity
                .ok()
                .body(ca);
    }
    @GetMapping("/ddochi")
    public ResponseEntity<ComicActor> getDdochi() {
        ComicActor ca= new ComicActor();
        ca.setName("또치");
        ca.setAddr("아프리카");
        ca.setImage("ddochi.jpg");
        return ResponseEntity
                .ok()
                .body(ca);
    }
    @GetMapping("/dauner")
    public ResponseEntity<ComicActor> getDauner() {
        ComicActor ca= new ComicActor();
        ca.setName("도우너");
        ca.setAddr("깐따삐아");
        ca.setImage("dauner.png");
        return ResponseEntity
                .ok()
                .body(ca);
    }
}
