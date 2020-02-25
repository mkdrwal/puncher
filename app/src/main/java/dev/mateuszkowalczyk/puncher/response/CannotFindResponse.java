package dev.mateuszkowalczyk.puncher.response;

import javax.servlet.http.HttpServletResponse;

public class CannotFindResponse extends Response {

    public CannotFindResponse() {
        this.message = "Cannot find element";
        this.httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

}
