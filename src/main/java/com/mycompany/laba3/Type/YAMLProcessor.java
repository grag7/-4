package com.mycompany.laba3.Type;

import com.mycompany.laba3.Reactor;
import com.mycompany.laba3.FileProcessor;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.yaml.snakeyaml.Yaml;

public class YAMLProcessor implements FileProcessor {

    private FileProcessor next;
    
    @Override
    public boolean canProcess(String fileType) {
        return fileType.equalsIgnoreCase("yaml") || fileType.equalsIgnoreCase("yml");
    }

    @Override
    public List<Reactor> process(File file) throws Exception {
        List<Reactor> reactors = new ArrayList<>();
        if("yaml".equals(file.getName().substring(file.getName().indexOf(".")+1))){
            
        }
        else{
            reactors = next.process(file);
        }

        return reactors;
    }
    @Override
    public void setNext(FileProcessor fileProcessor) {
        this.next = fileProcessor;
    }
}