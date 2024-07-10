package com.web.board.config;

import com.web.board.domain.Article;
import com.web.board.domain.ArticleComment;
import com.web.board.domain.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class DataRestConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig((config, cors) ->
                config
                        .exposeIdsFor(UserAccount.class)
//                        .exposeIdsFor(Article.class)
//                        .exposeIdsFor(ArticleComment.class)
//                        .exposeIdsFor(Hashtag.class)
        );
    }

}