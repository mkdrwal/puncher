package dev.mateuszkowalczyk.puncher.response;

public class Response {
    protected String message;

    public Response() {
        this.message = null;
    }

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
