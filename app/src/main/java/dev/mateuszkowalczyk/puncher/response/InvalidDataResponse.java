package dev.mateuszkowalczyk.puncher.response;

public class InvalidDataResponse extends Response{

    public InvalidDataResponse() {
        this.message = "Invalid data";
    }

    public InvalidDataResponse(String message) {
        this.message = message;
    }
}
