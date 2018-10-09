package api.daos.memory;

import api.daos.EmpresaDao;
import api.entities.Empresa;

import java.util.HashMap;

public class EmpresaDaoMemory extends GenericDaoMemory<Empresa> implements EmpresaDao {

    public EmpresaDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Empresa empresa) {
        return empresa.getId();
    }

    @Override
    public void setId(Empresa empresa, String id) {
        empresa.setId(id);

    }
}
