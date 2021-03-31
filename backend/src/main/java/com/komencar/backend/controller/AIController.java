package com.komencar.backend.controller;

import org.apache.commons.io.FileUtils;
import org.python.util.PythonInterpreter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;


import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;


@RestController
@RequestMapping("/predict")
public class AIController {

    private static PythonInterpreter intpre;
    @GetMapping("/picture")
    public String predictPicture(HttpServletRequest request) {
        String pythonPath = "/home/ubuntu/AI/models/research/object_detection/model_predict.py";
        String[] command = new String[2];
        command[0] = "python";
        command[1] = pythonPath;

        String result = "";
        try {
            result = execPython(command);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }
    public static String execPython(String[] command) throws IOException, InterruptedException  {
        CommandLine commandLine = CommandLine.parse(command[0]);
        commandLine.addArgument(command[1]);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        int result = executor.execute(commandLine);
        System.out.println("result: " + result);
        System.out.println("output: " + outputStream.toString());
        return outputStream.toString();
    }


}
