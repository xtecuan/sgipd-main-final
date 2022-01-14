package sv.gob.mined.projects.sgipd.jobs.steps.criterios;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Calificacion;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.repositories.CalificacionRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class Criterio4bProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(Criterio4bProcessor.class);
    @Inject
    CalificacionRepository calificacionRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public List<Calificacion> processItem(Object o) throws Exception {
        Docente d = (Docente) o;
        LOG.info("Processing: "+d.getIdSigobsolUsuario()+ " "+d.getNombreCompleto()+" NIP: "+d.getNip());
        return calificacionRepository.fromDocente_2_CalificacionListCriterio4b(d,currentUser);
    }
}
