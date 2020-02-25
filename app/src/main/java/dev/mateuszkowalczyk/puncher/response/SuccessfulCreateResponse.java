package dev.mateuszkowalczyk.puncher.response;

import javax.servlet.http.HttpServletResponse;

public class SuccessfulCreateResponse extends Response {


    public SuccessfulCreateResponse () {
        this.message = "Created successful";

        this.httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
    }
}
