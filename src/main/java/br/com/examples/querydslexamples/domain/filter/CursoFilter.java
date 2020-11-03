package br.com.examples.querydslexamples.domain.filter;

import br.com.examples.querydslexamples.domain.model.QCurso;
import br.com.examples.querydslexamples.util.QueryDslHelper;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;

import java.util.List;


public class CursoFilter {
    public static BooleanBuilder toPredicate(MultiValueMap<String, String> parameters){
        QueryDslHelper queryDslHelper = new QueryDslHelper();
        BooleanBuilder builder = new BooleanBuilder();

        if(parameters.isEmpty()){
            return builder;
        }

        QCurso qCurso = QCurso.curso;
        queryDslHelper.stringLike(builder, parameters.get("nome"), qCurso.nome);
        queryDslHelper.stringLike(builder, parameters.get("sigla"), qCurso.sigla);
        queryDslHelper.localDateGoe(builder, parameters.get("dtInicio"), qCurso.dtInicio);
        return builder;
    }

}
