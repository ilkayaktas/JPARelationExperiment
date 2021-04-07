package com.ilkayaktas.jparelationexperiment.manytoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ilkayaktas on 7.04.2021 at 08:00.
 */

@Entity
@Table(name = "groupmembertest")
public class GroupMember {
    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="JPA_PK_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Getter
    @Setter
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private Long userId;

    @Column(name = "group_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private Long groupId;

    @Column(name = "createtime")
    @Getter
    @Setter
    private Long time;

    @ManyToOne
    @Getter
    @Setter
    private Group group;

    @ManyToOne
    @Getter
    @Setter
    private User user;

}
