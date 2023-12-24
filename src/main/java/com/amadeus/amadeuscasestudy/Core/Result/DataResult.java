package com.amadeus.amadeuscasestudy.Core.Result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Wrapping class for all DTOs and datas for to be returned as result endpoints.")
public abstract class DataResult<Data> extends Result {

    @ApiModelProperty(
            value = "Result data of the request.",
            name = "data")
    private Data data;

    public DataResult(boolean success) {
        super(success);
    }

    public DataResult(boolean success, Data data) {
        super(success);
        this.data = data;
    }

    public DataResult(boolean success, String message) {
        super(success, message);
    }

    public DataResult(boolean success, String message, Data data) {
        super(success, message);
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
