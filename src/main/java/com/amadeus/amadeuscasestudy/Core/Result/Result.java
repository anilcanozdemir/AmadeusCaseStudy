package com.amadeus.amadeuscasestudy.Core.Result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "Result object which are the results of endpoints in controllers.")
public abstract class Result {
    @ApiModelProperty(
            value = "Whether the method is successful or not",
            name = "success")
    private boolean success;
    @ApiModelProperty(
            value = "The result message sent depending on whether the method was successful or not.",
            name = "message")
    private String message;


    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success,
                  String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
