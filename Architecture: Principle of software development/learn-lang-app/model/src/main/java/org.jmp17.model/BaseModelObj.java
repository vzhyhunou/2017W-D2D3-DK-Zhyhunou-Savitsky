package org.jmp17.model;

/**
 * Created by antonsavitsky on 2/11/17.
 */
public class BaseModelObj {
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
