package com.komencar.aibackend.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.python.util.PythonInterpreter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;


@RestController
@RequestMapping("/predict")
public class AIController {

    private static PythonInterpreter intpre;

    private static long file_name = 1;

    @ApiOperation(value = " 차 사진 업로드", notes = "차 사진 업로드")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "jpg file", dataType = "file", required = true),
    })
    @PostMapping("/picture")
    public String predictPicture(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        String pic_path = "test_images/"+file_name+"_"+file.getOriginalFilename();
        File targetFile = new File(pic_path);
        System.out.println(pic_path);
        try {
            InputStream fileStream = file.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            e.printStackTrace();
        }

        file_name++;

        String pythonPath = "model_predict.py";
        String[] command = new String[3];
        command[0] = "python";
        command[1] = pythonPath;
        command[2] = "--path="+pic_path;
//        command[2] = pic_path;

        String result = "";
        try {
            result = execPython(command);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String execPython(String[] command) throws IOException, InterruptedException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        commandLine.addArgument(command[1]);
        commandLine.addArgument(command[2]);


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
