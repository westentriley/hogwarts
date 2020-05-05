package edu.tcu.cs.hogwartsartifactonline.doa;

import edu.tcu.cs.hogwartsartifactonline.domain.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtifactDAO extends JpaRepository <Artifact, String> {
}
