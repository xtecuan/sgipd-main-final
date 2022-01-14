package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Calificacion;
import sv.gob.mined.projects.sgipd.entities.DocenteResumen;
import sv.gob.mined.projects.sgipd.repositories.CalificacionRepository;
import sv.gob.mined.projects.sgipd.repositories.DocenteResumenRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class LlenarCierreWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(LlenarCierreWriter.class);
    @Inject
    DocenteResumenRepository docenteResumenRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: DocenteResumen List "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<DocenteResumen> resumen = (List<DocenteResumen>) item;
            docenteResumenRepository.mergeList(resumen);
        });
    }
}
