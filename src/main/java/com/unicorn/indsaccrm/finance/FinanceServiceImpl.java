package com.unicorn.indsaccrm.finance;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class FinanceServiceImpl implements FinanceService{
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TradeBook{
        private String type;
        private float buyPrice;
        private float sellPrice;
        private int quantity;
        private float pnl;
        private String status;
    }

    @Override
    public ResponseEntity<?> analyseTradebook(MultipartFile file) {
        String fileName =
                new Date().getTime() + "." + getFileExtension(file.getOriginalFilename());
        try {
            // Check if the filename contains invalid characters
            if (fileName.contains("..")) {
                throw new RuntimeException(
                        "Sorry! Filename contains invalid path sequence " + fileName);
            }
            Reader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();
            Map<String,List<TradeBook>> symbolData =new HashMap<>();
            TradeBook tradeBook=null;
            for (String[] row : allData) {
                if(row[6].contains("buy")){
                     tradeBook = TradeBook.builder()
                            .quantity(Integer.parseInt(row[8]))
                            .buyPrice(Float.parseFloat(row[9]))
                            .status("initial")
                       .build();
                }else{if(tradeBook!=null && row[6].contains("sell") && tradeBook.getStatus().equals("initial")){
                    tradeBook = TradeBook.builder()
                            .sellPrice(Float.parseFloat(row[9]))
                            .pnl((tradeBook.getQuantity()*Float.parseFloat(row[9]))-tradeBook.getBuyPrice()*tradeBook.getQuantity())
                            .status("complete")
                            .build();
                    List<TradeBook> tradeBookList;
                    if(symbolData.get(row[2]).size()<1){
                        tradeBookList= new ArrayList<>();
                        tradeBookList.add(tradeBook);
                    }
                    else {
                        tradeBookList = symbolData.get(row[2]);
                        tradeBookList.add(tradeBook);
                    }
                    symbolData.put(row[2],tradeBookList);
                    tradeBook=null;

                }

                }


            }
            return new ResponseEntity<>(symbolData, HttpStatus.OK);
        } catch (Exception ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }

    private String getFileExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        String[] fileNameParts = fileName.split("\\.");

        return fileNameParts[fileNameParts.length - 1];
    }
}
