package dev.mateuszkowalczyk.puncher.response;

import javax.servlet.http.HttpServletResponse;

public class SuccessfulUpdateResponse extends Response {


    public SuccessfulUpdateResponse() {
        this.message = "Updated successful";

        this.httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
