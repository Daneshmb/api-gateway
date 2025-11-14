package com.dextris.filter;

import jakarta.validation.constraints.Max;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndPoints= List.of(
            "/v1/security/register",
            "/v1/security/login",
            "/v1/security/welcome"
    );

    public Predicate<ServerHttpRequest> isSecured=
            request ->
                     openApiEndPoints
                    .stream()
                    .noneMatch(uri ->request.getURI().getPath().contains(uri));
}
