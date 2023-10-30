package com.unicorn.indsaccrm.hrmManagement.onBoarding.documents;
import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documents")
public class Documents extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column
    private String documentname;
    @Column
    private DocumentType documenttype;
    private enum DocumentType{
        contract, policy, resume, performance_review
    }
    @Column
    private DocumentCategory documentcategory;
    private enum DocumentCategory{
        legal, HR, training
    }
    @Column
    private LocalDate uploaddate;
    @Column
    private LocalDate expirydate;
    @Column
    private String filepath;
    @Column
    private String description;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID employeeid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
