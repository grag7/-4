
package com.mycompany.laba3;

import com.mycompany.laba3.Type.JSONProcessor;
import com.mycompany.laba3.Type.XMLProcessor;
import com.mycompany.laba3.Type.YAMLProcessor;
import java.io.File;
import java.util.List;


public class Manager {
    private YAMLProcessor yamlProcessor = new YAMLProcessor();
    private JSONProcessor jsonProcessor = new JSONProcessor();
    private XMLProcessor xmlProcessor = new XMLProcessor();
    private Storage storage = new Storage();
    
    public void processingFile(File file) throws Exception{
        List<Reactor> reactorList = yamlProcessor.process(file);
        storage.addToStorage(reactorList);
        
    }
    
    public Manager() {
        setUpProcessors();
    }
    
    public void setUpProcessors() {
        yamlProcessor.setNext(jsonProcessor);
        jsonProcessor.setNext(xmlProcessor);
    }
    
    public Storage getStorage(){
        return storage;
    }
    
 
    
    
}
