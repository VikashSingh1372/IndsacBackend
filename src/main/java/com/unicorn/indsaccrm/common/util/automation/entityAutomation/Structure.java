package com.unicorn.indsaccrm.common.util.automation.entityAutomation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
class RequestField {
    String datatype;
    String value;
}
@Setter
@Getter
public class Structure {
    public String rootPackage;
    public String entityName;
    public List<RequestField> requestFields;
}
