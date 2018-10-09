package api;

import api.exceptions.ArgumentNotValidException;
import api.exceptions.RequestInvalidException;
import api.apiControllers.EmpresaApiController;
import api.dtos.EmpresaDto;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {
    private EmpresaApiController empresaApiController = new EmpresaApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                case PUT:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                case PATCH:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                case DELETE:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                default:
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(EmpresaApiController.EMPRESAS)) {

            response.setBody(this.empresaApiController.create((EmpresaDto) request.getBody()));
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod());
        }
    }

}
