package org.jmp17.springcore.rest;

import org.jmp17.model.LangCourse;
import org.jmp17.springcore.RawdataContextHolder;
import org.jmp17.springcore.service.LangCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by asavitsky on 3/27/17.
 */
@RestController
public class LangCourseRestService{
    @Autowired
    private RawdataContextHolder rawdataContextHolder;

    @Autowired
    private LangCourseService langCourseService;

    @RequestMapping(method = RequestMethod.POST,
                    value = "/course"/*, consumes = MediaType.MULTIPART_FORM_DATA_VALUE*/ )
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLangCourse(@RequestParam("raw") String rawData, @RequestBody LangCourse langCourse){
        rawdataContextHolder.put(rawData);
        langCourseService.addCourse(langCourse);
    }
}
