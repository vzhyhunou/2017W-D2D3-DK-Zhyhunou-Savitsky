package org.jmp17.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

/**
 * Created by asavitsky on 3/28/17.
 *
 * This classes is intended to be a factory for getting rawData bytes from request in scope of current request
 */
@Component
public class AttachmentsResourceFactory {

    @Autowired
    private RawdataContextHolder rawdataContextHolder;

    public ByteArrayResource getResource()
    {
        return new ByteArrayResource( rawdataContextHolder.getRawData().getBytes() );
    }
}
