package com.orders.management.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


public class LineAdditiveKey implements Serializable {

    @Column(name = "line_id")
    Long line_id;

    @Column(name = "additive_id")
    Long additive_id;

}
