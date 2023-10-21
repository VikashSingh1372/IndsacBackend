package com.unicorn.indsaccrm.common.util.automation.entityAutomation;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class StructureService {
    public String createEntityFile(Structure structure) {

        String entityName = structure.getEntityName();
        List<RequestField> requestFields = structure.getRequestFields();
        String rootPackage=structure.getRootPackage();

        String additionalFolderPath;
        if (rootPackage != null && !rootPackage.isEmpty()) {
            additionalFolderPath = "src/main/java/com/unicorn/indsaccrm"+rootPackage;
        } else {
            additionalFolderPath = "src/main/java/com/unicorn/indsaccrm";
        }

        // Get the entity path
        String entityPath = getEntityPath(entityName,additionalFolderPath);

        // Create entity file with the given entityName and columns
        String fileName = entityPath + File.separator + entityName + ".java";

        try {
            // Create the package directory
            File packageDir = new File(entityPath.toLowerCase());
            if (!packageDir.exists()) {
                packageDir.mkdirs();  // Create the package directory and any necessary parent directories
            }
            try (FileWriter fileWriter = new FileWriter(fileName)) {

                // Check rootPackage is null
                if (rootPackage != null) {
                    fileWriter.write("package com.unicorn.indsaccrm" + rootPackage.replaceFirst("[\\\\/]+", ".").replaceAll("[\\\\/]+", ".") + "." + entityName.toLowerCase() + ";\n");
                } else {
                    fileWriter.write("package com.unicorn.indsaccrm." + entityName.toLowerCase() + ";\n");
                }

                //import packages
                fileWriter.write("import com.unicorn.indsaccrm.common.config.Auditable;\n" +
                        "import lombok.*;\n" +
                        "import org.hibernate.annotations.GenericGenerator;\n" +
                        "import org.hibernate.annotations.Type;\n" +
                        "\n" +
                        "import javax.persistence.*;\n" +
                        "import java.util.UUID;\n");
                // Annotations
                fileWriter.write("@Getter\n" +
                        "@Setter\n" +
                        "@Builder\n" +
                        "@AllArgsConstructor\n" +
                        "@NoArgsConstructor\n" +
                        "@Entity\n" +
                        "@Table(name = \"" + entityName.toLowerCase() + "\")\n");
                // Entity Name
                fileWriter.write("public class " + entityName + " extends Auditable<String> {\n");
                fileWriter.write("    @Id\n" +
                        "    @GeneratedValue\n" +
                        "    @Type(type=\"org.hibernate.type.UUIDCharType\")\n" +
                        "    @GenericGenerator(\n" +
                        "            name = \"UUID\",\n" +
                        "            strategy = \"org.hibernate.id.UUIDGenerator\"\n" +
                        "    )\n" +
                        "    private UUID id;\n");
                // Iterate through requestFields to create columns
                for (RequestField field : requestFields) {
                    String fieldName = field.getValue();
                    String dataType = field.getDatatype();

                    // Below If condition check for the id's
                    if (dataType.contains("UUID")) {
                        // Add @Type and @Column for id fields
                        fileWriter.write("    @Column\n");
                        fileWriter.write("    @Type(type=\"org.hibernate.type.UUIDCharType\")\n");
                        fileWriter.write("    private UUID " + fieldName + ";\n");
                    } else {
                        // Add @Column for other fields
                        fileWriter.write("    @Column\n");
                        fileWriter.write("    private " + dataType + " " + fieldName + ";\n");
                    }
                }
                fileWriter.write("}\n");
                return "Entity file created successfully: " + fileName;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error creating entity file";
        }
    }

    private String getEntityPath(String entityName,String additionalFolderPath) {

        // This rootpath returns the "DriveName:\INDSAC\indsaccrmbe"
        String rootPath = System.getProperty("user.dir");

        // Create a File object for the rootPath
        File rootFile = new File(rootPath);

        // Create a File object for the additionalFolderPath relative to the rootPath
        File additionalFolder = new File(rootFile, additionalFolderPath);

        // Create a subfolder based on the entity name
        File entityFolder = new File(additionalFolder, entityName.toLowerCase());

        if (!entityFolder.exists()) {
            if (entityFolder.mkdirs()) {
                System.out.println("Created folder: " + entityFolder.getAbsolutePath());
            } else {
                System.err.println("Failed to create folder: " + entityFolder.getAbsolutePath());
            }
        }
        // Get the absolute path of the combined folder path
        return entityFolder.getAbsolutePath();
    }

}
