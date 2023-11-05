package com.unicorn.indsaccrm.customize.uitheme;
import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "uitheme")
public class UITheme extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    private boolean darkMode;
    @Column
    private boolean headerOptionfixed;
    @Column
    private boolean noborder;
    @Column
    private boolean sidebarcollapsed;
    @Column
    private boolean sidebarFixed;
    @Column
    private boolean sidebarMini;
    @Column
    private boolean sidebarMiniMD;
    @Column
    private boolean sidebarMiniXS;
    @Column
    private boolean navFlatStyle;
    @Column
    private boolean navLegacyStyle;
    @Column
    private boolean navCompact;
    @Column
    private boolean navChildIndent;
    @Column
    private boolean navChildHideonCollapse;
    @Column
    private boolean disableHoverFocusAutoExpand;
    @Column
    private boolean footerFixed;
    @Column
    private boolean bodysmalltext;
    @Column
    private boolean navbarsmalltext;
    @Column
    private boolean brandsmalltext;
    @Column
    private boolean sidebarnavsmalltext;
    @Column
    private boolean footersmalltext;
    @Column
    private String navbarvariant;
    @Column
    private String accesscolorvariant;
    @Column
    private String darkSidebarVariant;
    @Column
    private String LightSidebarVariant;
    @Column
    private String brandLogoVariant;
}
