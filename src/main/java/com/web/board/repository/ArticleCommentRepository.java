package com.web.board.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.web.board.controller.projection.ArticleCommentProjection;
import com.web.board.domain.Article;
import com.web.board.domain.ArticleComment;
import com.web.board.domain.QArticle;
import com.web.board.domain.QArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ArticleCommentProjection.class)
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        /* ArticleComment 엔티티에 있는 기본 검색 기능 추가해줌 */
        QuerydslPredicateExecutor<Article>,
        /* 입맛에 맞게 검색 기능 구현 하기 위해 추가해줌 */
        QuerydslBinderCustomizer<QArticleComment> {


    /* _ : Article 의 Id 로 찾는다. (연관관계 안으로 타고 들어갈 때 사용)
    * 게시글 아이디를 통해서 그 게시글 아이디에
    * 해당하는 댓글들의 리스트를 뽑아낸다. (게시글로 댓글을 검색)
    *  */
    List<ArticleComment> findByArticle_Id(Long articleId);
    void deleteByIdAndUserAccount_UserId(Long articleCommentId, String userId);

    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        // 리스팅을 하지 않는 프로퍼티는 검색에서 제외시키기 위해 true 로 설정
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.content, root.createdAt, root.createdBy);
        // exact match 룰 변경
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // like '%${v}$%'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }

}
