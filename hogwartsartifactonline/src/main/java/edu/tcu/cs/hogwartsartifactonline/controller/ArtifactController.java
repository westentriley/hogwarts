package edu.tcu.cs.hogwartsartifactonline.controller;

import edu.tcu.cs.hogwartsartifactonline.domain.Artifact;
import edu.tcu.cs.hogwartsartifactonline.domain.Result;
import edu.tcu.cs.hogwartsartifactonline.service.ArtifactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artifacts")
public class ArtifactController {

    private ArtifactService artifactService;

    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @GetMapping
    public Result findAll(){
        List<Artifact> all = artifactService.findAll();
        Result result = new Result(true, 200, "Find All Sucess", all);
        return result;
    }

    @GetMapping("/{artifactId}")
    public Result findById(@PathVariable String artifactId){
        return new Result(true, 200, "Find one Sucess", artifactService.findById(artifactId));
    }

    @PostMapping
    public Result save(@RequestBody Artifact newArtifact){
        artifactService.save(newArtifact);
        return new Result(true, 200, "Save Success");
    }

    @PutMapping("{artifactId}")
    public Result update(@PathVariable String artifactId, @RequestBody Artifact updatedArtifact){
        artifactService.update(artifactId, updatedArtifact);
        return new Result(true, 200, "Update Success");
    }

    @DeleteMapping("/{artifactId}")
    public Result delete(@PathVariable String artifactId){
        artifactService.delete(artifactId);
        return new Result(true, 200, "Delete Success");

    }
}
