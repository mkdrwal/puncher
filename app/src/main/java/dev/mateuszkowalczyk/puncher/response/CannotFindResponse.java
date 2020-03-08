package dev.mateuszkowalczyk.puncher.response;

import javax.servlet.http.HttpServletResponse;

public class CannotFindResponse extends Response {

    public CannotFindResponse() {
        this("Cannot find element");
    }

    public CannotFindResponse(String message) {
        this.message = message;
        this.httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

}
