package ar.edu.undec.tpseminario2.repository;

import ar.edu.undec.tpseminario2.entity.Panes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanesRepository extends JpaRepository<Panes, Integer> {

    public List<Panes> findPanesByEstadoEquals(Byte estate);
}
