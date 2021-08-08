package com.example.actualproject;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@Getter
@Setter
public class ErrorResponse
{
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    //General error message about nature of error
    private String message;

    private LocalDateTime date = LocalDateTime.now();
    //Specific errors in API request processing
    private List<String> details;

    //Getter and setters
}
