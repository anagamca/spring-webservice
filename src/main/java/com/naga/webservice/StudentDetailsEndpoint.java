package com.naga.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.naga.webservice.domain.ObjectFactory;
import com.naga.webservice.domain.StudentRequestType;
import com.naga.webservice.domain.StudentResponseType;


@Endpoint
public class StudentDetailsEndpoint {
	
	ObjectFactory objectFactory = new ObjectFactory();
    @PayloadRoot(namespace = "http://naga.blogger.com/ws-project", localPart = "StudentRequest")
    @ResponsePayload
    public JAXBElement<StudentResponseType> searchProjects(@RequestPayload StudentRequestType request) {
     
        try {
        	
        	StudentResponseType studentResponse = objectFactory.createStudentResponseType();
        	studentResponse.setName(request.getName());
        	studentResponse.setDepartment("MCA");
        	studentResponse.setSubject1(request.getSubject1());
        	studentResponse.setSubject2(request.getSubject2());
        	studentResponse.setSubject3(request.getSubject3());
        	studentResponse.setTotal(request.getSubject1()+request.getSubject2()+request.getSubject3());
 	    return new JAXBElement<StudentResponseType>(new QName("http://naga.blogger.com/ws-project",
               "studentResponse"), StudentResponseType.class, studentResponse);
        }
        catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }

}
