package br.com.examples.querydslexamples.util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;


public class QueryDslHelper {
    public void stringLike(BooleanBuilder builder, List<String> param, StringPath... fields) {
        if (isEmptyParams(param)) {
            return;
        }
        BooleanBuilder internalBuilder = new BooleanBuilder();
        param.forEach(value ->
                Stream.of(fields).forEach(field -> internalBuilder.or(field.toLowerCase().like("%" + value.toLowerCase() + "%")))
        );
        builder.and(internalBuilder);
    }

    public void stringEqual(BooleanBuilder builder, List<String> param, StringPath... fields) {
        if (isEmptyParams(param)) {
            return;
        }
        BooleanBuilder internalBuilder = new BooleanBuilder();
        param.forEach(value ->
                Stream.of(fields).forEach(field -> internalBuilder.or(field.equalsIgnoreCase(value)))
        );
        builder.and(internalBuilder);
    }

    public void localDateLoe(BooleanBuilder builder, List<String> param, DatePath<LocalDate> date) {
        if (isEmptyParams(param)) {
            return;
        }
        param.stream()
                .map(DateConverter::toLocalDate)
                .forEach(value -> builder.and(date.loe(value)));
    }

    public void localDateGoe(BooleanBuilder builder, List<String> param, DatePath<LocalDate> date) {
        if (isEmptyParams(param)) {
            return;
        }

        param.stream()
                .map(DateConverter::toLocalDate)
                .forEach(value -> builder.and(date.goe(value)));
    }

    public void numberInArray(BooleanBuilder builder, List<Long> ids, NumberPath<Long> id) {
        if (ids != null) {
            builder.and(id.in(ids));
        }
    }

    public void stringInArray(BooleanBuilder builder, List<String> ids, StringPath id) {
        if (ids != null) {
            builder.and(id.in(ids));
        }
    }

    private boolean isEmptyParams(List<String> params) {
        return params == null || params.isEmpty();
    }

}
