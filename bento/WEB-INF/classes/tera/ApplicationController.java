package tera;

public interface ApplicationController{
    public RequestContext getRequest(Object request);

    public ResponseContext handleRequest(RequestContext req);

    public void handleResponse(RequestContext req,ResponseContext res);
}