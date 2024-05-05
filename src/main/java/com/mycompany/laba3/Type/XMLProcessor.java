
package com.mycompany.laba3.Type;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mycompany.laba3.FileProcessor;
import com.mycompany.laba3.Reactor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class XMLProcessor implements FileProcessor {
    private FileProcessor next;
    
    @Override
    public boolean canProcess(String fileType) {
        // Поддержка файлов с расширением ".xml"
        return fileType.equalsIgnoreCase("xml");
    }
    
    @Override
    public List<Reactor> process(File file) throws Exception {
        // Используем XmlMapper для чтения XML данных
        
        List<Reactor> reactors = new ArrayList<>();
        if("xml".equals(file.getName().substring(file.getName().indexOf(".")+1))){
            XmlMapper mapper = new XmlMapper();
            Map<String, Reactor> map;
            map = mapper.readValue(file, new TypeReference<Map<String, Reactor>>(){});
                for(Map.Entry<String, Reactor> entry: map.entrySet()) {
                    Reactor reactor = entry.getValue();
                    reactor.setFileType(file.getName());
                    reactor.setName(entry.getKey());
                    reactors.add(reactor);
                }
        }
        else{
            throw new IllegalArgumentException();
        }
        return reactors;

     
    }
    
    @Override
    public void setNext(FileProcessor fileProcessor) {
        this.next = fileProcessor;
    }
}