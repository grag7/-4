/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laba3.Type;

import com.mycompany.laba3.FileProcessor;
import com.mycompany.laba3.Reactor;
import java.io.File;
import java.util.List;

/**
 *
 * @author 79175
 */
public abstract class BaseProcessor implements FileProcessor{
    FileProcessor next;
    
    @Override
    public abstract List<Reactor> process(File file) throws Exception;
    
    @Override
    public void setNext(FileProcessor fileProcessor) {
        this.next = fileProcessor;
    }
    
}
