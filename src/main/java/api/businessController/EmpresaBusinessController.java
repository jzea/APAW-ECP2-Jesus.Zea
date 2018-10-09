package api.businessController;

import api.daos.DaoFactory;
import api.dtos.EmpresaDto;
import api.entities.Empresa;
public class EmpresaBusinessController {
    public String create(EmpresaDto empresaDto) {
        Empresa empresa = new Empresa(empresaDto.getNombre(),empresaDto.getRazonSocial());
        DaoFactory.getFactory().getEmpresaDao().save(empresa);
        return empresa.getId();
    }
}
