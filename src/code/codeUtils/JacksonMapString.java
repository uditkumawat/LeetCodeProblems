package code.codeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JacksonMapString {

    public static void main(String args[]){

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> indMap = new HashMap<>();
        indMap.put("ind","hello1");

        Map<String,Object> authMap = new HashMap<>();
        authMap.put("nam","hello2");
        authMap.put("namFmt","hello3");
        authMap.put("namQfr","hello4");
        authMap.put("legacyIdpid","hello5");
        authMap.put("slo",indMap);


        Map<String,Object> map = new HashMap<>();
        map.put("auth", Arrays.asList(authMap));

        String transformedContext = null;
        try{
            transformedContext = objectMapper.writeValueAsString(map);
            System.out.println(transformedContext);
        }catch(JsonProcessingException ex){
          //  log.error("Json Serialization error for transformation SAML SLO Context", ex);
        }catch(Exception ex){
            //log.error("Exception in transformation of SAML SLO Context", ex);
        }
    }
}
