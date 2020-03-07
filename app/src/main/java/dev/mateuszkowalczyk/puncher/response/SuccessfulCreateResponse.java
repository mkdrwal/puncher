package dev.mateuszkowalczyk.puncher.response;

import javax.servlet.http.HttpServletResponse;

public class SuccessfulCreateResponse extends Response {

    public SuccessfulCreateResponse () {
        this("Created successful");
    }

    public SuccessfulCreateResponse(String message) {
        this.httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);

        this.message = message;
    }
}
