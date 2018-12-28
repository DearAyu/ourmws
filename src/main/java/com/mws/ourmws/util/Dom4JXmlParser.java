package com.mws.ourmws.util;

import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dom4JXmlParser {

    public Map<String,String> getNodes(Element nodes){
        Map<String,String> map=new HashMap<>();
        List<Element> listElement=nodes.elements();//所有一级子节点的list
        for(Element e:listElement){//遍历所有一级子节点
            if (e.elements().size()>0){
                List<Element> listElement2=e.elements();
                for (Element e1:listElement2){
                    //System.out.println(e1.getName() + ":  " + e1.getTextTrim());
                    map.put(e1.getName(),e1.getTextTrim());
                }
            }else {
                //System.out.println(e.getName() + ":  " + e.getTextTrim());
                map.put(e.getName(),e.getTextTrim());
            }
        }
        return map;
    }
}
