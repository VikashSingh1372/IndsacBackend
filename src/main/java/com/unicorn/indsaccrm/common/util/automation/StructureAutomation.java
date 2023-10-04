package com.unicorn.indsaccrm.common.util.automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StructureAutomation {
    public static void main(String[] args) throws FileNotFoundException {

        String entityVariable="product";
        String entityVariableCapital="Product";

        //This rootpath returns the "DriveName:\INDSAC\indsaccrmbe"
        String rootPath = System.getProperty("user.dir");

        // Additional folder path
        String additionalFolderPath = "src/main/java/com/unicorn/indsaccrm/Lokesh";

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
        createControllerFile(entityPath, controllerFileName, getControllerContent(entityVariableCapital));


        //Service
        String serviceFileName = entityVariableCapital + "Service.java";
        createServiceFile(entityPath, serviceFileName, getServiceContent(entityVariableCapital));

        //ServiceImpl
        String serviceImplFileName = entityVariableCapital + "ServiceImpl.java";
        createServiceImplFile(entityPath, serviceImplFileName, getServiceImplContent(entityVariableCapital));
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

    private static String getControllerContent(String entityVariableCapital) {
        return "package com.unicorn.indsaccrm."+entityVariableCapital.toLowerCase()+";\n\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.http.ResponseEntity;\n" +
                "import org.springframework.stereotype.Controller;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "import java.util.UUID;\n" +
                "\n" +
                "@CrossOrigin\n" +
                "@Controller\n" +
                "@RequestMapping(\"/"+entityVariableCapital.toLowerCase()+"s\")\n" +
                "public class " + entityVariableCapital + "Controller {\n" +
                "    @Autowired\n" +
                "    private " + entityVariableCapital + "Service " + entityVariableCapital.toLowerCase() + "Service;\n" +
                "\n" +
                "    @PostMapping\n" +
                "    ResponseEntity<?> create"+entityVariableCapital+"(@RequestBody " + entityVariableCapital + " " + entityVariableCapital.toLowerCase() + ") throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Service.save"+entityVariableCapital+"(" + entityVariableCapital.toLowerCase() + "));\n" +
                "    }\n" +
                "\n" +
                "    @GetMapping(\"/all\")\n" +
                "    ResponseEntity<?> getAll"+entityVariableCapital+"() throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Service.getAll"+entityVariableCapital+"s());\n" +
                "    }\n" +
                "\n" +
                "    @GetMapping(\"{id}\")\n" +
                "    ResponseEntity<?> get"+entityVariableCapital+"ByID(@PathVariable UUID id) throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Service.get"+entityVariableCapital+"ById(id));\n" +
                "    }\n" +
                "}\n";
    }

    private static String getServiceContent(String entityVariableCapital){
        return "public class " + entityVariableCapital + "Service {\n" +
                "\n" +
                "    ResponseEntity<?> save"+entityVariableCapital+"("+ entityVariableCapital+" "+entityVariableCapital.toLowerCase()+");\n"+
                "\n" +
                "    ResponseEntity<List<"+entityVariableCapital+">>"+" "+"getAll"+entityVariableCapital+"s();\n"+
                "\n" +
                "    ResponseEntity<Optional<"+entityVariableCapital+">>"+" "+"get"+entityVariableCapital+"ById(UUID id);\n"+
                "}";
    }

    private static String getServiceImplContent(String entityVariableCapital) {
        return "package com.unicorn.indsaccrm."+entityVariableCapital.toLowerCase()+";\n\n" +
                "import org.slf4j.Logger;\n" +
                "import org.slf4j.LoggerFactory;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.http.ResponseEntity;\n" +
                "import org.springframework.stereotype.Service;\n\n" +
                "import java.util.List;\n" +
                "import java.util.Optional;\n" +
                "import java.util.UUID;\n\n" +

                "@Service\n" +
                "public class " + entityVariableCapital + "ServiceImpl implements " + entityVariableCapital + "Service {\n\n" +
                "   @Autowired\n" +
                "   "+entityVariableCapital + "Repository " + entityVariableCapital.toLowerCase() + "Repository;\n" +
                "   Logger logger = LoggerFactory.getLogger("+ entityVariableCapital +"ServiceImpl.class);\n\n" +
                "   @Override\n" +
                "   public ResponseEntity<?> save" + entityVariableCapital + "s(" + entityVariableCapital + " " + entityVariableCapital.toLowerCase() + ") {\n" +
                "      logger.info(\"Save " + entityVariableCapital + " from save" + entityVariableCapital + " Successully\");\n" +
                "      return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Repository.save(" + entityVariableCapital.toLowerCase() + "));\n" +
                "   }\n\n" +
                "   @Override\n" +
                "   public ResponseEntity<List<" + entityVariableCapital + ">> getAll" + entityVariableCapital + "s() {\n" +
                "      logger.info(\"GET all " + entityVariableCapital + "s from getAll" + entityVariableCapital + "s Successully\");\n" +
                "      return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Repository.findAll());\n" +
                "   }\n\n" +
                "   @Override\n" +
                "   public ResponseEntity<Optional<" + entityVariableCapital + ">> get" + entityVariableCapital + "ById(UUID id) {\n" +
                "      logger.info(\"GET " + entityVariableCapital + " By Id from get" + entityVariableCapital + "ById Successfully\");\n" +
                "      return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Repository.findById(id));\n" +
                "   }\n";
    }

}


