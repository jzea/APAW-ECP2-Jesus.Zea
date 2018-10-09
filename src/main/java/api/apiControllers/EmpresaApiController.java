package api.apiControllers;

import api.businessController.EmpresaBusinessController;
import api.dtos.EmpresaDto;
import api.exceptions.ArgumentNotValidException;

public class EmpresaApiController {
    public static final String EMPRESAS = "/empresas";
    private EmpresaBusinessController empresaBusinessController = new EmpresaBusinessController();
    public String create(EmpresaDto empresaDto) {
        this.validate(empresaDto, "empresaDto");
        this.validate(empresaDto.getNombre(), "EmpresaDto Nombre");
        this.validate(empresaDto.getRazonSocial(), "EmpresaDto Razon Social");
        return this.empresaBusinessController.create(empresaDto);
    }
    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}
