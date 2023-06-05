package com.unicorn.indsaccrm.course;

import com.unicorn.indsaccrm.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="coursecard")
public class CourseCard extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(nullable=false)
    private UUID userid;

    @Column(nullable=false)
    @NotEmpty(message="{errors.title_required}")
    private String title;

    @Column(nullable=false)
    @NotEmpty(message="{errors.description_required}")
    private String description;

    @Column(nullable=false)
    @NotEmpty(message="{errors.courseLevel_required}")
    private String courseLevel;

    @Column(nullable=false)
    @NotEmpty(message="{errors.course_duration_required}")
    private String duration;

    @Column(nullable=false)
    @NotEmpty(message="{errors.price_required}")
    private String price;

    @Column
    private String discountprice;

    @Column
    private String status;
    @Column(nullable=false)
    @NotEmpty(message="{errors.tag_required}")
    private String tag;

    @Column
    private String rating;

    @Column
    private String image;

    @Column(nullable=false)
    @NotEmpty(message="{errors.category_required}")
    private String category;

    @Column(nullable=false)
    @NotEmpty(message="{errors.subcategory_required}")
    private String subcategory;

    @Column
    private String subsubcategory;

}
