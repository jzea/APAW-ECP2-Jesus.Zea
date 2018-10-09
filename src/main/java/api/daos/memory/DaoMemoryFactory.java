package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.EmpresaDao;

public class DaoMemoryFactory extends DaoFactory {

    private EmpresaDao empresaDao;

    @Override
    public EmpresaDao getEmpresaDao() {
        if (empresaDao == null) {
            empresaDao = new EmpresaDaoMemory();
        }
        return empresaDao;
    }
}
