package com.mycompany.paymentsystem;

import java.io.IOException;
import java.util.List;

public interface Save 
{
    void save(String filename, List al) throws IOException ;
}
