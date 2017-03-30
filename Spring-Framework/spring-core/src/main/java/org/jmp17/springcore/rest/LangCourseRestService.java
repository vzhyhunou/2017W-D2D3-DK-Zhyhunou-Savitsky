package org.jmp17.springcore.rest;

import org.jmp17.model.LangCourse;
import org.jmp17.springcore.RawdataContextHolder;
import org.jmp17.springcore.service.LangCourseService;
import org.jmp17.springcore.session.SessionScopeData;
import org.jmp17.springcore.session.SessionScopeDataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by asavitsky on 3/27/17.
 */
@RestController
public class LangCourseRestService{
    @Autowired
    private RawdataContextHolder rawdataContextHolder;

    @Autowired
    private LangCourseService langCourseService;

    @Autowired
    private SessionScopeDataHolder sessionScopeDataHolder;

    @RequestMapping(method = RequestMethod.POST,
                    value = "/course" )
    @ResponseStatus(HttpStatus.CREATED)
    @ModelAttribute
    public void saveLangCourse(@RequestParam("raw") String rawData,
                               @RequestBody LangCourse langCourse,
                               HttpServletResponse response){
        rawdataContextHolder.put(rawData);
        langCourseService.addCourse(langCourse);
        response.setHeader("Session-started", sessionScopeDataHolder.getSessionScopeData().getDate() );
    }

}
