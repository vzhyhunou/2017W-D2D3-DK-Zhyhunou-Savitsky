package org.jmp17.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by antonsavitsky on 2/11/17.
 */
@MappedSuperclass
public class BaseModelObj {
    @Id
    @GeneratedValue
    private Integer id;

    public BaseModelObj(Integer id){
        this.id = id;
    }

    public BaseModelObj(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
