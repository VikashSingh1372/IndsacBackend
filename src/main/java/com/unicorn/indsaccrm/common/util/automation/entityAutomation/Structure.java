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
    /*
    * ********* NOTE ********
    * If you want create a directory then please insert the value like "/folder-name/folder-name"
    * Otherwise please insert the value is empty like ""
    * */
    public String rootPackage;
    public String entityName;
    public List<RequestField> requestFields;
}
