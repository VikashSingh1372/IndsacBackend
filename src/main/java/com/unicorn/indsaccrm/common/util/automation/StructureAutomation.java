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
        String additionalFolderPath = "src/main/java/com/unicorn/indsaccrm/product";

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

    private static String getControllerContent(String entityVariableCapital) {
        return "package com.unicorn.indsaccrm.product;\n\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.http.ResponseEntity;\n" +
                "import org.springframework.stereotype.Controller;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "import java.util.UUID;\n" +
                "\n" +
                "@CrossOrigin\n" +
                "@Controller\n" +
                "@RequestMapping(\"/products\")\n" +
                "public class " + entityVariableCapital + "Controller {\n" +
                "    @Autowired\n" +
                "    private " + entityVariableCapital + "Service " + entityVariableCapital.toLowerCase() + "Service;\n" +
                "\n" +
                "    @PostMapping\n" +
                "    ResponseEntity<?> createProduct(@RequestBody " + entityVariableCapital + " " + entityVariableCapital.toLowerCase() + ") throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Service.saveProduct(" + entityVariableCapital.toLowerCase() + "));\n" +
                "    }\n" +
                "\n" +
                "    @GetMapping(\"/all\")\n" +
                "    ResponseEntity<?> getAllProduct() throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Service.getAllProducts());\n" +
                "    }\n" +
                "\n" +
                "    @GetMapping(\"{id}\")\n" +
                "    ResponseEntity<?> getProductByID(@PathVariable UUID id) throws Exception {\n" +
                "        return ResponseEntity.ok(" + entityVariableCapital.toLowerCase() + "Service.getProductById(id));\n" +
                "    }\n" +
                "}\n";
    }

    private static String getServiceContent(String entityVariableCapital){

        return "public class " + entityVariableCapital + "Service {\n" +
                "\n" +
                "    ResponseEntity<?> saveProduct("+ entityVariableCapital+" "+entityVariableCapital.toLowerCase()+");\n"+
                "\n" +
                "    ResponseEntity<List<"+entityVariableCapital+">>"+" "+"getAllProducts();\n"+
                "\n" +
                "    ResponseEntity<Optional<"+entityVariableCapital+">>"+" "+"getProductById(UUID id);\n";
    }

}


