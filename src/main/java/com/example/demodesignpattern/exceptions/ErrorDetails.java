package com.example.demodesignpattern.exceptions;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@Data
public class ErrorDetails {
  private Date timestamp;
  private String message;
  private String path;

  public ErrorDetails(Date timestamp, String message, String path) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.path = path;
  }

  public ErrorDetails() {}
}
