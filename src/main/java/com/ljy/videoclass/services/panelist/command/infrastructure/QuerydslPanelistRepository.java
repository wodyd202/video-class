package com.ljy.videoclass.services.panelist.command.infrastructure;

import com.ljy.videoclass.common.AbstractHibernateRepository;
import com.ljy.videoclass.services.panelist.domain.PanelistRepository;
import com.ljy.videoclass.services.panelist.domain.QPanelist;
import com.ljy.videoclass.services.panelist.domain.value.PanelistId;
import com.ljy.videoclass.services.panelist.domain.Panelist;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class QuerydslPanelistRepository extends AbstractHibernateRepository<Panelist> implements PanelistRepository {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Panelist> findById(PanelistId email) {
        Panelist panelist = jpaQueryFactory.selectFrom(QPanelist.panelist)
                                            .where(QPanelist.panelist.id().eq(email))
                                            .fetchFirst();
        log.info("load {} panelist into database : {}", email.get(), panelist);
        return Optional.ofNullable(panelist);
    }
}