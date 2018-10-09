package http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {

    public HttpResponse submit(HttpRequest request) {
        Logger logger = LogManager.getLogger(this.getClass());
        logger.info(request.toString());
        HttpResponse response = new Server().submit(request);
        logger.info(response);
        logger.info("---------------------------------------ooo----------------------------------------");
        if (response.getStatus().isError()) {
            throw new HttpException(response.getStatus(), response.getBody().toString());
        }
        return response;
    }
}
