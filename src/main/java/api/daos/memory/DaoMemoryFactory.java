package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.EmpresaDao;
import api.daos.EventoDao;
public class DaoMemoryFactory extends DaoFactory {

    private EmpresaDao empresaDao;
    private EventoDao eventoDao;

    @Override
    public EmpresaDao getEmpresaDao() {
        if (empresaDao == null) {
            empresaDao = new EmpresaDaoMemory();
        }
        return empresaDao;
    }
    @Override
    public EventoDao eventoDao() {
        if (this.eventoDao == null ) {
            this.eventoDao = new EventoDaoMemory();
        }
        return this.eventoDao;
    }
}
