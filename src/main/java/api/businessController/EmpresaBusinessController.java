package api.businessController;

import api.daos.DaoFactory;
import api.dtos.EmpresaDto;
import api.entities.Empresa;
import api.exceptions.NotFoundException;

public class EmpresaBusinessController {

    public String create(EmpresaDto empresaDto) {
        Empresa empresa = new Empresa(empresaDto.getNombre(), empresaDto.getRazonSocial());
        DaoFactory.getFactory().getEmpresaDao().save(empresa);
        return empresa.getId();
    }

    public void updateNombre(String id, EmpresaDto empresaDto) {
        Empresa empresa = DaoFactory.getFactory().getEmpresaDao().read(id).orElseThrow(() -> new NotFoundException("Empresa id: " + id));
        empresa.setNombre(empresaDto.getNombre());
        DaoFactory.getFactory().getEmpresaDao().save(empresa);
    }
}
