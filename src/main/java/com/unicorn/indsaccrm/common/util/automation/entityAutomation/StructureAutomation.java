package com.unicorn.indsaccrm.common.util.automation.entityAutomation;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StructureAutomation {
    public  String createFiles(Structure structure) throws FileNotFoundException {

        String entityVariableCapital = structure.getEntityName();
        String entityVariable = Character.toLowerCase(entityVariableCapital.charAt(0)) + entityVariableCapital.substring(1);
        String rootPackage=structure.getRootPackage();

        //This rootpath returns the "DriveName:\INDSAC\indsaccrmbe"
        String rootPath = System.getProperty("user.dir");
        System.out.println("rootPath: "+rootPath);

        // Check additionalFolderPath value is null or not
        String additionalFolderPath;
        if (rootPackage != null && !rootPackage.isEmpty()) {
            additionalFolderPath = "src/main/java/com/unicorn/indsaccrm"+rootPackage+"/"+entityVariableCapital.toLowerCase();
        } else {
            additionalFolderPath = "src/main/java/com/unicorn/indsaccrm/"+entityVariableCapital.toLowerCase();
        }

        // Check rootPackage value is null or not
        String packageImportInClass;
        if (rootPackage != null && !rootPackage.isEmpty()) {
            packageImportInClass="package com.unicorn.indsaccrm" + rootPackage.replaceFirst("[\\\\/]+", ".").replaceAll("[\\\\/]+", ".") + ".";
        } else {
            packageImportInClass="package com.unicorn.indsaccrm.";
        }

        // Create a File object for the rootPath
        File rootFile = new File(rootPath);

        // Create a File object for the additionalFolderPath relative to the rootPath
        File additionalFolder = new File(rootFile, additionalFolderPath);

        // Get the absolute path of the combined folder path
        String entityPath = additionalFolder.getAbsolutePath();

        // Print the result
        System.out.println("Combined Path: " + entityPath);

        //Controller
        String controllerFileName = entityVariableCapital + "Controller.java";
        createControllerFile(entityPath, controllerFileName, getControllerContent(entityVariableCapital,entityVariable,packageImportInClass));

        //Service
        String serviceFileName = entityVariableCapital + "Service.java";
        createServiceFile(entityPath, serviceFileName, getServiceContent(entityVariableCapital,entityVariable,packageImportInClass));

        //ServiceImpl
        String serviceImplFileName = entityVariableCapital + "ServiceImpl.java";
        createServiceImplFile(entityPath, serviceImplFileName, getServiceImplContent(entityVariableCapital,entityVariable,packageImportInClass));

        //Repository
        String repositoryFileName = entityVariableCapital + "Repository.java";
        createRepositoryFile(entityPath, repositoryFileName, getRepositoryContent(entityVariableCapital,entityVariable,packageImportInClass));
        return "\n Remaining Files also successfully created";
    }

     private static void createControllerFile(String path, String fileName, String content) {
        Path filePath = Paths.get(path, fileName);
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, content.getBytes());
            System.out.println("Controller File created successfully: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createServiceFile(String path, String fileName, String content) {
        Path filePath = Paths.get(path, fileName);
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, content.getBytes());
            System.out.println("Service File created successfully: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createServiceImplFile(String path, String fileName, String content) {
        Path filePath = Paths.get(path, fileName);
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, content.getBytes());
            System.out.println("ServiceImpl File created successfully: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createRepositoryFile(String path, String fileName, String content) {
        Path filePath = Paths.get(path, fileName);
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, content.getBytes());
            System.out.println("Repository File created successfully: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static String getControllerContent(String entityVariableCapital,String entityVariable,String packageImportInClass) {
        return  ""+packageImportInClass+""+entityVariableCapital.toLowerCase()+";\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.http.ResponseEntity;\n" +
                "import org.springframework.stereotype.Controller;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "import java.util.UUID;\n" +
                "@CrossOrigin\n" +
                "@Controller\n" +
                "@RequestMapping(\"/"+entityVariableCapital.toLowerCase()+"\")\n" +
                "public class " + entityVariableCapital + "Controller {\n" +
                "    @Autowired\n" +
                "    private " + entityVariableCapital + "Service " + entityVariable + "Service;\n" +
                "    @PostMapping\n" +
                "    ResponseEntity<?> create"+entityVariableCapital+"(@RequestBody " + entityVariableCapital + " " + entityVariable + ") throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariable + "Service.save"+entityVariableCapital+"(" + entityVariable + "));\n" +
                "    }\n" +
                "    @GetMapping(\"/all\")\n" +
                "    ResponseEntity<?> getAll"+entityVariableCapital+"() throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariable + "Service.getAll"+entityVariableCapital+"s());\n" +
                "    }\n" +
                "    @GetMapping(\"/{id}\")\n" +
                "    ResponseEntity<?> get"+entityVariableCapital+"ByID(@PathVariable UUID id) throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariable + "Service.get"+entityVariableCapital+"ById(id));\n" +
                "    }\n" +
                "}";
    }

    private static String getServiceContent(String entityVariableCapital,String entityVariable,String packageImportInClass){
        return ""+packageImportInClass+""+entityVariableCapital.toLowerCase()+";\n" +
                "import org.springframework.http.ResponseEntity;\n" +
                "import java.util.List;\n" +
                "import java.util.Optional;\n" +
                "import java.util.UUID;\n"+
                "public interface " + entityVariableCapital + "Service {\n" +
                "    ResponseEntity<?> save"+entityVariableCapital+"("+ entityVariableCapital+" "+entityVariable+");\n"+
                "    ResponseEntity<List<"+entityVariableCapital+">>"+" "+"getAll"+entityVariableCapital+"s();\n"+
                "    ResponseEntity<Optional<"+entityVariableCapital+">>"+" "+"get"+entityVariableCapital+"ById(UUID id);\n"+
                "}";
    }

    private static String getServiceImplContent(String entityVariableCapital,String entityVariable,String packageImportInClass) {
        return ""+packageImportInClass+""+entityVariableCapital.toLowerCase()+";\n" +
                "import org.slf4j.Logger;\n" +
                "import org.slf4j.LoggerFactory;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.http.ResponseEntity;\n" +
                "import org.springframework.stereotype.Service;\n\n" +
                "import java.util.List;\n" +
                "import java.util.Optional;\n" +
                "import java.util.UUID;\n\n" +
                "@Service\n" +
                "public class " + entityVariableCapital + "ServiceImpl implements " + entityVariableCapital + "Service {\n" +
                "   @Autowired\n" +
                "   "+entityVariableCapital + "Repository " + entityVariable + "Repository;\n" +
                "   Logger logger = LoggerFactory.getLogger("+ entityVariableCapital +"ServiceImpl.class);\n" +
                "   @Override\n" +
                "   public ResponseEntity<?> save" + entityVariableCapital + "(" + entityVariableCapital + " " + entityVariable + ") {\n" +
                "      logger.info(\"Save " + entityVariableCapital + " from save" + entityVariableCapital + " Successully\");\n" +
                "      return ResponseEntity.ok(" + entityVariable + "Repository.save(" + entityVariable + "));\n" +
                "   }\n" +
                "   @Override\n" +
                "   public ResponseEntity<List<" + entityVariableCapital + ">> getAll" + entityVariableCapital + "s() {\n" +
                "      logger.info(\"GET all " + entityVariableCapital + "s from getAll" + entityVariableCapital + "s Successully\");\n" +
                "      return ResponseEntity.ok(" + entityVariable + "Repository.findAll());\n" +
                "   }\n" +
                "   @Override\n" +
                "   public ResponseEntity<Optional<" + entityVariableCapital + ">> get" + entityVariableCapital + "ById(UUID id) {\n" +
                "      logger.info(\"GET " + entityVariableCapital + " By Id from get" + entityVariableCapital + "ById Successfully\");\n" +
                "      return ResponseEntity.ok(" + entityVariable + "Repository.findById(id));\n" +
                "   }\n"+
                "}";
    }

    private static String getRepositoryContent(String entityVariableCapital,String entityVariable,String packageImportInClass) {
        return ""+packageImportInClass+""+entityVariableCapital.toLowerCase()+";\n" +
                "import org.springframework.data.jpa.repository.JpaRepository;\n"+
                "import java.util.UUID;\n" +
                "public interface "+entityVariableCapital+"Repository extends JpaRepository<"+entityVariableCapital+",UUID> {\n"+
                "}\n";
    }

}


