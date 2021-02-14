package com.acme.customers.api.models.db.common;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20201029-rNA", date="2021-01-21T19:12:22")
@StaticMetamodel(BaseEntity.class)
public class BaseEntity_ { 

    public static volatile SingularAttribute<BaseEntity, Date> createdAt;
    public static volatile SingularAttribute<BaseEntity, String> id;
    public static volatile SingularAttribute<BaseEntity, Date> updatedAt;

}