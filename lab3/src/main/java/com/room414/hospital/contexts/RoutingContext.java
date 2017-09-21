package com.room414.hospital.contexts;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.Command;
import com.room414.hospital.commands.iternal.DefaultCommand;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.exceptions.StartUpException;
import com.room414.hospital.routing.Router;
import com.room414.hospital.routing.impl.RouterImpl;
import com.room414.hospital.routing.internal.RouteValue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class RoutingContext {
    private final static String COMMANDS_PACKAGE = "com.room414.hospital.commands";

    @Getter(lazy = true)
    private final Router router = new RouterImpl();

    @Getter(lazy = true)
    private final Command defaultCommand = new DefaultCommand();

    @Getter(lazy = true)
    private final Map<String, String> jspRoutes = loadJspRoutes();

    @Getter(lazy = true)
    private final Map<RouteValue, Command> routes = loadRoutes();

    private Map<String, String> loadJspRoutes() {
        return ImmutableMap.<String, String>builder()
                .put(toServletRoute(Routes.SIGN_IN), Views.SIGN_IN)
                .put(toServletRoute(Routes.SIGN_UP), Views.SIGN_UP)
                .put(toServletRoute(Routes.CREATE_DOCTOR), Views.DOCTOR)
                .put(toServletRoute(Routes.CREATE_DUTY), Views.DUTY)
                .put(toServletRoute(Routes.CREATE_PATIENT), Views.PATIENT)
                .build();
    }

    private Map<RouteValue, Command> loadRoutes() {
        Reflections reflections = new Reflections(COMMANDS_PACKAGE);
        Set<Class<?>> commandClasses = reflections.getTypesAnnotatedWith(Route.class);
        Map<RouteValue, Command> result = Maps.newHashMap();

        for (Class<?> commandClass : commandClasses) {
            Route route = commandClass.getAnnotation(Route.class);
            Command command = byClass(commandClass);
            result.put(toRouteValue(route), command);
        }

        return ImmutableMap.copyOf(result);
    }

    private RouteValue toRouteValue(Route route) {
        return RouteValue.of(route.method(), toServletRoute(route.path()));
    }

    private String toServletRoute(String route) {
        return Router.DISPATCHER_SERVLET_MAPPING + route;
    }

    private Command byClass(Class<?> clazz) {
        try {
            Object command = clazz.getConstructor().newInstance();

            if (command instanceof Command) {
                return (Command) command;
            }

            throw new StartUpException("Only classes that extends %s can have %s annotation", Command.class, Route.class);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new StartUpException("Command creation failed", e);
        }
    }
}
