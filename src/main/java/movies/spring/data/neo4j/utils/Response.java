package movies.spring.data.neo4j.utils;

import lombok.Data;

@Data
public class Response<T> {
    private static final String SUCCESS="success";
    private static final String ERROR="error";
    private static final Integer success_code=200;
    private static final Integer error_code=500;
    private Integer code;
    private T content;
    private String status;

    public static<T> Response success(T t){
        Response<T> response=new Response<>();
        response.setCode(success_code);
        response.setContent(t);
        response.setStatus(SUCCESS);
        return response;
    }

    public static<T> Response error(T  t){
        Response<T> response=new Response<>();
        response.setCode(error_code);
        response.setContent(t);
        response.setStatus(ERROR);
        return response;
    }
}
