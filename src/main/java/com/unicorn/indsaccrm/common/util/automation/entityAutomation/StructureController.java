package com.unicorn.indsaccrm.common.util.automation.entityAutomation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/structures")
public class StructureController {
    private final StructureService structureService;
    private final StructureAutomation structureAutomation;
    @Autowired
    public StructureController(StructureService structureService, StructureAutomation structureAutomation) {
        this.structureService = structureService;
        this.structureAutomation = structureAutomation;
    }

    @PostMapping("/create")
    public String createStructure(@RequestBody Structure structure) throws FileNotFoundException {
        String entityFile = structureService.createEntityFile(structure);
        String remainingFiles=structureAutomation.createFiles(structure);
        return entityFile+" and "+remainingFiles;
    }
}
